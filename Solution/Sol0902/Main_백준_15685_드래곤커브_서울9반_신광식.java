package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_백준_15685_드래곤커브_서울9반_신광식 {
	public static int n, answer;
	public static int[][] map;
	public static int[] dx = { 1, 0, -1, 0 };
	public static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		map = new int[101][101];
		ArrayList<Integer> dir = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			dir.clear();
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());

			map[y][x] = 1;
			x += dx[d];
			y += dy[d];
			map[y][x] = 1;
			dir.add(d);
			for (int j = 0; j < g; j++) {
				for (int k = dir.size() - 1; k >= 0; k--) {
					d = (dir.get(k) + 1) % 4;
					x += dx[d];
					y += dy[d];
					map[y][x] = 1;
					dir.add(d);
				}
			}
		}
		answer = 0;
		for (int i = 0; i < map.length - 1; i++) {
			for (int j = 0; j < map[i].length - 1; j++) {
				if (map[i][j] == 1 && map[i][j + 1] == 1 && map[i + 1][j] == 1 && map[i + 1][j + 1] == 1)
					answer++;
			}
		}
		System.out.println(answer);
		br.close();
	}

}
