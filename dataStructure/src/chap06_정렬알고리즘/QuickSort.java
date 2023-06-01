package chap06_정렬알고리즘;

import java.util.Random;

class QuickSort {
	static int count = 0;

	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	static void quickSort(int[] a, int left, int right) {
		int pl = left;
		int pr = right;
		int x = a[(pl + pr) / 2];

		do {
			while (a[pl] < x) {
				pl++;
				count++;
			}
			while (a[pr] > x) {
				pr--;
				count++;
			}
			if (pl <= pr) swap(a, pl++, pr--);
			count++;
		} while (pl <= pr);

		if (left < pr) quickSort(a, left, pr);
		if (pl < right) quickSort(a, pl, right);
	}

	public static void main(String[] args) {
		Random random = new Random();
		System.out.println("퀵 정렬(버전 1)");
		
		int nx = 100;
		int[] x = new int[nx];
		
		for (int i = 0; i < nx; i++) {
			x[i] = random.nextInt(100);
		}

		quickSort(x, 0, nx - 1);

		System.out.println("count : " + count);
		
		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++) {
			System.out.println("x[" + i + "]=" + x[i]);
		}
	}

}
