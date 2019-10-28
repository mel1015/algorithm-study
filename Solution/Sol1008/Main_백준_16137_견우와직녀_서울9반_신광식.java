package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_16137_견우와직녀_서울9반_신광식 {
	static int n, m, answer;
	static int[][] map;
	static int[][][] tMap;
	static ArrayList<int[]> bridge;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static class Pos {
		int x;
		int y;
		int bridge;
		int before;

		public Pos(int x, int y, int built, int cross) {
			this.x = x;
			this.y = y;
			this.bridge = built;
			this.before = cross;
		}
	}

	static boolean range(int nx, int ny) {
		if (nx >= 0 && nx < n && ny >= 0 && ny < n)
			return true;
		return false;
	}

	static void findCross() {
		for (int i = 0; i < bridge.size(); i++) {
			int x = bridge.get(i)[0];
			int y = bridge.get(i)[1];

			int colCliff = 0;
			for (int j = 0; j < 2; j++) {
				int nx = x + dx[j];
				int ny = y + dy[j];

				if (range(nx, ny)) {
					if (map[nx][ny] == 0 || map[nx][ny] == -1 || map[nx][ny] >= 2)
						colCliff++;
				}
			}
			int rowCliff = 0;
			for (int j = 2; j < 4; j++) {
				int nx = x + dx[j];
				int ny = y + dy[j];

				if (range(nx, ny)) {
					if (map[nx][ny] == 0 || map[nx][ny] == -1 || map[nx][ny] >= 2)
						rowCliff++;
				}
			}
			if (rowCliff >= 1 && colCliff >= 1)
				map[x][y] = -1;
		}
	}

	static int setTime(int time, int period) {
		int val = time;
		while (true) {
			if (val % period == 0)
				break;
			val++;
		}
		return val;
	}

	static void bfs() {
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(0, 0, 0, 0));
		tMap[0][0][0] = 0;

		while (!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			int bridge = q.peek().bridge;
			int before = q.poll().before;
			for (int d = 0; d < dx.length; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (range(nx, ny)) {
					if (map[nx][ny] == -1)
						continue;
					if (map[nx][ny] == 1) {
						if (tMap[nx][ny][bridge] > tMap[x][y][bridge] + 1) {
							tMap[nx][ny][bridge] = tMap[x][y][bridge] + 1;
							q.offer(new Pos(nx, ny, bridge, 0));
						}
					} else if (map[nx][ny] == 0) {
						if (bridge == 0 && before == 0) {
							int time = setTime(tMap[x][y][bridge] + 1, m);
							if (tMap[nx][ny][1] > time) {
								tMap[nx][ny][1] = time;
								q.offer(new Pos(nx, ny, 1, 1));
							}
						}
					} else if (map[nx][ny] >= 2) {
						if (before == 0) {
							int time = setTime(tMap[x][y][bridge] + 1, map[nx][ny]);
							if (tMap[nx][ny][bridge] > time) {
								tMap[nx][ny][bridge] = time;
								q.offer(new Pos(nx, ny, bridge, 1));
							}
						}
					}
				}
			}
		}
		answer = Math.min(tMap[n - 1][n - 1][0], tMap[n - 1][n - 1][1]);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		tMap = new int[n][n][2];
		bridge = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					bridge.add(new int[] { i, j });
				}
				tMap[i][j][0] = 987654321;
				tMap[i][j][1] = 987654321;
			}
		}
		findCross();
		bfs();
		System.out.println(answer);
		br.close();
	}

}
