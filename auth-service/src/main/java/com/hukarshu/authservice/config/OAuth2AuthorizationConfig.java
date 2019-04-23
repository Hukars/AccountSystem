package com.hukarshu.authservice.config;

import com.hukarshu.authservice.service.MySqlUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * @Auther: hukarshu
 * @Date: 2019/4/9 11:51
 * @Description:
 */
@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter {
    @Autowired
    @Qualifier("authenticationManagerBean")
    AuthenticationManager authenticationManager;

    @Autowired
    MySqlUserDetailsService mySqlUserDetailsService;

    @Autowired
    Environment env;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception{
        // @formatter:off
        // 浏览器作为client时，使用密码模式，用户向Client提供用户名和密码，Client向授权服务器索要授权
        //微服务本身作为client时，使用客户端模式，Client直接向授权服务器索要授权；每一个微服务本身也是一个资源服务器
        clients.inMemory()
                .withClient("browser")
                .authorizedGrantTypes("password","refresh_token")
                .scopes("ui")
                .and()
                .withClient("account-service")
                .secret(env.getProperty("ACCOUNT_SERVICE_PASSWORD"))
                .authorizedGrantTypes("client_credentials", "refresh_token")
                .scopes("server")
                .and()
                .withClient("statistic-service")
                .secret(env.getProperty("STATISTIC_SERVICE_PASSWORD"))
                .authorizedGrantTypes("client_credentials", "refresh_token")
                .scopes("server");
        // @formatter:on
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception{
        endpoints
                .tokenStore(new InMemoryTokenStore())
                .authenticationManager((authenticationManager))
                .userDetailsService(mySqlUserDetailsService);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception{
        oauthServer
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()")
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
}
