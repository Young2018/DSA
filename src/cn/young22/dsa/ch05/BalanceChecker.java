package cn.young22.dsa.ch05;

import cn.young22.dsa.ch06.LinkedStack;

public class BalanceChecker {
	public static boolean checkBalance(String expression){
		//假设LinkedStack已经存在
		StackInterface<Character> openDelimiterStack = new LinkedStack<>();
		
		int characterCount = expression.length();
		boolean isBalanced = true;
		int index = 0;
		char nextCharacter = ' ';
		
		while(isBalanced && (index < characterCount)){
			nextCharacter = expression.charAt(index);
			switch(nextCharacter){
			case '(': case '[': case '{':
				openDelimiterStack.push(nextCharacter);
				break;
			case ')': case ']': case '}':
				if(openDelimiterStack.isEmpty()){
					isBalanced = false;
				}else{
					char openDelimiter = openDelimiterStack.pop();
					isBalanced = isPaired(openDelimiter, nextCharacter);
				}
				break;
			} //end switch
			index++;
		}//end while
		
		if(!openDelimiterStack.isEmpty()){
			isBalanced = false;
		}
		return isBalanced;	
	}
	
	private static boolean isPaired(char open, char close){
		return(open == '(' && close == ')' ||
				open == '[' && close == ']' ||
				open == '{' && close == '}');
	}//end isPaired
}
