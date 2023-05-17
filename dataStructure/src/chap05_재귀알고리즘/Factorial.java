package chap05_재귀알고리즘;

import java.util.Scanner;

public class Factorial {

	static int factorial(int n) {
		if (n > 0) return n * factorial(n - 1);
		else return 1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 입력 : ");
		int n = sc.nextInt();
		System.out.print(n + "의 factorial 값은 " + factorial(n) + "입니다.");
	}
	
}
