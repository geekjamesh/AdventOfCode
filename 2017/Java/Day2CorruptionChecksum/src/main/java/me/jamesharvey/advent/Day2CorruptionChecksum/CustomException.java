package me.jamesharvey.advent.Day2CorruptionChecksum;

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
