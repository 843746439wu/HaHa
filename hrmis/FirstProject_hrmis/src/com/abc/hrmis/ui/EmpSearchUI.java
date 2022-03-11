/**
 * 
 */
package com.abc.hrmis.ui;

import java.util.List;
import java.util.Set;

import com.abc.hrmis.dao.EmployeeDao;
import com.abc.hrmis.dao.EmployeeDaoTxtImpl;
import com.abc.hrmis.domain.Employee;
import com.abc.hrmis.exception.BlankEntryException;
import com.abc.hrmis.utils.SysUtils;

/**
 * 员工信息查找界面
 * 
 * @author Decade
 *
 */
public class EmpSearchUI implements BaseUI {

	@Override
	public void setup() {
		EmployeeDao empDao = new EmployeeDaoTxtImpl();
		List<Employee> empList = empDao.loadEmps();
		
		while(true) {
			System.out.print("Enter Keyword:");
			try {
				String entry = SysUtils.getEntry();
				int cnt = 0;
				
				for(Employee emp:empList)
					if(emp.toString().toUpperCase().contains(entry.toUpperCase())) {
						emp.empOut();
						cnt++;
					}
				
				if(cnt == 0)
					System.out.println(String.format("keyword - %s - not found", entry));
				SysUtils.pause("\nPress Enter to continue...");
				break;
				
			}catch (BlankEntryException e) {
				SysUtils.pause("No keyword entered - try again");
			}
		}
	}

}
