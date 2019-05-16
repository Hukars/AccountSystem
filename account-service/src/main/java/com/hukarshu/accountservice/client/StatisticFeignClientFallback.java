package com.hukarshu.accountservice.client;

import com.hukarshu.accountservice.domain.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @Auther: hunan
 * @Date: 03/05/2019 20:46
 * @Description:
 */
@Component
public class StatisticFeignClientFallback implements StatisticFeignClient {

    private static final Logger Log = LoggerFactory.getLogger(StatisticFeignClientFallback.class);

    @Override
    public void updateStatistics(String nickname, List<Item> itemList){
        Log.error("Error for updating statistics of account {}",nickname);
    }

    @Override
    public void createOneStatistics(String nickname){
        Log.error("Error for creating statistics of account {}",nickname);
        Assert.notNull(null,"createOneStatistics fails！");
    }

}
