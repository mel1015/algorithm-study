package boj.Sol1106;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_정올_1733_오목_서울9반_신광식 {
	static int n, winColor, winX, winY;
	static int[][] map;
	static boolean[][][] visit;
	static ArrayList<int[]> omok;
	static int[] dx = { 0, 1, 1, 1 };
	static int[] dy = { 1, 1, 0, -1 };

	static void dfs(int i, int j, int color, int dir) {
		visit[i][j][dir] = true;
		omok.add(new int[] { i, j });
		int nx = i + dx[dir];
		int ny = j + dy[dir];
		if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == color) {
			dfs(nx, ny, color, dir);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = 19;
		map = new int[n][n];
		visit = new boolean[n][n][4];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean isEnd = false;
		for (int i = 0; i < n && !isEnd; i++) {
			for (int j = 0; j < n && !isEnd; j++) {
				if (map[i][j] != 0) {
					for (int d = 0; d < dx.length && !isEnd; d++) {
						if (visit[i][j][d])
							continue;
						omok = new ArrayList<>();
						dfs(i, j, map[i][j], d);
						if (omok.size() == 5) {
							isEnd = true;
							Collections.sort(omok, new Comparator<int[]>() {
								@Override
								public int compare(int[] o1, int[] o2) {
									if (o1[1] == o2[1])
										return Integer.compare(o1[0], o2[0]);
									return Integer.compare(o1[1], o2[1]);
								}
							});
							winColor = map[i][j];
							winX = omok.get(0)[0] + 1;
							winY = omok.get(0)[1] + 1;
						}
					}
				}
			}
		}
		if (isEnd)
			System.out.println(winColor + "\n" + winX + " " + winY);
		else
			System.out.println(0);
		br.close();
	}

}
