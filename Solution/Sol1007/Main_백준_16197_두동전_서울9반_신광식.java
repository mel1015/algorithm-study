package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_백준_16197_두동전_서울9반_신광식 {
	static int n, m, answer;
	static char[][] map;
	static ArrayList<int[]> coin;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static boolean out(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return true;
		return false;
	}

	static void move(int x, int y, int x2, int y2, int cnt, int dir) {
		if (answer < cnt)
			return;
		if (cnt > 10) {
			answer = Math.min(answer, cnt);
			return;
		}

		int nx = x + dx[dir];
		int ny = y + dy[dir];
		int nx2 = x2 + dx[dir];
		int ny2 = y2 + dy[dir];
		if (out(nx, ny) && out(nx2, ny2))
			return;
		else if (out(nx, ny) && !out(nx2, ny2)) {
			answer = Math.min(answer, cnt);
			return;
		} else if (!out(nx, ny) && out(nx2, ny2)) {
			answer = Math.min(answer, cnt);
			return;
		}
		if (map[nx][ny] == '#') {
			nx = x;
			ny = y;
		}
		if (map[nx2][ny2] == '#') {
			nx2 = x2;
			ny2 = y2;
		}
		for (int i = 0; i < dx.length; i++) {
			move(nx, ny, nx2, ny2, cnt + 1, i);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		coin = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'o') {
					coin.add(new int[] { i, j });
				}
			}
		}
		answer = Integer.MAX_VALUE;
		int x = coin.get(0)[0];
		int y = coin.get(0)[1];
		int x2 = coin.get(1)[0];
		int y2 = coin.get(1)[1];
		for (int i = 0; i < dx.length; i++) {
			move(x, y, x2, y2, 1, i);
		}
		System.out.println((answer > 10) ? -1 : answer);
		br.close();
	}

}
