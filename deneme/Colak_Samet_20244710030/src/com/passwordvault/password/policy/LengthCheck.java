package com.passwordvault.password.policy;

public class LengthCheck implements PasswordCheckStrategy {
	
	// This class checks if password length is at least 8 characters

	@Override
	public boolean check(String password) {
		return password.length() >= 8;
	}

	@Override
	public String getName() {
		return "Length Check";
	}

}
