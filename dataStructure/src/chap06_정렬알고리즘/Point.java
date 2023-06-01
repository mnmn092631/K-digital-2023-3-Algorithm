package chap06_정렬알고리즘;

class Point {
	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public boolean equals(Object p) {
		Point px = (Point) p;
		if (this.x == px.x && this.y == px.y) return true;
		return false;
	}

	@Override
	public String toString() {
		return this.hashCode() + " : x = " + x + ", y = " + y;
	}
}
