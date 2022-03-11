/**
 * 
 */
package com.abc.hrmis.ui;

import com.abc.hrmis.dao.EmployeeDao;
import com.abc.hrmis.dao.EmployeeDaoTxtImpl;
import com.abc.hrmis.domain.Employee;
import com.abc.hrmis.exception.BlankEntryException;
import com.abc.hrmis.utils.SysUtils;

/**
 * 员工信息的删除操作
 * 
 * @author Decade
 *
 */
public class EmpRemoveUI implements BaseUI {

	@Override
	public void setup() {
		
		EmployeeDao empDao = new EmployeeDaoTxtImpl();

		while(true) {
			
			System.out.print("Enter employee’s 3 digit payroll number to enable file deletion: ");
			String entry = null;
			
			try {
				
				entry = SysUtils.getEntry();
				Integer.parseInt(entry);
				
				Employee emp = empDao.getEmpByNo(entry);
				
				if(emp == null) {
					System.out.println(String.format("Employee record for %d not found", entry));
					SysUtils.pause("Press Enter to continue...");
					break;
				}else {
					emp.empOut();
					String payrollNo = entry;
					System.out.print("Confirm record deletion,(y)es or (n)o?");
					
					entry = SysUtils.getEntry(true);
					
					if(!SysUtils.isBlankStr(entry) && entry.trim().toUpperCase().charAt(0)=='Y') {
						empDao.delEmp(payrollNo);
						System.out.println("record deleted");
						
						System.out.print("Delete another? (y)es or (n)o");
						entry = SysUtils.getEntry(true);
						if(!SysUtils.isBlankStr(entry) && entry.trim().toUpperCase().charAt(0)=='Y') {
							continue;
						}
					}
					break;
				}
				
			} catch (BlankEntryException e) {
				SysUtils.pause("No payroll number entered – try again");
			} catch (NumberFormatException e) {
				SysUtils.pause("Payroll number can contain only numerical characters");
			}
		}

	}

}
