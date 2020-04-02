package com.test.server.task.repository;

import com.test.server.task.model.Statistic;
import com.test.server.task.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StatisticRepository extends JpaRepository<Statistic, Long> {

  @Query(value = "SELECT * FROM statistic WHERE user_id=?1 AND date >=?2 and date <=?3", nativeQuery = true)
  List<Statistic> statisticAllUserId(Users users, String start , String end);


  @Query(value = "SELECT sum(clicks) FROM Statistic s where s.userId=?1")
  Integer allTotalClicks(Long id);

  @Query(value = "SELECT sum(page_views) FROM Statistic s where s.userId=?1")
  Integer allTotalPageViews(Long id);

}
