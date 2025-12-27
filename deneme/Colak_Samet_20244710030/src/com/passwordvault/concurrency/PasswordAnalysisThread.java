package com.passwordvault.concurrency;

import com.passwordvault.password.policy.PasswordCheckStrategy;

//This class runs a password check in a separate thread

public class PasswordAnalysisThread extends Thread {
 private PasswordCheckStrategy strategy;
 private String password;

 public PasswordAnalysisThread(PasswordCheckStrategy strategy, String password) {
     this.strategy = strategy;
     this.password = password;
 }

 // Runs the check and prints result (STRONG or WEAK)
 public void run() {
     try {
         // Wait random time to simulate delay
         Thread.sleep((int)(Math.random() * 350));
     } catch (InterruptedException e) {
         e.printStackTrace();
     }

     boolean result = strategy.check(password);
     System.out.println("[" + strategy.getName() + "] Result: " + (result ? "STRONG" : "WEAK"));
 }
}
