package com.passwordvault.exception;

//This exception is thrown when platform already exists in saved list
public class DuplicatePlatformException extends Exception {
	// This ID is added to remove the serialization warning
	private static final long serialVersionUID = 1L;

	public DuplicatePlatformException(String message) {
     super(message); 
 }
}
