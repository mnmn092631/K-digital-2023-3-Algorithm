package chap02_기본자료구조;

class PhyscData implements Comparable<PhyscData> {
	String name;
	int height;
	double vision;

	public PhyscData(String name, int height, double vision) {
		this.name = name;
		this.height = height;
		this.vision = vision;
	}

	public static void showData(PhyscData[] arr) {
		for (PhyscData obj : arr) {
			System.out.println("name : " + obj.name + ", height : " + obj.height + ", vision : " + obj.vision);
		}
	}

	public static void sortData(PhyscData[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i].compareTo(arr[j]) > 0) {
					swap(arr, i, j);
				}
			}
		}
	}

	static void swap(PhyscData[] arr, int i, int j) {
		PhyscData temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	@Override
	public int compareTo(PhyscData o) {
		if (this.name.compareTo(o.name) == 0) {
			if (this.height == o.height) {
				return (int) (this.vision - o.vision);
			} else {
				return this.height - o.height;
			}
		} else {
			return this.name.compareTo(o.name);
		}
	}

}

public class 객체정렬 {

	public static void main(String[] args) {
		PhyscData[] data = { new PhyscData("홍길동", 162, 0.3), new PhyscData("홍동", 164, 1.3),
				new PhyscData("홍길", 152, 0.7), new PhyscData("김홍길동", 172, 0.3), new PhyscData("이길동", 182, 0.6),
				new PhyscData("박길동", 167, 0.2), new PhyscData("최길동", 169, 0.5), };
		PhyscData.showData(data);
		PhyscData.sortData(data);
		System.out.println("정렬 후 ------------------------------------");
		PhyscData.showData(data);
	}

}
