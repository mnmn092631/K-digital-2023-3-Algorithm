package chap06_정렬알고리즘;

import java.util.Scanner;

interface MaxHeap {
	public void Insert(int x);

	public int DeleteMax();
}

class Heap implements MaxHeap {
	private int[] heap;
	private int n;
	final int MaxSize;

	public Heap(int sz) {
		MaxSize = sz;
		n = 0;
		heap = new int[MaxSize + 1];
	}

	public void display() {
		for (int i = 1; i <= n; i++) {
			System.out.println("  (" + i + ", " + heap[i] + ") ");
		}
		System.out.println();
	}

	@Override
	public void Insert(int x) {
		int i;
		if (n == MaxSize) {
			HeapFull();
			return;
		}
		n++;
		for (i = n; i > 1;) {
			if (x <= heap[i / 2]) break;
			heap[i] = heap[i / 2];
			i /= 2;
		}
		heap[i] = x;
	}

	@Override
	public int DeleteMax() {
		int i, j;
		if (n == 0) {
			HeapEmpty();
			return -1;
		}
		int x = heap[1];
		int k = heap[n];
		n--;
		for (i = 1, j = 2; j <= n;) {
			if (j < n && heap[j] < heap[j + 1]) j++;
			if (k >= heap[j]) break;
			heap[i] = heap[j];
			i = j;
			j *= 2;
		}
		heap[i] = k;
		return x;
	}

	private void HeapEmpty() {
		System.out.println("Heap Empty");
	}

	private void HeapFull() {
		System.out.println("Heap Full");
	}
}

public class Heap정렬 {

	public static void main(String[] args) {
		int select = 0;
		Scanner stdIn = new Scanner(System.in);
		Heap heap = new Heap(20);
		final int count = 20;
		int[] x = new int[count + 1];
		int[] sorted = new int[count];

		do {
			System.out.println("Max Tree. Select: 1 insert, 2 display, 3 sort, 4 exit => ");
			select = stdIn.nextInt();
			switch (select) {
			case 1:
				for (int i = 0; i < count; i++) {
					x[i] = (int) (Math.random() * 130) + 1;
					heap.Insert(x[i]);
				}
				break;

			case 2:
				heap.display();
				break;

			case 3:
				for (int i = 1; i <= count; i++)
					sorted[i - 1] = heap.DeleteMax();
				for (int num : sorted)
					System.out.print(" " + num);
				System.out.println();
				break;

			case 4:
				return;
			}
		} while (select < 5);

	}
}
