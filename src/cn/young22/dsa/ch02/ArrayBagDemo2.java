package cn.young22.dsa.ch02;

import cn.young22.dsa.ch01.BagInterface;

/**
 * �����ʹ��������ArrayBag2������ӵķ�����
 * ��Ҫ������removeϵ�еķ���
 * */

public class ArrayBagDemo2 {

	public static void main(String[] args) {
		String[] contentsOfBag = {"A", "A", "B", "A", "C", "fadsd"};
		BagInterface<String> aBag = new ArrayBag2<>(contentsOfBag.length);
		
		//Adding Strings
		testAdd(aBag, contentsOfBag);
		
		//Removing Strings
		String[] testString = {"", "B", "A", "C", "D", "A"};
		testRemove(aBag, testString);
		
		//test method removeAll(T anEntry)
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
				//test remove()
				System.out.println("\nRemoving a string from the bag");
				String removedString = aBag.remove();
				System.out.println("remove returns " + removedString);
			}else{
				//test remove(T anEntry)
				System.out.println("\nRemoving \"" + aString + "\" from the bag:");
				boolean result = aBag.remove(aString);
				System.out.println("remove(\"" + aString + "\") returns " + result);
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

/**
Expected output:

Adding A A B A C fadsd 
The bag contains 6 string(s), as follows:
A A B A C fadsd 

Removing a string from the bag
remove returns fadsd
The bag contains 5 string(s), as follows:
A A B A C 

Removing "B" from the bag:
remove("B") returns true
The bag contains 4 string(s), as follows:
A A C A 

Removing "A" from the bag:
remove("A") returns true
The bag contains 3 string(s), as follows:
A A C 

Removing "C" from the bag:
remove("C") returns true
The bag contains 2 string(s), as follows:
A A 

Removing "D" from the bag:
remove("D") returns false
The bag contains 2 string(s), as follows:
A A 

Removing "A" from the bag:
remove("A") returns true
The bag contains 1 string(s), as follows:
A 
The bag contains 0 string(s), as follows:

 */
