package jo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_정올_1840_치즈_서울9반_신광식_dfs {
	static int n, m, cheese;
	static int[][] map;
	static boolean[][] visit;
	static ArrayList<int[]> daySize;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static boolean inRange(int nx, int ny) {
		if (nx >= 0 && nx < n && ny >= 0 && ny < m)
			return true;
		return false;
	}

	static void dfs(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (inRange(nx, ny) && !visit[nx][ny] && map[nx][ny] == 0) {
				visit[nx][ny] = true;
				dfs(nx, ny);
			} else if (inRange(nx, ny) && !visit[nx][ny] && map[nx][ny] == 1) {
				visit[nx][ny] = true;
				cheese--;
				map[nx][ny] = 0;
			}
		}
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					cheese++;
			}
		}
		int day = 0;
		daySize = new ArrayList<>();
		while (cheese > 0) {
			daySize.add(new int[] { day, cheese });
			visit[0][0] = true;
			dfs(0, 0);
			for (int i = 0; i < n; i++) {
				Arrays.fill(visit[i], false);
			}
			day++;
		}
		System.out.println(day + "\n" + daySize.get(daySize.size() - 1)[1]);
		br.close();
	}

}
