package cn.young22.dsa.ch05;
/**
 * An interface for the ADT stack
 * */
public interface StackInterface<T> {
	/**
	 * 
	* @FunctionName: push
	* @Action: ��ջ�����һ����Ԫ��
	* @param @param newEntry    
	* @ReturnType: void    
	 */
	public void push(T newEntry);
	
	/**
	 * 
	* @FunctionName: pop
	* @Action: ��ջ��ɾ��һ��Ԫ�� 
	* @ReturnType�� T    
	* @return ��ջ����Ԫ��
	 */
	public T pop();
	
	/**
	 * 
	* @FunctionName: peek
	* @Action: ����ջ��Ԫ��
	* @ReturnType�� T    
	* @return ����ջ��Ԫ��
	 */
	public T peek();
	
	/**
	 * 
	* @FunctionName: isEmpty
	* @Action: �ж�ջ�Ƿ��ǿյ�
	* @ReturnType�� boolean    
	* @return����ջ�գ�����True,���򣬷���False
	 */
	public boolean isEmpty();
	
	/**
	 * 
	* @FunctionName: clear
	* @Action: ���ջ������Ԫ�� 
	* @ReturnType�� void    
	* @return
	 */
	public void clear();
}
