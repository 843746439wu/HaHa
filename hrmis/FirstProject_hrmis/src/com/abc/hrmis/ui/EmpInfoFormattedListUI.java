/**
 * 
 */
package com.abc.hrmis.ui;

import java.util.Set;

import com.abc.hrmis.dao.EmployeeDao;
import com.abc.hrmis.dao.EmployeeDaoTxtImpl;
import com.abc.hrmis.domain.Employee;
import com.abc.hrmis.utils.SysUtils;

/**
 * 员工信息的格式化列表界面(全属性)
 * 
 * @author Decade
 *
 */
public class EmpInfoFormattedListUI implements BaseUI {

	@Override
	public void setup() {
		EmployeeDao empDao = new EmployeeDaoTxtImpl();
		Set<Employee> empList = empDao.loadSortedEmps();
		
		for(Employee emp:empList)
			emp.empFormattedOut();
		SysUtils.pause("\nPress Enter to continue... ");
	}

}
