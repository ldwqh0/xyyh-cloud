package com.xyyh.cloud.auth.server.security.oauth2.provider.approval;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.util.OAuth2Utils;
import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;

import com.xyyh.cloud.auth.server.services.UserClientApprovalService;

public class SimpleUserApprovalHandler implements UserApprovalHandler, InitializingBean {

	private String approvalParameter = OAuth2Utils.USER_OAUTH_APPROVAL;

	@Autowired
	private UserClientApprovalService userClientApprovalService;

	public void setUserClientApprovalService(UserClientApprovalService userClientApprovalService) {
		this.userClientApprovalService = userClientApprovalService;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isApproved(AuthorizationRequest authorizationRequest, Authentication userAuthentication) {
		return authorizationRequest.isApproved();
	}

	// 在进入授权页面之前触发
	@Override
	public AuthorizationRequest checkForPreApproval(AuthorizationRequest authorizationRequest,
			Authentication userAuthentication) {
		String client = authorizationRequest.getClientId();
		String user = userAuthentication.getName();
		boolean isApprovaled = userClientApprovalService.isApprovaled(user, client); // 判断用户是否已经对该应用进行过授权
		authorizationRequest.setApproved(isApprovaled);
		return authorizationRequest;
	}

	// 在用户点击授权按钮之后触发
	@Override
	public AuthorizationRequest updateAfterApproval(AuthorizationRequest authorizationRequest,
			Authentication userAuthentication) {
		
		Map<String, String> approvalParameters = authorizationRequest.getApprovalParameters();
		String flag = approvalParameters.get(approvalParameter);
		boolean approved = flag != null && flag.toLowerCase().equals("true");
		
		if (approved) {
			String client = authorizationRequest.getClientId();
			String user = userAuthentication.getName();
			userClientApprovalService.save(user,client);
		}
		authorizationRequest.setApproved(approved);
		return authorizationRequest;
	}

	/**
	 * 对授权参数进行处理，
	 */
	@Override
	public Map<String, Object> getUserApprovalRequest(AuthorizationRequest authorizationRequest,
			Authentication userAuthentication) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.putAll(authorizationRequest.getRequestParameters());
		return model;
	}

}
