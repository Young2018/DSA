package cn.young22.dsa.ch07;

/** ʹ�õݹ���1��һ���ܴ����ֵĺ�
 *  ��������������ԵĲ��㣬��������΢��һ��ʱ��
 *  �ͻ����Exception in thread "main" java.lang.StackOverflowError
 *  �Ĵ���
 * */
public class SumOf {
	
	public static void main(String[] args) {
		// ����һ���ϴ������
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
