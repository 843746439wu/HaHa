/**
 * 
 */
package com.abc.hrmis.exception;

/**
 * ϵͳ���쳣
 * 
 * @author Decade
 *
 */
public class HRMISException extends RuntimeException {
	
	public HRMISException() {
		super();
	}
	
	public HRMISException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public HRMISException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public HRMISException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public HRMISException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public HRMISException(String message,Throwable cause,boolean enable) {}
	
}
