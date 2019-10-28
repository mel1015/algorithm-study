package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_16137_견우와직녀_Solution {
	static int n, m;
	static int[][] map;
	static int[][][] dist;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static boolean canBuild(int i, int j) {
		boolean row = false;
		if (j - 1 >= 0 && map[i][j - 1] == 0)
			row = true;
		if (j + 1 < n && map[i][j + 1] == 0)
			row = true;
		boolean col = false;
		if (i - 1 >= 0 && map[i - 1][j] == 0)
			col = true;
		if (i + 1 < n && map[i + 1][j] == 0)
			col = true;
		return !(row && col);
	}

	static int bfs() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				Arrays.fill(dist[i][j], -1);
			}
		}
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0, 0 });
		dist[0][0][0] = 0;
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			int t = q.poll()[2];
			if (map[x][y] >= 2 && t % map[x][y] != 0) {
				int nt = (t + 1) % map[x][y];
				if (dist[x][y][nt] == -1) {
					dist[x][y][nt] = dist[x][y][t] + 1;
					q.add(new int[] { x, y, nt });
				}
			} else {
				for (int d = 0; d < dx.length; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
						if (map[x][y] >= 2 && map[nx][ny] >= 2)
							continue;
						if (map[nx][ny] >= 1) {
							int nt = (dist[x][y][t] + 1) % map[nx][ny];
							if (dist[nx][ny][nt] == -1) {
								dist[nx][ny][nt] = dist[x][y][t] + 1;
								q.add(new int[] { nx, ny, nt });
							}
						}
					}
				}
			}
		}
		int answer = -1;
		for (int i = 0; i < 20; i++) {
			if (dist[n - 1][n - 1][i] == -1)
				continue;
			if (answer == -1 || answer > dist[n - 1][n - 1][i]) {
				answer = dist[n - 1][n - 1][i];
			}
		}
		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		dist = new int[n][n][20];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = -1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 0 && canBuild(i, j)) {
					map[i][j] = m;
					int time = bfs();
					if (time != -1) {
						if (answer == -1 || answer > time) {
							answer = time;
						}
					}
					map[i][j] = 0;
				}
			}
		}
		System.out.println(answer);
		br.close();
	}

}
