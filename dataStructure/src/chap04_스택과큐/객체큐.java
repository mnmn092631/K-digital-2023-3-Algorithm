package chap04_스택과큐;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// int형 고정 길이 큐
class ObjectQueue {
	private List<Point> que;
	private int capacity; // 큐의 크기
	private int front; // 맨 처음 요소 커서
	private int rear; // 맨 끝 요소 커서
	private int num; // 현재 데이터 개수

	public class EmptyQueueException extends RuntimeException {
		public EmptyQueueException() {

		}
	}

	public class OverflowQueueException extends RuntimeException {
		public OverflowQueueException() {

		}
	}

	public ObjectQueue(int maxlen) {
		num = front = rear = 0;
		capacity = maxlen;
		try {
			que = new ArrayList<>(capacity);
		} catch (OutOfMemoryError e) {
			capacity = 0;
		}
	}

	public Point enque(Point p) throws OverflowQueueException {
		if (num >= capacity) throw new OverflowQueueException();
		if (num < capacity) que.add(p);
		else que.set(rear++, p);
		num++;
		if (rear == capacity) rear = 0;
		return p;
	}

	public Point deque() throws EmptyQueueException {
		if (num <= 0) throw new EmptyQueueException();
		Point p = que.get(front++);
		num--;
		if (front == capacity) front = 0;
		return p;
	}

	public Point peek() throws EmptyQueueException {
		if (num <= 0) throw new EmptyQueueException();
		return que.get(front);
	}

	public void clear() {
		num = front = rear = 0;
	}

	public int indexOf(Point p) {
		for (int i = 0; i < num; i++) {
			int idx = (i + front) % capacity;
			if (que.get(idx).equals(p)) return idx;
		}
		return -1;
	}

	public int getCapacity() {
		return capacity;
	}

	public int size() {
		return num;
	}

	public boolean isEmpty() {
		return num <= 0;
	}

	public void dump() {
		if (num <= 0) System.out.println("큐가 비어 있습니다.");
		else {
			for (int i = 0; i < num; i++) {
				System.out.println(que.get((i + front) % capacity) + " ");
			}
			System.out.println();
		}
	}
}

// int형 고정 길이 큐의 사용 예
public class 객체큐 {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		ObjectQueue s = new ObjectQueue(4);
		Random random = new Random();
		int rndx = 0, rndy = 0;
		Point p = null;
		while (true) {
			System.out.println(" "); // 메뉴 구분을 위한 빈 행 추가
			System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
			System.out.print("(1)인큐　(2)디큐　(3)피크　(4)덤프 (5)indexOf (6)clear　(0)종료: ");

			int menu = stdIn.nextInt();
			if (menu == 0) break;

			switch (menu) {
			case 1: // 인큐
				System.out.print("데이터: ");
				rndx = random.nextInt(20);
				rndy = random.nextInt(20);
				p = new Point(rndx, rndy);
				try {
					s.enque(p);
				} catch (ObjectQueue.OverflowQueueException e) {
					System.out.println("stack이 가득찼습니다.");
				}
				break;

			case 2: // 디큐
				try {
					p = s.deque();
					System.out.println("디큐한 데이터는 " + p + "입니다.");
				} catch (ObjectQueue.EmptyQueueException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 3: // 피크
				try {
					p = s.peek();
					System.out.println("피크한 데이터는 " + p + "입니다.");
				} catch (ObjectQueue.EmptyQueueException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 4: // 덤프
				s.dump();
				break;

			case 5: // indexOf
				System.out.print("데이터: ");
				rndx = stdIn.nextInt();
				rndy = stdIn.nextInt();
				p = new Point(rndx, rndy);
				System.out.println("입력한 데이터의 인덱스는 " + s.indexOf(p) + "입니다.");
				break;

			case 6: // clear
				s.clear();
				break;
			}
		}
	}

}