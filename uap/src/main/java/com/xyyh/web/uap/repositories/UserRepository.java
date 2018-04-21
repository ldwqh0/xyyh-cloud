package com.xyyh.web.uap.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.xyyh.web.uap.entity.User;

public interface UserRepository extends JpaRepository<User, Long>, QuerydslPredicateExecutor<User> {

	public User findByUsername(String username);

	public Page<User> findByUsernameContaining(String username, Pageable pageable);

}
