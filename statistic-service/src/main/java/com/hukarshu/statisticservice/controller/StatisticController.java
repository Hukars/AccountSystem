package com.hukarshu.statisticservice.controller;

import com.hukarshu.statisticservice.domain.Item;
import com.hukarshu.statisticservice.domain.Statistics;
import com.hukarshu.statisticservice.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.security.Principal;
import java.util.List;

/**
 * @Auther: hunan
 * @Date: 23/04/2019 11:36
 * @Description:
 */
@RestController
public class StatisticController {
    @Autowired
    private StatisticService statisticService;

    @GetMapping("/current")
    public Statistics getCurrentAccountStatistics(Principal principal){
        return statisticService.findByNickname(principal.getName());
    }

    @PreAuthorize("#oauth2.hasScope('server')")
    @GetMapping("/{nickname}")
    public Statistics getCurrentAccountStatistics(@PathVariable String nickname){
        return statisticService.findByNickname(nickname);
    }

    @PostMapping("/{nickname}")
    public void createOne(@PathVariable String nickname){
        statisticService.createStatistics(nickname);
    }

    @PreAuthorize("#oauth2.hasScope('server')")
    @PutMapping("/{nickname}")
    public void saveAccountStatistics(@PathVariable String nickname, @Valid @RequestBody List<Item> itemList) {
        statisticService.updateStatistics(nickname,itemList);
    }

}
