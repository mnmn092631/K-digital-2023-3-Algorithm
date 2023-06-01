package chap06_정렬알고리즘;

import java.util.Random;

class SelectionSort {

	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	static void selectionSort(int[] a, int n) {
		int count = 0;
		for (int i = 0; i < n - 1; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++) {
				count++;
				if (a[j] < a[min]) min = j;
			}
			swap(a, i, min);
		}
		System.out.println("정렬 횟수(count) : " + count);
	}

	public static void main(String[] args) {
		Random random = new Random();
		System.out.println("단순 선택 정렬");

		int nx = 100;
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {
			x[i] = random.nextInt(100);
		}

		selectionSort(x, nx);

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.print(x[i] + " ");
	}
	
}
