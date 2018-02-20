package cn.young22.dsa.ch01;

/** һ����������С���Ǯ�޵���*/
public class PiggyBankExample {

	public static void main(String[] args) {
		//��ʼ��һ��С���Ǯ��
		PiggyBank myBank = new PiggyBank();
		//���Ǯ���м���Ӳ��
		addCoin(new Coin(1, 2010), myBank);
		addCoin(new Coin(5, 2011), myBank);
		addCoin(new Coin(10, 2000), myBank);
		addCoin(new Coin(25, 2012), myBank);
		
		//��ʼ�Ӵ�Ǯ����ȡ��Ӳ��
		System.out.println("Removing all the coins:");
		
		//ȡ��Ӳ�ҵ���Ŀ
		int amountRemoved = 0;
		
		//�Ӵ�Ǯ����һ��һ����ȡ��Ӳ�Ҳ����Ӳ�ҵ���Ϣ
		while(!myBank.isEmpty()){
			Coin removedCoin = myBank.remove();
			System.out.println("Removed a " + removedCoin.getMyName() + ".");
			amountRemoved = amountRemoved + removedCoin.getValue();
		}
		//Ӳ��ȫ��ȡ��
		System.out.println("All done. Removed " + amountRemoved + " cents.");
	}
	
	/** ���Ǯ���м���Ӳ�ҵķ���*/
	public static void addCoin(Coin aCoin, PiggyBank aBank){
		if(aBank.add(aCoin)){
			System.out.println("Added a " + aCoin.getMyName() + ".");
		}else{
			System.out.println("Tried to add a " + aCoin.getMyName() +
					", but couldn't");
		}
	}//end addCoin
}// end PiggyBankExample

/*���н����
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
