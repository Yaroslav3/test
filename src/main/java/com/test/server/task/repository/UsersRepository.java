package com.test.server.task.repository;

import com.test.server.task.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>, PagingAndSortingRepository<Users, Long> {


}
