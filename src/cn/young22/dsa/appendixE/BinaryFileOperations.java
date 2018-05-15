package cn.young22.dsa.appendixE;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class BinaryFileOperations {
	
	public static int createRandomIntegerFile(String fileName, int howMany){
		int resultCode = 0;
		Random generator = new Random();
		DataOutputStream toFile = null;
		
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			toFile = new DataOutputStream(fos);
			
			for(int counter = 0; counter < howMany; counter++){
				toFile.writeInt(generator.nextInt());
			}
			
		} catch (FileNotFoundException e) {
			resultCode = 1;		// Error opening file
		} catch (IOException e) {
			resultCode = 2;		// Error writing file
		}
		finally{
			try{
				if(toFile != null){
					toFile.close();
				}
			}
			catch(IOException e){
				resultCode = 3;	// Error closing file
			}
		}
		return resultCode;
	}
	
}
