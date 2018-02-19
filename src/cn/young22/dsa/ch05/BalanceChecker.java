package cn.young22.dsa.ch05;

import cn.young22.dsa.ch06.LinkedStack;

/** 检测表达式是否平衡的类
 * 	在一个中缀表达式中，若括弧成对出现，且无交叉使用，则说表达式是平衡的
 *  若括弧不是成对出现的或括弧有交叉使用，则说该中缀表达式是不平衡的
 *  我们使用栈这样的工具来进队中缀表达式是否平衡进行判断
 * */
public class BalanceChecker {
	/** 检查表达式平衡方法*/
	public static boolean checkBalance(String expression){
		// 创建一个LinkedStack类型的对象，将其赋值给StackInterface<Character>类型的遍历openDelimiterStack
		StackInterface<Character> openDelimiterStack = new LinkedStack<>();
		
		int characterCount = expression.length();	// 使用字符串的.length方法获得表达式的长度
		boolean isBalanced = true;					// 将表达式初试的平衡标识符设为true
		int index = 0;								// 循环控制下标
		char nextCharacter = ' ';					// 初始化nextCharcter为 ' '
		
		// 当表达式为平衡且下标控制符index小于字符串的长度时，进入循环
		// 若判断出表达式不平衡, 则结束循环
		// 或下标控制符index不小于characterCount,
		// 则说明表达式的括弧没有交叉使用，结束循环
		// 还要进一步判断栈中是否还有字符来判断表达式是否是平衡的
		while(isBalanced && (index < characterCount)){
			// 通过index每次取一个字符进行判断
			nextCharacter = expression.charAt(index);
			// 使用switch case语句进行配对
			switch(nextCharacter){
			case '(': case '[': case '{':
				// 若字符为 ( [ {, 则将该字符压进栈,然后再判断下一个字符
				openDelimiterStack.push(nextCharacter);
				break;
			case ')': case ']': case '}':
				// 若字符为 ) ] }, 则先判断上一个case中的栈是否为空，若为空，则说明表达式是不平衡的
				if(openDelimiterStack.isEmpty()){
					isBalanced = false;
				}
				// 若栈不为空，则将栈中的字符串压出并赋值给一个新变量openDelimiter
				// 使用isPaired方法比较两个字符是否是配对的
				else{
					char openDelimiter = openDelimiterStack.pop();
					isBalanced = isPaired(openDelimiter, nextCharacter);
				}
				break;
			} //end switch
			index++;
		}//end while
		
		// 通过循环处理完所有字符后，再看栈中是否还有字符，若还有字符，说明表达式是不平衡的
		if(!openDelimiterStack.isEmpty()){
			isBalanced = false;
		}
		// 返回表达式是否平衡的结果
		return isBalanced;	
	}
	
	/** 检查栈中pop出来的字符是否与下一个字符匹配的方法*/
	private static boolean isPaired(char open, char close){
		return(open == '(' && close == ')' ||
				open == '[' && close == ']' ||
				open == '{' && close == '}');
	}//end isPaired
}
