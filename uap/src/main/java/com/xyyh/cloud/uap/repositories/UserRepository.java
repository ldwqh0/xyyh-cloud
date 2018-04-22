package com.xyyh.cloud.uap.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.xyyh.cloud.uap.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>, QuerydslPredicateExecutor<UserEntity> {

	public UserEntity findByUsername(String username);

	public Page<UserEntity> findByUsernameContaining(String username, Pageable pageable);

}
