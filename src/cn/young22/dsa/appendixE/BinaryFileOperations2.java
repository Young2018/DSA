package cn.young22.dsa.appendixE;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class BinaryFileOperations2 {

	public static int createRandomIntegerFile(String fileName, int howMany) {
		int resultCode = 0;
		Random generator = new Random();
		DataOutputStream toFile = null;

		FileOutputStream fos;
		try {
			fos = new FileOutputStream(fileName);

			toFile = new DataOutputStream(fos);

			for (int counter = 0; counter < howMany; counter++) {
				toFile.writeInt(generator.nextInt());
			}

		} catch (FileNotFoundException e) {
			resultCode = 1; // Error opening file
		} catch (IOException e) {
			resultCode = 2; // Error writing file
		} finally {

			try {
				if (toFile != null) {
					toFile.close();
				}
			} catch (IOException e) {
				resultCode = 3; // Error closing file
			}
		}
		return resultCode;
	} // end createRandomIntegerFile

	public static int displayBinaryFile(String fileName) {
		int resultCode = 0;
		DataInputStream fromFile = null;

		FileInputStream fis;
		try {
			fis = new FileInputStream(fileName);
			fromFile = new DataInputStream(fis);

			while (true) {
				int number = fromFile.readInt();
				System.out.println(number);
			}

		} catch (FileNotFoundException e) {
			resultCode = 1; // Error opening file
		} catch (EOFException e) {
			// Normal occurrence since entire file is read
		} catch (IOException e) {
			resultCode = 2; // Error reading file
		}

		finally {

			try {
				if (fromFile != null) {
					fromFile.close();
				}
			} catch (IOException e) {
				resultCode = 3; // Error closing file
			}
		}
		
		return resultCode;
	} // end displayBinaryCode
} // end BinaryFileOperations1
