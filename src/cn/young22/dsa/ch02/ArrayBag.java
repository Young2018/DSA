package cn.young22.dsa.ch02;

import cn.young22.dsa.ch01.BagInterface;

/** 使用数组实现包的类的代码结构
 *  定义该类的私有数据:存储元素的包bag, 包中的元素个数numberOfEntries
 *  及数组的默认容量DEFAULT_CAPACITY
 *  实现构造方法： 实现一个给定容量的ArrayBag构造方法，在该方法中初始化bag数组
 *  实现BagInterface<T>中要求实现的方法
 * */
public class ArrayBag<T> implements BagInterface<T> {
	// 定义终态的泛型数组bag
	private final T[] bag;	
	// 定义包中元素的个数
	private int numberOfEntries;
	// 定义包中默认元素的个数
	private static final int DEFAULT_CAPACITY = 25;
	
	/** 默认构造器方法，创建一个默认容量的包*/
	public ArrayBag(){
		this(DEFAULT_CAPACITY);
	}
	/** 创建一个给定容量的ArrayBag对象*/
	public ArrayBag(int capacity) {
		@SuppressWarnings("unchecked")
		T[] tempBag = (T[])new Object[capacity];
		bag = tempBag;
		numberOfEntries = 0;
	}
	
	/**
	 * 
	* @FunctionName: add
	* @Action: 向包中添加一个新元素
	* @param @param newEntry
	* @ReturnType： boolean    
	* @return: 当添加成功时返回真，当添加失败时返回假
	 */
	public boolean add(T newEntry) {
		// to be defined
		return false;
	}

	/**
	 * 
	* @FunctionName: toArray
	* @Action: 检索包中的所有元素，将其赋值到一个数组中  
	* @ReturnType： T[]    
	* @throws
	* @return： 一个根据包中元素新建的数组
	* 		  注意：若包为空，则返回的数组也为空
	 */
	public T[] toArray() {
		// to be defined
		return null;
	}	
	
	/**
	 * 
	* @FunctionName: isArrayFull
	* @Action: 判断包是否满了
	* @ReturnType： boolean    
	* @return 若包满，返回真，否则返回假
	 */
	public boolean isArrayFull(){
		// to be defined
		return false;
	}
	
	/**
	 * 
	* @FunctionName: isEmpty
	* @Action: 判断包是否为空
	* @ReturnType： boolean    
	* @return：返回真或假
	 */
	public boolean isEmpty(){
		// to be defined
		return false;
		
	};
	/**
	 * 
	* @FunctionName: getCurrentSize
	* @Action: 显示当前包中的对象个数
	* @return 返回当前包中的对象个数
	 */
	public int getCurrentSize(){
		return numberOfEntries;
		
	};
	
	
	/**
	 * 
	* @FunctionName: remove
	* @Action: 删除任意一个包中的元素
	* @param @return    
	* @ReturnType： T    
	* @return： 成功则返回被删除的元素，失败返回null
	 */
	public T remove() {
		return null;
	}
	
	/**
	 * 
	* @FunctionName: remove
	* @Action: 删除一个指定的元素
	* @param @param anEntry 要被删除的元素
	* @ReturnType： boolean    
	* @return：成功则返回真，失败返回假
	 */
	public boolean remove(T anEntry) {
		return false;
	}
	
	/**
	 * 
	* @FunctionName: clear
	* @Action: 清空整个包    
	* @ReturnType： void    
	 */
	public void clear() {
	}
	
	/**
	 * 
	* @FunctionName: getFrequencyOf
	* @Action: 显示特定元素在包中的个数
	* @param @param anEntry 要被计数的元素
	* @ReturnType： int    
	* @return 返回特定元素的个数
	 */
	public int getFrequencyOf(T anEntry) {
		return 0;
	}
	
	/**
	 * 
	* @FunctionName: contains
	* @Action: 判断包中是否含有特定的元素
	* @param @param anEntry
	* @param @return    
	* @ReturnType： boolean    
	* @return：若存在给定的元素，返回真，否则返回假
	 */
	public boolean contains(T anEntry) {
		return false;
	}
	
	/**
	 * 
	* @FunctionName: removeAll
	* @Action: 删除一个指定的元素在数组中的所有出现
	* @param @param anEntry
	* @ReturnType： boolean    
	* @return：成功则返回真，失败返回假
	 */
	@Override
	public boolean removeAll(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}
}
