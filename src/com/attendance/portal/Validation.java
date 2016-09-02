package com.attendance.portal;

public class Validation {
	public final boolean isValid;
	public final String accountType;
	public Validation(boolean isValid, String accountType){
		this.isValid = isValid;
		this.accountType = accountType;
	}
}
