package boj.Sol1015;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_17244_아맞다우산_서울9반_신광식 {
	static int n, m, startX, startY, exitX, exitY, answer;
	static char[][] map;
	static int[][][] dist;
	static int[] a, d, v;
	static ArrayList<int[]> stuff;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		int time = 0;
		int x = startX;
		int y = startY;
		int targetX = 0;
		int targetY = 0;
		for (int i = 0; i <= a.length; i++) {
			if (i < a.length) {
				targetX = stuff.get(a[i])[0];
				targetY = stuff.get(a[i])[1];
			} else {
				targetX = exitX;
				targetY = exitY;
			}
			dist[x][y][i] = 1;
			q.add(new int[] { x, y });
			while (!q.isEmpty()) {
				x = q.peek()[0];
				y = q.poll()[1];
				if (x == targetX && y == targetY) {
					time += dist[x][y][i] - 1;
					q.clear();
					break;
				}
				for (int d = 0; d < dx.length; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == '.' && dist[nx][ny][i] == 0) {
						dist[nx][ny][i] = dist[x][y][i] + 1;
						q.add(new int[] { nx, ny });
					}
				}
			}
		}
		return time;
	}

	static void perm(int start, int cnt) {
		if (cnt == stuff.size()) {
			int time = bfs();
			answer = Math.min(answer, time);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					Arrays.fill(dist[i][j], 0);
				}
			}
			return;
		}
		for (int i = 0; i < stuff.size(); i++) {
			if (v[i] == 0) {
				v[i] = 1;
				a[cnt] = d[i];
				perm(i, cnt + 1);
				v[i] = 0;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		stuff = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'X') {
					stuff.add(new int[] { i, j });
					map[i][j] = '.';
				} else if (map[i][j] == 'S') {
					startX = i;
					startY = j;
					map[i][j] = '.';
				} else if (map[i][j] == 'E') {
					exitX = i;
					exitY = j;
					map[i][j] = '.';
				}
			}
		}
		dist = new int[n][m][stuff.size() + 1];
		a = new int[stuff.size()];
		d = new int[stuff.size()];
		v = new int[stuff.size()];
		for (int i = 0; i < d.length; i++) {
			d[i] = i;
		}
		answer = Integer.MAX_VALUE;
		perm(0, 0);
		System.out.println(answer);
		br.close();
	}

}
