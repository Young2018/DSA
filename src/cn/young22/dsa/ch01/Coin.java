package cn.young22.dsa.ch01;

/** һ������Ӳ�ҵ���*/

public class Coin {
	private enum CoinSide {HEADS, TAILS}
	private CoinName myName;
	private int value;	// �Է�(cent)Ϊ��λ
	private int year;  // �������(mint year)
	private CoinSide sideUp;
	
	/**
	 * ������������ ����һ��������ֵ��������ݵĶ������泯�ϵ���������趨��
	 * @param coinValue
	 * @param mintYear
	 */
	public Coin(int coinValue, int mintYear){
		switch(coinValue){
		case 1:
			myName = CoinName.PENNY;
			break;
		case 5:
			myName = CoinName.NICKEL;
			break;
		case 10:
			myName = CoinName.DIME;
		case 25:
			myName = CoinName.QUARTER;
			break;
		case 50:
			myName = CoinName.FIFTY_CENT;
			break;
		case 100:
			myName = CoinName.DOLLAR;
			break;
		default:
			myName = CoinName.PENNY;
			break;
		}
		
		value = coinValue;
		year = mintYear;
		sideUp = getToss();
	}
	/**
	 * ����������������һ������Ӳ�����ƺ�������ݵĶ������泯�ϵ���������趨��
	 * @param name
	 * @param mintYear
	 */
	public Coin(CoinName name, int mintYear){
		switch(name){
		case PENNY:
			value = 1;
			break;
		case NICKEL:
			value = 5;
			break;
		case DIME:
			value = 10;
			break;
		case QUARTER:
			value = 25;
			break;
		case FIFTY_CENT:
			value = 50;
			break;
		case DOLLAR:
			value = 100;
			break;
		default:
			value = 1;
			break;
		}
	}
	
	/** ����Ӳ�ҵ�����*/
	public CoinName getMyName() {
		return myName;
	}
	/** ����Ӳ�ҵ���ֵ*/
	public int getValue() {
		return value;
	}
	/** ����Ӳ�ҵ��������*/
	public int getYear() {
		return year;
	}
	/** ���ͷ�����򷵻� "HEADS"�����򷵻�"TAILS"*/
	public String getSideUp() {
		return sideUp.toString();
	}
	
	/** ��ͷ���ϣ��򷵻��棬���򷵻ؼ�*/
	public boolean isHeads(){
		return sideUp == CoinSide.HEADS;
	}
	
	/** ������(��ͷ����)���ϣ��򷵻��棬���򷵻ؼ�*/
	public boolean isTails(){
		return sideUp == CoinSide.TAILS;
	}
	
	/** ����Ӳ�ң����ϵ���������Ϊ"HEADS"��"TAILS"*/
	public void toss(){
		sideUp = getToss();
	}
	
	/** ��value/year/side-up�ĸ�ʽ����Ӳ�ҵ��ַ�����Ϣ*/
	public String toString(){
		return value + "/" + year + "/" + sideUp;
	}
	
	/** ����һ��Ͷ��Ӳ�Һ������泯�ϵ�ֵ"HEADS"��"TAILS"*/
	private CoinSide getToss(){
		CoinSide result;
		if(Math.random() < 0.5){
			result = CoinSide.HEADS;
		}else{
			result = CoinSide.TAILS;
		}
		return result;
	}
	
}
