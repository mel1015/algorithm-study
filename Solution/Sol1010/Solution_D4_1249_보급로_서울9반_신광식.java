package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_D4_1249_보급로_서울9반_신광식 {
	public static int n;
	public static int[][] map, memo;
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { 0, 0 });
		memo[0][0] = 0;
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.poll()[1];
			for (int d = 0; d < dx.length; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
					// 다음 방문할 곳의 값이 상하좌우의 최단경로 중 최솟값이 아니면 => 갱신 가능
					if (memo[nx][ny] != Math.min(memo[nx][ny], memo[x][y] + map[nx][ny])) {
						memo[nx][ny] = Math.min(memo[nx][ny], memo[x][y] + map[nx][ny]);
						q.add(new int[] { nx, ny });
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
			for (int i = 0; i < n; i++) {
				String line = br.readLine();
				for (int j = 0; j < n; j++) {
					map[i][j] = line.charAt(j) - '0';
				}
				Arrays.fill(memo[i], 987654321);
			}
			bfs();
			System.out.println("#" + tc + " " + memo[n - 1][n - 1]);
		}
		br.close();
	}
}
