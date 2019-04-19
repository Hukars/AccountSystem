package com.hukarshu.statisticservice.repository;

import com.hukarshu.statisticservice.domain.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Auther: hunan
 * @Date: 19/04/2019 16:02
 * @Description:
 */
@Repository
public interface StatisticRepository extends JpaRepository<Statistics, String> {
    Statistics findByNickname(String nickname);
}
