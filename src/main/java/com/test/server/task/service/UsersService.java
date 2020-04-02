package com.test.server.task.service;

import com.test.server.task.model.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface UsersService {

  Page<Users> getUsers(Pageable pageable);
}
