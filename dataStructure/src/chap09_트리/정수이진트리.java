package chap09_트리;

import java.util.Random;
import java.util.Scanner;

//정수를 저장하는 이진트리 만들기 실습
class TreeNode {
	TreeNode LeftChild;
	int data;
	TreeNode RightChild;

	public TreeNode() {
		LeftChild = RightChild = null;
	}
}

class Tree {
	TreeNode root;

	Tree() {
		root = null;
	}

	TreeNode inorderSucc(TreeNode current) {
		TreeNode temp = current.RightChild;
		if (current.RightChild != null) {
			while (temp.LeftChild != null) {
				temp = temp.LeftChild;
			}
		}
		else if(current.LeftChild == null) return current;
		else inorderSucc(current.LeftChild);
		return temp;
	}

	boolean isLeafNode(TreeNode current) {
		if (current.LeftChild == null && current.RightChild == null) return true;
		else return false;
	}

	void inorder() {
		inorder(root);
	}

	void preorder() {
		preorder(root);
	}

	void postorder() {
		postorder(root);
	}

	void inorder(TreeNode CurrentNode) {
		if (CurrentNode != null) {
			inorder(CurrentNode.LeftChild);
			System.out.print(CurrentNode.data + " ");
			inorder(CurrentNode.RightChild);
		}
	}

	void preorder(TreeNode CurrentNode) {
		if (CurrentNode != null) {
			System.out.print(CurrentNode.data + " ");
			preorder(CurrentNode.LeftChild);
			preorder(CurrentNode.RightChild);
		}
	}

	void postorder(TreeNode CurrentNode) {
		if (CurrentNode != null) {
			postorder(CurrentNode.LeftChild);
			postorder(CurrentNode.RightChild);
			System.out.print(CurrentNode.data + " ");
		}
	}

	// binary search tree를 만드는 입력 => A + B * C을 tree로 만드는 방법: 입력 해결하는 알고리즘 작성 방법을
	// 설계하여 구현
	boolean insert(int num) {
		TreeNode p = root;
		TreeNode nd = new TreeNode();
		nd.data = num;
		if (root == null) {
			root = nd;
			return true;
		}
		while (true) {
			if (num == p.data) return false;
			else if (num - p.data < 0) {
				if (p.LeftChild == null) {
					p.LeftChild = nd;
					return true;
				} else p = p.LeftChild;
			} else {
				if (p.RightChild == null) {
					p.RightChild = nd;
					return true;
				} else p = p.RightChild;
			}
		}
	}

	boolean delete(int num) {
		TreeNode p = root;
		TreeNode parent = null;
		boolean isLeftChild = true;

		while (true) {
			if (p == null) return false;
			if (num == p.data) break;
			else {
				parent = p;
				if (num - p.data < 0) {
					isLeftChild = true;
					p = p.LeftChild;
				} else {
					isLeftChild = false;
					p = p.RightChild;
				}
			}
		}

		if (isLeafNode(p)) {
			if (p == root) root = null;
			else if (isLeftChild) parent.LeftChild = null;
			else parent.RightChild = null;
		}
		else {
			TreeNode successor = inorderSucc(p);
			int data = successor.data;
			delete(successor.data);
			p.data = data;
		}
		return true;
	}

	boolean search(int num) {
		TreeNode p = root;

		while (true) {
			if (p == null) return false;
			if (num == p.data) return true;
			else if (num - p.data < 0) p = p.LeftChild;
			else p = p.RightChild;
		}
	}
}

public class 정수이진트리 {
	enum Menu {
		Add("삽입"), Delete("삭제"), Search("검색"), InorderPrint("순차출력"), Exit("종료");

		private final String message; // 표시할 문자열

		static Menu MenuAt(int idx) { // 순서가 idx번째인 열거를 반환
			for (Menu m : Menu.values()) {
				if (m.ordinal() == idx) return m;
			}
			return null;
		}

		Menu(String string) { // 생성자(constructor)
			message = string;
		}

		String getMessage() { // 표시할 문자열을 반환
			return message;
		}
	}

	// --- 메뉴 선택 ---//
	static Menu SelectMenu() {
		Scanner stdIn = new Scanner(System.in);
		int key;
		do {
			for (Menu m : Menu.values()) {
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
			}
			System.out.print(" : ");
			key = stdIn.nextInt();
		} while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());

		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner stdIn = new Scanner(System.in);
		Tree t = new Tree();
		Menu menu; // 메뉴
		int count = 0;
		int num;
		boolean result;
		do {
			switch (menu = SelectMenu()) {
			case Add: // 노드 삽입
				System.out.println("The number of items = ");
				count = stdIn.nextInt();
				int[] input = new int[10];
				for (int ix = 0; ix < count; ix++) {
					input[ix] = rand.nextInt(20);
				}
				for (int i = 0; i < count; i++) {
					if (t.insert(input[i]) == false)
						System.out.println("Insert Duplicated data");
				}
				break;

			case Delete: // 노드 삭제
				System.out.println("삭제할 데이터:: ");
				num = stdIn.nextInt();
				if (t.delete(num) == true) System.out.println("삭제 데이터 = " + num + " 성공");
				else System.out.println("삭제 실패");
				break;

			case Search: // 노드 검색
				System.out.println("검색할 데이터:: ");
				num = stdIn.nextInt();
				result = t.search(num);
				if (result == true) System.out.println(" 데이터 = " + num + "존재합니다.");
				else System.out.println("해당 데이터가 없습니다.");
				break;

			case InorderPrint: // 전체 노드를 키값의 오름차순으로 표시
				t.inorder();
				System.out.println();
				break;
			}
		} while (menu != Menu.Exit);
	}
	
}
