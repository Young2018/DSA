package cn.young22.dsa.ch01;

/** 一个代表硬币的类*/

public class Coin {
	private enum CoinSide {HEADS, TAILS}
	private CoinName myName;
	private int value;	// 以分(cent)为单位
	private int year;  // 铸币年份(mint year)
	private CoinSide sideUp;
	
	/**
	 * 构造器方法， 创建一个给定面值和铸币年份的对象，正面朝上的面是随机设定的
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
	 * 构造器方法，创建一个给定硬币名称和铸币年份的对象，正面朝上的面是随机设定的
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
	
	/** 返回硬币的名称*/
	public CoinName getMyName() {
		return myName;
	}
	/** 返回硬币的面值*/
	public int getValue() {
		return value;
	}
	/** 返回硬币的铸造年份*/
	public int getYear() {
		return year;
	}
	/** 如果头像朝上则返回 "HEADS"，否则返回"TAILS"*/
	public String getSideUp() {
		return sideUp.toString();
	}
	
	/** 若头像朝上，则返回真，否则返回假*/
	public boolean isHeads(){
		return sideUp == CoinSide.HEADS;
	}
	
	/** 若背面(非头像面)朝上，则返回真，否则返回假*/
	public boolean isTails(){
		return sideUp == CoinSide.TAILS;
	}
	
	/** 抛掷硬币，朝上的面会随机的为"HEADS"或"TAILS"*/
	public void toss(){
		sideUp = getToss();
	}
	
	/** 以value/year/side-up的格式返回硬币的字符串信息*/
	public String toString(){
		return value + "/" + year + "/" + sideUp;
	}
	
	/** 返回一个投掷硬币后的随机面朝上的值"HEADS"或"TAILS"*/
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