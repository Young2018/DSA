package cn.young22.dsa.ch05;

import cn.young22.dsa.ch06.LinkedStack;
/** 测试LinkedStack方法*/
public class StackDemo1 {
	public static void main(String[] args){

		// 初始化stringStacks
		StackInterface<String> stringStack = new LinkedStack<>();
		
		// 想栈中添加几个字符串
		stringStack.push("Jim");
		stringStack.push("Jess");
		stringStack.push("Jill");
		stringStack.push("Jane");
		stringStack.push("Joe");
		
		// 取栈顶元素的值
		String top = stringStack.peek();		//returns "Joe"
		System.out.println(top + " is at the top of the stack"); 
		
		// 删除栈顶元素的值
		top = stringStack.pop();				//returns "Joe"
		System.out.println(top + " is removed from the stack");
		
		// 取栈顶元素的值
		top = stringStack.peek();				//returns "Jane"
		System.out.println(top + " is at the top of the stack");
		
		// 删除栈顶元素的值
		top = stringStack.pop();				//returns "Jane"
		System.out.println(top + " is removed from the stack");
		
	}
}
/**
Output:

Joe is at the top of the stack
Joe is removed from the stack
Jane is at the top of the stack
Jane is removed from the stack
 */
