package chap06_정렬알고리즘;

import java.util.Random;

class QuickSort2 {
	static int count;

	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	static void quickSort(int[] a, int left, int right) {
		ObjectStack st = new ObjectStack(right - left + 1);
		Point p = new Point(left, right);
		st.push(p);

		while (!st.isEmpty()) {
			p = st.pop();
			int pl = left = p.getX();
			int pr = right = p.getY();
			int x = a[(left + right) / 2];

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

			if (left < pr) {
				p = new Point(left, pr);
				st.push(p);
			}
			if (pl < right) {
				p = new Point(pl, right);
				st.push(p);
			}
		}
	}

	public static void main(String[] args) {
		Random random = new Random();
		System.out.println("퀵 정렬(버전 2)");

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
