package cn.young22.dsa.ch01;

import cn.young22.dsa.ch02.ArrayBag1;

/**
 * 
* @TypeName��OnlineShopper   
* @Description�� һ������ά�������̳ǹ��ﳵ����
 */
public class OnlineShopper {

	public static void main(String[] args) {
		// ģ����Ʒ
		Item[] items = {new Item("Bird feeder", 2050),
				new Item("Squirrel guard", 1547),
				new Item("Bird batch", 4499),
				new Item("Sunflower seeds", 1295)
		};
		
		// ����
		BagInterface<Item> shoppingCart = new ArrayBag1<>();
		// ��Ʒ���ܼ۸�
		int totalCost = 0;
		
		// ����ѡ����Ʒ�ӵ����ﳵ��
		for(int index = 0; index < items.length; index++){
			Item nextItem = items[index];
			shoppingCart.add(nextItem);
			totalCost = totalCost + nextItem.getPrice();
		}
		
		// ÿ��ɾ��һ�����ﳵ�е���Ʒ����ʾ��Ʒ��Ϣ
		while(!shoppingCart.isEmpty()){
			System.out.println(shoppingCart.remove());
		}
		
		// ��ʾ��Ʒ�ܼ۸�
		System.out.println("Total cost: " + "\t$" + totalCost / 100 + "." + totalCost % 100);
		
	}

}
