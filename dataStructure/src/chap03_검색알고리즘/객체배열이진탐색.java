package chap03_검색알고리즘;

import java.util.Arrays;

class PhyscData implements Comparable<PhyscData> {
	String name;
	int height;
	double vision;

	PhyscData(String name, int height, double vision) {
		this.name = name;
		this.height = height;
		this.vision = vision;
	}

	@Override
	public int compareTo(PhyscData o) {
		if (this.name.compareTo(o.name) == 0) {
			if (this.height == o.height) return (int) (this.vision - o.vision);
			else return this.height - o.height;
		} else {
			return this.name.compareTo(o.name);
		}
	}

}

public class 객체배열이진탐색 {

	public static void main(String[] args) {
		PhyscData[] data = { new PhyscData("홍길동", 162, 0.3), new PhyscData("홍동", 164, 1.3),
				new PhyscData("홍길", 152, 0.7), new PhyscData("김홍길동", 172, 0.3), new PhyscData("길동", 182, 0.6),
				new PhyscData("길동", 167, 0.2), new PhyscData("길동", 167, 0.5), };
		showData(data);
		sortData(data);
		showData(data);
		PhyscData key = new PhyscData("길동", 167, 0.2);
		int result = linearSearch(data, key);
		System.out.println("\nlinearSearch(): result = " + result);

		key = new PhyscData("길동", 167, 0.5);
		result = binarySearch(data, key);
		System.out.println("\nbinarySearch(): result = " + result);
		int idx = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(): result = " + idx);
	}

	static void showData(PhyscData[] arr) {
		System.out.println();
		for (PhyscData p : arr) {
			System.out.print(p.name + ", " + p.height + ", " + p.vision + " | ");
		}
		System.out.println();
	}

	public static void sortData(PhyscData[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i].compareTo(arr[j]) > 0) swap(arr, i, j);
			}
		}
	}

	static void swap(PhyscData[] arr, int i, int j) {
		PhyscData temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	static int linearSearch(PhyscData[] arr, PhyscData key) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].compareTo(key) == 0) return i;
		}
		
		return -1;
	}

	static int binarySearch(PhyscData[] arr, PhyscData key) {
		int pl = 0;
		int pr = arr.length;

		do {
			int pc = (pl + pr) / 2;
			if (arr[pc].compareTo(key) == 0)
				return pc;
			else if (arr[pc].compareTo(key) < 0)
				pl = pc + 1;
			else
				pr = pc - 1;
		} while (pl <= pr);
		
		return -1;
	}

}
