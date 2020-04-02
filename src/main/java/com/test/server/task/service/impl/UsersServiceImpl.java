package com.test.server.task.service.impl;

import com.test.server.task.model.Users;
import com.test.server.task.repository.UsersRepository;
import com.test.server.task.service.UsersService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

  private  UsersRepository usersRepository;

  public UsersServiceImpl(UsersRepository usersRepository) {
    this.usersRepository = usersRepository;
  }

  @Override
  public Page<Users> getUsers(Pageable pageable) {
    return usersRepository.findAll(pageable);
  }
}
