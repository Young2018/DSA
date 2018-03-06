package cn.young22.dsa.ch08;

import java.util.Arrays;

/**
 * 测试SortArray中的排序算法
 * @author Young
 *
 */
public class Main {
	public static void main(String[] args) {
		
		// SortArray sa = new SortArray();
		
		int[] array = { 27, 76, 3, 90, 4, 42, 40, 41, 8320, 903, 9302, 932, 93, 940, 0344, 94, 4903, 32, 04, 04,
				3490, 40, 5093, 34, 28, 85, 4390, 390, 4390 };
		
		Integer[] array1 = { 27, 76, 3, 90, 4, 42, 40, 41, 8320, 903, 9302, 932, 93, 940, 0344, 94, 4903, 32, 04, 04,
				3490, 40, 5093, 34, 28, 85, 4390, 390, 4390 };
		
		Integer[] tmpArray = new Integer[array.length];

		// SortArray.bubbleSort(array1);
		
		// SortArray.selectionSort(array1);
		
		// SortArray.insertSort(array1);
		
		// SortArray.shellSort(array1);
		
		// SortArray.mergeSort(array1, tmpArray, 0, array1.length - 1);
		
		// SortArray.quickSort(array, 0, array.length - 1);
		
		// SortArray.radixSort(array);
		
		// SortArray.heapSort(array1);
		
		// java.util. 包中的Arrays类自带了sort函数，它的内部是使用Dual-Pivot QuickSort算法实现的
		// 此算法的时间复杂度为O(n log(n)),比常规的 one-pivot 的QuickSort算法的性能要好得多
		Arrays.sort(array);
		
//		for (int index = 0; index < array1.length; index++) {
//			System.out.print(array1[index] + " ");
//		}
		
		for (int index = 0; index < array.length; index++){
			System.out.print(array[index] + " ");
		}
	}
}

/*
Output:
3 4 4 4 27 28 32 34 40 40 41 42 76 85 90 93 94 228 390 903 932 940 3490 4390 4390 4903 5093 8320 9302 
 */
