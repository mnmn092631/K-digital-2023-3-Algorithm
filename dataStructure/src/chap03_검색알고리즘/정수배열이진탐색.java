package chap03_검색알고리즘;

import java.util.Arrays;
import java.util.Random;

public class 정수배열이진탐색 {

	static void inputData(int[] arr) {
		Random ran = new Random();

		for (int i = 0; i < arr.length; i++) {
			arr[i] = ran.nextInt(40);
		}
	}

	static void showData(int[] arr) {
		for (int num : arr) {
			System.out.print(num + " ");
		}
	}

	static void sortData(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) swap(arr, i, j);
			}
		}
	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	static int linearSearch(int[] arr, int key) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key) return i;
		}
		
		return -1;
	}

	static int binarySearch(int[] arr, int key) {
		int pl = 0;
		int pr = arr.length - 1;

		do {
			int pc = (pl + pr) / 2;
			if (arr[pc] == key) return pc;
			else if (arr[pc] < key) pl = pc + 1;
			else pr = pc - 1;
		} while (pl <= pr);

		return -1;
	}

	public static void main(String[] args) {
		int[] data = new int[10];
		inputData(data);
		showData(data);

		sortData(data);
		System.out.println();
		for (int num : data) {
			System.out.print(num + " ");
		}

		int key = 33;
		int result = linearSearch(data, key);
		System.out.println("\nlinearSearch(): result = " + result);

		key = 39;
		result = binarySearch(data, key);
		System.out.println("\nbinarySearch(): result = " + result);
		int idx = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(): result = " + idx);

	}

}