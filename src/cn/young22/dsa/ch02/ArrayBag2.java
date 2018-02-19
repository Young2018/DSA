package cn.young22.dsa.ch02;

import cn.young22.dsa.ch01.BagInterface;

public class ArrayBag2<T> implements BagInterface<T>{
	private final T[] bag;	
	private int numberOfEntries;
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;
	//默认构造器方法
	public ArrayBag2(){
		this(DEFAULT_CAPACITY);
	}
	//创建一个给定容量的ArrayBag对象
	public ArrayBag2(int desiredCapacity) {
		//将客户指定的容量与最大的容量比较，若大于最大容量，则抛出异常
		if(desiredCapacity <= MAX_CAPACITY){
			//在分配数组是不能使用泛型，但可以使用Object类型
			//故先分配Object类型的数组，再进行强制类型转换，变成泛型数组
			//但是转型完后还会在编译时出现警告
			//ArrayBag2.java uses unchecked or unsafe operations
			//Note:Recompile with -Xlint:unchecked for details
			//由于数组刚刚分配，其中仅含有null项，故这种类型转换时安全的，使用
			//@SuppressWarnings("unchecked")来让编译程序忽略这个警告
			@SuppressWarnings("unchecked")
			T[] tempBag = (T[])new Object[desiredCapacity];
			bag = tempBag;
			numberOfEntries = 0;
			initialized = true;
		}else{
			throw new IllegalStateException("Attempt to create a bag" +
					"whose capacity exceeds allowed maximum");
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
	public boolean add(T newEntry) {
		checkInitialization();
		boolean result = true;
		if(isArrayFull()){
			result = false;
		}else{
			//Assertion: result is true here
			bag[numberOfEntries] = newEntry;
			numberOfEntries++;
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
	public T[] toArray() {
		checkInitialization();
		
		@SuppressWarnings("Unchecked")
		T[] result = (T[])new Object[numberOfEntries];
		
		for(int index = 0; index < numberOfEntries; index++){
			result[index] = bag[index];
		}
		return result;
	}	
	
	//若包满了，则返回True,否则，返回false
	public boolean isArrayFull(){
		//当数组中的元素个数大于或等于数组的大小时，返回True
		return numberOfEntries >= bag.length;
	}
	
	/**
	 * 
	* @FunctionName: isEmpty
	* @Action: 判断包是否为空
	* @ReturnType： boolean    
	* @return：返回真或假
	 */
	public boolean isEmpty(){
		return numberOfEntries == 0;
		
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
	* @Action: 删除包中的最后一个元素
	* @param @return    
	* @ReturnType： T    
	* @return： 成功则返回被删除的元素，失败返回null
	 */
	public T remove() {
		checkInitialization();
		//删除包中的最后一个元素
		T result = removeEntry(numberOfEntries - 1);
		return result;
	}
	
	/**
	 * 
	* @FunctionName: remove
	* @Action: 删除一个指定的元素，删除的元素的为数组中第一次出现该值的位置
	* @param @param anEntry 要被删除的元素
	* @ReturnType： boolean    
	* @return：成功则返回真，失败返回假
	 */
	public boolean remove(T anEntry) {
		//检查对象是否正常初始化
		checkInitialization();
		//获取给定元素的下标位置
		int index = getIndexOf(anEntry);
		//删除给定下标的元素
		T result = removeEntry(index);
		//返回删除的结果
		return anEntry.equals(result);
	}
	
	public boolean removeAll(T anEntry){
		//检查对象是否正常初始化
		checkInitialization();
		//查找bag中第一个给定值的位置
		int index = getIndexOf(anEntry);
		//初始化result为null
		T result = null;
		
		//通过循环删除包中所有的给定的值
		while(index > -1){
			result = removeEntry(index);
			index = getIndexOf(anEntry);		
		}
		
		return anEntry.equals(result);
	}
	
	/**
	 * 
	* @FunctionName: clear
	* @Action: 清空整个包    
	* @ReturnType： void    
	 */
	public void clear() {
		//若包不为空，则一直删除该包的最后一个元素
		while(!isEmpty()){
			remove();
		}
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
		checkInitialization();
		int counter = 0;
		for(int index = 0; index < numberOfEntries; index++){
			//这里不可以使用bag[index].equals(anEntry),因为bag[index]可能没有值，程序会抛出NullPointerException
			if(anEntry.equals(bag[index])){
				counter++;
			}
		}
		return counter;
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
		checkInitialization();
		//调用getIndexOf方法在bag数组中找anEntry，
		//若找到，返回的值不为负值
		return getIndexOf(anEntry) > -1;
	}
	
	//根据给定的元素，在bag中找到其下标值
	private int getIndexOf(T anEntry){
		int where = -1;
		boolean found = false;
		int index = 0;
		
		while(!found && (index < numberOfEntries)){
			if(anEntry.equals(bag[index])){
				found = true;
				where = index;
			}
			index++;
		}
		// Assertion: If where > -1, anEntry is in the array bag and
		// it equals bag[where]; 
		// otherwise, anEntry is not in the arry.
		return where;
	}// end getIndexOf
	
	// Removes and returns the entry at a given index within the array
	private T removeEntry(int givenIndex){
		T result = null;
		
		if(!isEmpty() && (givenIndex > -1)){
			result = bag[givenIndex]; //要删除的元素
			int lastIndex = numberOfEntries - 1;//找到最后一个元素的下标
			bag[givenIndex] = bag[lastIndex];//将最后一个元素移到要删除元素的位置
			bag[lastIndex] = null;//将最后一个元素的值赋值为null
			numberOfEntries--;//将bag中的元素数目-1
		}//end if
		
		return result;
	}//end removeEntry
	
	//检查对象是否正常初始化，若未正常初始化，则抛出安全异常
	public void checkInitialization(){
		if(!initialized){
			throw new SecurityException("ArrayBag object is not initialized properly");
		}
	}
}
