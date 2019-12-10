package boj.Sol1022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://mygumi.tistory.com/289
public class Main_백준_1799_비숍_서울9반_신광식 {
	static int n;
	static int[][] map, colorMap;
	static int[] answer;
	static boolean[] visit;
	static int[] dx = { -1, -1, 1, 1 };
	static int[] dy = { -1, 1, -1, 1 };

	static boolean promising(int x, int y) {
		for (int d = 0; d < dx.length; d++) {
			int nx = x;
			int ny = y;
			int v = nx * n + ny;
			while (true) {
				nx += dx[d];
				ny += dy[d];
				v = nx * n + ny;
				if (nx >= 0 && nx < n && ny >= 0 && ny < n && visit[v]) {
					return false;
				} else if (nx < 0 || nx >= n || ny < 0 || nx >= n)
					break;
			}
		}
		return true;
	}

	public static void dfs(int v, int cnt, int color) {
		if (answer[color] < cnt) {
			answer[color] = cnt;
		}
		// 배열을 이중 for문으로 탐색하면 이전 dfs에서 탐색한 바로 다음 칸을 탐색하기 어려움
		// => 배열을 0 ~ n*n으로 표현해서 행(i/n), 열(i%n)으로 표현
		// => 배열의 모든 칸을 순차적으로 탐색할 수 있음
		for (int i = v + 1; i < n * n; i++) {
			int r = i / n;
			int c = i % n;
			if (colorMap[r][c] != color)
				continue;
			else if (map[r][c] == 1) {
				if (promising(r, c)) {
					visit[i] = true;
					dfs(i, cnt + 1, color);
				}
			}
		}
		if (v == -1)
			return;
		visit[v] = false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		colorMap = new int[n][n];
		visit = new boolean[n * n];
		answer = new int[2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (i % 2 == 0) {
					if (j % 2 == 0)
						colorMap[i][j] = 1;
				} else {
					if (j % 2 != 0)
						colorMap[i][j] = 1;
				}
			}
		}
		dfs(-1, 0, 1);
		dfs(-1, 0, 0);
		System.out.println(answer[0] + answer[1]);
		br.close();
	}

}
