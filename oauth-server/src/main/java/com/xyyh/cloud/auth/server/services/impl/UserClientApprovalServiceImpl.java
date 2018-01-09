package com.xyyh.cloud.auth.server.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyyh.cloud.auth.server.entity.UserClientApprovalEntity;
import com.xyyh.cloud.auth.server.repository.UserClientApprovalRepository;
import com.xyyh.cloud.auth.server.services.UserClientApprovalService;

@Service
public class UserClientApprovalServiceImpl implements UserClientApprovalService {

	@Autowired
	private UserClientApprovalRepository repository;

	@Override
	public boolean isApprovaled(String user, String client) {
		UserClientApprovalEntity query = new UserClientApprovalEntity();
		query.setUser(user);
		query.setClient(client);
		return repository.exists(query);
	}

	@Override
	public void save(String user, String client) {
		UserClientApprovalEntity query = new UserClientApprovalEntity();
		query.setUser(user);
		query.setClient(client);
		if (!repository.exists(query)) {
			repository.save(query);
		}
	}

}
