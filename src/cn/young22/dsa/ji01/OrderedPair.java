package cn.young22.dsa.ji01;
/** һ�������Ѿ�����õĳɶ�������*/

public class OrderedPair<T> implements Pairable<T> {

	private T first, second;
	
	/** Ĭ�Ϲ���������*/
	public OrderedPair(){
		
	}
	
	/** ����������*/
	public OrderedPair(T firstItem, T secondItem){
		first = firstItem;
		second = secondItem;
	}
	
	/** ���سɶ������еĵ�һ��*/
	@Override
	public T getFisrt() {
		return first;
	}
	
	/** ���سɶ������еĵڶ���*/
	@Override
	public T getSecond() {
		return second;
	}
	
	/** ���ش���óɶ����ݵ��ַ���*/
	public String toString(){
		return "(" + first + "," + second + ")";
	}
	
	/** �ı�ɶ����ݵ�˳��*/
	@Override
	public void changeOrder() {
		T temp = first;
		first = second;
		second = temp;	
	}
	
}

/*
 * ����OrderedPair�������磬Ϊ����String���󣬿���д���µ����
 * 
 * OrderedPair<String> fruit = new OrderedPair<>("apple", "orange");
 * 
 */
