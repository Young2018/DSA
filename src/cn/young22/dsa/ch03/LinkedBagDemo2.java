package cn.young22.dsa.ch03;

import cn.young22.dsa.ch01.BagInterface;

/**
 * 这个类使用来测试LinkedBag2中新添加的方法的
 * 主要测试了remove系列的方法
 * 这个类的内容与ArrayBagDemo2类的内容类似，
 * 不同点在于：
 * 		由于它们的构造方法不同，在初始化时LinkedBag2类不需要填节点个数
 * 		在ArrayBagDemo2类的基础上抽象了testRemoveAll方法
 * */

public class LinkedBagDemo2 {

	public static void main(String[] args) {
		String[] contentsOfBag = {"A", "A", "B", "A", "C", "fadsd", "A", "A", "F", "G"};
		BagInterface<String> aBag = new LinkedBag2<>();
		
		// Testing method isEmpty()
		testIsEmpty(aBag, true);
		
		// Adding Strings
		testAdd(aBag, contentsOfBag);
		
		// Removing Strings
		String[] testString = {"", "B", "A", "C", "D", "A"};
		testRemove(aBag, testString);
		
		// Testing method contains()
		String[] testContains = {"A", "B", "C", "D", "E"};
		testContains(aBag, testContains);
		
		// Testing method getFrequencyOf
		testFrequency(aBag, testString);
		
		// Tests method removeAll(T anEntry)
		String[] testString1 = {"A"};
		testRemoveAll(aBag, testString1);
		
		
	}

	/** Tests the method add.*/
	private static void testAdd(BagInterface<String> aBag, String[] content)
	{
		System.out.print("Adding ");
		for (int index = 0; index < content.length; index++)
		{
			aBag.add(content[index]);
         System.out.print(content[index] + " ");
		} // end for
      System.out.println();    
		displayBag(aBag);
	} // end testAdd	
	
	/** Tests remove() and remove(T anEntry) methods */
	private static void testRemove(BagInterface<String> aBag, String[] contents){
		for(int index = 0; index < contents.length; index++){
			String aString = contents[index];
			if(aString.equals("") || (aString == null)){
				// test remove()
				System.out.println("\nRemoving a string from the bag");
				String removedString = aBag.remove();
				System.out.println("remove returns " + removedString);
			}else{
				// test remove(T anEntry)
				System.out.println("\nRemoving \"" + aString + "\" from the bag:");
				boolean result = aBag.remove(aString);
				System.out.println("remove(\"" + aString + "\") returns " + result);
			}
			displayBag(aBag);
		}
	}
	
	/** Tests the method removeAll()*/
	private static void testRemoveAll(BagInterface<String> aBag, String[] contents){
		for(int index = 0; index < contents.length; index++){
			String aString = contents[index];
			System.out.println("\nTests method removeAll()");
			boolean success = aBag.removeAll(aString);
			System.out.println("removeAll(\"" + aString + "\") returns " + success);
			displayBag(aBag);
		}
	}

	/** Tests the method toArray while displaying the bag. */
	private static void displayBag(BagInterface<String> aBag)
	{
		System.out.println("The bag contains " + aBag.getCurrentSize() +
		                   " string(s), as follows:");		
		Object[] bagArray = aBag.toArray();
		for (int index = 0; index < bagArray.length; index++)
		{
			System.out.print(bagArray[index] + " ");
		} // end for
		
		System.out.println();
	} // end displayBag
	
	// Tests the method isEmpty
	// correctResult indicates what isEmpty should return
	private static void testIsEmpty(BagInterface<String> aBag, boolean correctResult){
		System.out.print("Testing the method isEmpty with ");
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
		System.out.println();
	}
	
	// Tests the method getFrequency
	private static void testFrequency(BagInterface<String> aBag, String[] tests){
		System.out.println("\nTesting the method of getFrequency of:");
		for(int index = 0; index < tests.length; index++){
			System.out.println("In this bag, the count of " + tests[index] + 
					" is " + aBag.getFrequencyOf(tests[index]));
		}
		System.out.println();
	}
	
	// Tests the method contains
	private static void testContains(BagInterface<String> aBag, String[] tests){
		System.out.println("Testing the method contains:");
		for (int index = 0; index < tests.length; index++){
			System.out.println("Does this bag cotain " + tests[index] +
					"? " + aBag.contains(tests[index]));
		}
	}
}

/*
Output:
Testing the method isEmpty with an empty bag
isEmpty finds the bag 
empty: OK.
Adding A A B A C fadsd A A F G 
The bag contains 10 string(s), as follows:
G F A A fadsd C A B A A 
Removing a string from the bag
remove returns G
The bag contains 9 string(s), as follows:
F A A fadsd C A B A A 
Removing "B" from the bag:
remove("B") returns true
The bag contains 8 string(s), as follows:
A A fadsd C A F A A 
Removing "A" from the bag:
remove("A") returns true
The bag contains 7 string(s), as follows:
A fadsd C A F A A 
Removing "C" from the bag:
remove("C") returns true
The bag contains 6 string(s), as follows:
fadsd A A F A A 
Removing "D" from the bag:
remove("D") returns false
The bag contains 6 string(s), as follows:
fadsd A A F A A 
Removing "A" from the bag:
remove("A") returns true
The bag contains 5 string(s), as follows:
fadsd A F A A 
Testing the method contains:
Does this bag cotain A? true
Does this bag cotain B? false
Does this bag cotain C? false
Does this bag cotain D? false
Does this bag cotain E? false
Testing the method of getFrequency of:
In this bag, the count of  is 0
In this bag, the count of B is 0
In this bag, the count of A is 3
In this bag, the count of C is 0
In this bag, the count of D is 0
In this bag, the count of A is 3
Tests method removeAll()
removeAll("A") returns true
The bag contains 2 string(s), as follows:
fadsd F 
*/