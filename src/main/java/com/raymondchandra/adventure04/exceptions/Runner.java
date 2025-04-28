package com.raymondchandra.adventure04.exceptions;

//--- 3B ---
public class Runner {
	
	public static void loveThrowingExceptionInPurpose () throws MyException  {
		throw new MyException("I just throw and exception. So what? Any problem?");
	}
	
	public static void main(String[] args) throws MyException {
		Runner.loveThrowingExceptionInPurpose();
	}
}
