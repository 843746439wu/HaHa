/**
 * 
 */
package com.abc.hrmis.ui;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import com.abc.hrmis.dao.EmployeeDao;
import com.abc.hrmis.dao.EmployeeDaoTxtImpl;
import com.abc.hrmis.domain.Employee;
import com.abc.hrmis.exception.BlankEntryException;
import com.abc.hrmis.utils.Constants;
import com.abc.hrmis.utils.SysUtils;

/**
 * 新增员工信息界面
 * 
 * @author Decade
 *
 */
public class EmpRegisterUI implements BaseUI {

	@Override
	public void setup() {
		while(true) {
			Employee emp = new Employee();
			emp.setPayrollNo(this.getPayrollNo());
			emp.setTelephoneCode(this.getTelephoneCode());
			emp.setLastname(this.getLastName());
			emp.setFirstname(this.getFirstName());
			emp.setInitial(this.getInitial());
			emp.setDeptNo(this.getDeptNo());
			emp.setJobTitle(this.getJobTitle());
			emp.setHiringDate(this.getHiringDate());
			//emp.empOut();
			EmployeeDao empDao = new EmployeeDaoTxtImpl();
			empDao.addEmp(emp);
			
			System.out.println("Record Saved \n");
			System.out.println("Add another employee record? (y)es or (n)o");
			String entry = SysUtils.getEntry();
			if(!SysUtils.isBlankStr(entry) && entry.trim().toUpperCase().charAt(0)=='Y') {
				continue;
			}else
				break;
			
		}

	}
	
	private static String getPayrollNo() {
		
		String payrollNo = null;
		while(true) {
			System.out.print("Enter employee 3 digit payroll number:");
			try {
				payrollNo =SysUtils.getEntry();
				Integer.parseInt(payrollNo);
				
				EmployeeDao empDao = new EmployeeDaoTxtImpl();
				List<Employee> empList = empDao.loadEmps();
				
				Employee someEmp = new Employee();
				someEmp.setPayrollNo(payrollNo);
				
				if(empList.contains(someEmp)) {
					SysUtils.pause(String.format("工号：%s已经存在，请检查!", payrollNo));
					continue;
				}
				break;
				
			}catch (BlankEntryException e) {
				SysUtils.pause("No payroll number entered - try again");
			}catch (NumberFormatException e) {
				SysUtils.pause("Payroll number can contain only numerical characters");
			}
		}
		return payrollNo;
		
	}
	
	private static String getTelephoneCode() {
		String phonrCode = null;
		String pattern = "0[2-8]-[1-9][0-9]{7}";
		while(true) {
			System.out.print("Enter Phone Number (02-12345678):");
			try {
				phonrCode = SysUtils.getEntry();
				boolean checkResult = Pattern.matches(pattern, phonrCode);
				if(!checkResult) {
					SysUtils.pause("Invalid phone number - try again");
				}else
					break;
			} catch (BlankEntryException e) {
				SysUtils.pause("No phone number entered - try again");
			}
		}
		return phonrCode;
	}
	
	private static String getLastName() {
		String lastname = null;
		String pattern = "[a-zA-Z]{1,}";
		while(true) {
			System.out.print("Enter Last Name:");
			try {
				lastname = SysUtils.getEntry();
				boolean checkResult = Pattern.matches(pattern, lastname);
				if(!checkResult) {
					SysUtils.pause("Last name can contain only alphabetical characters and spaces ");
				}else
					break;
			} catch (BlankEntryException e) {
				SysUtils.pause("No last name entered - try again");
			}
		}
		return lastname;
	}

	private static String getFirstName() {
		String firstname = null;
		String pattern = "[a-zA-Z]{1,}";
		while(true) {
			System.out.print("Enter First Name:");
			try {
				firstname = SysUtils.getEntry();
				boolean checkResult = Pattern.matches(pattern, firstname);
				if(!checkResult) {
					SysUtils.pause("First name can contain only alphabetical characters and spaces ");
				}else
					break;
			} catch (BlankEntryException e) {
				SysUtils.pause("No First name entered - try again");
			}
		}
		return firstname;
	}
	
	private static String getInitial() {
		String initial = null;
		String pattern = "[a-zA-Z]{1,}";
		while(true) {
			System.out.print("Enter Middle Init:");
			try {
				initial = SysUtils.getEntry();
				boolean checkResult = Pattern.matches(pattern, initial);
				if(!checkResult) {
					SysUtils.pause("Middle Init can contain only alphabetical characters and spaces ");
				}else
					break;
			} catch (BlankEntryException e) {
				SysUtils.pause("No Middle Init entered - try again");
			}
		}
		return initial;
	}
	
	private int getDeptNo() {
		String entry = null;
		while(true) {
			System.out.print("Enter Dept #:");
			try {
				entry = SysUtils.getEntry();
				Integer.parseInt(entry);
				break;
			} catch (BlankEntryException e) {
				SysUtils.pause("Dept # can contain only digits with no spaces");
			} catch (NumberFormatException e) {
				SysUtils.pause("No Dept # entered – try again");
			}
		}
		return Integer.parseInt(entry);
	}
	
	private static String getJobTitle() {
		String jobTitle = null;
		String pattern = "[a-zA-Z]{1,}";
		while(true) {
			System.out.print("Enter Job Title:");
			try {
				jobTitle = SysUtils.getEntry();
				boolean checkResult = Pattern.matches(pattern, jobTitle);
				if(!checkResult) {
					SysUtils.pause("Job title can contain only alphabetical characters and spaces ");
				}else
					break;
			} catch (BlankEntryException e) {
				SysUtils.pause("No Job title entered – try again");
			}
		}
		return jobTitle;
	}
	
	private static Date getHiringDate() {
		Date hiringDate = null;
		while(true) {
			System.out.print("Enter Date Hired (dd-mm-yyyy):");
			try {
				String entry = SysUtils.getEntry();
				Constants.SDF.setLenient(false);
				hiringDate = Constants.SDF.parse(entry);
				break;
			} catch (BlankEntryException e) {
				SysUtils.pause("No date hired entered – try again");
			} catch (ParseException e) {
				SysUtils.pause("Invalid Date Hired");
			}
		}
		return hiringDate;
		
	}
}
