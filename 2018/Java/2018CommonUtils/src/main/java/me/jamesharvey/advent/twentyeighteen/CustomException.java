package me.jamesharvey.advent.twentyeighteen;

public class CustomException extends Exception {

	public CustomException(String string) {
		super(string);
	}

	public CustomException(Throwable cause) {
		super(cause);
	}

	public CustomException(String string, Throwable cause) {
		super(string, cause);
	}
}
