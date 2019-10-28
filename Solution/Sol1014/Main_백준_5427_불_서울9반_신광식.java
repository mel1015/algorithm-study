package boj.Sol1014;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_5427_불_서울9반_신광식 {
	static int n, m;
	static char[][] map;
	static int[][] sMap, fMap;
	static ArrayList<int[]> sPos, fPos, exit;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static void bfs(ArrayList<int[]> pos, int[][] bMap, int sang) {
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < pos.size(); i++) {
			int x = pos.get(i)[0];
			int y = pos.get(i)[1];
			bMap[x][y] = 0;
			q.add(new int[] { x, y });
		}
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.poll()[1];
			for (int d = 0; d < dx.length; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
					if (map[nx][ny] == '.' && bMap[nx][ny] == 987654321) {
						bMap[nx][ny] = bMap[x][y] + 1;
						q.add(new int[] { nx, ny });
					}
				} else if (sang == 1) {
					exit.add(new int[] { x, y });
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			map = new char[n][m];
			sMap = new int[n][m];
			fMap = new int[n][m];
			sPos = new ArrayList<>();
			fPos = new ArrayList<>();
			exit = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < m; j++) {
					if (map[i][j] == '@') {
						map[i][j] = '.';
						sPos.add(new int[] { i, j });
					} else if (map[i][j] == '*')
						fPos.add(new int[] { i, j });
				}
				Arrays.fill(sMap[i], 987654321);
				Arrays.fill(fMap[i], 987654321);
			}
			bfs(sPos, sMap, 1);
			if (exit.isEmpty()) {
				System.out.println("IMPOSSIBLE");
			} else {
				bfs(fPos, fMap, 0);
				int minTime = Integer.MAX_VALUE;
				for (int i = 0; i < exit.size(); i++) {
					int x = exit.get(i)[0];
					int y = exit.get(i)[1];
					if (sMap[x][y] < fMap[x][y]) {
						minTime = Math.min(minTime, sMap[x][y] + 1);
					}
				}
				System.out.println((minTime >= 987654321) ? "IMPOSSIBLE" : minTime);
			}
		}
		br.close();
	}

}
