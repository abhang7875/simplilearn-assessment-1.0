package com.assignment;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import com.assignment.myexceptions.DirectoryDoesNotExistException;

public class Operations {
	/**
	 * This method will display all the files from the specified directory in ascending
	 * order
	 * 
	 * @author Nilesh
	 * @ModifiedBy Nilesh
	 * @CreatedDate 22-Feb-2022
	 * @ModifiedDate 24-Feb-2022
	 * @param None
	 * @return None
	 * @throws DirectoryDoesNotExistException 
	 */
	public void listFilesFromDirectoryAscending(String filePath) throws DirectoryDoesNotExistException {
		File file = new File(filePath);
		if(file.exists()) {
			if(file.isDirectory()) {
				File [] files = file.listFiles();
				ArrayList<String> data = new ArrayList<String>();
				for(File f : files) {
					if(f.isFile()) {
						data.add(f.getName());
					}
				}
				if(data.size() == 0) {
					System.out.println("No files found at the specified directory..!!");
				}else {
					Collections.sort(data);
					System.out.println("Files found at the " + filePath + " are as follows: ");
					for(String s: data) {
						System.out.println(s);
					}
				}
			}else {
				System.out.println("Specified file is not a directory..!!");
			}
		}else {
			file = new File(System.getProperty("user.dir")+filePath);
			if(file.exists())
				listFilesFromDirectoryAscending(System.getProperty("user.dir")+filePath);
			else
				throw new DirectoryDoesNotExistException();
		}
	}
	
	/**
	 * This method will display all the files from the root directory in ascending
	 * order
	 * 
	 * @author Nilesh
	 * @ModifiedBy Nilesh
	 * @CreatedDate 22-Feb-2022
	 * @ModifiedDate 24-Feb-2022
	 * @param None
	 * @return None
	 * @throws DirectoryDoesNotExistException 
	 */
	public void listFilesFromDirectoryAscending() throws DirectoryDoesNotExistException {
		listFilesFromDirectoryAscending(System.getProperty("user.dir"));
	}

	/**
	 * This helper method to list all files from directory
	 * 
	 * @author Nilesh
	 * @ModifiedBy Nilesh
	 * @CreatedDate 22-Feb-2022
	 * @ModifiedDate 24-Feb-2022
	 * @param array of files, index, level
	 * @return None
	 */
	private void listFilesFromDirectoryHelper(File[] files, int index, int level) {
		// this is terminating condition
		if (index == files.length)
			return;
		// adding -- for internal levels
		for (int i = 0; i < level; i++)
			System.out.print("   ");
		System.out.print("|-");
		// checking the current index is file or directory
		if (files[index].isFile()) {
			System.out.println(files[index].getName());
		} else if (files[index].isDirectory()) {
			System.out.println("{" + files[index].getName() + "}");
			// printing sub directories
			listFilesFromDirectoryHelper(files[index].listFiles(), 0, level + 1);
		}
		// printing main directory
		listFilesFromDirectoryHelper(files, ++index, level);
	}

	/**
	 * This method accepts the path of the directory and checks that the directory
	 * exists or not if it exists then it will print all the files from the
	 * directory in a tree format 
	 * @author Nilesh
	 * @ModifiedBy Nilesh
	 * @CreatedDate 22-Feb-2022
	 * @ModifiedDate 24-Feb-2022
	 * @param path of the directory from which you want to list all files
	 * @return None
	 * @throws DirectoryDoesNotExistException 
	 */
	public void listFilesFromDirectory(String path) throws DirectoryDoesNotExistException {
		// creating object of file to check whether it is directory or file
		File file = new File(path);
		if (file.exists()) {
			System.out.println("Files found at the " + path + " are as follows: ");
			listFilesFromDirectoryHelper(file.listFiles(), 0, 0);
		} else {
			// in case user did not entered absolute path
			path = System.getProperty("user.dir") + path;
			file = new File(path);
			if (file.exists()) {
				System.out.println("Files found at the " + path + " are as follows: ");
				listFilesFromDirectoryHelper(file.listFiles(), 0, 0);
			} else
				throw new DirectoryDoesNotExistException();
		}

	}

	/**
	 * This method will print all the files from the current working directory
	 * @author Nilesh
	 * @ModifiedBy Nilesh
	 * @CreatedDate 22-Feb-2022
	 * @ModifiedDate 24-Feb-2022
	 * @param None
	 * @return None
	 */

	public void listFilesFromDirectory() {
		File file = new File(System.getProperty("user.dir"));
		System.out.println("Files found at current working directory are as follows: ");
		listFilesFromDirectoryHelper(file.listFiles(), 0, 0);
	}

	/**
	 * This method will delete the from the specified directory
	 * @author Nilesh
	 * @ModifiedBy Nilesh
	 * @CreatedDate 22-Feb-2022
	 * @ModifiedDate 24-Feb-2022
	 * @param filePath
	 * @return boolean
	 */

	public boolean deleteFile(String fileName) {
		File file = new File(System.getProperty("user.dir"));
		File [] files = file.listFiles();
		// searching the file
		int index = findFileHelper(files, fileName);
		if(index == -1) {
			System.out.println("File not found..!!");
			return false;
		}
		files[index].delete();
		System.out.println(fileName+" deleted successfully..!!");
		return true;
	}

	/**
	 * This method will return an index of the file found
	 * 
	 * @author Nilesh
	 * @ModifiedBy Nilesh
	 * @CreatedDate 24-Feb-2022
	 * @ModifiedDate 24-Feb-2022
	 * 
	 * @param path fileName 
	 * @return index
	 */
	
	public int findFile(String filePath,String fileName) throws DirectoryDoesNotExistException{
		File file = new File(filePath);
		if(!file.exists()) {
			throw new DirectoryDoesNotExistException();
		}
		return findFileHelper(file.listFiles(),fileName);
	}
	
	/**
	 * This helper method will return an index of the file found
	 * 
	 * @author Nilesh
	 * @ModifiedBy Nilesh
	 * @CreatedDate 22-Feb-2022
	 * @ModifiedDate 24-Feb-2022
	 * 
	 * @param path fileName 
	 * @return index
	 */
	
	private int findFileHelper(File [] files, String fileName) {
		int n = files.length;
		for(int i=0;i<n;i++) {
			String name = files[i].getName().trim();
			if(name.equals(fileName)) {
				System.out.println("Successfully found the file at: "+files[i].getAbsolutePath());
				return i;
			}
		}
		return -1;
	}

	public void createNewFileInRoot(String fileName) {
		String filePath = System.getProperty("user.dir")+"\\files\\"+fileName;
		File file = new File(filePath);
		if(file.exists()) {
			System.out.println("Specified file already exists..!!");
		}else {
			try {
				if(file.createNewFile()) {
					System.out.println("File created successfully..!!");
				}else {
					System.out.println("File already exists..!!");
				}
			} catch (IOException e) {
				System.out.println("Unable create file");
			}
		}
		
	}
}
