package cn.young22.dsa.ch02;

import java.util.Arrays;

import cn.young22.dsa.ch01.BagInterface;

public class ResizeableArrayBag<T> implements BagInterface<T>{

	private T[] bag;	//cannot be final due to doubling
	private int numberOfEntries;
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;
	
	/** Ĭ�Ϲ��캯�������ø��������Ĺ��캯�����г�ʼ��*/
	public ResizeableArrayBag() {
		this(DEFAULT_CAPACITY);
	}
	
	/** �Ը��������ĵķ�ʽ��ʼ��һ��ResizeableArrayBag����*/
	public ResizeableArrayBag(int initialCapacity) {
		//����û�ָ���������Ƿ񳬹��������
		checkCapacity(initialCapacity);
		
		@SuppressWarnings("unchekced")
		T[] tempBag = (T[])new Object[initialCapacity];
		bag = tempBag;
		numberOfEntries = 0;
		initialized = true;
	}
	
	/** �Ը��������ݵķ�ʽ��ʼ��һ��ResizeableArrayBag����*/
	public ResizeableArrayBag(T[] contents) {
		checkCapacity(contents.length);
		//ʹ��Arrays�������齫contents�����ݸ��Ƹ�bag
		bag = Arrays.copyOf(contents, contents.length);
		//��contents��length��ֵ��numberOfEntries
		numberOfEntries = contents.length;
		//��ʼ�����
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
	
	//����µ�Ԫ�أ�������������ʱ����������������֮���ٽ���Ԫ�ؼӵ��������
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
		//ɾ����������һ��Ԫ�ز�������ֵ��ֵ��result
		T result = removeEntry(numberOfEntries - 1);
		//����ɾ��Ԫ�ص�ֵ
		return result;
	}

	@Override
	public boolean remove(T anEntry) {
		checkInitialization();
		//�ҵ������е�һ�γ��ָ���ֵ���±겢��ֵ��index
		int index = getIndexOf(anEntry);
		//ɾ�������±�index��Ԫ�ز�������ֵ��ֵ��result
		T result = removeEntry(index);
		//ʹ��equals�����ж��Ƿ񷵻سɹ���
		//��anEntry��ֵ��bag[index]��ֵ��ȣ�����True,���򷵻�False
		//System.out.println("****anEntry "+anEntry+"  bag[index] "+ bag[index]);
		return anEntry.equals(result);
	}

	@Override
	public boolean removeAll(T anEntry) {
		checkInitialization();
		int index = getIndexOf(anEntry);
		T result = null;
		
		//ͨ��ѭ��ɾ���������и�����ֵ
		while(index > -1){
			result = removeEntry(index);
			index = getIndexOf(anEntry);
		}
		
		return anEntry.equals(result);
	}

	@Override
	public void clear() {
		//ͨ��isEmpty������whileѭ����
		//��isEmpty=False����ÿ��ɾ���������һ��Ԫ��
		//��isEmpty=True,�����ѭ��
		while(!isEmpty()){
			remove();
		}
	}
	/** ����ָ�����±�ȥɾ�����е�Ԫ��*/
	private T removeEntry(int givenIndex){
		
		T result = null;
		//�����ǿգ��Ҹ������±�Ǹ����򽫰������һ��Ԫ�ظ�ֵ��Ҫɾ����Ԫ�ص�λ��
		//�ٽ����һ��Ԫ�ظ�ֵΪnull,���numberOfEntries-1
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
	
	//ʹ��getIndexOf�������鿴�����Ƿ����ָ��Ԫ��
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
	
	//�ж������Ƿ�����
	private boolean isArrayFull(){
		return numberOfEntries >= bag.length;
	}
	
	// Throws an exception if the client requests a capacity that is too large
	// �жϿͻ�����Ҫ��İ��������Ƿ�������������׳��쳣
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
	
	//������������
	private void doubleCapacity(){
		int newLength = 2 * bag.length;
		checkCapacity(newLength);
		bag = Arrays.copyOf(bag, newLength);
	}//end doubleCapacity
	
	//���ݸ���ֵ����Ԫ���������е��±�λ��
	private int getIndexOf(T anEntry){
		//���Ի�Ԫ���±�λ��
		int where = -1;
		//��ʼ�����ҽ��
		boolean found = false;
		//��ʼ�������±�
		int index = 0;

		//���ҵ���Ԫ���������е�λ�ã������ѭ����found=true
		//��֪��ѭ��������δ�ҵ�Ԫ�أ������ѭ����found=false
		while(!found && (index < numberOfEntries)){
			if(anEntry.equals(bag[index])){
				found = true;
				where = index;
			}
			//ÿ����һ��Ԫ�أ������±�+1
			index++;
		}
		//���ظ���Ԫ���±�λ��
		return where;
	}
}
