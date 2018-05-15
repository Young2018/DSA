package cn.young22.dsa.appendixE;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextFileOperations {

	public static boolean createTextFile(String fileName, int howMany){
		boolean fileOpened = true;
		PrintWriter toFile = null;
		
		try {
			toFile = new PrintWriter(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			fileOpened = false;	// error opening the file
		}
		
		if(fileOpened){
			Scanner input = new Scanner(System.in);
			System.out.println("Enter " + howMany + " lines of data");
			for(int counter = 1; counter <= howMany; counter++){
				System.out.println("Line " + counter + ": ");
				String line = input.nextLine();
				toFile.println(line);
			} // end for
			
			toFile.close();
		} // end if
		
		return fileOpened;
	} // end createTextFile
} // end TextFileOperation
