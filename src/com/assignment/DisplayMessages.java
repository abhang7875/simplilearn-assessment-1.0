package com.assignment;

public class DisplayMessages {
	/**
	 * This method will display welcome message with developer details
	 * @param None
	 * @return None
	 * 
	 */
	public DisplayMessages() {
		System.out.println("Welcome to the Lockedme.com");
		System.out.println("Developed By - Nilesh Abhang");
	}
	
	/**
	 * This method will display main menu 
	 * and options available to perform the operation.
	 * @param None
	 * @return None
	 * 
	 */
	public void displayMainMenu() {
		System.out.println("1) List all files.");
		System.out.println("2) Perform other file operations");
		System.out.println("3) Exit");
		System.out.print("Select any option from the above list: ");
	}
	
	/**
	 * This method will display option-1 menu  
	 * and options available to perform the operation.
	 * @param None
	 * @return None
	 * 
	 */
	public void displayOption1Menu() {
		System.out.println("1) Show complete root directory");
		System.out.println("2) Show complete user specified directory");
		System.out.println("3) Show only files from root directory");
		System.out.println("4) Show only files from user specified directory");
		System.out.println("5) Back to main menu");
		System.out.print("Select any option from the above list: ");
	}
	
	/**
	 * This method will display option-2 menu  
	 * and options available to perform the operation.
	 * @param None
	 * @return None
	 * 
	 */
	public void displayOption2Menu() {
		System.out.println("1) Add file to root directory");
		System.out.println("2) Delete file from root directory");
		System.out.println("3) Search a file from root directory");
		System.out.println("4) Back to main menu");
		System.out.print("Select any option from the above list: ");
	}
}
