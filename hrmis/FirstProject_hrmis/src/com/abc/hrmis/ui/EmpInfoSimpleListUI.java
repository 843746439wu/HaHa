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
 * Ա����Ϣ�ļ��б����(��������)
 * 
 * @author Decade
 *
 */
public class EmpInfoSimpleListUI implements BaseUI {

	@Override
	public void setup() {
		EmployeeDao empDao = new EmployeeDaoTxtImpl();
		Set<Employee> empList = empDao.loadSortedEmps();
		
		for(Employee emp:empList)
			emp.empSimpleOut();
		SysUtils.pause("\nPress Enter to continue... ");

	}

}
