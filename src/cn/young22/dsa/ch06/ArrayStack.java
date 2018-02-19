package cn.young22.dsa.ch06;

import java.util.Arrays;
import java.util.EmptyStackException;

import cn.young22.dsa.ch05.StackInterface;

public class ArrayStack<T> implements StackInterface<T>{
	private T[] stack;
	private int topIndex;
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
	
	public ArrayStack(){
		this(DEFAULT_CAPACITY);
	}//end default constructor
	
	public ArrayStack(int initialCapacity) {
		checkCapacity(initialCapacity);
		
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[])new Object[initialCapacity];
		stack = tempStack;
		topIndex = -1;
		initialized = true;
	}

// <Implementations of the stack operations go here.>
	
	@Override
	public void push(T newEntry) {
		checkInitilization();
		ensureCapacity();
		stack[topIndex + 1] = newEntry;
		topIndex++;
	}

	@Override
	public T pop() {
		checkInitilization();
		if(isEmpty()){
			throw new EmptyStackException();
		}else{
			T top = stack[topIndex];
			stack[topIndex] = null;
			topIndex--;
			return top;
		}
	}

	@Override
	public T peek() {
		checkInitilization();
		if(isEmpty()){
			throw new EmptyStackException();
		}else{
			return stack[topIndex];
		}
	}

	@Override
	public boolean isEmpty() {
		return topIndex < 0;
	}

	@Override
	public void clear() {
		//��ջ��Ϊ��ʱ����һֱpop��ջ��Ԫ��
		while(!isEmpty()){
			pop();
		}
	}
	
	/**
	 * 
	* @FunctionName: checkCapacity
	* @Action: ���ͻ�����Ҫ�������Ƿ�����������ֵ
	* @param @param desiredCapacity    
	 */
	private void checkCapacity(int desiredCapacity){
		if(desiredCapacity > MAX_CAPACITY){
			throw new IllegalStateException("Attempt to create a bag whose capacity"+
					" exceeds allowed maximu of" + 
					MAX_CAPACITY);
		}
	}
	
	/**
	 * 
	* @FunctionName: checkInitilization
	* @Action: �������Ƿ�������ʼ��
	* @ReturnType�� void    
	* @return
	 */
	private void checkInitilization(){
		if(!initialized){
			throw new SecurityException("ArrayBag object is not initialized properly");
		}
	}
	
	/**
	 * 
	* @FunctionName: ensureCapacity
	* @Action: ��֤ջ���㹻������ 
	* @ReturnType�� void    
	 */
	private void ensureCapacity(){
		if(topIndex >= stack.length - 1){
			int newLength = 2 * stack.length;
			checkCapacity(newLength);
			stack = Arrays.copyOf(stack, newLength);
		}// end if
	}// end ensureCapacity
	
}
