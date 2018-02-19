package cn.young22.dsa.ch01;

import cn.young22.dsa.ch02.ArrayBag;
/** 小猪存钱罐类*/
public class PiggyBank {
	//私有的包类型的变量coins
	private BagInterface<Coin> coins;
	/** 构造方法，新生产一个ArrayBag对象并赋值给coins*/
	public PiggyBank(){
		coins = new ArrayBag<>();
	}
	
	/** 向coins中添加硬币*/
	public boolean add(Coin aCoin){
		return coins.add(aCoin);
	}
	
	/** 移除coins中的硬币*/
	public Coin remove(){
		return coins.remove();
	}
	
	/** 判断coins是否为空*/
	public boolean isEmpty(){
		return coins.isEmpty();
	}
}
