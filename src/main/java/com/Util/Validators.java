package com.Util;

public class Validators {

	public static boolean isBlank(String data) {
		return (data == null || data.trim().length() == 0 || data.equals("-1"));
	}
	
	public static boolean isAlpha(String data) {
		String alphaRegex = "[A_Za-z]+";
		return !data.matches(alphaRegex);
		
	}
}
