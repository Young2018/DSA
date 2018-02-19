package cn.young22.dsa.ch05;
/**
 * An interface for the ADT stack
 * */
public interface StackInterface<T> {
	/**
	 * 
	* @FunctionName: push
	* @Action: 在栈顶添加一个新元素
	* @param @param newEntry    
	* @ReturnType: void    
	 */
	public void push(T newEntry);
	
	/**
	 * 
	* @FunctionName: pop
	* @Action: 从栈顶删除一个元素 
	* @ReturnType： T    
	* @return 在栈顶的元素
	 */
	public T pop();
	
	/**
	 * 
	* @FunctionName: peek
	* @Action: 检索栈顶元素
	* @ReturnType： T    
	* @return 返回栈顶元素
	 */
	public T peek();
	
	/**
	 * 
	* @FunctionName: isEmpty
	* @Action: 判断栈是否是空的
	* @ReturnType： boolean    
	* @return：若栈空，返回True,否则，返回False
	 */
	public boolean isEmpty();
	
	/**
	 * 
	* @FunctionName: clear
	* @Action: 清楚栈的所有元素 
	* @ReturnType： void    
	* @return
	 */
	public void clear();
}
