package cn.young22.dsa.ch04;

/** <p>�����ʹ����˵���ò�ͬ���㷨����ͬһ���µ�Ч�ʵĲ��</p>
 *  <p>ʹ�������㷨�������1�ӵ�һ���ܴ���������ʽ�� 1 + 2 + 3 + ... + A_LARGE_NUMBER</p>
 *  
 *  <p>�㷨1ʹ��һ��ѭ�����ü�����counter��1�ӵ�A_LARGE_NUMBER</p>
 *  <p>�㷨2ʹ��˫��ѭ�����������A_LARGE_NUMBER����ѭ�����ܴ�����
 *  	���ڲ���index������ѭ���Ĵ������ڲ�ѭ��ִ�е��������ǰҪ�ӵ�����</p>
 *  <p>�㷨3ʹ�ø�˹�㷨ֱ�Ӽ������� counter = (1 + A_LARGE_NUMBER) * A_LARGE_NUMBER / 2</p>
 *  
 *  <p>ʹ������Ϊ��λ�����Ը����㷨�õ���ͽ����ʱ�䣬���бȽϣ��Ӷ��ó�����ҪѰ����õ��㷨ȥ���Ч��</p>
 *  
 * */

public class RecordTimeOfThreeAlgorithms {
	public static void main(String[] args){
		// a variable which represents the largest number
		final long A_LARGE_NUMBER = 1000000;
		
		System.out.println("This program uses algorithm 1 to add 1 to 10000000");
		long startTime1 = System.nanoTime(); 
		long counter1 = 0;
		for(int index = 1; index <= A_LARGE_NUMBER; index++){
			counter1 = counter1 + index;
		}
		System.out.println("result: " + counter1);
		long endTime1 = System.nanoTime(); 
		System.out.println("Algorithm 1 costs: " + (endTime1 - startTime1) + "ns\n");
		
		
		System.out.println("This program uses algorithm 2 to add 1 to 10000000");
		long startTime2 = System.nanoTime(); 
		long counter2 = 0;
		for(int index = 1; index <= A_LARGE_NUMBER; index++){
			long temp1 = 0;
			for(int j = 0; j < index; j++){
				temp1 = temp1 + 1;
			}
			counter2 = counter2 + temp1;
		}
		System.out.println("result: " + counter2);
		long endTime2 = System.nanoTime(); 
		System.out.println("Algorithm 2 costs: " + (endTime2 - startTime2) + "ns\n");
		
		System.out.println("This program uses algorithm 3 to add 1 to 10000000");
		long startTime3 = System.nanoTime();
		long counter3 = 0;
		counter3 = (1 + A_LARGE_NUMBER) * A_LARGE_NUMBER / 2;
		System.out.println("result: " + counter3);
		long endTime3 = System.nanoTime();
		System.out.println("Algorithm 3 costs: " + (endTime3 - startTime3) + "ns\n");
		
	}
}
/*
output: 

This program uses algorithm 1 to add 1 to 10000000
result: 500000500000
Algorithm 1 costs: 5456347ns

This program uses algorithm 2 to add 1 to 10000000
result: 500000500000
Algorithm 2 costs: 18675768010ns

This program uses algorithm 3 to add 1 to 10000000
result: 500000500000
Algorithm 3 costs: 105467ns

������������Կ�����ʹ�ø�˹�������������ǰ�����㷨��
ʹ���㷨2��Ч�����Բ����㷨1���㷨3
 */
