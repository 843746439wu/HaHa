/**
 * 
 */
package com.abc.hrmis.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.abc.hrmis.dao.EmployeeDao;
import com.abc.hrmis.dao.EmployeeDaoTxtImpl;
import com.abc.hrmis.domain.Employee;
import com.abc.hrmis.utils.Constants;
import com.abc.hrmis.utils.SysUtils;

/**
 * @author Decade
 *
 */
public class EmpInfoUpdataUI implements BaseUI {

	@Override
	public void setup() {
		File file = new File(Constants.DATA_FILE);
		Long fileLength = file.length();
		byte[] fileContext = new byte[fileLength.intValue()];
		FileInputStream in = null;
		PrintWriter out = null;
		EmployeeDao empDao = new EmployeeDaoTxtImpl();
		List<Employee> empList = empDao.loadEmps();
		
		while(true) {
			System.out.print("Data to modify:");
			String entry1 = SysUtils.getEntry();
			int cnt = 0;
			for(Employee emp:empList)
				if(emp.toString().toUpperCase().contains(entry1.toUpperCase())) {
					emp.empOut();
					cnt++;
				}
			
			if(cnt == 0) 
				System.out.println(String.format("Data - %s - not found", entry1));
				
			if(cnt>0) {
				System.out.print("Modify data to:");
				String entry2 = SysUtils.getEntry();
				try {
					in = new FileInputStream(Constants.DATA_FILE);
					in.read(fileContext);
					String str = new String(fileContext, "utf-8");
					str = str.replace(entry1, entry2);
					out = new PrintWriter(Constants.DATA_FILE);
					out.write(str);
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						out.flush();
						out.close();
						in.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Data modification succeeded");
				break;
			}
		}
		SysUtils.pause("\nPress Enter to continue...");
	}
}
