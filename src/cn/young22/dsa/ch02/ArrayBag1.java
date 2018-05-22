package cn.young22.dsa.ch02;

import cn.young22.dsa.ch01.BagInterface;
/**
 * ArrayBag1类，添加了：
 * 构造方法时增加了安全性检查，
 * 		判断客户端要求的容量是否小于包的最大容量，若不满足，抛出异常
 * 		添加了initialized变量来检测对象是否正常初始化
 * checkInitialization的实现
 * add(T anEntry)的实现
 * toArray()的实现
 * isArrayFull()的实现
 * isEmpty()的实现
 * getCurrentSize()的实现
 * getFrequencyOf(T anEntry)的实现
 * contains(T anEntry)的实现
 * */
public class ArrayBag1<T> implements BagInterface<T> {
	// 定义一个泛型的数组，并设置为final,不让它被修改
	private final T[] bag;	
	// 定义int类型的numberOfEntries变量，用来存放包中的元素个数
	private int numberOfEntries;
	// 布尔型的变量initialized用在构造方法中，用来判断对象是否正常被构造完全
	private boolean initialized = false;
	// 初试的包容量
	private static final int DEFAULT_CAPACITY = 25;
	// 包的最大容量
	private static final int MAX_CAPACITY = 10000;
	
	/** 默认构造器方法*/
	public ArrayBag1(){
		this(DEFAULT_CAPACITY);
	}
	
	/** 创建一个给定容量的ArrayBag对象*/
	public ArrayBag1(int desiredCapacity) {
		if(desiredCapacity <= MAX_CAPACITY){
			// 由于不可以创建泛型的数组，故先创建Object类型的数组，再强制类型转换成泛型的数组，然后赋值给bag
			@SuppressWarnings("unchecked")
			T[] tempBag = (T[])new Object[desiredCapacity];
			bag = tempBag;
			numberOfEntries = 0;
			// 初始化完成后，将initialized的值赋为true
			initialized = true;
		}else{
			throw new IllegalStateException("Attempt to create a bag, whose capacity exceeds allowed maximum");			
		}		
	}
	
	/**
	 * 
	* @FunctionName: add
	* @Action: 向包中添加一个新元素
	* @param @param newEntry
	* @ReturnType： boolean    
	* @return: 当添加成功时返回真，当添加失败时返回假
	 */
	@Override
	public boolean add(T newEntry) {
		checkInitilization();	// check if the object has been initialized properly
		boolean result = true;	// default result is true
		if(isArrayFull()){		// if isArrayFull is true, add operation failed
			result = false;
		}else{
			// Assertion: result is true here
			bag[numberOfEntries] = newEntry;// put the newEntry in the end of the bag
			numberOfEntries++;// increment of numberOfEntries
		}
		return result;
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
	@Override
	public T[] toArray() {
		checkInitilization();	
		// the cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfEntries]; // Unchecked cast
		// 用循环的方式将bag中的元素赋值给一个新的数组
		for(int index = 0; index < numberOfEntries; index++){
			result[index] = bag[index];
		}
		return result;
	}	
	/**
	 * 
	* @FunctionName: isArrayFull
	* @Action: 判断包是否满了
	* @ReturnType： boolean    
	* @return 若包满，返回true,否则，返回false
	 */
	public boolean isArrayFull(){
		return numberOfEntries >= bag.length;
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
	* @FunctionName: isEmpty
	* @Action: 判断包是否为空
	* @ReturnType： boolean    
	* @return：若包空，返回真，否则，返回假
	 */
	@Override
	public boolean isEmpty(){
		return numberOfEntries == 0;
	};
	
	/**
	 * 
	* @FunctionName: getCurrentSize
	* @Action: 显示当前包中的对象个数
	* @return 返回当前包中的对象个数
	 */
	@Override
	public int getCurrentSize(){
		return numberOfEntries;
		
	};
	
	/**
	 * 
	* @FunctionName: getFrequencyOf
	* @Action: 显示特定元素在包中的个数
	* @param @param anEntry 要被计数的元素
	* @ReturnType： int    
	* @return 返回特定元素的个数
	 */
	@Override
	public int getFrequencyOf(T anEntry) {
		checkInitilization();
		int counter = 0;
		// 使用for循环遍历整改包，碰到与给定值相等的元素则counter+1,直到遍历完整改数组
		for(int index = 0; index < numberOfEntries; index++){
			if(anEntry.equals(bag[index])){
				counter++;
			}
		}
		return counter;
	}
	
	/**
	 * 
	* @FunctionName: contains
	* @Action: 判断包中是否含有给定的元素
	* @param @param anEntry
	* @param @return    
	* @ReturnType： boolean    
	* @return：若存在给定的元素，返回真，否则返回假
	 */
	@Override
	public boolean contains(T anEntry) {
		checkInitilization();
		boolean found = false;
		int index = 0;
		// 使用found和index两个判断条件来遍历整改包
		// 若在包中找到给定元素，循环结束,found=true
		// 若遍历完整改包，任没找到给定元素，循环结束，found=false;
		while(!found && (index < numberOfEntries)){
			if(anEntry.equals(bag[index])){
				found = true;
			}
			index++;
		}
		return found;
	}
	
	
	/**
	 * 
	* @FunctionName: remove
	* @Action: 删除任意一个包中的元素
	* @param @return    
	* @ReturnType： T    
	* @return： 成功则返回被删除的元素，失败返回null
	 */
	@Override
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
	@Override
	public boolean remove(T anEntry) {
		return false;
	}
	
	/**
	 * 
	* @FunctionName: clear
	* @Action: 清空整个包    
	* @ReturnType： void    
	 */
	@Override
	public void clear() {
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
		return false;
	}
}