package cn.young22.dsa.ch05;

/** 测试BalanceChecker类，
 *  使用一个平衡的表达式和一个不平衡的表达式来测试BalanceChecker类
 * */
public class BalanceCheckerDemo {
	public static void main(String[] args){
		String expression = "a {b [c (d + e)/2 - f] + 1}";
		boolean isBalanced = BalanceChecker.checkBalance(expression);
		
		if(isBalanced){
			System.out.println(expression + " is balanced");
		}else{
			System.out.println(expression + " is not balanced");
		}
		
		String expression1 = "a {b [c (d + e)/2 - f + 1}";
		boolean isBalanced1 = BalanceChecker.checkBalance(expression1);
		if(isBalanced1){
			System.out.println(expression1 + " is balanced");
		}else{
			System.out.println(expression1 + " is not balanced");
		}
	}
}
/*
Output:
a {b [c (d + e)/2 - f] + 1} is balanced
a {b [c (d + e)/2 - f + 1} is not balanced
*/