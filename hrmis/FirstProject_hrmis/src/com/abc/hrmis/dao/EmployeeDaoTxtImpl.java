/**
 * 
 */
package com.abc.hrmis.dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.abc.hrmis.domain.Employee;
import com.abc.hrmis.utils.Constants;

/**
 * @author Decade
 *
 */
public class EmployeeDaoTxtImpl implements EmployeeDao {

	@Override
	public List<Employee> loadEmps() {
		
		BufferedReader reader = null;
		List<Employee> empList = new ArrayList<>();

		try {
			reader = new BufferedReader( new InputStreamReader(new FileInputStream(Constants.DATA_FILE)));
			String entry = null;
			while((entry = reader.readLine())!=null){
				empList.add(Employee.getEmpByStr(entry));
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
		return empList;
	}

	@Override
	public Set<Employee> loadSortedEmps() {
		TreeSet<Employee> empSet = new TreeSet<>(this.loadEmps());
		return empSet;
	}

	@Override
	public void addEmp(Employee emp) {
		
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new FileOutputStream(Constants.DATA_FILE,true));
			writer.println(emp.toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			writer.flush();
			writer.close();
		}
		
	}

	@Override
	public Employee getEmpByNo(String payrollNo) {
		List<Employee> empList = this.loadEmps();
		
		for(Employee emp:empList)
			if(emp.getPayrollNo().equals(payrollNo))
				return emp;
		return null;
	}

	@Override
	public void delEmp(String payrollNo) {
		List<Employee> empList = this.loadEmps();
		
		empList.remove(new Employee(payrollNo));
		PrintWriter writer = null;
		
		try {
			writer = new PrintWriter(new FileOutputStream(Constants.DATA_FILE));
			for(Employee emp:empList)
				writer.println(emp);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			writer.flush();
			writer.close();
		}
		
	}

}
