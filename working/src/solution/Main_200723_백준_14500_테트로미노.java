package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_200723_백준_14500_테트로미노 {
	static int n, m, answer;
	static int[][] map, visit;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static void dfs(int x, int y, int sum, int cnt) {
		if (cnt == 4) {
			answer = Math.max(answer, sum);
			return;
		}
		for (int i = 0; i < dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
				if (visit[nx][ny] == 0) {
					visit[nx][ny] = 1;
					dfs(nx, ny, sum + map[nx][ny], cnt + 1);
					visit[nx][ny] = 0;
				}
			}
		}
	}

	static void hShape(int x, int y) {
		for (int i = 0; i < dx.length; i++) {
			int cnt = 0;
			int sum = map[x][y];
			for (int j = i + 1; j <= i + 3; j++) {
				int nx = x + dx[j % 4];
				int ny = y + dy[j % 4];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
					cnt++;
					sum += map[nx][ny];
				} else
					break;
			}
			if (cnt == 3) {
				answer = Math.max(answer, sum);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		visit = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visit[i][j] = 1;
				dfs(i, j, map[i][j], 1);
				visit[i][j] = 0;
				hShape(i, j);
			}
		}
		System.out.println(answer);

		br.close();
	}
}