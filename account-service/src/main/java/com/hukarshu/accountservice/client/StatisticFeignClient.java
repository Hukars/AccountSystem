package com.hukarshu.accountservice.client;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Auther: hunan
 * @Date: 21/04/2019 10:31
 * @Description:
 */
@FeignClient(name="statistic-service")
public interface StatisticFeignClient {
    void updateStatistics();
}
