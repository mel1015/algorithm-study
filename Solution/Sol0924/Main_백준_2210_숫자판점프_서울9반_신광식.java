package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_백준_2210_숫자판점프_서울9반_신광식 {
	static int[][] map;
	static HashSet<String> set;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static void dfs(int x, int y, String num) {
		if (num.length() == 6) {
			set.add(num);
			return;
		}
		num += map[x][y];
		for (int i = 0; i < dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
				dfs(nx, ny, num);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[5][5];
		set = new HashSet<>();
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				dfs(i, j, "");
			}
		}
		System.out.println(set.size());
		br.close();
	}

}
