package cn.young22.dsa.ji01;
/** 一个具有已经排序好的成对数据类*/

public class OrderedPair<T> implements Pairable<T> {

	private T first, second;
	
	/** 默认构造器方法*/
	public OrderedPair(){
		
	}
	
	/** 构造器方法*/
	public OrderedPair(T firstItem, T secondItem){
		first = firstItem;
		second = secondItem;
	}
	
	/** 返回成对数据中的第一个*/
	@Override
	public T getFisrt() {
		return first;
	}
	
	/** 返回成对数据中的第二个*/
	@Override
	public T getSecond() {
		return second;
	}
	
	/** 返回代表该成对数据的字符串*/
	public String toString(){
		return "(" + first + "," + second + ")";
	}
	
	/** 改变成对数据的顺序*/
	@Override
	public void changeOrder() {
		T temp = first;
		first = second;
		second = temp;	
	}
	
}

/*
 * 创建OrderedPair对象，例如，为创建String对象，可以写如下的语句
 * 
 * OrderedPair<String> fruit = new OrderedPair<>("apple", "orange");
 * 
 */
