package boj.Sol1030;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution_D9_2105_디저트카페_서울9반_신광식2 {
	static int n, startX, startY, answer;
	static int[][] map;
	static boolean[] visit;
	static int[] dx = { 1, 1, -1, -1 };
	static int[] dy = { -1, 1, 1, -1 };

	static void dessertCafe(int x, int y, int dir, int cnt, int change) {
		if (change > 3)
			return;
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
			if (change == 3 && nx == startX && ny == startY) {
				answer = Math.max(cnt, answer);
				return;
			}
			if (!visit[map[nx][ny]]) {
				visit[map[nx][ny]] = true;
				dessertCafe(nx, ny, dir, cnt + 1, change);
				dessertCafe(nx, ny, dir + 1, cnt + 1, change + 1);
				visit[map[nx][ny]] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d9_2105.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			visit = new boolean[101];
			answer = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < n - 2; i++) {
				for (int j = 1; j < n - 1; j++) {
					startX = i;
					startY = j;
					visit[map[i][j]] = true;
					dessertCafe(i, j, 0, 1, 0);
					visit[map[i][j]] = false;
				}
			}
			System.out.println("#" + tc + " " + ((answer == 0) ? -1 : answer));
		}
		br.close();
	}

}
