package com.assistance.studentstaff.common;

public class CustomGenericException extends Exception{
	
	private static final long serialVersionUID = -8838519223065672833L;
	private String errMsg;
	private String errDebugMsg;
	
	public CustomGenericException(String errMsg, String errDebugMsg) {
		super();
		this.errMsg = errMsg;
		this.errDebugMsg = errDebugMsg;
	}

	public CustomGenericException(String errMsg) {
		super();
		this.errMsg = errMsg;
		this.errDebugMsg = errMsg;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getErrDebugMsg() {
		return errDebugMsg;
	}

	public void setErrDebugMsg(String errDebugMsg) {
		this.errDebugMsg = errDebugMsg;
	}

}
