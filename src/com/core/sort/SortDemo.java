package com.core.sort;

public class SortDemo {
	public static void main(String[] args) {
		 int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
		//SortDemo.Bubble_Sort1(a);
		//SortDemo.Bubble_Sort2(a);
		 SortDemo.Insert_sort(a);
	}
	
	/**
	 * 传统的冒泡
	 * @param a 数组
	 * @return
	 */
	public static int[] Bubble_Sort1(int a[]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < i; j++) {
				int temp = 0;
				if (a[i] > a[j]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		return a;
	}
	
	/**
	 * 改良版的冒泡
	 * @param a 数组
	 * @return
	 */
	public static int[] Bubble_Sort2(int a[]) {
		int i = a.length - 1;
		while (i > 0) {
			int positon = 0;
			int temp;
			for (int j = 0; j < i; j++) {
				if (a[j] > a[j + 1]) {
					positon = i;
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
			i = positon;
		}
		return a;
	}
	
	/** 直接插入排序
	 * @param a
	 * @return
	 */
	public static int[] Insert_sort(int a[]) {
		int temp = 0;
		for (int i = 1; i < a.length; i++) {
			int j = i - 1;
			temp = a[i];
			for (; j >= 0 && temp < a[j]; j--) {
				a[j + 1] = a[j];
			}
			a[j + 1] = temp;
		}
		return a;
	}
	
	/**
	 * 希尔排序
	 * @param a
	 * @return
	 */
	private static int[] Shell_sort(int a[]) {
		int temp = 0;
		while (true) {
			double d1 = a.length;
			d1 = Math.ceil(d1 / 2);
			int d = (int) d1;
			for (int x = 0; x < d; x++) {
				for (int i = x + d; i < a.length; i += d) {
					int j = i - d;
					temp = a[i];
					for (; j >= 0 && temp < a[j]; j -= d) {
						a[j + d] = a[j];
					}
					a[j + d] = temp;
				}
			}

			if (d == 1) {
				break;
			}
		}
		return a;
	}
	
}
