package cn.young22.dsa.ch01;

import cn.young22.dsa.ch02.ArrayBag;
/** С���Ǯ����*/
public class PiggyBank {
	//˽�еİ����͵ı���coins
	private BagInterface<Coin> coins;
	/** ���췽����������һ��ArrayBag���󲢸�ֵ��coins*/
	public PiggyBank(){
		coins = new ArrayBag<>();
	}
	
	/** ��coins�����Ӳ��*/
	public boolean add(Coin aCoin){
		return coins.add(aCoin);
	}
	
	/** �Ƴ�coins�е�Ӳ��*/
	public Coin remove(){
		return coins.remove();
	}
	
	/** �ж�coins�Ƿ�Ϊ��*/
	public boolean isEmpty(){
		return coins.isEmpty();
	}
}
