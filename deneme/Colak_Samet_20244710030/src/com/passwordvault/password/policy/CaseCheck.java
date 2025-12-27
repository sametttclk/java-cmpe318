package com.passwordvault.password.policy;

public class CaseCheck implements PasswordCheckStrategy {
	
	// This class checks if password has both upper and lower case letters

	@Override
    public boolean check(String password) {
        boolean hasUpper = false;
        boolean hasLower = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
            	hasUpper = true;
            	break;
            }
        }
        for (char c : password.toCharArray()) {
        	if (Character.isLowerCase(c)) {
            	hasLower = true;
            	break;
            }
        }

        return hasUpper && hasLower; // Return true if both exist
    }

	@Override
	public String getName() {
		return "Case Check";
	}

}
