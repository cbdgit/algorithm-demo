package com.valueyouth.algorithmdemo;

/**
 * ��˵�����򵥿��������㷨
 * @author cwang6
 * @since 2017-2-7
 * @version 1.0
 */
public class SimpleQuickSort {

	/**
	 * ����˵�������Է�����������������顣
	 * @param args Ԥ�����
	 */
	public static void main(String[] args) {
		int[] numbers = {25, 25, 36, 95, 12, 68, 101};
		SimpleQuickSort simpleQuickSort = new SimpleQuickSort();
		
		simpleQuickSort.quickSort(numbers, 0, numbers.length - 1);
		for (int number : numbers){
			System.out.print(number + " ");
		}
	}
	
	/**
	 * ����˵������{@code left}С��{@code right}ʱ��ͨ�����෽�����õ���׼λ��
	 * ׼ȷλ�ã�������λ��{@code pivot}���ء�Ȼ����ͨ���ݹ���÷���{@code quickSort}
	 * ִ���������̡�
	 * @param numbers Դ����
	 * @param left �ײ�����
	 * @param right β������
	 */
	private void quickSort(int[] numbers, int left, int right) {
		if (left < right){
			int pivot = partition(numbers, left, right);
			quickSort(numbers, left, pivot - 1);
			quickSort(numbers, pivot + 1, right);
		}
	}
	
	
	/**
	 * ����˵�������Ȼ�׼λ����{@code pivotNumber}������֣����ƶ���{@code pivotNumber}
	 * ���ұߣ�ͬʱ���Ȼ�׼λ����{@code pivotNumber}С�����֣����ƶ���{@code pivotNumber}
	 * ����ߡ���󣬽���׼λ�����ַ��õ���ȷ��λ�á�
	 * @param numbers Դ����
	 * @param left �ײ�������һ���ǻ�׼λ�á�
	 * @param right β������
	 * @return ��׼�������ڵ�λ��
	 */
	private int partition(int[] numbers, int left, int right) {
		int pivotNumber = numbers[left]; // �������һλ��Ϊ��׼
		
		while (left < right) {
			while (left < right && numbers[right] > pivotNumber) {
				right--;
			}
			numbers[left] = numbers[right]; // �ƶ�С�ڻ�׼�ļ�¼�����
			
			while (left < right && numbers[left] < pivotNumber) {
				left++;
			}
			numbers[right] = numbers[left]; // �ƶ����ڻ�׼�ļ�¼���ұ�
		}
		
		numbers[left] = pivotNumber; // �ƶ���׼λ��¼����ȷλ��
		return left;
	}
	
}
