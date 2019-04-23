package com.hukarshu.statisticservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@SpringBootApplication
@EnableOAuth2Client
@EnableDiscoveryClient
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class StatisticServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StatisticServiceApplication.class, args);
    }

}
