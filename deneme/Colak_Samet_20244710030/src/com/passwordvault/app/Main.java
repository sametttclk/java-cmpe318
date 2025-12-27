package com.passwordvault.app;

import java.util.Scanner;

import com.passwordvault.service.CredentialManager;

import com.passwordvault.concurrency.PasswordAnalysisThread;
import com.passwordvault.exception.DuplicatePlatformException;
import com.passwordvault.model.Credential;
import com.passwordvault.password.policy.CaseCheck;
import com.passwordvault.password.policy.LengthCheck;
import com.passwordvault.password.policy.SpecialCharCheck;

public class Main {
 public static void main(String[] args) {
	 
	// Use try-with-resources to automatically close the Scanner after use.
	// This helps prevent resource leaks and is a best practice for input handling.

     try (Scanner scanner = new Scanner(System.in)) {
		CredentialManager manager = new CredentialManager();

		 while (true) {
		     System.out.println("1 - Add Credential");
		     System.out.println("2 - View All Credentials");
		     System.out.println("3 - Filter by Platform");
		     System.out.println("4 - Exit");
		     System.out.print("Choice: ");

		     String choice = scanner.nextLine();

		     switch (choice) {
		         case "1":
		             System.out.print("Platform: ");
		             String platform = scanner.nextLine();
		             
		             // If platform is empty, skip adding
		             if (platform.trim().isEmpty()) {
		                 System.out.println("No platform entered. Returning to main menu.");
		                 break;
		             }

		             System.out.print("Username: ");
		             String username = scanner.nextLine();
		             
		             // If username is empty, skip adding
		             if (username.trim().isEmpty()) {
		                 System.out.println("No username entered. Returning to main menu.");
		                 break;
		             }

		             System.out.print("Password: ");
		             String password = scanner.nextLine();

		             // If password is empty, skip adding
		             if (password.trim().isEmpty()) {
		                 System.out.println("No password entered. Returning to main menu.");
		                 break;
		             }

		             // Run password checks in separate threads
		             PasswordAnalysisThread lengthCheck = new PasswordAnalysisThread(new LengthCheck(), password);
		             PasswordAnalysisThread caseCheck = new PasswordAnalysisThread(new CaseCheck(), password);
		             PasswordAnalysisThread specialCheck = new PasswordAnalysisThread(new SpecialCharCheck(), password);

		             lengthCheck.start();
		             caseCheck.start();
		             specialCheck.start();

		             // Wait for all threads to finish
		             try {
		                 lengthCheck.join();
		                 caseCheck.join();
		                 specialCheck.join();

		                 // Try to add the credential
		                 manager.addCredential(new Credential(platform, username, password));
		             } catch (DuplicatePlatformException e) {
		                 System.out.println("Error: " + e.getMessage());
		             } catch (InterruptedException e) {
		                 e.printStackTrace();
		             }

		             break;

		         case "2":
		             manager.printAll(); // Show all credentials
		             break;

		         case "3":
		             System.out.print("Enter keyword: ");
		             String keyword = scanner.nextLine();
		             manager.filterByPlatform(keyword); // Filter result
		             break;

		         case "4":
		             System.out.println("Closed Successfully.");
		             return;

		         default:
		             System.out.println("Invalid option.");
		             break;
		     }
		 }
	}
 }
}

