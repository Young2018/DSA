package cn.young22.dsa.ji01;
/** ≤‚ ‘OrderedPair¿‡*/
public class Client {

	public static void main(String[] args) {
		OrderedPair<String> aPair = new OrderedPair<>("hi", "how are you?");
		// print the information of aPair
		System.out.println(aPair);
		// change the order of objects in this pair
		aPair.changeOrder();
		// print the info after changeOrder
		System.out.println(aPair);
		// get first object of this pair
		String firstValue = aPair.getFisrt();
		// print the info of firstValue
		System.out.println(firstValue);
		// get second object of this pair
		String secondPair = aPair.getSecond();
		// print the info of the secondValue
		System.out.println(secondPair);	
	}
}
/*
 * output:
 * 	
 * 	(hi,how are you?)
	(how are you?,hi)
	how are you?
	hi
 * 
 */
