package cn.young22.dsa.ji01;

/** 一个成对数据类型的接口 */
public interface Pairable<T> {
	/** 获取成对数据中的第一个值 */
	public T getFisrt();

	/** 获取成对数据中的第二个值 */
	public T getSecond();

	/** 交换成对数据的顺序 */
	public void changeOrder();
}
/*
 * 实现这个接口的类的开头是下列语句
 * 
 * public class OrderedPair<T> implements Pairable<T>
 * 
 */