package cn.young22.dsa.ji01;
/** һ���ɶ��������͵Ľӿ�*/
public interface Pairable<T> {
	/** ��ȡ�ɶ������еĵ�һ��ֵ*/
	public T getFisrt();
	/** ��ȡ�ɶ������еĵڶ���ֵ*/
	public T getSecond();
	/** �����ɶ����ݵ�˳��*/
	public void changeOrder();
}
/*
 * ʵ������ӿڵ���Ŀ�ͷ���������
 * 
 * public class OrderedPair<T> implements Pairable<T>
 * 
 */
 