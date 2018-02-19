package cn.young22.dsa.ch05;

public class BalanceCheckerDemo {
	public static void main(String[] args){
		String expression = "a {b [c (d + e)/2 - f] + 1}";
		boolean isBalanced = BalanceChecker.checkBalance(expression);
		
		if(isBalanced){
			System.out.println(expression + " is balanced");
		}else{
			System.out.println(expression + " is not balanced");
		}
	}
}
//expected output
//a {b [c (d + e)/2 - f] + 1} is balanced
