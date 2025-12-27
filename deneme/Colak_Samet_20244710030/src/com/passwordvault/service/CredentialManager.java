package com.passwordvault.service;

import java.util.ArrayList;
import java.util.List;

import com.passwordvault.exception.DuplicatePlatformException;
import com.passwordvault.model.Credential;

//This class manages all saved credentials
public class CredentialManager {
 private List<Credential> credentials = new ArrayList<>();

 // Adds a new credential if platform is not already saved
 public void addCredential(Credential credential) throws DuplicatePlatformException {
     for (Credential c : credentials) {
         // Check if same platform name already exists (ignore case)
         if (c.getPlatform().equalsIgnoreCase(credential.getPlatform())) {
             throw new DuplicatePlatformException("Platform already exists!");
         }
     }
     credentials.add(credential); // Add if no duplicate
     System.out.println("Credential added successfully.");
 }

 //Prints all saved credentials using Stream API for iteration
 public void printAll() {
	    credentials.stream().forEach(System.out::println);
	}

//Filters and shows credentials whose platform starts with the first letter of the given keyword (case insensitive) using Stream API
 public void filterByPlatform(String keyword) {
	    char firstChar = keyword.toLowerCase().charAt(0);
	    credentials.stream()
	        .filter(c -> c.getPlatform().toLowerCase().charAt(0) == firstChar)
	        .forEach(System.out::println);
	    
	    System.out.println();
	}

}