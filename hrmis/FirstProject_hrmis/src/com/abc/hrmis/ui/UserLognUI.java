package com.abc.hrmis.ui;

import java.util.List;

import com.abc.hrmis.dao.UserDao;
import com.abc.hrmis.dao.UserDaoImpl;
import com.abc.hrmis.domain.User;
import com.abc.hrmis.utils.SysUtils;

public class UserLognUI implements BaseUI {

	@Override
	public void setup() {
		UserDao userDao = new UserDaoImpl();
		List<User> userList = userDao.loadEmps();
		
		while(true) {
			System.out.print("Enter UserNo:");
			String entry1 = SysUtils.getEntry();
			System.out.print("Enter UserPwd:");
			String entry2 = SysUtils.getEntry();
			String entry = entry1 + "," + entry2;
			int cnt = 0;
			
			for(User user:userList)
				if(user.toString().contains(entry)) {				
					SysUtils.runUI(new MenuUI());
					cnt++;
				}
			
			if(cnt == 0)
				System.out.println(String.format("UserNo or UserPwd not found"));
			SysUtils.pause("\nPress Enter to continue...");
			break;
				
		}

	}

}
