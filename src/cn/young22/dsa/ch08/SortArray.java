package cn.young22.dsa.ch08;

import java.util.ArrayList;
import java.util.List;

/**
 * 一个用于给数组从小到大排序得到类
 * 
 * @author Young
 *
 */
public class SortArray {

	/**
	 * bubbleSort
	 * 
	 * @description 排序思想. 
	 * 		外层： 循环进行数组长度次数 
	 * 		内层： 依次比较相邻两个元素的值，若前一个元素比后一个元素大，
	 *      交换两个元素的位置，直至最后一个元素，下一趟遍历则遍历值倒数第二个元素为止，依次类推
	 * 		冒泡排序的时间复杂度为O(n^2)
	 * @param a 待排序数组
	 */
	public static <T extends Comparable<? super T>> void bubbleSort(T[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (a[j].compareTo(a[j + 1]) > 0) {
					swap(a, j, j + 1);
				}
			}
		}
	}

	/**
	 * selectionSort
	 * 
	 * @description 算法思想，每次找到数组中的最小值，将它与数组当前循环控制符index下标位置的元素交换，直至排序结束
	 * @param a	待排序数组
	 */
	public static <T extends Comparable<? super T>> void selectionSort(T[] a) {
		int n = a.length;
		for (int index = 0; index < n - 1; index++) {
			int indexOfNextSmallest = getIndexOfSmallest(a, index, n - 1);
			swap(a, index, indexOfNextSmallest);
			// Assertion: a[0] <= a[1] <= a[2] <= ... <= a[index] <= all other
			// a[i]
		}
	}

	/**
	 * getIndexOfSmallest
	 * 
	 * @description 找到最小的元素的下标位置
	 * @param a	待排序数组
	 * @param first 首个元素的下标
	 * @param last  尾元素的下标
	 * @return 最小元素的下标
	 */
	private static <T extends Comparable<? super T>> int getIndexOfSmallest(T[] a, int first, int last) {
		T min = a[first];
		int indexOfMin = first;
		for (int index = first + 1; index <= last; index++) {
			if (a[index].compareTo(min) < 0) {
				min = a[index];
				indexOfMin = index;
			}
		} // Assertion: min is the smallest of a[first] through a[index]

		return indexOfMin;
	}// end of getIndexOfSmallest

	/**
	 * @description 交换数组下标为i 和 j的元素
	 * @param a	待交换元素的数组
	 * @param i 
	 * @param j
	 */
	private static void swap(Object[] a, int i, int j) {
		Object temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	} // end swap

	/**
	 * insertSort
	 * 
	 * @description 插入排序思想：从第二个元素开始，依次与前n(n>=1)个元素进行比较，
	 * 				若找到比起大的元素，则将其插入到那个元素之前
	 * 
	 * @param a 待排序数组
	 */
	public static <T extends Comparable<? super T>> void insertSort(T[] a) {
		int n = a.length;
		T insertElement;
		for (int i = 1; i < n; i++) {
			insertElement = a[i];
			int j = i - 1;
			while (j >= 0 && a[j].compareTo(insertElement) > 0) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = insertElement;
		}
	}

	/**
	 * shellSort
	 * 
	 * @description 改进的插入排序
	 * 与直接插入排序不同的是，希尔排序是在有等间距下标的子数组项进行排序
	 * 
	 * @param a 待排序数组
	 */
	public static <T extends Comparable<? super T>> void shellSort(T[] a) {
		int n = a.length;
		while (n != 0) {
			n = n / 2;	// 初始间隔设为数组长度的一半，随着循环的进行依次减半
			for (int i = 0; i < n; i++) {
				// 依次比较数组中间隔为n/2 的元素的大小，若后者比前者大，则交换两个元素的位置
				for (int j = i + n; j < a.length; j += n) {
					int k = j - n;
					T temp = a[j];
					while (k >= 0 && temp.compareTo(a[k]) < 0) {
						a[k + n] = a[k];
						k -= n;
					}
					a[k + n] = temp;
				}
			}
		}
	}

	/**
	 * mergeSort
	 * 归并排序使用了分制(divide and conquer)的思想
	 * 它先是递归的将待排序数组拆分成仅含有一个元素的子数组，然后再递归的有序合并这些子数组,从而使得整个数组是有序的
	 * 
	 * @description 递归的排序数值项 a[start] 到 a[end]
	 * @param a 待排序数组
	 * @param tmpArray 临时数组
	 * @param first	数组开始位置下标
	 * @param last	数组结尾位置下标
	 */
	public static <T extends Comparable<? super T>> void mergeSort(T[] a, T[] tmpArray, int first, int last) {
		if (first < last) {
			int mid = (first + last) / 2;
			// 把数组分解成两个子列,直至子列只有一项为止
			mergeSort(a, tmpArray, first, mid);
			mergeSort(a, tmpArray, mid + 1, last);
			// 合并两个有序的的两半数组 a[start... mid] a[mid + 1... end]
			merge(a, tmpArray, first, mid, last);
		}
	}

	/**
	 * merge
	 * 
	 * @description 合并已经排序好的两部分数组
	 * @param a 待合并数组
	 * @param tmpArray 临时数组
	 * @param first 第一个元素的下标
	 * @param mid	中间元素的下标
	 * @param last	最后一个元素的下标
	 */
	private static <T extends Comparable<? super T>> void merge(T[] a, T[] tmpArray, int first, int mid, int last) {
		int i = first;
		int j = mid + 1;
		int k = 0;
		// 当两个子数组都不为空时，让一个子数组中的项与另一个子数组中的项进行比较
		// 然后将较小的项复制到临时数组中
		while (i <= mid && j <= last) {
			if (a[i].compareTo(a[j]) <= 0) {
				tmpArray[k] = a[i];
				i++;
			} else {
				tmpArray[k] = a[j];
				j++;
			}
			k++;
		}
		// 断言：一个子数组已经全部复制到tmpArray中

		// 将另一个数组中的其余项复制到tmpArray中
		while (i <= mid) {
			tmpArray[k] = a[i];
			k++;
			i++;
		}
		while (j <= last) {
			tmpArray[k] = a[j];
			k++;
			j++;
		}

		// 将tmpArray中的项赋值到数组a中
		for (int m = 0; m < k; m++) {
			a[first + m] = tmpArray[m];
		}
	}

	/**
	 * quickSort 快速排序
	 * @description
	 * 快速排序使用数组中的一项作为枢轴，
	 * 将数组划分成两部分，较小的部分和较大的部分，
	 * 与归并不同的是，这两部分不一定是数组的一半
	 * 
	 * 理想情形是枢轴正好移动到数组的中心，若对美对quickSort的调用都划分了相等大小的子数组，
	 * 则快排与归并排序一样递归调用数组的两半，此时的时间复杂度为O(nlogn) 是最优情形
	 * 
	 * 快速排序的平均时间复杂度为 O(nlogn) 且在排序时不需要额外的辅助空间
	 * 
	 * 
	 * @param a		待排序数组
	 * @param first	第一个元素下标
	 * @param last	最后一个元素下标
	 */
	public static <T extends Comparable<? super T>> void quickSort(T[] a, int first, int last) {
		// 递归的排序数组 a[first] 到 a[last]
		if (first < last) {
			T baseElement = a[first];	// 选择第一个元素为枢轴
			int i = first;	
			int j = last;	
			do {
				while ((a[i].compareTo(baseElement) < 0) && (i < last)) {
					i++;
				}
				while ((a[j].compareTo(baseElement) > 0) && (j > first)) {
					j--;
				}
				if (i <= j) {
					swap(a, i, j);
					i++;
					j--;
				}
			} while (i <= j);
			if (first < j) {
				quickSort(a, first, j);
			}
			if (last > i) {
				quickSort(a, i, last);
			}
		}
	}

	/**
	 * radixSort 基数排序
	 * 
	 * 基数排序中的元素的数据类型有限制的，它适用于元素本身可以切分的数据类型
	 * 根据最大元素的位数来分配bucket，每一个元素依次在每个桶内进行排序，最终达到数组全部排序的效果
	 * @param a 待排序数组
	 */
	public static void radixSort(int[] a) {
		// 先确定排序的趟数
		int max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
			}
		}
		int time = 0;
		// 判断位数
		while (max > 0) {
			max /= 10;
			time++;
		}
		// 新建10个bucket
		List<ArrayList<Integer>> queue = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			ArrayList<Integer> queue1 = new ArrayList<>();
			queue.add(queue1);
		}

		// 进行time次分配和收集
		for (int i = 0; i < time; i++) {
			// 分配数组元素
			for (int j = 0; j < a.length; j++) {
				// 得到数字的第time+1位数字
				int x = a[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
				ArrayList<Integer> queue2 = queue.get(x);
				queue2.add(a[j]);
				queue.set(x, queue2);
			}
			int count = 0;
			for (int k = 0; k < 10; k++) {
				while (queue.get(k).size() > 0) {
					// 将bucket[0], bucket[1]... bucket[9] 放回到数组a中
					ArrayList<Integer> queue3 = queue.get(k);
					a[count] = queue3.get(0);
					// 清空bucket[0] bucket[1]... bucket[9]
					queue3.remove(0);
					count++;
				}
			}
		}
	}

	/**
	 * heapSort 堆排序
	 * 
	 * @param a 待排序数组
	 */
	public static <T extends Comparable<? super T>> void heapSort(T[] a) {
		int n = a.length;
		// 循环建堆
		for (int i = 0; i < n - 1; i++) {
			buildMaxHeap(a, n - 1 - i);
			swap(a, 0, n - 1 - i);
		}
	}

	/**
	 * buidMaxHeap 用来构造大顶堆的方法
	 * 
	 * @param a 构造大顶堆的数组
	 * @param lastIndex 数组的最后一个索引
	 */
	private static <T extends Comparable<? super T>> void buildMaxHeap(T[] a, int lastIndex) {
		for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
			int k = i;
			while (k * 2 + 1 <= lastIndex) {
				int biggerIndex = 2 * k + 1;
				if (biggerIndex < lastIndex) {
					if (a[biggerIndex].compareTo(a[biggerIndex + 1]) < 0) {
						biggerIndex++;
					}
				}
				if (a[k].compareTo(a[biggerIndex]) < 0) {
					swap(a, k, biggerIndex);
					k = biggerIndex;
				} else {
					break;
				}
			}
		}
	}

}
