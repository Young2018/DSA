package cn.young22.dsa.ch06;

import java.util.EmptyStackException;
import java.util.Vector;

import cn.young22.dsa.ch05.StackInterface;

/**
 * 	调用Vector类来实现栈的功能
 *  VectorStack实现了所有StackInterface的功能
 * */
public class VectorStack<T> implements StackInterface<T> {

	private Vector<T> stack;						// 初始化一个Vector泛型的栈stack
	private boolean initialized = false;			// 将对象初始化标识符设为false
	private static final int DEFAULT_CAPACITY = 50;	// 将栈顶默认容量设为50
	private static final int MAX_CAPACITY = 10000;	// 将栈的最大容量设为10000
	
	/** 默认构造方法，生成一个默认容量的VectorStack对象*/
	public VectorStack(){
		this(DEFAULT_CAPACITY);
	}
	
	/** 栈的构造方法，根据用户给定栈容量生成栈*/
	public VectorStack(int initialCapacity){
		// 检查用户给定容量是否超过栈容量的最大值
		checkCapacity(initialCapacity);
		// 若未超过栈容量的最大值则使用Vector类构造一个给定容量的栈
		stack = new Vector<>(initialCapacity);
		// 将对象初始化标识符设置为true
		initialized = true;
	}
	
	/** push方法，用来将用户给定的值添加到栈顶*/
	@Override
	public void push(T newEntry) {
		// 检查栈对象是否初始化成功
		checkInitilization();
		// 若成功，则调用Vector的add方法，将给定的值加到栈顶
		stack.add(newEntry);
	}
	
	/** pop方法，删除栈顶元素*/
	@Override
	public T pop() {
		// 检查栈对象是否初始化成功
		checkInitilization();
		// 若栈为空，则抛出栈空异常
		if(isEmpty()){
			throw new EmptyStackException();
		}
		// 若栈不为空，移除栈顶元素
		else{
			return stack.remove(stack.size() - 1);
		}
	}
	
	/** peek方法，获取栈顶元素的值*/
	@Override
	public T peek() {
		// 检查栈对象是否初始化成功
		checkInitilization();
		// 若栈空，则抛出栈空异常
		if(isEmpty()){
			throw new EmptyStackException();
		}
		// 若栈不为空，则返回栈顶元素(对于Vector来说，是Vector的最后一个元素)
		else{
			return stack.lastElement();
		}
	}
	
	/** 判断栈空*/
	@Override
	public boolean isEmpty() {
		// 调用Vector的isEmpty()方法可以得到栈是否为空的结果
		return stack.isEmpty();
	}
	
	/** 清除栈*/
	@Override
	public void clear() {
		// 调用Vector的clear()方法可以清除栈
		stack.clear();
	}
	
	/**
	 * 
	* @FunctionName: checkCapacity
	* @Action: 检测客户端所要的容量是否大于最大容量值
	* @param @param desiredCapacity    
	 */
	private void checkCapacity(int desiredCapacity){
		// 若客户需求的栈容量大于最大的栈容量，抛出异常
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
		// 若对象未正常初始化，抛出异常
		if(!initialized){
			throw new SecurityException("ArrayBag object is not initialized properly");
		}
	}

}
