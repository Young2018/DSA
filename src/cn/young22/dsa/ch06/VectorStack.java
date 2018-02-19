package cn.young22.dsa.ch06;

import java.util.EmptyStackException;
import java.util.Vector;

import cn.young22.dsa.ch05.StackInterface;

public class VectorStack<T> implements StackInterface<T> {

	private Vector<T> stack;
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
	
	public VectorStack(){
		this(DEFAULT_CAPACITY);
	}
	
	public VectorStack(int initialCapacity){
		checkCapacity(initialCapacity);
		stack = new Vector<>(initialCapacity);
		initialized = true;
	}
	
	@Override
	public void push(T newEntry) {
		checkInitilization();
		stack.add(newEntry);
	}

	@Override
	public T pop() {
		checkInitilization();
		if(isEmpty()){
			throw new EmptyStackException();
		}else{
			return stack.remove(stack.size() - 1);
		}
	}

	@Override
	public T peek() {
		checkInitilization();
		if(isEmpty()){
			throw new EmptyStackException();
		}else{
			return stack.lastElement();
		}
	}

	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	@Override
	public void clear() {
		stack.clear();
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

}
