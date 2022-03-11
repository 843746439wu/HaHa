/**
 * 
 */
package com.abc.hrmis.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.prefs.BackingStoreException;

import com.abc.hrmis.exception.BlankEntryException;
import com.abc.hrmis.ui.BaseUI;

/**
 * ϵͳ������
 * 
 * @author Decade
 *
 */
public class SysUtils {
	
	public static String getEntry() {
		return getEntry(false);
		
	}
	
	/**
	 * �ӿ���̨���һ������
	 * @return
	 * @throws BackingStoreException 
	 */
	public static String getEntry(boolean allowBlank) {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String entry = null;
		try {
			entry = reader.readLine();
			if(isBlankStr(entry) && !allowBlank) {
				throw new BlankEntryException("No selection entered. Press Enter to continue��");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entry;
	}
	
	/**
	 * �ַ����մ��ж�
	 * @param str
	 * @return
	 */
	public static boolean isBlankStr(String str) {
		return str==null || str.trim().length()==0;
	}
	
	public static void pause() {
		getEntry(true);
	}
	
	public static void pause(String message){
		System.out.print(message);
		pause();
	}
	
	//����UI����
	public static void runUI(BaseUI ui){
		ui.setup();
	}
	
}
