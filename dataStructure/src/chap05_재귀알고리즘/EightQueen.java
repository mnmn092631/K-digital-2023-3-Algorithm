package chap05_재귀알고리즘;

public class EightQueen {

	public static void SolveQueen(int[][] d) {
 		int count = 0;
		int ix = 0, iy = 0;
		ObjectStack st = new ObjectStack(10);
		Point p = new Point(ix, iy);
		d[ix][iy] = 1;
		count++;
		st.push(p);
		while (count < d.length) {
			ix++;
			int cy = NextMove(d, ix, 0);
			while (ix < d.length) {
				if (cy < d[0].length) {
					Point px = new Point(ix, cy);
					st.push(px);
					d[ix][cy] = 1;
					count++;
				}
				if (cy != d[0].length) {
					break;
				} else {
					p = st.pop();
					d[p.getX()][p.getY()] = 0;
					count--;
					ix--;
					cy = NextMove(d, ix, p.getY() + 1);
				}
			}
		}
	}

	public static boolean checkRow(int[][] d, int crow) {
		for (int i = 0; i < d.length; i++) {
			if (d[crow][i] == 1)
				return false;
		}
		return true;
	}

	public static boolean checkCol(int[][] d, int ccol) {
		for (int i = 0; i < d[0].length; i++) {
			if (d[i][ccol] == 1)
				return false;
		}
		return true;
	}

	// x++, y-- or x--, y++ where 0 <= x,y <= 7
	public static boolean checkDiagSW(int[][] d, int cx, int cy) {
		while (cx < d.length - 1 && cy > 0) {
			cx++;
			cy--;
			if (d[cx][cy] == 1)
				return false;
		}
		while (cx > 0 && cy < d[0].length - 1) {
			cx--;
			cy++;
			if (d[cx][cy] == 1)
				return false;
		}
		return true;
	}

	// x++, y++ or x--, y--
	public static boolean checkDiagSE(int[][] d, int cx, int cy) {
		while (cx < d.length - 1 && cy < d[0].length - 1) {
			cx++;
			cy++;
			if (d[cx][cy] == 1)
				return false;
		}
		while (cx > 0 && cy > 0) {
			cx--;
			cy--;
			if (d[cx][cy] == 1)
				return false;
		}
		return true;
	}

	// (x,y)로 이동 가능한지를 check
	public static boolean CheckMove(int[][] d, int x, int y) {
		if (checkRow(d, x) && checkCol(d, y) && checkDiagSW(d, x, y) && checkDiagSE(d, x, y))
			return true;
		return false;
	}

	// 다음 row에 대하여 이동할 col을 조사
	public static int NextMove(int[][] d, int row, int col) {
		while (col < d[0].length) {
			if (CheckMove(d, row, col))
				return col;
			col++;
		}
		return d[0].length;
	}

	public static void main(String[] args) {
		int[][] data = new int[8][8];

		SolveQueen(data);

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				System.out.print(" " + data[i][j]);
			}
			System.out.println();
		}
	}

}
