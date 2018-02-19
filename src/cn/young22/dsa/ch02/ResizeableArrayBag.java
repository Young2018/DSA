package cn.young22.dsa.ch02;

import java.util.Arrays;

import cn.young22.dsa.ch01.BagInterface;

public class ResizeableArrayBag<T> implements BagInterface<T>{

	private T[] bag;	//cannot be final due to doubling
	private int numberOfEntries;
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;
	
	/** 默认构造函数，调用给定容量的构造函数进行初始化*/
	public ResizeableArrayBag() {
		this(DEFAULT_CAPACITY);
	}
	
	/** 以给定容量的的方式初始化一个ResizeableArrayBag对象*/
	public ResizeableArrayBag(int initialCapacity) {
		//检查用户指定的容量是否超过最大容量
		checkCapacity(initialCapacity);
		
		@SuppressWarnings("unchekced")
		T[] tempBag = (T[])new Object[initialCapacity];
		bag = tempBag;
		numberOfEntries = 0;
		initialized = true;
	}
	
	/** 以给定包内容的方式初始化一个ResizeableArrayBag对象*/
	public ResizeableArrayBag(T[] contents) {
		checkCapacity(contents.length);
		//使用Arrays工具数组将contents的内容复制给bag
		bag = Arrays.copyOf(contents, contents.length);
		//将contents的length赋值给numberOfEntries
		numberOfEntries = contents.length;
		//初始化完毕
		initialized = true;
	}
	
	@Override
	public int getCurrentSize() {
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty() {		
		return numberOfEntries == 0;
	}
	
	//添加新的元素，当数组容量满时，则倍增数组容量，之后再将新元素加到数组最后
	@Override
	public boolean add(T newEntry) {
		checkInitialization();
		if(isArrayFull()){
			doubleCapacity();
		}		
		bag[numberOfEntries] = newEntry;
		numberOfEntries++;		
		return true;
	}

	@Override
	public T remove() {
		checkInitialization();
		//删除最包的最后一个元素并将返回值赋值给result
		T result = removeEntry(numberOfEntries - 1);
		//返回删除元素的值
		return result;
	}

	@Override
	public boolean remove(T anEntry) {
		checkInitialization();
		//找到数组中第一次出现给定值的下标并赋值给index
		int index = getIndexOf(anEntry);
		//删除给定下标index的元素并将返回值赋值给result
		T result = removeEntry(index);
		//使用equals方法判断是否返回成功，
		//若anEntry的值与bag[index]的值相等，返回True,否则返回False
		//System.out.println("****anEntry "+anEntry+"  bag[index] "+ bag[index]);
		return anEntry.equals(result);
	}

	@Override
	public boolean removeAll(T anEntry) {
		checkInitialization();
		int index = getIndexOf(anEntry);
		T result = null;
		
		//通过循环删除包中所有给定的值
		while(index > -1){
			result = removeEntry(index);
			index = getIndexOf(anEntry);
		}
		
		return anEntry.equals(result);
	}

	@Override
	public void clear() {
		//通过isEmpty来控制while循环，
		//若isEmpty=False，则每次删除包的最后一个元素
		//若isEmpty=True,则结束循环
		while(!isEmpty()){
			remove();
		}
	}
	/** 根据指定的下标去删除包中的元素*/
	private T removeEntry(int givenIndex){
		
		T result = null;
		//若包非空，且给定的下标非负，则将包的最后一个元素赋值到要删除的元素的位置
		//再将最后一个元素赋值为null,最后将numberOfEntries-1
		if(!isEmpty() && (givenIndex >= 0)){
			result = bag[givenIndex];
			int lastIndex = numberOfEntries - 1;
			bag[givenIndex] = bag[lastIndex];
			bag[lastIndex] = null;
			numberOfEntries--;
		}
		
		return result;		
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		checkInitialization();
		int counter = 0;
		for(int index = 0; index < numberOfEntries; index++){
			if(anEntry.equals(bag[index])){
				counter++;
			}
		}
		return counter;
	}
	
	//使用getIndexOf方法来查看包中是否包含指定元素
	@Override
	public boolean contains(T anEntry) {
		checkInitialization();
		return getIndexOf(anEntry) > -1;
	}

	@Override
	public T[] toArray() {
		checkInitialization();
		
		@SuppressWarnings("unchekced")
		T[] result = (T[])new Object[numberOfEntries];
		for(int index = 0; index < numberOfEntries; index++){
			result[index] = bag[index];
		}
		
		return result;
	}
	
	//判断数组是否满了
	private boolean isArrayFull(){
		return numberOfEntries >= bag.length;
	}
	
	// Throws an exception if the client requests a capacity that is too large
	// 判断客户端所要求的包的容量是否过大，若过大则抛出异常
	private void checkCapacity(int capacity){
		if(capacity > MAX_CAPACITY){
			throw new IllegalStateException("Attempt to create a bag"+
					"whose capacity exceeds allowed maximum of" + 
					MAX_CAPACITY);
		}
	}
	
	//Throws an exception if receiving object is not initialized
	private void checkInitialization(){
		if(!initialized){
			throw new SecurityException("Uninitialized object used " + 
					"to call an ArrayBag method");
		}
	}//end checkinitialization
	
	//倍增数组容量
	private void doubleCapacity(){
		int newLength = 2 * bag.length;
		checkCapacity(newLength);
		bag = Arrays.copyOf(bag, newLength);
	}//end doubleCapacity
	
	//根据给定值查找元素在数组中的下标位置
	private int getIndexOf(T anEntry){
		//初试化元素下标位置
		int where = -1;
		//初始化查找结果
		boolean found = false;
		//初始化数组下标
		int index = 0;

		//若找到该元素在数组中的位置，则结束循环，found=true
		//若知道循环结束仍未找到元素，则结束循环，found=false
		while(!found && (index < numberOfEntries)){
			if(anEntry.equals(bag[index])){
				found = true;
				where = index;
			}
			//每经过一个元素，数组下标+1
			index++;
		}
		//返回给定元素下标位置
		return where;
	}
}
