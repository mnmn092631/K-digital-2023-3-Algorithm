package chap03_검색알고리즘;

import java.util.Arrays;

public class 스트링배열이진탐색 {

	static void showData(String[] arr) {
		for (String str : arr) {
			System.out.print(str + " ");
		}
	}

	static void sortData(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i].compareTo(arr[j]) > 0) swap(arr, i, j);
			}
		}
	}

	static void swap(String[] arr, int i, int j) {
		String temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	static int linearSearch(String[] arr, String key) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals(key)) return i;
		}
		
		return -1;
	}

	static int binarySearch(String[] arr, String key) {
		int pl = 0;
		int pr = arr.length - 1;

		do {
			int pc = (pl + pr) / 2;
			if (arr[pc].equals(key)) return pc;
			else if (arr[pc].compareTo(key) < 0) pl = pc + 1;
			else pr = pc - 1;
		} while (pl <= pr);

		return -1;
	}

	public static void main(String[] args) {
		String[] data = { "apple", "grape", "persimmon", "감", "배", "사과", "포도", "pear", "blueberry", "strawberry",
				"melon", "oriental melon" };
		showData(data);
		
		sortData(data);
		System.out.println();
		showData(data);

		String key = "감";
		int result = linearSearch(data, key);
		System.out.println("\nlinearSearch(): result = " + result);

		key = "배";
		result = binarySearch(data, key);
		System.out.println("\nbinarySearch(): result = " + result);
		int idx = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(): result = " + idx);

	}

}