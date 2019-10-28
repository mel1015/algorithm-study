package boj.Sol1023;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_정올_2074_홀수마방진_서울9반_신광식 {
	static int n;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		map[0][n / 2] = 1;
		int row = 0;
		int col = n / 2;
		for (int i = 2; i <= n * n; i++) {
			if (map[row][col] % n == 0) {
				row++;
				map[row][col] = i;
			} else {
				row--;
				col--;
				if (row < 0)
					row = n - 1;
				if (col < 0)
					col = n - 1;
				map[row][col] = i;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		br.close();
	}

}
