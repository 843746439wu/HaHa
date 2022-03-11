package com.abc.hrmis.dao;

import java.util.List;
import java.util.Set;

import com.abc.hrmis.domain.Employee;

/**
 * DAO:Data Access Object
 * ��ר�Ÿ���ĳ��ҵ��ʵ������ݴ�ȡ����
 * @author Decade
 *
 */

public interface EmployeeDao {

	List<Employee> loadEmps();
	Set<Employee> loadSortedEmps();
	void addEmp(Employee emp);
	Employee getEmpByNo(String payrollNo);
	void delEmp(String payrollNo);
	
}
