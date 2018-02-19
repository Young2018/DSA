package cn.young22.dsa.ch02;

import cn.young22.dsa.ch01.BagInterface;

/** ≤‚ ‘ArrayBag1µƒ¿‡*/
public class ArrayBagDemo1 {

	public static void main(String[] args) {
		// A bag that is not full
		BagInterface<String> aBag = new ArrayBag1<>();
		
		// tests on an empty bag
		testIsEmpty(aBag, true);
		String[] testStrings1 = {"A"};
		testFrequency(aBag, testStrings1);
		testCotains(aBag, testStrings1);
		
		// Adding strings
		String[] contentsOfBag1 = {"A", "A", "B", "A", "C", "A"};
		testAdd(aBag, contentsOfBag1);
		
		// testing toArray()
		System.out.println("\nTesting toArray method");
		displayBag(aBag);
		
		// Tests on a bag that is not empty
		testIsEmpty(aBag, false);
		String[] teStrings2 = {"A", "B", "C", "D", "Z"};
		testFrequency(aBag, teStrings2);
		testCotains(aBag, teStrings2);
		
		//-------------------------------------------------
		
		// A bag that will be full
		aBag = new ArrayBag1<String>(7);
		System.out.println("\nA new empty bag:");
		
		// Tests on an empty bag
		testIsEmpty(aBag, true);
		testFrequency(aBag, testStrings1);
		testCotains(aBag, testStrings1);
		
		// Adding strings
		String[] contentsOfBag2 = {"A", "B", "A", "C", "B", "C", "D"};
		testAdd(aBag, contentsOfBag2);
		
		//tests on a bag that is full
		testIsEmpty(aBag, false);
		testFrequency(aBag, teStrings2);
		testCotains(aBag, teStrings2);
	}//end main
	
	// test the method add
	private static void testAdd(BagInterface<String> aBag, String[] content){
		System.out.println("Adding to the bag");
		for(int index = 0; index < content.length; index++){
			aBag.add(content[index]);
			System.out.print(content[index] + " ");
		}
		System.out.println();
		
	}
	
	//Tests the method isEmpty
	//correctResult indicates what isEmpty should return
	private static void testIsEmpty(BagInterface<String> aBag, boolean correctResult){
		System.out.print("\nTesting the method isEmpty with ");
		if(correctResult){
			System.out.println("an empty bag");
		}else{
			System.out.println("a bag that is not empty");
		}
		
		System.out.println("isEmpty finds the bag ");
		if(correctResult && aBag.isEmpty()){
			System.out.println("empty: OK.");
		}else if(correctResult){
			System.out.println("not empty, but it is empty: ERROR");			
		}else if(!correctResult && aBag.isEmpty()){
			System.out.println("empty, but it is not empty: ERROR");
		}else{
			System.out.println("not empty: OK");
		}
	}
	
	//Tests the method getFrequency
	private static void testFrequency(BagInterface<String> aBag, String[] tests){
		System.out.println("\nTesting the method of getFrequency of:");
		for(int index = 0; index < tests.length; index++){
			System.out.println("In this bag, the count of " + tests[index] + 
					" is " + aBag.getFrequencyOf(tests[index]));
		}
		System.out.println();
	}
	
	//Tests the method contains
	private static void testCotains(BagInterface<String> aBag, String[] tests){
		System.out.println("Testing the method contains:");
		for (int index = 0; index < tests.length; index++){
			System.out.println("Does this bag cotain " + tests[index] +
					"? " + aBag.contains(tests[index]));
		}
	}
	
	//Tests the method toArray() and display the size of the bag and the items in the bag
	private static void displayBag(BagInterface<String> aBag){
		System.out.println("The bag contains " + aBag.getCurrentSize() + 
				"string(s), as follows:");
		Object[] bagArray = aBag.toArray();
		for(int index = 0; index < bagArray.length; index++){
			System.out.print(bagArray[index] + " ");
		}
		System.out.println();
	}
	

}
/*
 * Expected output: 
Testing the method isEmpty with an empty bag
isEmpty finds the bag 
empty: OK.

Testing the method of getFrequency of:
In this bag, the count of A is 0

Testing the method contains:
Does this bag cotain A? false
Adding to the bag
A A B A C A 

Testing toArray method
The bag contains 6string(s), as follows:
A A B A C A 

Testing the method isEmpty with a bag that is not empty
isEmpty finds the bag 
not empty: OK

Testing the method of getFrequency of:
In this bag, the count of A is 4
In this bag, the count of B is 1
In this bag, the count of C is 1
In this bag, the count of D is 0
In this bag, the count of Z is 0

Testing the method contains:
Does this bag cotain A? true
Does this bag cotain B? true
Does this bag cotain C? true
Does this bag cotain D? false
Does this bag cotain Z? false

A new empty bag:

Testing the method isEmpty with an empty bag
isEmpty finds the bag 
empty: OK.

Testing the method of getFrequency of:
In this bag, the count of A is 0

Testing the method contains:
Does this bag cotain A? false
Adding to the bag
A B A C B C D 

Testing the method isEmpty with a bag that is not empty
isEmpty finds the bag 
not empty: OK

Testing the method of getFrequency of:
In this bag, the count of A is 2
In this bag, the count of B is 2
In this bag, the count of C is 2
In this bag, the count of D is 1
In this bag, the count of Z is 0

Testing the method contains:
Does this bag cotain A? true
Does this bag cotain B? true
Does this bag cotain C? true
Does this bag cotain D? true
Does this bag cotain Z? false
 */
