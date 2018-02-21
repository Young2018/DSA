package cn.young22.dsa.ch07;

/** 打印按递减顺序输出数字的程序*/
public class CountDown {
	
	public static void main(String[] args){
		System.out.println("Algorithm 1: ");
		countDown1(10);
		
		System.out.println("\n\nAlgorithm 2: ");
		countDown2(10);
		
		System.out.println("\n\nAlgorithm 3: ");
		countDown3(10);
		
		System.out.println("\n\nAlgorithm 4: ");
		countDown4(10);
	}
	
	/** 第一种实现方案*/
	public static void countDown1(int integer){
		System.out.print(integer + " ");
		if(integer > 1){
			countDown1(integer - 1);
		}
	}
	
	/** 第二种实现方案*/
	public static void countDown2(int integer){
		if(integer == 1){
			System.out.print(integer + " ");
		}else{
			System.out.print(integer + " ");
			countDown2(integer - 1);
		}
	}
	
	/** 第三种实现方案*/
	public static void countDown3(int integer){
		if(integer >= 1){
			System.out.print(integer + " ");
			countDown3(integer - 1);
		}
	}
	
	/** 第四种实现方案，使用迭代实现*/
	public static void countDown4(int integer){
		while (integer >= 1){
			System.out.print(integer + " ");
			integer--;
		}
	}
}
/*
Output:

Algorithm 1: 
10 9 8 7 6 5 4 3 2 1 

Algorithm 2: 
10 9 8 7 6 5 4 3 2 1 

Algorithm 3: 
10 9 8 7 6 5 4 3 2 1 

Algorithm 4: 
10 9 8 7 6 5 4 3 2 1 

 */
