package cn.young22.dsa.ch06;

import java.util.Arrays;
import java.util.EmptyStackException;

import cn.young22.dsa.ch05.StackInterface;
/** ArrayStack是用数组实现的栈
 * 	它实现了StackInterface的功能
 * */
public class ArrayStack<T> implements StackInterface<T>{
	private T[] stack;						// 泛型的栈数组
	private int topIndex;					// 记录栈顶位置的变量
	private boolean initialized = false;	// 初始化标识符
	private static final int DEFAULT_CAPACITY = 50;	// 默认栈容量为50
	private static final int MAX_CAPACITY = 10000;	// 最大的栈容量为10000
	
	/** 默认构造器方法，生成一个默认容量的栈对象*/
	public ArrayStack(){
		this(DEFAULT_CAPACITY);
	}// end default constructor
	
	/** 客户指定栈容量的构造方法，根据用户指定的栈容量生成一个栈对象*/
	public ArrayStack(int initialCapacity) {
		// 检查客户指定的栈容量是否是小于最大栈容量的
		checkCapacity(initialCapacity);
		
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[])new Object[initialCapacity];
		stack = tempStack;
		topIndex = -1;
		initialized = true;
	}

// <Implementations of the stack operations go here.>
	
	/** push方法将客户指定的值加入到栈顶*/
	@Override
	public void push(T newEntry) {
		
		checkInitilization();
		ensureCapacity();
		stack[topIndex + 1] = newEntry;
		topIndex++;
	}
	
	/** pop方法删除栈顶元素
	 *  先检查栈是否正常初始化，若未正常初始化，则抛出异常
	 *  然后再检查栈是否为空，若栈空，则抛出异常
	 *  若栈对象初始化成功且栈不为空，则删除栈顶元素
	 * */
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
	
	/** 获取栈顶元素的值
	 *  与pop方法类似，先要检查栈对象是否初始化成功和栈是否为空
	 *  当栈初始化成功且不为空时，返回栈顶元素的值
	 * */
	@Override
	public T peek() {
		checkInitilization();
		if(isEmpty()){
			throw new EmptyStackException();
		}else{
			return stack[topIndex];
		}
	}
	
	/** 查看栈是否为空*/
	@Override
	public boolean isEmpty() {
		return topIndex < 0;
	}
	
	/** 清除栈中的所有元素*/
	@Override
	public void clear() {
		// 当栈不为空时，则一直pop出栈顶元素
		while(!isEmpty()){
			pop();
		}
	}
	
	/**
	 * 
	* @FunctionName: checkCapacity
	* @Action: 检测客户端所要的容量是否大于最大容量值
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
	* @Action: 检测对象是否被正常初始化
	* @ReturnType： void    
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
	* @Action: 保证栈有足够的容量 
	* @ReturnType： void    
	 */
	private void ensureCapacity(){
		if(topIndex >= stack.length - 1){
			int newLength = 2 * stack.length;
			checkCapacity(newLength);
			stack = Arrays.copyOf(stack, newLength);
		}// end if
	}// end ensureCapacity
	
}