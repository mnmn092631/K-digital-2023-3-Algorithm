package chap03_검색알고리즘;

import java.util.Arrays;
import java.util.Comparator;

class Fruit {
	private String name;
	private int price;
	private String date;

	Fruit(String name, int price, String date) {
		this.name = name;
		this.price = price;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public String getDate() {
		return date;
	}
}

public class Fruit객체배열이진탐색 {

	public static void main(String[] args) {
		Fruit[] arr = { new Fruit("사과", 200, "2023-5-8"), new Fruit("키위", 500, "2023-6-8"),
				new Fruit("오렌지", 200, "2023-7-8"), new Fruit("바나나", 50, "2023-5-18"), new Fruit("수박", 880, "2023-5-28"),
				new Fruit("체리", 10, "2023-9-8") };
		System.out.println("정렬전 객체 배열: ");
		showData(arr);
		
		Arrays.sort(arr, (a, b) -> a.getPrice() - b.getPrice()); // Fruit에 compareTo()가 있어도 람다식 우선 적용
		System.out.println("\n\n람다식 정렬(가격)후 객체 배열: ");
		showData(arr);

		Arrays.sort(arr, new Comparator<Fruit>() {
			@Override
			public int compare(Fruit a1, Fruit a2) {
				return a1.getName().compareTo(a2.getName());
			}
		});
		System.out.println("\n\ncomparator 정렬(이름)후 객체 배열: ");
		showData(arr);

		Comparator<Fruit> cc_name = new Comparator<Fruit>() {
			@Override
			public int compare(Fruit o1, Fruit o2) {
				return o1.getName().compareTo(o2.getName());
			}
		};

		Comparator<Fruit> cc_price = new Comparator<Fruit>() {
			@Override
			public int compare(Fruit o1, Fruit o2) {
				return o1.getPrice() - o2.getPrice();
			}
		};

		Fruit newFruit = new Fruit("체리", 500, "2023-5-18");
		int result3 = Arrays.binarySearch(arr, newFruit, cc_name);
		System.out.println("\n\nArrays.binarySearch() 조회결과::" + result3);
		result3 = binarySearch(arr, newFruit, cc_name);
		System.out.println("\nbinarySearch() 조회결과::" + result3);

		sortData(arr, cc_price);
		System.out.println("\ncomparator 정렬(가격)후 객체 배열: ");
		showData(arr);
		
		result3 = Arrays.binarySearch(arr, newFruit, cc_price);
		System.out.println("\n\nArrays.binarySearch() 조회결과::" + result3);
		result3 = binarySearch(arr, newFruit, cc_price);
		System.out.println("\nbinarySearch() 조회결과::" + result3);
	}

	static void showData(Fruit[] arr) {
		for (Fruit f : arr) {
			System.out.print(f.getName() + ", " + f.getPrice() + ", " + f.getDate() + " | ");
		}
	}

	public static void sortData(Fruit[] arr, Comparator<Fruit> com) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (com.compare(arr[i], arr[j]) > 0) swap(arr, i, j);
			}
		}
	}

	static void swap(Fruit[] arr, int i, int j) {
		Fruit temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	static int binarySearch(Fruit[] arr, Fruit key, Comparator<Fruit> com) {
		int pl = 0;
		int pr = arr.length - 1;

		do {
			int pc = (pl + pr) / 2;
			if(com.compare(arr[pc], key) == 0) return pc;
			else if(com.compare(arr[pc], key) < 0) pl = pc + 1;
			else pr = pc - 1;
		} while(pl <= pr);
		
		return -1;
	}

}
