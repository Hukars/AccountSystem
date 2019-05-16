package com.hukarshu.accountservice.client;

import com.hukarshu.accountservice.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther: hukarshu
 * @Date: 2019/4/9 14:24
 * @Description:
 */
@FeignClient(name="auth-service", fallback = AuthFeignClientFallback.class)
public interface AuthFeignClient {
    @RequestMapping(method = RequestMethod.POST, value = "/uaa/users/", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    void createUser(User user);
}
