/**
 * 
 */
package com.abc.hrmis.dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.abc.hrmis.domain.User;
import com.abc.hrmis.utils.Constants;

/**
 * @author Decade
 *
 */
public class UserDaoImpl implements UserDao {

ArrayList<User> arrList = new ArrayList<User>();

	@Override
	public List<User> loadEmps() {
		BufferedReader reader = null;
		List<User> userList = new ArrayList<>();

		try {
			reader = new BufferedReader( new InputStreamReader(new FileInputStream(Constants.USER_FILE),"GBK"));
			String entry = null;
			while((entry = reader.readLine())!=null){
				userList.add(User.getUserByStr(entry));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return userList;
	}
	
	public User getUserByNo(String userNo) {
		List<User> userList = this.loadEmps();
		
		for(User user:userList)
			if(user.getUserNo().equals(userNo))
				return user;
		return null;
	}

}
