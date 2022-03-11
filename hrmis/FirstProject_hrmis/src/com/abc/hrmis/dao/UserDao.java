package com.abc.hrmis.dao;

import java.util.List;

import com.abc.hrmis.domain.User;

public interface UserDao {

	public abstract List<User> loadEmps();

	public User getUserByNo(String userNo);
}
