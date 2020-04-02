package com.test.server.task.controller;

import com.test.server.task.model.Statistic;
import com.test.server.task.model.Users;
import com.test.server.task.service.impl.StatisticServiceImpl;
import com.test.server.task.service.impl.UsersServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/users/")
public class ControllerUsers {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  private final UsersServiceImpl usersService;
  private final StatisticServiceImpl statisticService;

  public ControllerUsers(UsersServiceImpl usersService, StatisticServiceImpl statisticService) {
    this.usersService = usersService;
    this.statisticService = statisticService;
  }

  @GetMapping("/page")
  public ResponseEntity<List<Users>> getAllUsersPagination(@RequestParam("page") int page, @RequestParam("range") int range) {
    Pageable pageable = PageRequest.of(page, range);
    List<Users> users = usersService.getUsers(pageable).stream().map(x -> {
      return Users.builder()
        .id(x.getId())
        .email(x.getEmail())
        .firstName(x.getFirstName())
        .lastName(x.getLastName())
        .IpAddress(x.getIpAddress())
        .gender(x.getGender())
        .totalClicks(statisticService.totalClicks(x.getId()))
        .totalPageViews(statisticService.allTotalPageViews(x.getId())).build();
    }).collect(Collectors.toList());

    return new ResponseEntity<>(users, HttpStatus.OK);
  }

  @GetMapping("/statistic")
  public ResponseEntity<List<Statistic>> getStatisticUser(@RequestParam("id") long id,
                                                          @RequestParam("start") String start,
                                                          @RequestParam("end") String end) {
    Users users = new Users();
    users.setId(id);
    List<Statistic> statistic = statisticService.statisticAllUserId(users, start, end);
    if (!statistic.isEmpty()) {
      return new ResponseEntity<>(statistic, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
