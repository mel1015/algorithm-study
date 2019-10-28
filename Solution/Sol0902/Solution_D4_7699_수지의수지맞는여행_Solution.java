package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_7699_수지의수지맞는여행_Solution {
	public static int r, c, answer;
	public static char[][] map;
	public static boolean[] visit;
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	public static void dfs(int x, int y, int cnt) {
		if (cnt == 26)
			return;
		if (answer < cnt)
			answer = cnt;
		visit[map[x][y] - 'A'] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= r || ny < 0 || ny >= c || visit[map[nx][ny] - 'A'])
				continue;
			dfs(nx, ny, cnt + 1);
		}
		visit[map[x][y] - 'A'] = false;
	}

	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("res/input_d4_7699.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			map = new char[r][c];
			visit = new boolean[27];
			for (int i = 0; i < r; i++) {
				String line = br.readLine();
				map[i] = line.toCharArray();
			}
			answer = 0;
			dfs(0, 0, 1);
			System.out.println("#" + tc + " " + answer);
		}
		br.close();
	}

}
