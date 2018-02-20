package cn.young22.dsa.ch05;

import cn.young22.dsa.ch06.ArrayStack;
import cn.young22.dsa.ch06.LinkedStack;
import cn.young22.dsa.ch06.VectorStack;
/** ������ʵ�ֵ�
 * 	LinkedStack
 * 	VectorStack
 *  ArrayStack
 * */
public class StackDemo1 {
	public static void main(String[] args){

		// ��ʼ��stringStacks
		//StackInterface<String> stringStack = new LinkedStack<>();
		// ����ArrayStack
		// StackInterface<String> stringStack = new ArrayStack();
		// ���� VectorStack
		StackInterface<String> stringStack = new VectorStack<>();
		
		// ��ջ����Ӽ����ַ���
		stringStack.push("Jim");
		stringStack.push("Jess");
		stringStack.push("Jill");
		stringStack.push("Jane");
		stringStack.push("Joe");
		
		// ȡջ��Ԫ�ص�ֵ
		String top = stringStack.peek();		//returns "Joe"
		System.out.println(top + " is at the top of the stack"); 
		
		// ɾ��ջ��Ԫ�ص�ֵ
		top = stringStack.pop();				//returns "Joe"
		System.out.println(top + " is removed from the stack");
		
		// ȡջ��Ԫ�ص�ֵ
		top = stringStack.peek();				//returns "Jane"
		System.out.println(top + " is at the top of the stack");
		
		// ɾ��ջ��Ԫ�ص�ֵ
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
