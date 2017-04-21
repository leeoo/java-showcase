/**
 * 
 */
package com.lex.showcase.algorithm.sorting;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Lex Li
 *
 */
public class BubbleSort {
	
	private static Logger log = LogManager.getLogger(BubbleSort.class.getName());

	public static void main(String[] args) {
//		int[] array = {6, 3, 10};
		int[] array = {4, 3, 2, 1};
//		int[] array = {6, 3, 10, 7, -1, 9, 2, 0};
//		int[] array = {-1, 0, 2, 3, 6, 7, 9, 10}; // Ordered data ASC
//		int[] array = {10, 9, 7, 6, 3, 2, 0, -1}; // Ordered data DESC
		log.info("Array length: " + array.length);

		bubbleSort(array);
//		bubbleSort2(array);
		
//		selectSort(array);
	}

	/**
	 * 它重复地走访过要排序的数列，一次比较两个元素，如果他们的顺序错误就把他们交换过来。走访数列的工作是重复地进行直到没有再需要交换，
	 * 也就是说该数列已经排序完成。 这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端，故名。
	 * 
	 * @param array
	 */
	private static void bubbleSort(int[] array) {
		final int length = array.length;
		if (array == null || length < 2) {
			log.info("No data to bubble sort!");
			return;
		}
		
		int counter = 0;
		log.info("Source data: " + Arrays.toString(array));
		for (int i = 0; i < length; i++) {
			counter += 1;
			for (int j = 0; j < length - i - 1; j++) { // "j < length - i - 1;"是为了仅针对剩余的待排序数据进行排序！
				if (array[j] > array[j + 1]) {
					counter += 1;
					
					log.info("	swap data.");
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
				log.info("	Level 2 loop j" + j + ": " + Arrays.toString(array));
			}
			log.info("Level 1 loop i" + i + ": " + Arrays.toString(array));
		}
		
		log.info("Sorting finished: " + Arrays.toString(array));
		log.info("Counter: " + counter);
	}
	
	private static void bubbleSort2(int[] array) {
		final int length = array.length;
		if (array == null || length == 0) {
			log.info("No data to bubble sort!");
			return;
		}
		
		int counter = 0;
		log.info("Source data: " + Arrays.toString(array));
		for (int i = 0; i < length; i++) {
			counter += 1;
			for (int j = i + 1; j < length; j++) {
				if (array[i] > array[j]) {
					counter += 1;
					
					log.info("	swap data.");
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
				log.info("	Level 2 loop " + j + ": " + Arrays.toString(array));
			}
			log.info("Level 1 loop " + i + ": " + Arrays.toString(array));
		}
		
		log.info("Sorting finished: " + Arrays.toString(array));
		log.info("Counter: " + counter);
	}

	/**
	 * 错误的写法，每一趟排序都针对所有的数据！！！
	 * @param array
	 */
	private static void bubbleSortBadWay(int[] array) {
		int counter = 0;
		for (int i = 0; i < array.length; i++) {
			counter += 1;
			for (int j = 0; j < array.length; j++) {
				if (array[j] < array[i]) {
					counter += 1;
					
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp; 
				}
				log.info("	Level 2 loop " + j + ": " + Arrays.toString(array));
			}
			log.info("Level 1 loop " + i + ": " + Arrays.toString(array));
		}
		
		log.info("Sorting finished: " + Arrays.toString(array));
		log.info("Counter: " + counter);
	}
	
	/**
	 * 选择排序  每一趟从待排序的数据元素中选出最小（或最大）的一个元素，顺序放在已排好序的数列的最后，直到全部待排序的数据元素排完。
	 * 选择排序是不稳定的排序方法。
	 * 
	 * @param array
	 */
	private static void selectSort(int[] array) {
		int counter = 0;
		for (int i = 0; i < array.length; i++) {
			counter += 1;
			
			int min = i;
			for (int j = i; j < array.length; j++) {
				if (array[min] > array[j]) {
					counter += 1;
					
					min = j;
				}
			}
			if (min != i) {
				int temp = array[i];
				array[i] = array[min];
				array[min] = temp;
			}
		}
		log.info("Counter: " + counter);
		log.info("Sorting finished: " + Arrays.toString(array));
	}
	
}
