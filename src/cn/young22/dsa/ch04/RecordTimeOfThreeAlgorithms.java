package cn.young22.dsa.ch04;

/** <p>这个类使用来说明用不同的算法来做同一件事的效率的差别</p>
 *  <p>使用三个算法来计算从1加到一个很大的整数这个式子 1 + 2 + 3 + ... + A_LARGE_NUMBER</p>
 *  
 *  <p>算法1使用一个循环，让计数器counter从1加到A_LARGE_NUMBER</p>
 *  <p>算法2使用双重循环，在外层由A_LARGE_NUMBER控制循环的总次数，
 *  	在内层有index来控制循环的次数，内层循环执行的是算出当前要加的整数</p>
 *  <p>算法3使用高斯算法直接计算出结果 counter = (1 + A_LARGE_NUMBER) * A_LARGE_NUMBER / 2</p>
 *  
 *  <p>使用纳秒为单位计算以各个算法得到求和结果的时间，进行比较，从而得出，需要寻求更好的算法去提高效率</p>
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

从上述结果可以看出，使用高斯法求和明显优于前两种算法，
使用算法2的效果明显不如算法1和算法3
 */
