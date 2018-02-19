package cn.young22.dsa.ch05;

import cn.young22.dsa.ch06.LinkedStack;

public class StackDemo1 {
	public static void main(String[] args){
		//假设OurStack已经有了
		StackInterface<String> stringStack = new LinkedStack<>();
		
		stringStack.push("Jim");
		stringStack.push("Jess");
		stringStack.push("Jill");
		stringStack.push("Jane");
		stringStack.push("Joe");
		
		String top = stringStack.peek();		//returns "Joe"
		System.out.println(top + " is at the top of the stack"); 
		
		top = stringStack.pop();				//returns "Joe"
		System.out.println(top + " is removed from the stack");
		
		top = stringStack.peek();				//returns "Jane"
		System.out.println(top + " is at the top of the stack");
		
		top = stringStack.pop();				//returns "Jane"
		System.out.println(top + " is removed from the stack");
		
	}
}
