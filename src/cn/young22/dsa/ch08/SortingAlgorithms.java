package cn.young22.dsa.ch08;

import java.util.ArrayList;
import java.util.List;

/**
 * 普通版本的针对特殊数据类型(这里是int)的排序算法实现
 * 
 * @author Young
 *
 */
public class SortingAlgorithms {

	/**
	 * BubbleSort
	 * 
	 * 排序思想： 外层： 循环进行数组长度次数 内层： 依次比较相邻两个元素的值，若前一个元素比后一个元素大，
	 * 交换两个元素的位置，直至最后一个元素，下一趟遍历则遍历值倒数第二个元素为止，依次类推
	 * 
	 * @param array
	 */
	public static void bubbleSort(int[] array) {
		int len = array.length;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

	/**
	 * selectionSort
	 * 
	 * 排序思想： 外层： 循环进行数组长度次数 内层： 每次找到最小的元素交换到外层循环次数i的位置上
	 * 
	 * @param array
	 */
	public static void selectSort(int[] array) {
		int len = array.length;
		for (int i = 0; i < len; i++) {// 循环次数
			int value = array[i];
			int position = i;
			for (int j = i + 1; j < len; j++) {// 找到最小的值和位置
				if (array[j] < value) {
					value = array[j];
					position = j;
				}
			}
			array[position] = array[i];// 进行交换
			array[i] = value;
		}
	}

	/**
	 * insertSort 排序思想： 在一个待排序的数组中,假设前 n-1 (n>=2)项是已将排好序的，
	 * 将第n个数插入到前面的有序数当中，使得这n个数是有序的，如此循环，直到全部元素排好序为止。
	 * 
	 * @param array
	 */
	public static void insertSort(int[] array) {
		int len = array.length;// 单独把数组长度拿出来，提高效率
		int insertNum;// 要插入的数
		for (int i = 1; i < len; i++) { // 因为第一次只有一个元素，不用跟谁比较，是有序的，所以从1开始
			insertNum = array[i];
			int j = i - 1; // 序列元素个数
			while (j >= 0 && array[j] > insertNum) {// 从后往前循环，将大于insertNum的数向后移动
				array[j + 1] = array[j];// 元素向后移动
				j--;
			}
			array[j + 1] = insertNum;// 找到位置，插入当前元素
		}
	}

	/**
	 * shellSort
	 * 
	 * @param array
	 */
	public static void shellSort(int[] array) {
		int len = array.length;// 单独把数组长度拿出来，提高效率
		while (len != 0) {
			len = len / 2;
			for (int i = 0; i < len; i++) {// 分组
				for (int j = i + len; j < array.length; j += len) {// 元素从第二个开始
					int k = j - len;// k为有序序列最后一位的位数
					int temp = array[j];// 要插入的元素
					/*
					 * for(;k>=0&&temp<a[k];k-=len){ a[k+len]=a[k]; }
					 */
					while (k >= 0 && temp < array[k]) {// 从后往前遍历
						array[k + len] = array[k];
						k -= len;// 向后移动len位
					}
					array[k + len] = temp;
				}
			}
		}
	}

	public static void mergeSort(int[] A, int[] temp, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			// 把数组分解为两个子列
			mergeSort(A, temp, start, mid);
			mergeSort(A, temp, mid + 1, end);
			// 逐级合并两个子列
			merge(A, temp, start, mid, end);
		}
	}

	public static void merge(int[] A, int[] temp, int start, int mid, int end) {
		int i = start;
		int j = mid + 1;
		int k = 0;
		while (i <= mid && j <= end) {
			if (A[i] <= A[j]) {
				temp[k] = A[i];
				i++;
				k++;
			} else {
				temp[k] = A[j];
				j++;
				k++;
			}
		}
		while (i <= mid) {
			temp[k] = A[i];
			k++;
			i++;
		}
		while (j <= end) {
			temp[k] = A[j];
			k++;
			j++;
		}
		for (int m = 0; m < k; m++) {
			A[start + m] = temp[m];
		}
	}

	/**
	 * quickSort
	 * 
	 * @param array
	 * @param start
	 * @param end
	 */
	public static void quickSort(int[] array, int start, int end) {
		if (start < end) {
			int baseNum = array[start];// 选基准值
			int midNum;// 记录中间值
			int i = start;
			int j = end;
			do {
				while ((array[i] < baseNum) && (i < end)) {
					i++;
				}
				while ((array[j] > baseNum) && (j > start)) {
					j--;
				}
				if (i <= j) {
					midNum = array[i];
					array[i] = array[j];
					array[j] = midNum;
					i++;
					j--;
				}
			} while (i <= j);
			if (start < j) {
				quickSort(array, start, j);
			}
			if (end > i) {
				quickSort(array, i, end);
			}
		}
	}

	/**
	 * baseSort
	 * 
	 * @param array
	 */
	public static void baseSort(int[] array) {
		// 首先确定排序的趟数;
		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		int time = 0;
		// 判断位数;
		while (max > 0) {
			max /= 10;
			time++;
		}
		// 建立10个队列;
		List<ArrayList<Integer>> queue = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < 10; i++) {
			ArrayList<Integer> queue1 = new ArrayList<Integer>();
			queue.add(queue1);
		}
		// 进行time次分配和收集;
		for (int i = 0; i < time; i++) {
			// 分配数组元素;
			for (int j = 0; j < array.length; j++) {
				// 得到数字的第time+1位数;
				int x = array[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
				ArrayList<Integer> queue2 = queue.get(x);
				queue2.add(array[j]);
				queue.set(x, queue2);
			}
			int count = 0;// 元素计数器;
			// 收集队列元素;
			for (int k = 0; k < 10; k++) {
				while (queue.get(k).size() > 0) {
					ArrayList<Integer> queue3 = queue.get(k);
					array[count] = queue3.get(0);
					queue3.remove(0);
					count++;
				}
			}
		}
	}

	/**
	 * heapSort
	 * 
	 * @param array
	 */
	public static void heapSort(int[] array) {
		int len = array.length;
		// 循环建堆
		for (int i = 0; i < len - 1; i++) {
			// 建堆
			buildMaxHeap(array, len - 1 - i);
			// 交换堆顶和最后一个元素
			swap(array, 0, len - 1 - i);
		}
	}

	/**
	 * 交换方法
	 * 
	 * @param array
	 * @param i
	 * @param j
	 */
	private static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	/**
	 * 对data数组从0到lastIndex建大顶堆
	 * 
	 * @param array
	 * @param lastIndex
	 */
	private static void buildMaxHeap(int[] array, int lastIndex) {
		// 从lastIndex处节点（最后一个节点）的父节点开始
		for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
			// k保存正在判断的节点
			int k = i;
			// 如果当前k节点的子节点存在
			while (k * 2 + 1 <= lastIndex) {
				// k节点的左子节点的索引
				int biggerIndex = 2 * k + 1;
				// 如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
				if (biggerIndex < lastIndex) {
					// 若果右子节点的值较大
					if (array[biggerIndex] < array[biggerIndex + 1]) {
						// biggerIndex总是记录较大子节点的索引
						biggerIndex++;
					}
				}
				// 如果k节点的值小于其较大的子节点的值
				if (array[k] < array[biggerIndex]) {
					// 交换他们
					swap(array, k, biggerIndex);
					// 将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
					k = biggerIndex;
				} else {
					break;
				}
			}
		}
	}
}
