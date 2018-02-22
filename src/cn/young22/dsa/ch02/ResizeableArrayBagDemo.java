package cn.young22.dsa.ch02;

import cn.young22.dsa.ch01.BagInterface;
/**
 *  测试ResizeableArrayBag类
 * */
public class ResizeableArrayBagDemo {

	public static void main(String[] args) {
		// A bag whose initial capacity is small
		// 初始化一个容量只有3的包
		BagInterface<String> aBag = new ResizeableArrayBag<>(3);
		// 测试此时包空是否为真
		testIsEmpty(aBag, true);
		
		// 测试add方法，将contentsOfBag的值赋值到aBag中
		// 注意，这时contentsOfBag中有7个元素，而初始化的aBag的容量仅为3，故在运行时aBag会自动的增加容量
		System.out.println("Adding to the bag more strings that its initial capacity");
		String[] contentsOfBag = {"A", "D", "B", "A", "C", "A", "D"};
		testAdd(aBag, contentsOfBag);
		
		// 添加了元素后再测试isEmpty方法
		testIsEmpty(aBag, false);
		String[] testStrings2 = {"A", "B", "C", "D", "Z"};
		// 使用testStrings2去测试每个给定字符出现在aBag中的频率或判断包中是否包含给定字符
		testFrequency(aBag, testStrings2);
		testContains(aBag, testStrings2);
		
		// 测试remove()和remove(anEntry)方法，
		// 若传入的字符串为""或null则调用remove()方法，删除包中的最后一个元素的值
		// 否则，则调用remove(anEntry)方法，删除包中给定值的第一次出现
		String[] testStrings3 = {"", "B", "A", "C", "Z"};
		testRemove(aBag, testStrings3);
		
		// 测试removeAll()方法，删除给定元素在包中的所有值
		System.out.println("\nRemove the specific string in the bag");
		aBag.removeAll("A");
		displayBag(aBag);
		
		// 测试clear()方法，情况整个包中的元素
		System.out.println("\nClearing the bag:");
		aBag.clear();
		testIsEmpty(aBag, true);
		displayBag(aBag);
	}
	
	/** Tests the method add*/
	private static void testAdd(BagInterface<String> aBag, String[] contents){
		System.out.print("Adding to the bag: ");
		for(int index = 0; index < contents.length; index++){
			aBag.add(contents[index]);
			System.out.print(contents[index] + " ");
		}// end for
		System.out.println();
		
		displayBag(aBag);
	}// end testAdd
	
	/** Tests the two remove methods*/
	private static void testRemove(BagInterface<String> aBag, String[] tests){
		for(int index = 0; index < tests.length; index++){
			String aString = tests[index];
			if(aString.equals("") || (aString == null)){
				// test remove
				System.out.println("\nRemoving a string from the bag:");
				String removedString = aBag.remove();
				System.out.println("remove() returns" + removedString);
			}else{
				// testremove(aString)
				System.out.println("\nRemoving \"" + aString + "\" from the bag:");
				boolean result = aBag.remove(aString);
				System.out.println("remove(\"" + aString + "\") returns " + result);
			}		
			displayBag(aBag);
		}
	}
	
	/** Tests the method isEmpty*/
	// correctResult indicates what isEmpty should return
	private static void testIsEmpty(BagInterface<String> aBag, boolean coorrectResult){
		System.out.print("Testing isEmpty with ");
		if(coorrectResult){
			System.out.println("an empty bag:");
		}else{
			System.out.println("a bag that is not empty");
		}
		
		System.out.println("isEmpty finds the bag ");
		if(coorrectResult && aBag.isEmpty()){
			System.out.println("empty: OK");
		}else if(coorrectResult){
			System.out.println("not empty, but it is empty: ERROR");
		}else if(!coorrectResult && aBag.isEmpty()){
			System.out.println("empty, but it is not empty: ERROR");
		}else{
			System.out.println("not empty: OK.");
		}
		System.out.println();
	}
	
	/** Tests the method getFrequency*/
	private static void testFrequency(BagInterface<String> aBag, String[] tests){
		System.out.println("\nTesting the method getFrequencyOf:");
		for(int index = 0; index < tests.length; index++){
			System.out.println("In this bag, the count of " + tests[index] + 
					" is " + aBag.getFrequencyOf(tests[index]));
		}
	}
	
	/** Tests the method contains*/
	private static void testContains(BagInterface<String> aBag, String[] tests){
		System.out.println("\nTesting the method contains");
		for(int index = 0; index < tests.length; index++){
			System.out.println("Does this bag contain " + tests[index] + 
					"? " + aBag.contains(tests[index]));
		}
	}
	
	/** Tests the method toArray while displaying the bag*/
	private static void displayBag(BagInterface<String> aBag){
		System.out.println("The bag contains " + aBag.getCurrentSize() + 
				" string(s), as follows:");
		Object[] bagArray = aBag.toArray();
		for(int index = 0; index < bagArray.length; index++){
			System.out.print(bagArray[index] + " ");
		}
		System.out.println();
	}// end displayBag
}

/*
Expected output:
Testing isEmpty with an empty bag:
isEmpty finds the bag 
empty: OK
Adding to the bag more strings that its initial capacity
Adding to the bag: A D B A C A D 
The bag contains 7 string(s), as follows:
A D B A C A D 
Testing isEmpty with a bag that is not empty
isEmpty finds the bag 
not empty: OK.
Testing the method getFrequencyOf:
In this bag, the count of A is 3
In this bag, the count of B is 1
In this bag, the count of C is 1
In this bag, the count of D is 2
In this bag, the count of Z is 0
Testing the method contains
Does this bag contain A? true
Does this bag contain B? true
Does this bag contain C? true
Does this bag contain D? true
Does this bag contain Z? false
Removing a string from the bag:
remove() returnsD
The bag contains 6 string(s), as follows:
A D B A C A 
Removing "B" from the bag:
remove("B") returns true
The bag contains 5 string(s), as follows:
A D A A C 
Removing "A" from the bag:
remove("A") returns true
The bag contains 4 string(s), as follows:
C D A A 
Removing "C" from the bag:
remove("C") returns true
The bag contains 3 string(s), as follows:
A D A 
Removing "Z" from the bag:
remove("Z") returns false
The bag contains 3 string(s), as follows:
A D A 
Remove the specific string in the bag
The bag contains 1 string(s), as follows:
D 
Clearing the bag:
Testing isEmpty with an empty bag:
isEmpty finds the bag 
empty: OK
The bag contains 0 string(s), as follows:
 
 
 */