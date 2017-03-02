package com.javatest.string;

import java.util.*;
import java.security.*;

public class AtoString {

	public static void main(String[] args) {

		DoNotTerminate.forbidExit();

		try {
			Scanner in = new Scanner(System.in);
			int n = in.nextInt();
			in.close();
			StringBuffer buffer = new StringBuffer();
			int temp = n;
			boolean isNeg = false;
			if (temp < 0) {
				isNeg = true;
				temp *= -1;
			} 
			
			if(temp == 0) {
				buffer.append('0');
			} else {
				while (temp > 0) {
					buffer.append(temp % 10);
					temp = temp / 10;
				}
			}
			if(isNeg) 
				buffer.append("-");
			buffer = buffer.reverse();
			String s = buffer.toString();
			
			
			if (n == Integer.parseInt(s)) {
				System.out.println("Good job");
			} else {
				System.out.println("Wrong answer.");
			}
		} catch (DoNotTerminate.ExitTrappedException e) {
			System.out.println("Unsuccessful Termination!!");
		}
	}
}

// The following class will prevent you from terminating the code using exit(0)!
class DoNotTerminate {

	public static class ExitTrappedException extends SecurityException {

		private static final long serialVersionUID = 1;
	}

	public static void forbidExit() {
		final SecurityManager securityManager = new SecurityManager() {
			@Override
			public void checkPermission(Permission permission) {
				if (permission.getName().contains("exitVM")) {
					throw new ExitTrappedException();
				}
			}
		};
		System.setSecurityManager(securityManager);
	}
}
