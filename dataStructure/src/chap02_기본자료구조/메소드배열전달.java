package chap02_기본자료구조;

import java.util.Random;

public class 메소드배열전달 {
	static void getData(int[] arr) {
		Random rand = new Random();
		for (int i = 0; i < arr.length; i++) {
			int temp;
			do {
				temp = rand.nextInt(11);
			} while (hasNum(arr, temp));
			arr[i] = temp;
		}
	}

	static boolean hasNum(int[] arr, int num) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == num)
				return true;
		}
		return false;
	}

	static void showData(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	static int findMax(int[] arr) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max)
				max = arr[i];
		}
		return max;
	}

	static void sortData(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					swap(arr, i, j);
				}
			}
		}
	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[] data = new int[10];
		getData(data);
		showData(data);
		int mvalue = findMax(data);
		System.out.println();
		System.out.println("max = " + mvalue);
		sortData(data);
		System.out.println("정렬 후 결과");
		showData(data);
	}

}
