package d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_2805_농작물수확하기_서울9반_신광식 {
	public static char[][] farm;

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_2805.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			farm = new char[n][n];

			for (int i = 0; i < n; i++) {
				String line = br.readLine();
				farm[i] = line.toCharArray();
			}

			int colIdx = n / 2;
			int x = -1, y = 1;
			int sum = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < y; j++) {
					sum += farm[i][colIdx + j] - '0';
				}
				colIdx += x;
				if (colIdx < 0) {
					x *= -1;
					colIdx += 2;
				}
				if (x < 0)
					y += 2;
				else
					y -= 2;
			}
			System.out.println("#" + tc + " " + sum);
		}
		br.close();
	}

}