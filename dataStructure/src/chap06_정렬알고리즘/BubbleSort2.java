package chap06_정렬알고리즘;

import java.util.Random;

class BubbleSort2 {
	
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	static void bubbleSort(int[] a, int n) {
		int count = 0;
		for (int i = 0; i < n - 1; i++) {
			int exchg = 0;
			for (int j = n - 1; j > i; j--) {
				count++;
				if (a[j - 1] > a[j]) {
					swap(a, j - 1, j);
					exchg++;
				}
			}
			if (exchg == 0) break;
		}
		System.out.println("비교 횟수(count) : " + count);
	}

	public static void main(String[] args) {
		Random random = new Random();
		System.out.println("버블 정렬(버전 2)");

		int nx = 100;
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {
			x[i] = random.nextInt(100);
		}

		bubbleSort(x, nx);

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++) {
			System.out.print(x[i] + " ");
		}
	}
	
}
