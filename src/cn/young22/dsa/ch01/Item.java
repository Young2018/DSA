package cn.young22.dsa.ch01;

import jdk.nashorn.internal.objects.annotations.Getter;

/** 一个用来描述商品名称和价格的类*/
public class Item {
	private String description;	//物品描述
	private int    price;		//物品价格，以分为单位
	
	/** 构造器方法，
	 * 将客户端传来的productDescription赋值给description
	 * productPrice赋值给price
	 * */
	public Item(String productDescription, int productPrice){
		description = productDescription;
		price = productPrice;
	}//end constructor
	
	@Getter
	public String getDescription() {
		return description;
	}
	
	@Getter
	public int getPrice() {
		return price;
	}
	
	//以下面的格式输出对象的信息
	@Override
	public String toString() {
		return description + "\t$" + price / 100 + "." + price % 100;
	}
	
	
}
