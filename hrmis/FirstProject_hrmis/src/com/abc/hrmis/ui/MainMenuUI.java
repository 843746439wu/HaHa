package com.abc.hrmis.ui;

import com.abc.hrmis.exception.HRMISException;
import com.abc.hrmis.utils.SysUtils;

public class MainMenuUI implements BaseUI {


	@Override
	public void setup() {
		boolean isContinued = true;
		String entry = null;
		
		while(isContinued) {
			System.out.println("\n ===Main Menu===\n");
			System.out.println("=====================================================\n");
			System.out.println("1 - Sign in\n\n");
			System.out.println("2 ¨C Register\n\n");
			System.out.println("3 ¨C MenuPart\n\n");
			System.out.println("4 - Quit\n\n");
			System.out.print("Your Selection:");
			
			try {
				entry = SysUtils.getEntry();
			} catch (HRMISException e) {
				SysUtils.pause(e.getMessage());
				continue;
			}
			
			char choose = entry.toUpperCase().charAt(0);
			switch (choose) {
				case '1':
					SysUtils.runUI(new UserLognUI());
					break;
				case '2':
					SysUtils.runUI(new UserRegisterUI());
					break;	
				case '3':
					SysUtils.runUI(new MenuPartUI());
					break;
				case '4':
					isContinued=false;
					break;
				default:
					SysUtils.pause("Invalid code! Press Enter to continue¡­");
					break;
			}
			
		}
		System.out.println("thank you for using HRMISS");					
	}

}

