package cn.young22.dsa.ch01;

import cn.young22.dsa.ch02.ArrayBag1;

/**
 * 
* @TypeName：OnlineShopper   
* @Description： 一个用来维持在线商城购物车的类
 */
public class OnlineShopper {

	public static void main(String[] args) {
		// 模拟商品
		Item[] items = {new Item("Bird feeder", 2050),
				new Item("Squirrel guard", 1547),
				new Item("Bird batch", 4499),
				new Item("Sunflower seeds", 1295)
		};
		
		// 创建
		BagInterface<Item> shoppingCart = new ArrayBag1<>();
		// 物品的总价格
		int totalCost = 0;
		
		// 将挑选的商品加到购物车中
		for(int index = 0; index < items.length; index++){
			Item nextItem = items[index];
			shoppingCart.add(nextItem);
			totalCost = totalCost + nextItem.getPrice();
		}
		
		// 每次删除一个购物车中的商品并显示商品信息
		while(!shoppingCart.isEmpty()){
			System.out.println(shoppingCart.remove());
		}
		
		// 显示商品总价格
		System.out.println("Total cost: " + "\t$" + totalCost / 100 + "." + totalCost % 100);
		
	}

}
