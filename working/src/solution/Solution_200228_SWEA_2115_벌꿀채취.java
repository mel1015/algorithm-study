package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_200228_SWEA_2115_벌꿀채취 {
	static int n, m, c, result, answer;
	static int[][] map;
	static int[] pick;
	static boolean[] visit;

	static void getProfit(int x, int y, int cnt, int honey, int profit) {
		if (honey > c)
			return;
		result = Math.max(result, profit);
		if (cnt == m)
			return;

		getProfit(x, y + 1, cnt + 1, honey + map[x][y], profit + (map[x][y] * map[x][y]));
		getProfit(x, y + 1, cnt + 1, honey, profit);
	}

	static void dfs(int start, int cnt) {
		if (cnt == 2) {
			int profit = 0;
			for (int i = 0; i < pick.length; i++) {
				int x = pick[i] / n;
				int y = pick[i] % n;
				result = 0;
				getProfit(x, y, 0, 0, 0);
				profit += result;
			}
			answer = Math.max(answer, profit);
			return;
		}
		for (int i = start; i < n * n; i++) {
			int col = i % n;
			if (col + m > n)
				continue;
			if (!visit[i]) {
				for (int j = 0; j < m; j++) {
					visit[i + j] = true;
				}
				pick[cnt] = i;
				dfs(i, cnt + 1);
				for (int j = 0; j < m; j++) {
					visit[i + j] = false;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_swea_2115.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			answer = 0;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			map = new int[n][n];
			pick = new int[2];
			visit = new boolean[n * n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < n * n; i++) {
				int col = i % n;
				if (col + m > n)
					continue;
				dfs(i, 0);
			}
			System.out.println("#" + tc + " " + answer);
		}
		br.close();
	}

}
