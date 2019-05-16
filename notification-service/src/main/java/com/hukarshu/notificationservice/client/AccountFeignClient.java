package com.hukarshu.notificationservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther: hunan
 * @Date: 02/05/2019 14:56
 * @Description:
 */
@FeignClient(name = "account-service")
public interface AccountFeignClient {
    @RequestMapping(method = RequestMethod.GET, value = "/accounts/{accountName}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String getAccount(@PathVariable("accountName") String accountName);
}
