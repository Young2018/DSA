package cn.young22.dsa.ch08;

/**
 * 测试特定数据类型的SortingAlgorithms类
 * @author Young
 *
 */
public class TestSortingAlgorithms {

	public static void main(String[] args) {
		int[] array = { 4, 3, 2 };
		int[] tmp = new int[array.length];
		SortingAlgorithms.mergeSort(array, tmp, 0, array.length - 1);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

}
