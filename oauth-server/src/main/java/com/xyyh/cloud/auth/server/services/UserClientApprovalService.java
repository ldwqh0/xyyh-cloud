package com.xyyh.cloud.auth.server.services;

public interface UserClientApprovalService {

	/**
	 * 判断某个用户,是否对相应的app进行了授权
	 */
	public boolean isApprovaled(String user, String client);

	/**
	 * 保存用户对clinet的授权信息
	 * 
	 * @param user
	 * @param client
	 */
	public void save(String user, String client);

}
