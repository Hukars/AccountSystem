package com.hukarshu.statisticservice.domain;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * @Auther: hunan
 * @Date: 19/04/2019 14:57
 * @Description:
 */
public class ExpenditureStatistics {
    //本月分类支出
    private HashMap<String, BigDecimal> expenditureClassification;

    //本月支出趋势
    private HashMap<Integer, BigDecimal> ExpenditureTrend;
}
