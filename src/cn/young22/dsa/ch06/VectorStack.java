package cn.young22.dsa.ch06;

import java.util.EmptyStackException;
import java.util.Vector;

import cn.young22.dsa.ch05.StackInterface;

/**
 * 	����Vector����ʵ��ջ�Ĺ���
 *  VectorStackʵ��������StackInterface�Ĺ���
 * */
public class VectorStack<T> implements StackInterface<T> {

	private Vector<T> stack;						// ��ʼ��һ��Vector���͵�ջstack
	private boolean initialized = false;			// �������ʼ����ʶ����Ϊfalse
	private static final int DEFAULT_CAPACITY = 50;	// ��ջ��Ĭ��������Ϊ50
	private static final int MAX_CAPACITY = 10000;	// ��ջ�����������Ϊ10000
	
	/** Ĭ�Ϲ��췽��������һ��Ĭ��������VectorStack����*/
	public VectorStack(){
		this(DEFAULT_CAPACITY);
	}
	
	/** ջ�Ĺ��췽���������û�����ջ��������ջ*/
	public VectorStack(int initialCapacity){
		// ����û����������Ƿ񳬹�ջ���������ֵ
		checkCapacity(initialCapacity);
		// ��δ����ջ���������ֵ��ʹ��Vector�๹��һ������������ջ
		stack = new Vector<>(initialCapacity);
		// �������ʼ����ʶ������Ϊtrue
		initialized = true;
	}
	
	/** push�������������û�������ֵ��ӵ�ջ��*/
	@Override
	public void push(T newEntry) {
		// ���ջ�����Ƿ��ʼ���ɹ�
		checkInitilization();
		// ���ɹ��������Vector��add��������������ֵ�ӵ�ջ��
		stack.add(newEntry);
	}
	
	/** pop������ɾ��ջ��Ԫ��*/
	@Override
	public T pop() {
		// ���ջ�����Ƿ��ʼ���ɹ�
		checkInitilization();
		// ��ջΪ�գ����׳�ջ���쳣
		if(isEmpty()){
			throw new EmptyStackException();
		}
		// ��ջ��Ϊ�գ��Ƴ�ջ��Ԫ��
		else{
			return stack.remove(stack.size() - 1);
		}
	}
	
	/** peek��������ȡջ��Ԫ�ص�ֵ*/
	@Override
	public T peek() {
		// ���ջ�����Ƿ��ʼ���ɹ�
		checkInitilization();
		// ��ջ�գ����׳�ջ���쳣
		if(isEmpty()){
			throw new EmptyStackException();
		}
		// ��ջ��Ϊ�գ��򷵻�ջ��Ԫ��(����Vector��˵����Vector�����һ��Ԫ��)
		else{
			return stack.lastElement();
		}
	}
	
	/** �ж�ջ��*/
	@Override
	public boolean isEmpty() {
		// ����Vector��isEmpty()�������Եõ�ջ�Ƿ�Ϊ�յĽ��
		return stack.isEmpty();
	}
	
	/** ���ջ*/
	@Override
	public void clear() {
		// ����Vector��clear()�����������ջ
		stack.clear();
	}
	
	/**
	 * 
	* @FunctionName: checkCapacity
	* @Action: ���ͻ�����Ҫ�������Ƿ�����������ֵ
	* @param @param desiredCapacity    
	 */
	private void checkCapacity(int desiredCapacity){
		// ���ͻ������ջ������������ջ�������׳��쳣
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
		// ������δ������ʼ�����׳��쳣
		if(!initialized){
			throw new SecurityException("ArrayBag object is not initialized properly");
		}
	}

}
