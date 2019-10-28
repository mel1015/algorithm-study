package jo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1335_색종이만들기_서울9반_신광식 {
	public static int[][] map;
	public static int n, blue, white;

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
			blue++;
		else
			white++;

		return color;
	}

	public static void divide(int x, int y, int size) {
		int c = check(x, y, size);
		if (c == -1) {
			divide(x, y, size / 2);
			divide(x, y + size / 2, size / 2);
			divide(x + size / 2, y, size / 2);
			divide(x + size / 2, y + size / 2, size / 2);
		}
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_jo_1335.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		divide(0, 0, n);
		System.out.println(white + "\n" + blue);
		br.close();
	}

}
