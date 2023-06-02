package chap08_리스트;

import java.util.Random;
import java.util.Scanner;

class Node1 {
	int data;
	Node1 link;

	public Node1(int element) {
		data = element;
		link = null;
	}
}

class LinkedList1 {
	Node1 first;

	public LinkedList1() {
		first = null;
	}

	// element 삭제
	public String Delete(int element) {
		Node1 ptr = first;
		if (first == null) return "List가 비어있어 삭제할 수 없습니다.";
		if (!Search(element)) return "리스트에 " + element + "가 없습니다.";
		
		if (element == first.data) first = first.link;
		else {
			while (ptr.link.data != element) {
				ptr = ptr.link;
			}
			ptr.link = ptr.link.link;
		}
		return element + "가 삭제되었습니다.";
	}

	// 모든 노드 출력
	public void Show() {
		Node1 ptr = first;

		while (ptr != null) {
			System.out.println(ptr.data);
			ptr = ptr.link;
		}
	}

	// 정렬된 순서로 입력
	public void Add(int element) {
		Node1 nd = new Node1(element);
		Node1 ptr = first;
		Node1 pre = null;
		if (ptr == null) {
			first = nd;
			return;
		}
		while (ptr != null) {
			if (element < ptr.data) {
				if (first == ptr) {
					first = nd;
					nd.link = ptr;
					return;
				}
				nd.link = ptr;
				pre.link = nd;
				return;
			}
			pre = ptr;
			ptr = ptr.link;
		}
		if (ptr == null) pre.link = nd;
	}

	// 검색
	public boolean Search(int data) {
		Node1 ptr = first;

		while (ptr != null) {
			if (data == ptr.data) return true;
			ptr = ptr.link;
		}
		return false;
	}
}

public class 정수연결리스트 {
	enum Menu {
		Add("삽입"), Delete("삭제"), Show("인쇄"), Search("검색"), Exit("종료");

		// 표시할 문자열
		private final String message;

		// 순서가 idx번째인 열거를 반환
		static Menu MenuAt(int idx) {
			for (Menu m : Menu.values()) {
				if (m.ordinal() == idx) return m;
			}
			return null;
		}

		// 생성자(constructor)
		Menu(String string) {
			message = string;
		}

		// 표시할 문자열을 반환
		String getMessage() {
			return message;
		}
	}

	// --- 메뉴 선택 ---//
	static Menu SelectMenu() {
		Scanner sc = new Scanner(System.in);
		int key;
		do {
			for (Menu m : Menu.values()) {
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
				if ((m.ordinal() % 3) == 2 && m.ordinal() != Menu.Exit.ordinal()) System.out.println();
			}
			System.out.print(" : ");
			key = sc.nextInt();
		} while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());
		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Menu menu; // 메뉴
		Random rand = new Random();
		System.out.println("Linked List");
		LinkedList1 l = new LinkedList1();
		Scanner sc = new Scanner(System.in);
		int data = 0;
		System.out.println("inserted");
		l.Show();
		do {
			switch (menu = SelectMenu()) {
			case Add: // 삽입
				data = rand.nextInt(20);
				l.Add(data);
				break;
			case Delete: // 선택 노드를 삭제
				data = sc.nextInt();
				String delResult = l.Delete(data);
				System.out.println(delResult);
				break;
			case Show: // 모든 노드 출력
				l.Show();
				break;
			case Search: // 검색
				int n = sc.nextInt();
				boolean result = l.Search(n);
				if (result == false) System.out.println("검색 값 = " + n + "데이터가 없습니다.");
				else System.out.println("검색 값 = " + n + "데이터가 존재합니다.");
				break;
			case Exit:
				break;
			}
		} while (menu != Menu.Exit);
	}
	
}
