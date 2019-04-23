package com.hukarshu.statisticservice.service;

import com.hukarshu.statisticservice.domain.Item;
import com.hukarshu.statisticservice.domain.Statistics;

import java.util.List;

/**
 * @Auther: hunan
 * @Date: 21/04/2019 10:37
 * @Description:
 */
public interface StatisticService {
    Statistics findByNickname(String nickname);

    void createStatistics(String nickname);

    void updateStatistics(String nickname, List<Item> itemList);
}
