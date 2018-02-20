package cn.young22.dsa.ch02;

import java.util.Arrays;

import cn.young22.dsa.ch01.BagInterface;
/** ���������������ArrayBag
 *  �������ArrayBag2�����Ҫ��ͬ�������Ԫ��ʱ��
 *  ���ж�ifArrayFullΪTrueʱ�������Ǿܾ���ӣ����Ǳ������������ټ��������Ԫ��
 * */
public class ResizeableArrayBag<T> implements BagInterface<T>{

	private T[] bag;	// cannot be final due to doubling
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
		// ����û�ָ���������Ƿ񳬹��������
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
		// ʹ��Arrays�������齫contents�����ݸ��Ƹ�bag
		bag = Arrays.copyOf(contents, contents.length);
		// ��contents��length��ֵ��numberOfEntries
		numberOfEntries = contents.length;
		// ��ʼ�����
		initialized = true;
	}
	
	/** ��ȡ���е�ǰ��Ԫ�ظ���*/
	@Override
	public int getCurrentSize() {
		return numberOfEntries;
	}

	/** �жϰ��Ƿ�Ϊ��*/
	@Override
	public boolean isEmpty() {		
		return numberOfEntries == 0;
	}
	
	/**����µ�Ԫ�أ�������������ʱ����������������֮���ٽ���Ԫ�ؼӵ��������*/
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
	
	/** ɾ�����е����һ��Ԫ��*/
	@Override
	public T remove() {
		checkInitialization();
		// ɾ����������һ��Ԫ�ز�������ֵ��ֵ��result
		T result = removeEntry(numberOfEntries - 1);
		// ����ɾ��Ԫ�ص�ֵ
		return result;
	}

	/** ɾ������Ԫ���ڰ��еĵ�һ�γ���*/
	@Override
	public boolean remove(T anEntry) {
		checkInitialization();
		// �ҵ������е�һ�γ��ָ���ֵ���±겢��ֵ��index
		int index = getIndexOf(anEntry);
		// ɾ�������±�index��Ԫ�ز�������ֵ��ֵ��result
		T result = removeEntry(index);
		// ʹ��equals�����ж��Ƿ񷵻سɹ���
		// ��anEntry��ֵ��result��ֵ��ȣ�����True,���򷵻�False
		return anEntry.equals(result);
	}

	/** ɾ���������еĸ�����Ԫ��*/
	@Override
	public boolean removeAll(T anEntry) {
		checkInitialization();
		// �õ�����Ԫ���������е�һ�γ��ֵ��±겢��ֵ��index
		int index = getIndexOf(anEntry);
		// ��ʼ�� result
		T result = null;
		
		// ͨ��ѭ��ɾ���������и�����ֵ
		while(index > -1){					// ��index��Ϊ��ֵ���������и�����Ԫ�أ������ѭ��
			result = removeEntry(index);	// ɾ�����������±��Ԫ�أ���������ֵ����result
			index = getIndexOf(anEntry);	// �����ٰ���Ѱ�Ҹ���ֵ���±�
		}
		return anEntry.equals(result);		// ���ز���ɾ���������ɾ���ɹ�������True,���򣬷���False
	}
	
	/** ��հ��е�����Ԫ��*/
	@Override
	public void clear() {
		// ͨ��isEmpty������whileѭ����
		// ��isEmpty=False����ÿ��ɾ���������һ��Ԫ��
		// ��isEmpty=True,�����ѭ��
		while(!isEmpty()){
			remove();
		}
	}
	
	/** ����ָ�����±�ȥɾ�����е�Ԫ��*/
	private T removeEntry(int givenIndex){
		
		T result = null;
		// �����ǿգ��Ҹ������±�Ǹ����򽫰������һ��Ԫ�ظ�ֵ��Ҫɾ����Ԫ�ص�λ��
		// �ٽ����һ��Ԫ�ظ�ֵΪnull,���numberOfEntries-1
		if(!isEmpty() && (givenIndex >= 0)){
			result = bag[givenIndex];
			int lastIndex = numberOfEntries - 1;
			bag[givenIndex] = bag[lastIndex];
			bag[lastIndex] = null;
			numberOfEntries--;
		}
		
		return result;		
	}

	/** ���Ҹ���Ԫ�س����ڰ��еĴ���*/
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
	
	/** ʹ��getIndexOf�������鿴�����Ƿ����ָ��Ԫ��*/
	@Override
	public boolean contains(T anEntry) {
		checkInitialization();
		return getIndexOf(anEntry) > -1;
	}

	/** �����е�Ԫ�ظ�ֵ���µ��������鲢��������*/
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
	
	/** �ж������Ƿ�����*/
	private boolean isArrayFull(){
		return numberOfEntries >= bag.length;
	}
	
	/** �жϿͻ�����Ҫ��İ��������Ƿ�������������׳��쳣*/
	private void checkCapacity(int capacity){
		if(capacity > MAX_CAPACITY){
			throw new IllegalStateException("Attempt to create a bag"+
					"whose capacity exceeds allowed maximum of" + 
					MAX_CAPACITY);
		}
	}
	
	/** �ж϶����Ƿ�������ʼ������δ������ʼ�������׳��쳣*/
	private void checkInitialization(){
		if(!initialized){
			throw new SecurityException("Uninitialized object used " + 
					"to call an ArrayBag method");
		}
	}// end checkinitialization
	
	/** ������������������ʹ��Arrays���ߣ�
	 *  ��ԭ���鿽����һ���µ�����Ϊԭ����������������
	 *  ������������ø�ֵ��ԭ����
	 *  ���������������ݲ���
	 * */
	private void doubleCapacity(){
		int newLength = 2 * bag.length;
		checkCapacity(newLength);
		bag = Arrays.copyOf(bag, newLength);
	}// end doubleCapacity
	
	/** ���ݸ���ֵ����Ԫ���������е��±�λ��*/
	private int getIndexOf(T anEntry){
		// ���Ի�Ԫ���±�λ��
		int where = -1;
		// ��ʼ�����ҽ��
		boolean found = false;
		// ��ʼ�������±�
		int index = 0;

		// ���ҵ���Ԫ���������е�λ�ã������ѭ����found=true
		// ��֪��ѭ��������δ�ҵ�Ԫ�أ������ѭ����found=false
		while(!found && (index < numberOfEntries)){
			if(anEntry.equals(bag[index])){
				found = true;
				where = index;
			}
			// ÿ����һ��Ԫ�أ������±�+1
			index++;
		}
		// ���ظ���Ԫ���±�λ��
		return where;
	}
}
