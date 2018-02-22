package cn.young22.dsa.ch07;

/** 使用递归求1到一个很大数字的和
 *  这个程序有着明显的不足，当数字稍微大一点时，
 *  就会出现Exception in thread "main" java.lang.StackOverflowError
 *  的错误
 * */
public class SumOf {
	
	public static void main(String[] args) {
		// 定义一个较大的整数
		final int A_BIG_INTEGER = 1000;
		int sumOfOneToA_BIG_INTEGER = sumOf(A_BIG_INTEGER);
		System.out.println(sumOfOneToA_BIG_INTEGER);
	}
	
	public static int sumOf(int n){
		int sum;
		if(n == 1){
			sum = 1;
		}else{
			sum = sumOf(n - 1) + n;
		}
		
		return sum;
	}

}

/*
Output:
500500
 */