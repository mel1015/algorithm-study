package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_4963_섬의개수_서울9반_신광식 {
	static int n, m, answer;
	static int[][] map;
	static boolean[][] visit;
	static ArrayList<int[]> posIsland;
	static int[] dx = { -1, 1, 0, 0, -1, 1, 1, -1 };
	static int[] dy = { 0, 0, -1, 1, 1, 1, -1, -1 };

	static int dfs(int x, int y) {
		if (visit[x][y])
			return 0;
		visit[x][y] = true;
		for (int d = 0; d < dx.length; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 1 && !visit[nx][ny]) {
				dfs(nx, ny);
			}
		}
		return 1;
	}

	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < posIsland.size(); i++) {
			int x = posIsland.get(i)[0];
			int y = posIsland.get(i)[1];
			if (visit[x][y])
				continue;
			answer++;
			visit[x][y] = true;
			q.add(new int[] { x, y });
			while (!q.isEmpty()) {
				x = q.peek()[0];
				y = q.poll()[1];
				for (int d = 0; d < dx.length; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 1 && !visit[nx][ny]) {
						visit[nx][ny] = true;
						q.add(new int[] { nx, ny });
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			if (n == 0 && m == 0)
				break;
			map = new int[n][m];
			visit = new boolean[n][m];
			posIsland = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				boolean isIsland = false;
				for (int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 0)
						isIsland = false;
					else if (!isIsland && map[i][j] == 1) {
						posIsland.add(new int[] { i, j });
						isIsland = true;
					}
				}
			}
			answer = 0;
//			for (int i = 0; i < posIsland.size(); i++) {
//				int x = posIsland.get(i)[0];
//				int y = posIsland.get(i)[1];
//				answer += dfs(x, y);
//			}
			bfs();
			System.out.println(answer);
		}
		br.close();
	}

}
