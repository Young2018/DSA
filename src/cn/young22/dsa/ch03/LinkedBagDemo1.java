package cn.young22.dsa.ch03;

import cn.young22.dsa.ch01.BagInterface;
/** 这个类用来测试LinkedBag1所实现的
 *  isEmpty方法和add方法*/
public class LinkedBagDemo1 {

	public static void main(String[] args) {
		System.out.println("Creating an empty bag");
		// 创建一个LinkedBag1类型的对象并赋值给BagInterface<String>类型的aBag
		BagInterface<String> aBag = new LinkedBag1<>();
		
		// tests the method isEmpty
		testIsEmpty(aBag, true);
		displayBag(aBag);
		
		// tests the method add
		String[] contentsOfBag = {"A", "D", "B", "A", "C", "A", "D"};
		testAdd(aBag, contentsOfBag);
		testIsEmpty(aBag, false);
	}
	
	/** Tests the method isEmpty
	 	Precondition: If the bag is empty, the parameter empty should be true
	 	otherwise, it should be false*/
	private static void testIsEmpty(BagInterface<String> bag, boolean empty){
		System.out.print("\nTesting isEmpty with ");
		if(empty){
			System.out.println("an empty bag:");
		}else{
			System.out.println("a bag that is not empty:");
		}
		
		System.out.print("isEmpty finds the bag ");
		if(empty && bag.isEmpty()){
			System.out.println("empty: OK.");
		}else if(empty){
			System.out.println("not empty, but it is: ERROR");
		}else if(!empty && bag.isEmpty()){
			System.out.println("empty, but it is not empty: ERROR");
		}else{
			System.out.println("not empty: OK.");
		}
		System.out.println();
	}
	
	
	/** Tests the method add*/
	private static void testAdd(BagInterface<String> aBag, String[] content){
		System.out.println("Adding the following " + content.length +
				" string(s) to the bag: ");
		for(int index = 0; index < content.length; index++){
			if(aBag.add(content[index])){
				System.out.print(content[index] + " ");
			}else{
				System.out.println("\nUnable to add " + content[index] + 
						" to the bag.");
			}
		}
		System.out.println();
		
	}
	
	/** Tests the method toArray while displaying the bag*/
	private static void displayBag(BagInterface<String> aBag){
		System.out.println("The bag contains the following string(s)");
		Object[] bagArray = aBag.toArray();
		for(int index = 0; index < bagArray.length; index++){
			System.out.print(bagArray[index] + " ");
		}//end for
		
		System.out.println();
	}
	
}
/*
output:
Creating an empty bag
Testing isEmpty with an empty bag:
isEmpty finds the bag empty: OK.
The bag contains the following string(s)
Adding the following 7 string(s) to the bag: 
A D B A C A D 
Testing isEmpty with a bag that is not empty:
isEmpty finds the bag not empty: OK.
 */