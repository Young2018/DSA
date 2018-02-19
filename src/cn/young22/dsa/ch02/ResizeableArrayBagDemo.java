package cn.young22.dsa.ch02;

import cn.young22.dsa.ch01.BagInterface;

public class ResizeableArrayBagDemo {

	public static void main(String[] args) {
		//A bag whose initial capacity is small
		//��ʼ��һ������ֻ��3�İ�
		BagInterface<String> aBag = new ResizeableArrayBag<>(3);
		//���Դ�ʱ�����Ƿ�Ϊ��
		testIsEmpty(aBag, true);
		
		//����add��������contentsOfBag��ֵ��ֵ��aBag��
		//ע�⣬��ʱcontentsOfBag����7��Ԫ�أ�����ʼ����aBag��������Ϊ3����������ʱaBag���Զ�����������
		System.out.println("Adding to the bag more strings that its initial capacity");
		String[] contentsOfBag = {"A", "D", "B", "A", "C", "A", "D"};
		testAdd(aBag, contentsOfBag);
		
		//�����Ԫ�غ��ٲ���isEmpty����
		testIsEmpty(aBag, false);
		String[] testStrings2 = {"A", "B", "C", "D", "Z"};
		//ʹ��testStrings2ȥ����ÿ�������ַ�������aBag�е�Ƶ�ʻ��жϰ����Ƿ���������ַ�
		testFrequency(aBag, testStrings2);
		testContains(aBag, testStrings2);
		
		//����remove()��remove(anEntry)������
		//��������ַ���Ϊ""��null�����remove()������ɾ�����е����һ��Ԫ�ص�ֵ
		//���������remove(anEntry)������ɾ�����и���ֵ�ĵ�һ�γ���
		String[] testStrings3 = {"", "B", "A", "C", "Z"};
		testRemove(aBag, testStrings3);
		
		//����removeAll()������ɾ������Ԫ���ڰ��е�����ֵ
		System.out.println("\nRemove the specific string in the bag");
		aBag.removeAll("A");
		displayBag(aBag);
		
		//����clear()����������������е�Ԫ��
		System.out.println("\nClearing the bag:");
		aBag.clear();
		testIsEmpty(aBag, true);
		displayBag(aBag);
	}
	
	private static void testAdd(BagInterface<String> aBag, String[] contents){
		System.out.print("Adding to the bag: ");
		for(int index = 0; index < contents.length; index++){
			aBag.add(contents[index]);
			System.out.print(contents[index] + " ");
		}// end for
		System.out.println();
		
		displayBag(aBag);
	}//end testAdd
	
	//Tests the two remove methods
	private static void testRemove(BagInterface<String> aBag, String[] tests){
		for(int index = 0; index < tests.length; index++){
			String aString = tests[index];
			if(aString.equals("") || (aString == null)){
				//test remove
				System.out.println("\nRemoving a string from the bag:");
				String removedString = aBag.remove();
				System.out.println("remove() returns" + removedString);
			}else{
				//testremove(aString)
				System.out.println("\nRemoving \"" + aString + "\" from the bag:");
				boolean result = aBag.remove(aString);
				System.out.println("remove(\"" + aString + "\") returns " + result);
			}		
			displayBag(aBag);
		}
	}
	
	//Tests the method isEmpty
	//correctResult indicates what isEmpty should return
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
	
	//Tests the method getFrequency
	private static void testFrequency(BagInterface<String> aBag, String[] tests){
		System.out.println("\nTesting the method getFrequencyOf:");
		for(int index = 0; index < tests.length; index++){
			System.out.println("In this bag, the count of " + tests[index] + 
					" is " + aBag.getFrequencyOf(tests[index]));
		}
	}
	
	//Tests the method contains
	private static void testContains(BagInterface<String> aBag, String[] tests){
		System.out.println("\nTesting the method contains");
		for(int index = 0; index < tests.length; index++){
			System.out.println("Does this bag contain " + tests[index] + 
					"? " + aBag.contains(tests[index]));
		}
	}
	
	//Tests the method toArray while displaying the bag
	//����toArray��������ʾ���е�����
	private static void displayBag(BagInterface<String> aBag){
		System.out.println("The bag contains " + aBag.getCurrentSize() + 
				" string(s), as follows:");
		Object[] bagArray = aBag.toArray();
		for(int index = 0; index < bagArray.length; index++){
			System.out.print(bagArray[index] + " ");
		}
		System.out.println();
	}//end displayBag
}
