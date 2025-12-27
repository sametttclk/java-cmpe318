package com.passwordvault.password.policy;

public class SpecialCharCheck implements PasswordCheckStrategy {
	
	// This class checks if password includes at least one special character

	@Override
	public boolean check(String password) {
		return password.matches(".*[!@#$%^&*].*");
	}

	@Override
	public String getName() {
		return "Special Char Check";
	}

}
