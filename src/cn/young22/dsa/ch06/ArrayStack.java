package cn.young22.dsa.ch06;

import java.util.Arrays;
import java.util.EmptyStackException;

import cn.young22.dsa.ch05.StackInterface;
/** ArrayStack��������ʵ�ֵ�ջ
 * 	��ʵ����StackInterface�Ĺ���
 * */
public class ArrayStack<T> implements StackInterface<T>{
	private T[] stack;						// ���͵�ջ����
	private int topIndex;					// ��¼ջ��λ�õı���
	private boolean initialized = false;	// ��ʼ����ʶ��
	private static final int DEFAULT_CAPACITY = 50;	// Ĭ��ջ����Ϊ50
	private static final int MAX_CAPACITY = 10000;	// ����ջ����Ϊ10000
	
	/** Ĭ�Ϲ���������������һ��Ĭ��������ջ����*/
	public ArrayStack(){
		this(DEFAULT_CAPACITY);
	}//end default constructor
	
	/** �ͻ�ָ��ջ�����Ĺ��췽���������û�ָ����ջ��������һ��ջ����*/
	public ArrayStack(int initialCapacity) {
		// ���ͻ�ָ����ջ�����Ƿ���С�����ջ������
		checkCapacity(initialCapacity);
		
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[])new Object[initialCapacity];
		stack = tempStack;
		topIndex = -1;
		initialized = true;
	}

// <Implementations of the stack operations go here.>
	
	/** push�������ͻ�ָ����ֵ���뵽ջ��*/
	@Override
	public void push(T newEntry) {
		
		checkInitilization();
		ensureCapacity();
		stack[topIndex + 1] = newEntry;
		topIndex++;
	}
	
	/** pop����ɾ��ջ��Ԫ��
	 *  �ȼ��ջ�Ƿ�������ʼ������δ������ʼ�������׳��쳣
	 *  Ȼ���ټ��ջ�Ƿ�Ϊ�գ���ջ�գ����׳��쳣
	 *  ��ջ�����ʼ���ɹ���ջ��Ϊ�գ���ɾ��ջ��Ԫ��
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
	
	/** ��ȡջ��Ԫ�ص�ֵ
	 *  ��pop�������ƣ���Ҫ���ջ�����Ƿ��ʼ���ɹ���ջ�Ƿ�Ϊ��
	 *  ��ջ��ʼ���ɹ��Ҳ�Ϊ��ʱ������ջ��Ԫ�ص�ֵ
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
	
	/** �鿴ջ�Ƿ�Ϊ��*/
	@Override
	public boolean isEmpty() {
		return topIndex < 0;
	}
	
	/** ���ջ�е�����Ԫ��*/
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
