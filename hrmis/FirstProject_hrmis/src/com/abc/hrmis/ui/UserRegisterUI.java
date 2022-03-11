package com.abc.hrmis.ui;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UserRegisterUI implements BaseUI {

	@Override
	public void setup() {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = null;

		try {
			writer = new PrintWriter(new FileOutputStream("D:\\XunKe\\FirstProject\\UserPwd.txt",true));
			
			System.out.print("’À∫≈:");
			String entry1 = null;
			String entry2 = null;
			
			entry1 = reader.readLine();

			System.out.print("√‹¬Î:");
			
			entry2 = reader.readLine();
			writer.println(entry1+","+entry2);
			
			System.out.println("save is ok!");
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			writer.flush();
			writer.close();
		}
	}

}


