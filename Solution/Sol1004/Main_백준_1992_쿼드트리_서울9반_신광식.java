package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_1992_쿼드트리_서울9반_신광식 {
	static int n;
	static int[][] map;
	static StringBuffer sb;

	public static int check(int x, int y, int size) {
		int color = map[x][y];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (map[x + i][y + j] != color) {
					return -1;
				}
			}
		}
		if (color == 1)
			sb.append(1);
		else
			sb.append(0);

		return color;
	}

	public static void divide(int x, int y, int size) {
		int c = check(x, y, size);
		if (c == -1) {
			sb.append("(");
			divide(x, y, size / 2);
			divide(x, y + size / 2, size / 2);
			divide(x + size / 2, y, size / 2);
			divide(x + size / 2, y + size / 2, size / 2);
			sb.append(")");
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		sb = new StringBuffer();
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < line.length(); j++) {
				map[i][j] = line.charAt(j) - 48;
			}
		}
		divide(0, 0, n);
		System.out.println(sb.toString());
		br.close();
	}

}
