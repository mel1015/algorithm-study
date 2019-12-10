package jo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_정올_1695_단지번호붙이기_Dfs_서울9반_신광식 {
	public static char[][] map;
	public static boolean[][] visit;
	public static ArrayList<Integer> danzi;
	public static int n, cnt;
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	public static void dfs(int x, int y) {
		if (visit[x][y])
			return;
		visit[x][y] = true;
		for (int i = 0; i < dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == '1' && !visit[nx][ny]) {
				cnt++;
				dfs(nx, ny);
			}
		}
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_jo_1695.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		map = new char[n][n];
		visit = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			map[i] = line.toCharArray();
		}

		danzi = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == '1' && !visit[i][j]) {
					cnt = 1;
					dfs(i, j);
					danzi.add(cnt);
				}
			}
		}
		Collections.sort(danzi);
		System.out.println(danzi.size());
		for (int i = 0; i < danzi.size(); i++) {
			System.out.println(danzi.get(i));
		}
		br.close();
	}

}
