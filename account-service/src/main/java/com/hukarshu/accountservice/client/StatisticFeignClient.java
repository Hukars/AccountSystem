package com.hukarshu.accountservice.client;

import com.hukarshu.accountservice.domain.Item;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Auther: hunan
 * @Date: 21/04/2019 10:31
 * @Description:
 */
@FeignClient(name="statistic-service",fallback = StatisticFeignClientFallback.class)
public interface StatisticFeignClient {

    @RequestMapping(method = RequestMethod.POST, value = "/statistics/{nickname}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    void createOneStatistics(@PathVariable("nickname") String nickname);

    @RequestMapping(method = RequestMethod.PUT, value = "/statistics/{nickname}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    void updateStatistics(@PathVariable("nickname") String nickname, List<Item> itemList);
}
