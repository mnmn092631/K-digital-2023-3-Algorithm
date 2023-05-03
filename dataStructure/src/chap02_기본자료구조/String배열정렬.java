package chap02_기본자료구조;

public class String배열정렬 {
	static void showData(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	static void sortData(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i].compareTo(arr[j]) > 0) {
					swap(arr, i, j);
				}
			}
		}
	}

	static void swap(String[] arr, int i, int j) {
		String temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		String[] data = { "apple", "grape", "banana", "melon" };
		showData(data);
		System.out.println();
		sortData(data);
		System.out.println("정렬 후 결과");
		showData(data);
	}

}
