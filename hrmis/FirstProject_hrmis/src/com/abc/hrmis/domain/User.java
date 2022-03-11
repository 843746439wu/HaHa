package com.abc.hrmis.domain;

import java.text.ParseException;

import com.abc.hrmis.utils.Constants;

/**
 * 
 * 操作用户
 * 
 * @author Decade
 *
 */

public class User extends ValueObject{
	
	private String userNo;//用户账号
	
	private String userPwd;//用户密码
	
	

	public User() {
		super();
	}

	public User(String userNo, String userPwd) {
		super();
		this.userNo = userNo;
		this.userPwd = userPwd;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	@Override
	public String toString() {
		return userNo + "," + userPwd ;
	}
	
	public static User getUserByStr(String UserInfoStr) {
		String[] section = UserInfoStr.split("\\,");
		User user = new User();
		user.setUserNo(section[0]);
		user.setUserPwd(section[1]);
		
		return user;
	}
	
}
