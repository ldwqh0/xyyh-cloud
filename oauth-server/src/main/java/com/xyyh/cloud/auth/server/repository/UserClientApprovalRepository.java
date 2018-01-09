package com.xyyh.cloud.auth.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xyyh.cloud.auth.server.entity.UserClientApprovalEntity;

public interface UserClientApprovalRepository
		extends JpaRepository<UserClientApprovalEntity, UserClientApprovalEntity> {

}
