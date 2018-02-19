package cn.young22.dsa.ch01;

import cn.young22.dsa.ch02.ArrayBag;

public class PiggyBank {
	private BagInterface<Coin> coins;
	
	public PiggyBank(){
		coins = new ArrayBag<>();
	}
	
	public boolean add(Coin aCoin){
		return coins.add(aCoin);
	}
	
	public Coin remove(){
		return coins.remove();
	}
	
	public boolean isEmpty(){
		return coins.isEmpty();
	}
}
