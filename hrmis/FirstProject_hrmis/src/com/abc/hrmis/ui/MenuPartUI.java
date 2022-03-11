/**
 * 
 */
package com.abc.hrmis.ui;

import com.abc.hrmis.exception.HRMISException;
import com.abc.hrmis.utils.SysUtils;

/**
 * @author Decade
 *
 */
public class MenuPartUI implements BaseUI {

	
		private static final String MENU_INFO;
		static {
			StringBuilder sb = new StringBuilder();
			sb.append("\n讯通科技 - Employee Information - Main Menu\n")
			  .append("=====================================================\n")
			  .append("1 - Print All Current Records\n")
			  .append("2 - Search for specific Record(s)\n")
			  .append("Q - Quit\n\n")
			  .append("Your Selection:");
			MENU_INFO = sb.toString();
		}
		
		@Override
		public void setup() {
			
			boolean isContinued = true;
			String entry = null;
			
			while(isContinued) {
				MenuPartUI.printMenuPart();
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
						SysUtils.runUI(new EmpSearchUI());			
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
		private static void printMenuPart() {
			System.out.print(MENU_INFO);
		}

}


