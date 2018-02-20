package cn.young22.dsa.ch02;

import cn.young22.dsa.ch01.BagInterface;
/**
 * ArrayBag1�࣬����ˣ�
 * ���췽��ʱ�����˰�ȫ�Լ�飬
 * 		�жϿͻ���Ҫ��������Ƿ�С�ڰ�������������������㣬�׳��쳣
 * 		�����initialized�������������Ƿ�������ʼ��
 * checkInitialization��ʵ��
 * add(T anEntry)��ʵ��
 * toArray()��ʵ��
 * isArrayFull()��ʵ��
 * isEmpty()��ʵ��
 * getCurrentSize()��ʵ��
 * getFrequencyOf(T anEntry)��ʵ��
 * contains(T anEntry)��ʵ��
 * */
public class ArrayBag1<T> implements BagInterface<T> {
	// ����һ�����͵����飬������Ϊfinal,���������޸�
	private final T[] bag;	
	// ����int���͵�numberOfEntries������������Ű��е�Ԫ�ظ���
	private int numberOfEntries;
	// �����͵ı���initialized���ڹ��췽���У������ж϶����Ƿ�������������ȫ
	private boolean initialized = false;
	// ���Եİ�����
	private static final int DEFAULT_CAPACITY = 25;
	// �����������
	private static final int MAX_CAPACITY = 10000;
	
	/** Ĭ�Ϲ���������*/
	public ArrayBag1(){
		this(DEFAULT_CAPACITY);
	}
	
	/** ����һ������������ArrayBag����*/
	public ArrayBag1(int desiredCapacity) {
		if(desiredCapacity <= MAX_CAPACITY){
			//���ڲ����Դ������͵����飬���ȴ���Object���͵����飬��ǿ������ת���ɷ��͵����飬Ȼ��ֵ��bag
			@SuppressWarnings("unchecked")
			T[] tempBag = (T[])new Object[desiredCapacity];
			bag = tempBag;
			numberOfEntries = 0;
			//��ʼ����ɺ󣬽�initialized��ֵ��Ϊtrue
			initialized = true;
		}else{
			throw new IllegalStateException("Attempt to create a bag, whose capacity exceeds allowed maximum");			
		}		
	}
	
	/**
	 * 
	* @FunctionName: add
	* @Action: ��������һ����Ԫ��
	* @param @param newEntry
	* @ReturnType�� boolean    
	* @return: ����ӳɹ�ʱ�����棬�����ʧ��ʱ���ؼ�
	 */
	public boolean add(T newEntry) {
		checkInitilization();	//check if the object has been initialized properly
		boolean result = true;	//default result is true
		if(isArrayFull()){		//if isArrayFull is true, add operation failed
			result = false;
		}else{
			//Assertion: result is true here
			bag[numberOfEntries] = newEntry;//put the newEntry in the end of the bag
			numberOfEntries++;//incresement of numberOfEntries
		}
		return result;
	}

	/**
	 * 
	* @FunctionName: toArray
	* @Action: �������е�����Ԫ�أ����丳ֵ��һ��������  
	* @ReturnType�� T[]    
	* @throws
	* @return�� һ�����ݰ���Ԫ���½�������
	* 		  ע�⣺����Ϊ�գ��򷵻ص�����ҲΪ��
	 */
	public T[] toArray() {
		checkInitilization();	
		//the cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfEntries]; //Unchecked cast
		//��ѭ���ķ�ʽ��bag�е�Ԫ�ظ�ֵ��һ���µ�����
		for(int index = 0; index < numberOfEntries; index++){
			result[index] = bag[index];
		}
		return result;
	}	
	/**
	 * 
	* @FunctionName: isArrayFull
	* @Action: �жϰ��Ƿ�����
	* @ReturnType�� boolean    
	* @return ������������true,���򣬷���false
	 */
	public boolean isArrayFull(){
		return numberOfEntries >= bag.length;
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
	* @FunctionName: isEmpty
	* @Action: �жϰ��Ƿ�Ϊ��
	* @ReturnType�� boolean    
	* @return�������գ������棬���򣬷��ؼ�
	 */
	public boolean isEmpty(){
		return numberOfEntries == 0;
	};
	
	/**
	 * 
	* @FunctionName: getCurrentSize
	* @Action: ��ʾ��ǰ���еĶ������
	* @return ���ص�ǰ���еĶ������
	 */
	public int getCurrentSize(){
		return numberOfEntries;
		
	};
	
	/**
	 * 
	* @FunctionName: getFrequencyOf
	* @Action: ��ʾ�ض�Ԫ���ڰ��еĸ���
	* @param @param anEntry Ҫ��������Ԫ��
	* @ReturnType�� int    
	* @return �����ض�Ԫ�صĸ���
	 */
	public int getFrequencyOf(T anEntry) {
		checkInitilization();
		int counter = 0;
		//ʹ��forѭ���������İ������������ֵ��ȵ�Ԫ����counter+1,ֱ����������������
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
	* @Action: �жϰ����Ƿ��и�����Ԫ��
	* @param @param anEntry
	* @param @return    
	* @ReturnType�� boolean    
	* @return�������ڸ�����Ԫ�أ������棬���򷵻ؼ�
	 */
	public boolean contains(T anEntry) {
		checkInitilization();
		boolean found = false;
		int index = 0;
		//ʹ��found��index�����ж��������������İ�
		//���ڰ����ҵ�����Ԫ�أ�ѭ������,found=true
		//�����������İ�����û�ҵ�����Ԫ�أ�ѭ��������found=false;
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
	* @Action: ɾ������һ�����е�Ԫ��
	* @param @return    
	* @ReturnType�� T    
	* @return�� �ɹ��򷵻ر�ɾ����Ԫ�أ�ʧ�ܷ���null
	 */
	public T remove() {
		return null;
	}
	
	/**
	 * 
	* @FunctionName: remove
	* @Action: ɾ��һ��ָ����Ԫ��
	* @param @param anEntry Ҫ��ɾ����Ԫ��
	* @ReturnType�� boolean    
	* @return���ɹ��򷵻��棬ʧ�ܷ��ؼ�
	 */
	public boolean remove(T anEntry) {
		return false;
	}
	
	/**
	 * 
	* @FunctionName: clear
	* @Action: ���������    
	* @ReturnType�� void    
	 */
	public void clear() {
	}
	
	/**
	 * 
	* @FunctionName: removeAll
	* @Action: ɾ��һ��ָ����Ԫ���������е����г���
	* @param @param anEntry
	* @ReturnType�� boolean    
	* @return���ɹ��򷵻��棬ʧ�ܷ��ؼ�
	 */
	@Override
	public boolean removeAll(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}
}
