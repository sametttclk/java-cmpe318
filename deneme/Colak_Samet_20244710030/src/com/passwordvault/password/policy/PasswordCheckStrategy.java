package com.passwordvault.password.policy;

public interface PasswordCheckStrategy {
	boolean check(String password);
	String getName();
	
}

/**
 * This interface has two methods for checking password strength. 
 * The 'check' method tests if the password follows a specific rule. 
 * The 'getName' method returns the name of that rule.
 */
