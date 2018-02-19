package cn.young22.dsa.ch01;
/**
 * һ����������(Set)��������Ľӿ�
 */
public interface SetInterface<T> {
	/**
	 * ��õ�ǰ������Ԫ�ص���Ŀ
	 * @return ���ؼ����е�Ԫ�ظ���
	 * */
	public int getCurrentSize();
	
	/**
	 * �жϸü����Ƿ�Ϊ��
	 * @return ����Ͽգ�����True,���򷵻�False
	 * */
	public boolean isEmpty();
	
	/**
	 * �򼯺������һ��Ԫ�أ�����ӵ�Ԫ�ز����뼯�����е�Ԫ���ظ�
	 * @param newEntry Ҫ���뼯�ϵ�Ԫ��
	 * @return �����Ԫ�سɹ�������True,���򣬷���False
	 * */
	public boolean add(T newEntry);
	
	/**
	 * �Ӽ�����ɾ��һ��ָ����Ԫ�أ��������ɾ���Ļ�
	 * @param anEntry Ҫ��ɾ����Ԫ��
	 * @return ��ɾ���ɹ�����True,���򷵻�False 
	 * */
	public boolean remove(T anEntry);
	
	/**
	 * �Ӽ�����ɾ��һ�������Ԫ�أ��������ɾ���Ļ�
	 * @return ��ɾ���ɹ��ģ�����ɾ����Ԫ�أ����򣬷���null
	 */
	public T remove();
	
	/**
	 * ɾ�������е�����Ԫ��
	 * */
	public void clear();
	
	/**
	 * ���Ըü����Ƿ����ƶ���Ԫ��
	 * @param anEntry Ҫ������Ԫ��
	 * @return �����и�Ԫ�أ�����True,���򣬷���False
	 * */
	public boolean contains(T anEntry);
	
	/**
	 * ���������е�����Ԫ��
	 * @return һ���ɼ���������Ԫ���·��������
	 * */
	public T[] toArray();
}// end SetInterface
