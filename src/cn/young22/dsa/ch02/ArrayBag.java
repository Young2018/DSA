package cn.young22.dsa.ch02;

import cn.young22.dsa.ch01.BagInterface;

/** ʹ������ʵ�ְ�����Ĵ���ṹ
 *  ��������˽������:�洢Ԫ�صİ�bag, ���е�Ԫ�ظ���numberOfEntries
 *  �������Ĭ������DEFAULT_CAPACITY
 *  ʵ�ֹ��췽���� ʵ��һ������������ArrayBag���췽�����ڸ÷����г�ʼ��bag����
 *  ʵ��BagInterface<T>��Ҫ��ʵ�ֵķ���
 * */
public class ArrayBag<T> implements BagInterface<T> {
	// ������̬�ķ�������bag
	private final T[] bag;	
	// �������Ԫ�صĸ���
	private int numberOfEntries;
	// �������Ĭ��Ԫ�صĸ���
	private static final int DEFAULT_CAPACITY = 25;
	
	/** Ĭ�Ϲ���������������һ��Ĭ�������İ�*/
	public ArrayBag(){
		this(DEFAULT_CAPACITY);
	}
	/** ����һ������������ArrayBag����*/
	public ArrayBag(int capacity) {
		@SuppressWarnings("unchecked")
		T[] tempBag = (T[])new Object[capacity];
		bag = tempBag;
		numberOfEntries = 0;
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
		// to be defined
		return false;
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
		// to be defined
		return null;
	}	
	
	/**
	 * 
	* @FunctionName: isArrayFull
	* @Action: �жϰ��Ƿ�����
	* @ReturnType�� boolean    
	* @return �������������棬���򷵻ؼ�
	 */
	public boolean isArrayFull(){
		// to be defined
		return false;
	}
	
	/**
	 * 
	* @FunctionName: isEmpty
	* @Action: �жϰ��Ƿ�Ϊ��
	* @ReturnType�� boolean    
	* @return����������
	 */
	public boolean isEmpty(){
		// to be defined
		return false;
		
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
	* @FunctionName: getFrequencyOf
	* @Action: ��ʾ�ض�Ԫ���ڰ��еĸ���
	* @param @param anEntry Ҫ��������Ԫ��
	* @ReturnType�� int    
	* @return �����ض�Ԫ�صĸ���
	 */
	public int getFrequencyOf(T anEntry) {
		return 0;
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
		return false;
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
