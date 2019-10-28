package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_D4_1249_보급로_서울9반_신광식2 {
	static int n;
	static int[][] map, memo;
	static boolean[][] visit;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static void dijkstra() {
		memo[0][0] = 0;
		for (int k = 0; k < n * n; k++) {
			int min = 987654321;
			int mx = 0;
			int my = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visit[i][j] && min > memo[i][j]) {
						min = memo[i][j];
						mx = i;
						my = j;
					}
				}
			}
			visit[mx][my] = true;
			for (int d = 0; d < 4; d++) {
				int nx = mx + dx[d];
				int ny = my + dy[d];
				if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
					if (memo[nx][ny] > memo[mx][my] + map[nx][ny]) {
						memo[nx][ny] = memo[mx][my] + map[nx][ny];
					}
				}
			}
		}
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1249.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			memo = new int[n][n];
			visit = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				String line = br.readLine();
				for (int j = 0; j < n; j++) {
					map[i][j] = line.charAt(j) - '0';
				}
				Arrays.fill(memo[i], 987654321);
			}
			dijkstra();
			System.out.println("#" + tc + " " + memo[n - 1][n - 1]);
		}
		br.close();
	}
}
