package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_백준_15683_감시_서울9반_신광식2 {
	public static int n, m, answer;
	public static int[][] map;
	public static ArrayList<int[]> cctv;

	public static int checkHide() {
		int cnt = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 0)
					cnt++;
			}
		}
		return cnt;
	}

	public static void overSee(int x, int y, int dir) {
		switch (dir) {
		case 0:
			// 상
			for (int i = x; i >= 0; i--) {
				if (map[i][y] == 6)
					break;
				else if (map[i][y] <= -1)
					map[i][y]--;
				else
					map[i][y] = -1;
			}
			break;
		case 1:
			// 좌
			for (int i = y; i >= 0; i--) {
				if (map[x][i] == 6)
					break;
				else if (map[x][i] <= -1)
					map[x][i]--;
				else
					map[x][i] = -1;
			}
			break;
		case 2:
			// 하
			for (int i = x; i < n; i++) {
				if (map[i][y] == 6)
					break;
				else if (map[i][y] <= -1)
					map[i][y]--;
				else
					map[i][y] = -1;
			}
			break;
		case 3:
			// 우
			for (int i = y; i < m; i++) {
				if (map[x][i] == 6)
					break;
				else if (map[x][i] <= -1)
					map[x][i]--;
				else
					map[x][i] = -1;
			}
			break;
		default:
			break;
		}
	}

	public static void clearSee(int x, int y, int dir) {
		switch (dir) {
		case 0:
			// 상
			for (int i = x; i >= 0; i--) {
				if (map[i][y] == 6)
					break;
				map[i][y]++;
			}
			break;
		case 1:
			// 좌
			for (int i = y; i >= 0; i--) {
				if (map[x][i] == 6)
					break;
				map[x][i]++;
			}
			break;
		case 2:
			// 하
			for (int i = x; i < n; i++) {
				if (map[i][y] == 6)
					break;
				map[i][y]++;
			}
			break;
		case 3:
			// 우
			for (int i = y; i < m; i++) {
				if (map[x][i] == 6)
					break;
				map[x][i]++;
			}
			break;
		default:
			break;
		}
	}

	public static void printMap() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.printf("%3d", map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void dfs(int idx) {
//		System.out.println("steps: " + idx);
//		printMap();
		if (idx >= cctv.size()) {
			int cnt = checkHide();
			answer = Math.min(answer, cnt);
			return;
		}
		// 0:상, 1:좌, 2:하, 3:우
		if (cctv.get(idx)[2] == 1) {
			for (int dir = 0; dir < 4; dir++) {
				overSee(cctv.get(idx)[0], cctv.get(idx)[1], dir);
				dfs(idx + 1);
				clearSee(cctv.get(idx)[0], cctv.get(idx)[1], dir);
			}
		} else if (cctv.get(idx)[2] == 2) {
			for (int dir = 0; dir < 2; dir++) {
				overSee(cctv.get(idx)[0], cctv.get(idx)[1], dir);
				overSee(cctv.get(idx)[0], cctv.get(idx)[1], dir + 2);
				dfs(idx + 1);
				clearSee(cctv.get(idx)[0], cctv.get(idx)[1], dir);
				clearSee(cctv.get(idx)[0], cctv.get(idx)[1], dir + 2);
			}
		} else if (cctv.get(idx)[2] == 3) {
			for (int dir = 0; dir < 4; dir++) {
				overSee(cctv.get(idx)[0], cctv.get(idx)[1], dir);
				overSee(cctv.get(idx)[0], cctv.get(idx)[1], (dir + 3) % 4);
				dfs(idx + 1);
				clearSee(cctv.get(idx)[0], cctv.get(idx)[1], dir);
				clearSee(cctv.get(idx)[0], cctv.get(idx)[1], (dir + 3) % 4);
			}
		} else if (cctv.get(idx)[2] == 4) {
			for (int dir = 0; dir < 4; dir++) {
				overSee(cctv.get(idx)[0], cctv.get(idx)[1], dir);
				overSee(cctv.get(idx)[0], cctv.get(idx)[1], (dir + 1) % 4);
				overSee(cctv.get(idx)[0], cctv.get(idx)[1], (dir + 3) % 4);
				dfs(idx + 1);
				clearSee(cctv.get(idx)[0], cctv.get(idx)[1], dir);
				clearSee(cctv.get(idx)[0], cctv.get(idx)[1], (dir + 1) % 4);
				clearSee(cctv.get(idx)[0], cctv.get(idx)[1], (dir + 3) % 4);
			}
		} else if (cctv.get(idx)[2] == 5) {
			for (int dir = 0; dir < 4; dir++) {
				overSee(cctv.get(idx)[0], cctv.get(idx)[1], dir);
			}
			dfs(idx + 1);
			for (int dir = 0; dir < 4; dir++) {
				clearSee(cctv.get(idx)[0], cctv.get(idx)[1], dir);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		cctv = new ArrayList<>();
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0 && map[i][j] != 6) {
					cctv.add(new int[] { i, j, map[i][j] });
				}
			}
		}
		answer = Integer.MAX_VALUE;
		dfs(0);
		System.out.println(answer);
		br.close();
	}

}
