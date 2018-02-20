package cn.young22.dsa.ch01;

/** 一个用来测试小猪存钱罐的类*/
public class PiggyBankExample {

	public static void main(String[] args) {
		//初始化一个小猪存钱罐
		PiggyBank myBank = new PiggyBank();
		//向存钱罐中加入硬币
		addCoin(new Coin(1, 2010), myBank);
		addCoin(new Coin(5, 2011), myBank);
		addCoin(new Coin(10, 2000), myBank);
		addCoin(new Coin(25, 2012), myBank);
		
		//开始从存钱罐中取出硬币
		System.out.println("Removing all the coins:");
		
		//取出硬币的数目
		int amountRemoved = 0;
		
		//从存钱罐中一个一个的取出硬币并输出硬币的信息
		while(!myBank.isEmpty()){
			Coin removedCoin = myBank.remove();
			System.out.println("Removed a " + removedCoin.getMyName() + ".");
			amountRemoved = amountRemoved + removedCoin.getValue();
		}
		//硬币全部取完
		System.out.println("All done. Removed " + amountRemoved + " cents.");
	}
	
	/** 向存钱罐中加入硬币的方法*/
	public static void addCoin(Coin aCoin, PiggyBank aBank){
		if(aBank.add(aCoin)){
			System.out.println("Added a " + aCoin.getMyName() + ".");
		}else{
			System.out.println("Tried to add a " + aCoin.getMyName() +
					", but couldn't");
		}
	}//end addCoin
}// end PiggyBankExample

/*运行结果：
Added a PENNY.
Added a NICKEL.
Added a DIME.
Added a QUARTER.
Removing all the coins:
Removed a QUARTER.
Removed a DIME.
Removed a NICKEL.
Removed a PENNY.
All done. Removed 41 cents. 
*/
