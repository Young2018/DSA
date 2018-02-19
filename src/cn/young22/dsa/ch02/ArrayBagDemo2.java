package cn.young22.dsa.ch02;

import cn.young22.dsa.ch01.BagInterface;

public class ArrayBagDemo2 {

	public static void main(String[] args) {
		String[] contentsOfBag = {"A", "A", "B", "A", "C", "fadsd"};
		BagInterface<String> aBag = new ArrayBag2<>(contentsOfBag.length);
		
		//Adding Strings
		testAdd(aBag, contentsOfBag);
		
		//Removing Strings
		//String[] testString3 = {"", "B", "A", "C", "D", "A"};
		
		//testRemove(aBag, testString3);
		aBag.removeAll("A");
		displayBag(aBag);
	}

	// Tests the method add.
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
	
	private static void testRemove(BagInterface<String> aBag, String[] contents){
		for(int index = 0; index < contents.length; index++){
			String aString = contents[index];
			if(aString.equals("") || (aString == null)){
				System.out.println("\nRemoving a string from the bag");
				String removedString = aBag.remove();
				System.out.println("remove returns " + removedString);
			}else{
				//test remove(aString)
				System.out.println("\nRemoving \"" + aString + "\" from the bag:");
				boolean result = aBag.remove(aString);
				System.out.println("remove(\"" + aString + "\" returns " + result);
			}
			displayBag(aBag);
		}
	}

	// Tests the method toArray while displaying the bag.
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
}
