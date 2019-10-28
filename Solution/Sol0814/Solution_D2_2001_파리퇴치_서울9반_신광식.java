package d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_2001_파리퇴치_서울9반_신광식 {
	public static int n, m, answer;
	public static int[][] map;

	public static void killFly(int x, int y) {
		int sum = 0;
		for (int i = x; i < x + m; i++) {
			for (int j = y; j < y + m; j++) {
				sum += map[i][j];
			}
		}
		answer = Math.max(answer, sum);
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d2_2001.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			answer = 0;
			for (int i = 0; i <= n - m; i++) {
				for (int j = 0; j <= n - m; j++) {
					killFly(i, j);
				}
			}
			System.out.println("#" + tc + " " + answer);
		}
		br.close();
	}

}
