package com.test.server.task.service;

import com.test.server.task.model.Statistic;
import com.test.server.task.model.Users;

import java.util.List;

public interface StatisticService {

  List<Statistic> statisticAllUserId(Users users, String start , String end);
  Integer totalClicks(Long id);
  Integer allTotalPageViews(Long id);
}
