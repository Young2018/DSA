package cn.young22.dsa.appendixB;

import java.util.Scanner;

public class FirstProgram {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Hello");
		System.out.println("Want to talk some more?");
		System.out.println("Please answer yes or not");
		
		String answer = input.nextLine();
		if(answer.equals("yes")){
			System.out.println("It's too good a day to take an exam.");
		}
		
		System.out.println("Goodbye");
	}
}
/**
Output:
Hello
Want to talk some more?
Please answer yes or not
yes
It's too good a day to take an exam.
Goodbye
 */
