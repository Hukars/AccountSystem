package com.hukarshu.statisticservice.service;

import com.hukarshu.statisticservice.domain.*;
import com.hukarshu.statisticservice.repository.StatisticRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Auther: hunan
 * @Date: 21/04/2019 11:03
 * @Description:
 */
@Service
public class StatisticServiceImpl implements StatisticService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    StatisticRepository statisticRepository;


    @Override
    public Statistics findByNickname(String nickname){
        if(!nickname.isEmpty())
            return statisticRepository.findByNickname(nickname);
        return null;
    }

    @Override
    public void createStatistics(String nickname){
        Statistics statistics = new Statistics();
        statistics.setNickname(nickname);

        statisticRepository.save(statistics);

        log.info("New Statistics has been created:"+nickname);
    }


    @Override
    public void updateStatistics(String nickname, List<Item> itemList){
        Statistics statistics = statisticRepository.findByNickname(nickname);
        Assert.notNull(statistics,"can't find statistics with name " + nickname);

        if(itemList.isEmpty())
            updateByTime(statistics);
        else
            updateByItem(statistics,itemList);

        log.info("Statistics has been updated:"+nickname);

    }

    private void updateByTime(Statistics statistics){
        BalanceSheet balanceSheet = statistics.getBalanceSheet();
        Calendar now = Calendar.getInstance();

        Integer currentYear = now.get(Calendar.YEAR);
        Integer currentMonth = now.get(Calendar.MONTH) + 1;
        Integer currentDay = now.get(Calendar.DAY_OF_MONTH);

        FinancialBriefing financialBriefing = statistics.getFinancialBriefing();

        Map<String, BigDecimal> expenditureClassification = statistics.getExpenditureClassification();
        Map<Integer, BigDecimal> expenditureTrend = statistics.getExpenditureTrend();

        if(!currentYear.equals(balanceSheet.getThisYear())){
            balanceSheet.setThisYear(currentYear);
            balanceSheet.setYearExpenditure(new BigDecimal("0.00"));
            balanceSheet.setYearIncome(new BigDecimal("0.00"));

            balanceSheet.setThisMonth(currentMonth);
            balanceSheet.setMonthExpenditure(new BigDecimal("0.00"));
            balanceSheet.setMonthIncome(new BigDecimal("0.00"));

            financialBriefing.setTotalRecords(0);
            financialBriefing.setUse(new BigDecimal("0.00"));
            //有关额度代码之后补充
            financialBriefing.setRemaining(financialBriefing.getBudget());

            expenditureClassification.clear();
            expenditureTrend.clear();
        }
        else {

            if (!currentMonth.equals(balanceSheet.getThisMonth())) {
                balanceSheet.setThisMonth(currentMonth);
                balanceSheet.setMonthExpenditure(new BigDecimal("0.00"));
                balanceSheet.setMonthIncome(new BigDecimal("0.00"));

                financialBriefing.setTotalRecords(0);
                financialBriefing.setUse(new BigDecimal("0.00"));
                //有关额度代码之后补充
                financialBriefing.setRemaining(financialBriefing.getBudget());

                expenditureClassification.clear();
                expenditureTrend.clear();
            }
        }
        financialBriefing.setCurrentDay(currentDay);

        statisticRepository.save(statistics);
    }

    private void updateByItem(Statistics statistics,List<Item> itemList){
        Asset asset = statistics.getAsset();

        BalanceSheet balanceSheet = statistics.getBalanceSheet();
        Calendar now = Calendar.getInstance();
        Integer currentYear = now.get(Calendar.YEAR);
        Integer currentMonth = now.get(Calendar.MONTH) + 1;
        Integer currentDay = now.get(Calendar.DAY_OF_MONTH);

        FinancialBriefing financialBriefing = statistics.getFinancialBriefing();

        Map<String, BigDecimal> expenditureClassification = statistics.getExpenditureClassification();
        Map<Integer, BigDecimal> expenditureTrend = statistics.getExpenditureTrend();


        if(!currentYear.equals(balanceSheet.getThisYear())){
            balanceSheet.setThisYear(currentYear);
            balanceSheet.setThisMonth(currentMonth);
            balanceSheet.setYearExpenditure(new BigDecimal("0.00"));
            balanceSheet.setYearIncome(new BigDecimal("0.00"));
            balanceSheet.setMonthExpenditure(new BigDecimal("0.00"));
            balanceSheet.setMonthIncome(new BigDecimal("0.00"));

            financialBriefing.setTotalRecords(itemList.size());
            financialBriefing.setUse(new BigDecimal("0.00"));
            //有关额度代码之后补充
            financialBriefing.setRemaining(financialBriefing.getBudget());

            expenditureClassification.clear();
            expenditureTrend.clear();
        }
        else {
            if (!currentMonth.equals(balanceSheet.getThisMonth())) {
                balanceSheet.setThisMonth(currentMonth);
                balanceSheet.setMonthExpenditure(new BigDecimal("0.00"));
                balanceSheet.setMonthIncome(new BigDecimal("0.00"));

                financialBriefing.setTotalRecords(itemList.size());
                financialBriefing.setUse(new BigDecimal("0.00"));
                //有关额度代码之后补充
                financialBriefing.setRemaining(financialBriefing.getBudget());

                expenditureClassification.clear();
                expenditureTrend.clear();
            }
        }

        financialBriefing.setCurrentDay(currentDay);
        financialBriefing.setTotalRecords(financialBriefing.getTotalRecords()+itemList.size());


        for (Item  e:itemList) {
            switch (e.getItemType()){
                case INC:
                    asset.setCurrentAsset(asset.getCurrentAsset().add(e.getAmount()));
                    asset.setNetAsset(asset.getNetAsset().add(e.getAmount()));
                    balanceSheet.setMonthIncome(balanceSheet.getMonthIncome().add(e.getAmount()));
                    balanceSheet.setYearIncome(balanceSheet.getYearIncome().add(e.getAmount()));
                    break;
                case EXP:
                    asset.setCurrentAsset(asset.getCurrentAsset().subtract(e.getAmount()));
                    asset.setNetAsset(asset.getNetAsset().subtract(e.getAmount()));
                    balanceSheet.setMonthExpenditure(balanceSheet.getMonthExpenditure().add(e.getAmount()));
                    balanceSheet.setYearExpenditure(balanceSheet.getYearExpenditure().add(e.getAmount()));
                    financialBriefing.setUse(financialBriefing.getUse().add(e.getAmount()));
                    financialBriefing.setRemaining(financialBriefing.getBudget().subtract(financialBriefing.getUse()));
                    if(expenditureClassification.containsKey(e.getTitle()))
                        expenditureClassification.put(e.getTitle(),expenditureClassification.get(e.getTitle()).add(e.getAmount()));
                    else
                        expenditureClassification.put(e.getTitle(),e.getAmount());
                    expenditureTrend.put(currentDay,expenditureTrend.get(currentDay).add(e.getAmount()));
                    break;
                case BOR:
                    asset.setCurrentAsset(asset.getCurrentAsset().add(e.getAmount()));
                    asset.setDebt(asset.getDebt().add(e.getAmount()));
                    break;
                case Len:
                    asset.setCollectDebt(asset.getCollectDebt().add(e.getAmount()));
                    asset.setNetAsset(asset.getNetAsset().add(e.getAmount()));
                    break;
            }
        }
        statisticRepository.save(statistics);
    }


}
