package com.test.server.task.service.impl;

import com.test.server.task.model.Statistic;
import com.test.server.task.model.Users;
import com.test.server.task.repository.StatisticRepository;
import com.test.server.task.service.StatisticService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatisticServiceImpl implements StatisticService {

  private final StatisticRepository statisticRepository;

  public StatisticServiceImpl(StatisticRepository statisticRepository) {
    this.statisticRepository = statisticRepository;
  }

  @Override
  public List<Statistic> statisticAllUserId ( Users users, String start , String end) {
    return statisticRepository.statisticAllUserId(users, start, end)
      .stream().sorted(Comparator.comparing(Statistic::getDate)).collect(Collectors.toList());
  }

  @Override
  public Integer totalClicks(Long id) {
    return statisticRepository.allTotalClicks(id);
  }

  @Override
  public Integer allTotalPageViews(Long id) {
    return statisticRepository.allTotalPageViews(id);
  }
}
