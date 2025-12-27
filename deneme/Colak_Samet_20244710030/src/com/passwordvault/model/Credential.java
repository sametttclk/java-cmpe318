package com.passwordvault.model;

import java.time.LocalDateTime;

//This class holds information about a saved credential.
//This class is kept in the platform, username, password and createdAt fields.
//They are kept in String format.
public class Credential {
 String platform;
 String username;
 String password;
 LocalDateTime createdAt;

 public Credential(String platform, String username, String password) {
     this.platform = platform;
     this.username = username;
     this.password = password;
     this.createdAt = LocalDateTime.now(); // Save current time
 }

 // Returns the credential info in sample run format
 public String toString() {
     return platform + " | " + username + " | " + password + " | " + createdAt;
 }

public String getPlatform() {
	return platform;
}

public void setPlatform(String platform) {
	this.platform = platform;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public LocalDateTime getCreatedAt() {
	return createdAt;
}

public void setCreatedAt(LocalDateTime createdAt) {
	this.createdAt = createdAt;
}

}
