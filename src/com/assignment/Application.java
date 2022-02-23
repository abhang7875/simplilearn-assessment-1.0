package com.assignment;

import java.util.Scanner;

import com.assignment.myexceptions.DirectoryDoesNotExistException;
import com.assignment.myexceptions.InvalidChoiceException;

public class Application {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = -1;
		Operations op = new Operations();
		DisplayMessages display = new DisplayMessages();
		while (choice != 3) {
			try {
				display.displayMainMenu();
				choice = Integer.parseInt(sc.nextLine().trim());
				if (choice == 1) {
					choice = 0;
					while (choice != 5) {
						display.displayOption1Menu();
						choice = Integer.parseInt(sc.nextLine().trim());
						if (choice == 1) {
							op.listFilesFromDirectory();
						} else if (choice == 2) {
							System.out.print("Please enter valid directory: ");
							String path = sc.nextLine();
							op.listFilesFromDirectory(path);
						} else if (choice == 3) {
							op.listFilesFromDirectoryAscending();
						} else if (choice == 4) {
							System.out.print("Please enter valid directory: ");
							String path = sc.nextLine();
							op.listFilesFromDirectoryAscending(path);
						} else if (choice == 5) {
							System.out.println("Navigating back to the main menu");
						} else {
							throw new InvalidChoiceException();
						}
						choice = -1;
					}
				}else if(choice == 2) {
					choice = 0;
					while(choice != 4) {
						display.displayOption2Menu();
						choice = Integer.parseInt(sc.nextLine().trim());
						if(choice == 1) {
							System.out.print("Enter a valid file name: ");
							String fileName = sc.nextLine();
							op.createNewFileInRoot(fileName);
						}else if(choice == 2) {
							System.out.print("Enter a valid file name: ");
							String fileName = sc.nextLine();
							op.deleteFile(fileName);
						}else if(choice == 3) {
							System.out.print("Enter a valid file name: ");
							String fileName = sc.nextLine();
							int a = op.findFile(System.getProperty("user.dir"), fileName);
							if(a==-1) {
								System.out.println("File not found at root directory");
							}
						}else if(choice == 4) {
							System.out.println("Navigating back to the main menu");
						}else {
							throw new InvalidChoiceException();
						}
					}
					choice = -1;
				}else if (choice == 3){
					System.out.println("Thanks for using our application.");
				}else {
					throw new InvalidChoiceException();
				}
			} catch (NumberFormatException e) {
				System.out.println("Please enter numberic value..!!");
				System.out.println("Navigating back to the main menu");
			} catch (DirectoryDoesNotExistException e) {
				System.out.println(e.getMessage());
				System.out.println("Navigating back to the main menu");
			} catch (InvalidChoiceException e) {
				System.out.println(e.getMessage());
				System.out.println("Navigating back to the main menu");
			}
		}
		sc.close();
	}
}
