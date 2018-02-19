package cn.young22.dsa.ch01;
/**
 * 
* @TypeName��BagInterface   
* @Description�� һ�������������Ľӿ�
 */
public interface BagInterface<T> {
	/**
	 * 
	* @FunctionName: getCurrentSize
	* @Action: ��ʾ��ǰ���еĶ������
	* @return ���ص�ǰ���еĶ������
	 */
	public int getCurrentSize();
	
	/**
	 * 
	* @FunctionName: isEmpty
	* @Action: �жϰ��Ƿ�Ϊ��
	* @ReturnType�� boolean    
	* @return����������
	 */
	public boolean isEmpty();
	
	/**
	 * 
	* @FunctionName: add
	* @Action: ��������һ����Ԫ��
	* @param @param newEntry
	* @ReturnType�� boolean    
	* @return: ����ӳɹ�ʱ�����棬�����ʧ��ʱ���ؼ�
	 */
	public boolean add(T newEntry);
	
	/**
	 * 
	* @FunctionName: remove
	* @Action: ɾ������һ�����е�Ԫ��
	* @param @return    
	* @ReturnType�� T    
	* @return�� �ɹ��򷵻ر�ɾ����Ԫ�أ�ʧ�ܷ���null
	 */
	public T remove();
	
	/**
	 * 
	* @FunctionName: remove
	* @Action: ɾ��һ��ָ����Ԫ��
	* @param @param anEntry
	* @ReturnType�� boolean    
	* @return���ɹ��򷵻��棬ʧ�ܷ��ؼ�
	 */
	public boolean remove(T anEntry);
	
	/**
	 * 
	* @FunctionName: removeAll
	* @Action: ɾ��һ��ָ����Ԫ���������е����г���
	* @param @param anEntry
	* @ReturnType�� boolean    
	* @return���ɹ��򷵻��棬ʧ�ܷ��ؼ�
	 */
	public boolean removeAll(T anEntry);
	
	/**
	 * 
	* @FunctionName: clear
	* @Action: ���������    
	* @ReturnType�� void    
	 */
	public void clear();
	
	/**
	 * 
	* @FunctionName: getFrequencyOf
	* @Action: ��ʾ�ض�Ԫ���ڰ��еĸ���
	* @param @param anEntry Ҫ��������Ԫ��
	* @ReturnType�� int    
	* @return �����ض�Ԫ�صĸ���
	 */
	public int getFrequencyOf(T anEntry);
	
	/**
	 * 
	* @FunctionName: contains
	* @Action: �жϰ����Ƿ����ض���Ԫ��
	* @param @param anEntry
	* @param @return    
	* @ReturnType�� boolean    
	* @return�������ڸ�����Ԫ�أ������棬���򷵻ؼ�
	 */
	public boolean contains(T anEntry);
	
	/**
	 * 
	* @FunctionName: toArray
	* @Action: �������е�����Ԫ�أ����丳ֵ��һ��������  
	* @ReturnType�� T[]    
	* @throws
	* @return�� һ�����ݰ���Ԫ���½�������
	* 		  ע�⣺����Ϊ�գ��򷵻ص�����ҲΪ��
	 */
	public T[] toArray();	
	
}