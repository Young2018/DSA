package cn.young22.dsa.ch03;

import cn.young22.dsa.ch01.BagInterface;

public class LinkedBagDemo1 {

	public static void main(String[] args) {
		System.out.println("Creating an empty bag");
		BagInterface<String> aBag = new LinkedBag1<>();
		
		testIsEmpty(aBag, true);
		displayBag(aBag);
		
		String[] contentsOfBag = {"A", "D", "B", "A", "C", "A", "D"};
		testAdd(aBag, contentsOfBag);
		testIsEmpty(aBag, false);
	}
	
	// Tests the method isEmpty
	// Precondition: If the bag is empty, the parameter empty should be true
	// otherwise, it should be false
	private static void testIsEmpty(BagInterface<String> bag, boolean empty){
		System.out.println("\nTesting isEmpty with ");
		if(empty){
			System.out.println("an empty bag:");
		}else{
			System.out.println("a bag that is not empty:");
		}
		
		System.out.println("isEmpty finds the bag ");
		if(empty && bag.isEmpty()){
			System.out.println("empty: OK.");
		}else if(empty){
			System.out.println("not empty, but it is: ERROR");
		}else if(!empty && bag.isEmpty()){
			System.out.println("empty, but it is not empty: ERROR");
		}else{
			System.out.println("not empyt: OK.");
		}
	}
	
	
	
	// Tests the method add
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
	
	// Tests the method toArray while displaying the bag
	private static void displayBag(BagInterface<String> aBag){
		System.out.println("The bag contains the following string(s)");
		Object[] bagArray = aBag.toArray();
		for(int index = 0; index < bagArray.length; index++){
			System.out.print(bagArray[index] + " ");
		}//end for
		
		System.out.println();
	}
	
}
