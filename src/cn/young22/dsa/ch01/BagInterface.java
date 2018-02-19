package cn.young22.dsa.ch01;
/**
 * 
* @TypeName：BagInterface   
* @Description： 一个描述包操作的接口
 */
public interface BagInterface<T> {
	/**
	 * 
	* @FunctionName: getCurrentSize
	* @Action: 显示当前包中的对象个数
	* @return 返回当前包中的对象个数
	 */
	public int getCurrentSize();
	
	/**
	 * 
	* @FunctionName: isEmpty
	* @Action: 判断包是否为空
	* @ReturnType： boolean    
	* @return：返回真或假
	 */
	public boolean isEmpty();
	
	/**
	 * 
	* @FunctionName: add
	* @Action: 向包中添加一个新元素
	* @param @param newEntry
	* @ReturnType： boolean    
	* @return: 当添加成功时返回真，当添加失败时返回假
	 */
	public boolean add(T newEntry);
	
	/**
	 * 
	* @FunctionName: remove
	* @Action: 删除任意一个包中的元素
	* @param @return    
	* @ReturnType： T    
	* @return： 成功则返回被删除的元素，失败返回null
	 */
	public T remove();
	
	/**
	 * 
	* @FunctionName: remove
	* @Action: 删除一个指定的元素
	* @param @param anEntry
	* @ReturnType： boolean    
	* @return：成功则返回真，失败返回假
	 */
	public boolean remove(T anEntry);
	
	/**
	 * 
	* @FunctionName: removeAll
	* @Action: 删除一个指定的元素在数组中的所有出现
	* @param @param anEntry
	* @ReturnType： boolean    
	* @return：成功则返回真，失败返回假
	 */
	public boolean removeAll(T anEntry);
	
	/**
	 * 
	* @FunctionName: clear
	* @Action: 清空整个包    
	* @ReturnType： void    
	 */
	public void clear();
	
	/**
	 * 
	* @FunctionName: getFrequencyOf
	* @Action: 显示特定元素在包中的个数
	* @param @param anEntry 要被计数的元素
	* @ReturnType： int    
	* @return 返回特定元素的个数
	 */
	public int getFrequencyOf(T anEntry);
	
	/**
	 * 
	* @FunctionName: contains
	* @Action: 判断包中是否含有特定的元素
	* @param @param anEntry
	* @param @return    
	* @ReturnType： boolean    
	* @return：若存在给定的元素，返回真，否则返回假
	 */
	public boolean contains(T anEntry);
	
	/**
	 * 
	* @FunctionName: toArray
	* @Action: 检索包中的所有元素，将其赋值到一个数组中  
	* @ReturnType： T[]    
	* @throws
	* @return： 一个根据包中元素新建的数组
	* 		  注意：若包为空，则返回的数组也为空
	 */
	public T[] toArray();	
	
}