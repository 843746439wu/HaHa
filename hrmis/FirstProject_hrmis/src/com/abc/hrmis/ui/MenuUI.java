/**
 * 
 */
package com.abc.hrmis.ui;

import com.abc.hrmis.exception.HRMISException;
import com.abc.hrmis.utils.SysUtils;

/**
 * 主菜单界面
 * 
 * @author Decade
 *
 */
public class MenuUI implements BaseUI {
	
	private static final String MENU_INFO;
	static {
		StringBuilder sb = new StringBuilder();
		sb.append("\n讯通科技 - Employee Information - Main Menu\n")
		  .append("=====================================================\n")
		  .append("1 - Print All Current Records\n")
		  .append("2 – Print All Current Records (formatted)\n")
		  .append("3 – Print Names and Phone Numbers\n")
		  .append("4 – Print Names and Phone Numbers (formatted)\n")
		  .append("5 - Search for specific Record(s)\n")
		  .append("6 - Add New Records\n")
		  .append("7 – Delete Records\n")
		  .append("8 – Updata Records\n\n")
		  .append("Q - Quit\n\n")
		  .append("Your Selection:");
		MENU_INFO = sb.toString();
	}
	
	@Override
	public void setup() {
		
		boolean isContinued = true;
		String entry = null;
		
		while(isContinued) {
			MenuUI.printMenu();
			try {
				entry = SysUtils.getEntry();
			} catch (HRMISException e) {
				SysUtils.pause(e.getMessage());
				continue;
			}
			
			char choose = entry.toUpperCase().charAt(0);
			switch (choose) {
				case '1':
					SysUtils.runUI(new EmpInfoListUI());
					break;
				case '2':
					SysUtils.runUI(new EmpInfoFormattedListUI());
					break;
				case '3':
					SysUtils.runUI(new EmpInfoSimpleListUI());
					break;
				case '4':
					SysUtils.runUI(new EmpInfoSimpleFormattedListUi());		
					break;
				case '5':
					SysUtils.runUI(new EmpSearchUI());			
					break;
				case '6':
					SysUtils.runUI(new EmpRegisterUI());				
					break;
				case '7':
					SysUtils.runUI(new EmpRemoveUI());	
					break;
				case '8':
					SysUtils.runUI(new EmpInfoUpdataUI());	
					break;
				case 'Q':
					isContinued=false;
					break;
				default:
					SysUtils.pause("Invalid code! Press Enter to continue…");
					break;
			}
			
		}
		
		  
	}
	//打印菜单
	private static void printMenu() {
		System.out.print(MENU_INFO);
	}

}
