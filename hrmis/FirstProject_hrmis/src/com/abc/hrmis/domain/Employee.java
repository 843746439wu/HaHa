package com.abc.hrmis.domain;

import java.text.ParseException;
import java.util.Date;

import com.abc.hrmis.utils.Constants;

public class Employee extends ValueObject implements Comparable<Employee>{
	
	private String payrollNo;//工号
	
	private String telephoneCode;//电话号码
	
	private String lastname;//lastname
	
	private String firstname;//firstname
	
	private String initial;//initial
	
	private int deptNo;//部门编号
	
	private String jobTitle;//职务
	
	private Date hiringDate;//入职时间
	
	public Employee() {
		super();
	}

	public Employee(String payrollNo) {
		super();
		this.payrollNo = payrollNo;
	}

	public String getPayrollNo() {
		return payrollNo;
	}

	public void setPayrollNo(String payrollNo) {
		this.payrollNo = payrollNo;
	}

	public String getTelephoneCode() {
		return telephoneCode;
	}

	public void setTelephoneCode(String telephoneCode) {
		this.telephoneCode = telephoneCode;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getInitial() {
		return initial;
	}

	public void setInitial(String initial) {
		this.initial = initial;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Date getHiringDate() {
		return hiringDate;
	}

	public void setHiringDate(Date hiringDate) {
		this.hiringDate = hiringDate;
	}

	@Override
	public String toString() {
		return String.format("%s:%s:%s:%s:%s:%d:%s:%s", this.payrollNo
													  , this.telephoneCode
													  , this.lastname
													  , this.firstname
													  , this.initial
													  , this.deptNo
													  , this.jobTitle
													  , Constants.SDF.format(this.hiringDate));
	}

	/**
	 * 根据员工信息字符串获得员工对象
	 * @param empInfoStr
	 * 	信息字符串 111:02-98781999:Williams:Nick:T:35:Computer Officer:14-10-2000
	 * @return
	 */
	public static Employee getEmpByStr(String empInfoStr) {
		String[] section = empInfoStr.split("\\:");
		Employee emp = new Employee();
		emp.setPayrollNo(section[0]);
		emp.setTelephoneCode(section[1]);
		emp.setLastname(section[2]);
		emp.setFirstname(section[3]);
		emp.setInitial(section[4]);
		emp.setDeptNo(Integer.parseInt(section[5]));
		emp.setJobTitle(section[6]);
		try {
			emp.setHiringDate(Constants.SDF.parse(section[7]));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return emp;
	}

	@Override
	public int compareTo(Employee otherEmp) {
		
		return this.lastname.compareTo(otherEmp.lastname) ;
	}
	
	public void empOut() {
		System.out.println(this);
	}
	public void empFormattedOut() {
		System.out.println(String.format("%-12s%-10s%-4s%-4s%-14s%-4d%-20s%-10s"
																  , this.lastname
																  , this.firstname
																  , this.initial
																  , this.payrollNo
																  , this.telephoneCode
																  , this.deptNo
																  , this.jobTitle
																  , Constants.SDF.format(this.hiringDate)));
	}
	public void empSimpleOut() {
		System.out.println(String.format("%s,%s,%s",this.lastname,this.firstname,this.telephoneCode));			 
	}
	public void empSimpleFormattedOut() {
		System.out.println(String.format("%-12s%-10s%-14s",this.lastname,this.firstname,this.telephoneCode));			 
	}
	
	public boolean equals(Object obj) {
		if(obj==null)	return false;
		if(obj==this)	return true;
		
		if(obj instanceof Employee) {
			Employee otherEmp = (Employee)obj;
			return otherEmp.payrollNo.equals(this.payrollNo);
		}
		return false;
		
	}
}
