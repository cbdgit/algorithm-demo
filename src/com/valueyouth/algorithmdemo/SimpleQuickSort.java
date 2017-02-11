package com.valueyouth.algorithmdemo;

/**
 * 类说明：简单快速排序算法
 * @author cwang6
 * @since 2017-2-7
 * @version 1.0
 */
public class SimpleQuickSort {

	public static void main(String[] args) {
		
		
	}
	
	
	/**
	 * 方法说明：
	 * @param numbers 源数组
	 * @param left 首部索引，一般是基准位置。
	 * @param right 尾部索引
	 * @return 基准数字所在的位置
	 */
	private int partition(int[] numbers, int left, int right) {
		int pivotNumber = numbers[left]; // 将数组第一位作为基准
		
		while (left < right) {
			while (left < right && numbers[right] > pivotNumber) {
				
			}
			
			
		}
		
		return 0;
	}
	
}
