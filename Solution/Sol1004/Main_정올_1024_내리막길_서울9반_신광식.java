package jo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1024_내리막길_백준_1520_서울9반_신광식 {
	static int n, m;
	static int[][] map, memo;
	static boolean[][] visit;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int dfs(int x, int y) {
		if (x == n - 1 && y == m - 1)
			return 1;
		if (memo[x][y] != 0)
			return memo[x][y];
		if (!visit[x][y]) {
			visit[x][y] = true;
			for (int d = 0; d < dx.length; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[x][y] > map[nx][ny]) {
					memo[x][y] += dfs(nx, ny);
				}
			}
		}
		return memo[x][y];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		memo = new int[n][m];
		visit = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = dfs(0, 0);
		System.out.println(answer);
		br.close();
	}

}
