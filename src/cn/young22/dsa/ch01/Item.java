package cn.young22.dsa.ch01;

import jdk.nashorn.internal.objects.annotations.Getter;

/** һ������������Ʒ���ƺͼ۸����*/
public class Item {
	private String description;	//��Ʒ����
	private int    price;		//��Ʒ�۸��Է�Ϊ��λ
	
	/** ������������
	 * ���ͻ��˴�����productDescription��ֵ��description
	 * productPrice��ֵ��price
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
	
	//������ĸ�ʽ����������Ϣ
	@Override
	public String toString() {
		return description + "\t$" + price / 100 + "." + price % 100;
	}
	
	
}
