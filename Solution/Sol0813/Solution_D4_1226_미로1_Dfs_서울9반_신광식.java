package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D4_1226_미로1_Dfs_서울9반_신광식 {
	public static char[][] map;
	public static boolean[][] visit;
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };
	public static int answer = 0;

	public static void dfs(int x, int y) {
		visit[x][y] = true;
		if (map[x][y] == '3') {
			answer = 1;
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 1 && nx <= 15 && ny >= 1 && ny <= 15 && map[nx][ny] != '1' && !visit[nx][ny]) {
				dfs(nx, ny);
			}
		}
		visit[x][y] = false;
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1226.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			int T = Integer.parseInt(br.readLine());
			map = new char[16][16];
			visit = new boolean[16][16];
			for (int i = 0; i < 16; i++) {
				String line = br.readLine();
				map[i] = line.toCharArray();
			}
			answer = 0;
			dfs(1, 1);
			System.out.println("#" + T + " " + answer);
		}
	}
}
