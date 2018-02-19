package cn.young22.dsa.ch05;

/** ����BalanceChecker�࣬
 *  ʹ��һ��ƽ��ı��ʽ��һ����ƽ��ı��ʽ������BalanceChecker��
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