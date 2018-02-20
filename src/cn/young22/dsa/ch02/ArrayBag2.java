package cn.young22.dsa.ch02;

import cn.young22.dsa.ch01.BagInterface;

/** ArrayBag2����ArrayBag1��Ļ����������:
 * 	remove()��ʵ��
 *  remove(T anEntry)��ʵ��
 *  removeAll(T anEntry)��ʵ��
 *  clear()��ʵ��
 *  
 *  ��ʵ������4������ʱ���õ���һ�¼���������
 *  getIndexOf(T anEntry)		ͨ������ֵ�ҵ����ڰ��еĵ�һ�γ���λ��
 *  removeEntry(int givenIndex)	ͨ���������������е�����ɾ�����е�Ԫ��
 * */

public class ArrayBag2<T> implements BagInterface<T>{
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
	public ArrayBag2(){
		this(DEFAULT_CAPACITY);
	}
	
	/** ����һ������������ArrayBag����*/
	public ArrayBag2(int desiredCapacity) {
		// ���ͻ�ָ�������������������Ƚϣ�������������������׳��쳣
		if(desiredCapacity <= MAX_CAPACITY){
			// �ڷ��������ǲ���ʹ�÷��ͣ�������ʹ��Object����
			// ���ȷ���Object���͵����飬�ٽ���ǿ������ת������ɷ�������
			// ����ת����󻹻��ڱ���ʱ���־���
			// ArrayBag2.java uses unchecked or unsafe operations
			// Note:Recompile with -Xlint:unchecked for details
			// ��������ոշ��䣬���н�����null�����������ת��ʱ��ȫ�ģ�ʹ��
			// @SuppressWarnings("unchecked")���ñ����������������
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
	* @Action: ��������һ����Ԫ��
	* @param @param newEntry
	* @ReturnType�� boolean    
	* @return: ����ӳɹ�ʱ�����棬�����ʧ��ʱ���ؼ�
	 */
	public boolean add(T newEntry) {
		checkInitialization();
		boolean result = true;
		if(isArrayFull()){
			result = false;
		}else{
			// Assertion: result is true here
			bag[numberOfEntries] = newEntry;
			numberOfEntries++;
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
		checkInitialization();
		
		@SuppressWarnings("Unchecked")
		T[] result = (T[])new Object[numberOfEntries];
		
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
	* @return �������������棬���򷵻ؼ�
	 */
	public boolean isArrayFull(){
		// �������е�Ԫ�ظ������ڻ��������Ĵ�Сʱ������True
		return numberOfEntries >= bag.length;
	}
	
	/**
	 * 
	* @FunctionName: isEmpty
	* @Action: �жϰ��Ƿ�Ϊ��
	* @ReturnType�� boolean    
	* @return����������
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
	* @FunctionName: remove
	* @Action: ɾ�����е����һ��Ԫ��
	* @param @return    
	* @ReturnType�� T    
	* @return�� �ɹ��򷵻ر�ɾ����Ԫ�أ�ʧ�ܷ���null
	 */
	public T remove() {
		checkInitialization();
		// ɾ�����е����һ��Ԫ��
		T result = removeEntry(numberOfEntries - 1);
		return result;
	}
	
	/**
	 * 
	* @FunctionName: remove
	* @Action: ɾ��һ��ָ����Ԫ�أ�ɾ����Ԫ�ص�Ϊ�����е�һ�γ��ָ�ֵ��λ��
	* @param @param anEntry Ҫ��ɾ����Ԫ��
	* @ReturnType�� boolean    
	* @return���ɹ��򷵻��棬ʧ�ܷ��ؼ�
	 */
	public boolean remove(T anEntry) {
		// �������Ƿ�������ʼ��
		checkInitialization();
		// ��ȡ����Ԫ�ص��±�λ��
		int index = getIndexOf(anEntry);
		// ɾ�������±��Ԫ��
		T result = removeEntry(index);
		// ����ɾ���Ľ��
		return anEntry.equals(result);
	}
	
	/**
	 * 
	* @FunctionName: removeAll
	* @Action: ɾ��һ��ָ����Ԫ���������е����г���
	* @param @param anEntry
	* @ReturnType�� boolean    
	* @return���ɹ��򷵻��棬ʧ�ܷ��ؼ�
	 */
	public boolean removeAll(T anEntry){
		// �������Ƿ�������ʼ��
		checkInitialization();
		// ����bag�е�һ������ֵ��λ��
		int index = getIndexOf(anEntry);
		// ��ʼ��resultΪnull
		T result = null;
		
		// ͨ��ѭ��ɾ���������еĸ�����ֵ
		while(index > -1){
			result = removeEntry(index);
			index = getIndexOf(anEntry);		
		}
		
		return anEntry.equals(result);
	}
	
	/**
	 * 
	* @FunctionName: clear
	* @Action: ���������    
	* @ReturnType�� void    
	 */
	public void clear() {
		// ������Ϊ�գ���һֱɾ���ð������һ��Ԫ��
		while(!isEmpty()){
			remove();
		}
	}
	
	/**
	 * 
	* @FunctionName: getFrequencyOf
	* @Action: ��ʾ�ض�Ԫ���ڰ��еĸ���
	* @param @param anEntry Ҫ��������Ԫ��
	* @ReturnType�� int    
	* @return �����ض�Ԫ�صĸ���
	 */
	public int getFrequencyOf(T anEntry) {
		checkInitialization();
		int counter = 0;
		for(int index = 0; index < numberOfEntries; index++){
			// ���ﲻ����ʹ��bag[index].equals(anEntry),��Ϊbag[index]����û��ֵ��������׳�NullPointerException
			if(anEntry.equals(bag[index])){
				counter++;
			}
		}
		return counter;
	}
	
	/**
	 * 
	* @FunctionName: contains
	* @Action: �жϰ����Ƿ����ض���Ԫ��
	* @param @param anEntry
	* @param @return    
	* @ReturnType�� boolean    
	* @return�������ڸ�����Ԫ�أ������棬���򷵻ؼ�
	 */
	public boolean contains(T anEntry) {
		checkInitialization();
		// ����getIndexOf������bag��������anEntry��
		// ���ҵ������ص�ֵ��Ϊ��ֵ
		return getIndexOf(anEntry) > -1;
	}
	
	/**
	 * 
	* @FunctionName: getIndexOf
	* @Action: ���ݸ�����Ԫ�أ���bag���ҵ����±�ֵ
	* @param @param anEntry 
	* @ReturnType�� int    
	* @return: ����ֵ���±�
	 */
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
	
	/**
	 * 
	* @FunctionName: removeEntry
	* @Action: ͨ����������ɾ�����е�Ԫ�� 
	* @param @param givenIndex
	* @ReturnType�� T    
	* @return ��ɾ���ɹ�������True,����,����False
	 */
	private T removeEntry(int givenIndex){
		T result = null;
		
		if(!isEmpty() && (givenIndex > -1)){
			result = bag[givenIndex]; // Ҫɾ����Ԫ��
			int lastIndex = numberOfEntries - 1;// �ҵ����һ��Ԫ�ص��±�
			bag[givenIndex] = bag[lastIndex];// �����һ��Ԫ���Ƶ�Ҫɾ��Ԫ�ص�λ��
			bag[lastIndex] = null;// �����һ��Ԫ�ص�ֵ��ֵΪnull
			numberOfEntries--;// ��bag�е�Ԫ����Ŀ-1
		}// end if
		
		return result;
	}// end removeEntry
	
	/**
	 * 
	* @FunctionName: checkInitilization
	* @Action: �������Ƿ�������ʼ��,������δ������ʼ�������׳��쳣
	* @ReturnType�� void    
	 */
	public void checkInitialization(){
		if(!initialized){
			throw new SecurityException("ArrayBag object is not initialized properly");
		}
	}
}
