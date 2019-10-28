package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 기출_15683_신광식 {
	public static int N, M, answer = Integer.MAX_VALUE;
	public static int[][] map;
	public static ArrayList<Cctv> cctv;

	public static class Cctv {
		int x;
		int y;

		Cctv(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static int[][] overSee(int[][] visited, int x, int y, int dir) {
		switch (dir) {
		case 0:
			// 상
			for (int i = x; i >= 0; --i) {
				if (map[i][y] == 6)
					break;
				visited[i][y] = -1;
			}
			break;
		case 1:
			// 좌
			for (int j = y; j >= 0; --j) {
				if (map[x][j] == 6)
					break;
				visited[x][j] = -1;
			}
			break;
		case 2:
			// 하
			for (int i = x; i < N; ++i) {
				if (map[i][y] == 6)
					break;
				visited[i][y] = -1;
			}
			break;
		case 3:
			// 우
			for (int j = y; j < M; ++j) {
				if (map[x][j] == 6)
					break;
				visited[x][j] = -1;
			}
			break;
		default:
			break;
		}
		return visited;
	}

	public static void check(int cctvIndex, int[][] prev) {
		if (cctvIndex == cctv.size()) {
			int count = 0;
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < M; ++j) {
					if (prev[i][j] == 0)
						count++;
				}
			}
			answer = Math.min(answer, count);
		} else {
			int x = cctv.get(cctvIndex).x;
			int y = cctv.get(cctvIndex).y;
			int cctvNum = map[x][y];
			switch (cctvNum) {
			case 1:
				// 0 상, 1 좌, 2 하, 3 우
				for (int i = 0; i < 4; ++i) {
					int[][] visited = new int[N][M];
					for (int j = 0; j < N; j++) {
						visited[j] = prev[j].clone();
					}
					visited = overSee(visited, x, y, i);
					check(cctvIndex + 1, visited);
				}
				break;
			case 2:
				// (상, 하), (좌, 우)
				for (int i = 0; i < 2; ++i) {
					int[][] visited = new int[N][M];
					for (int j = 0; j < N; j++) {
						visited[j] = prev[j].clone();
					}
					visited = overSee(visited, x, y, i);
					visited = overSee(visited, x, y, i + 2);
					check(cctvIndex + 1, visited);
				}
				break;
			case 3:
				// (상, 좌), (좌, 하), (하, 우), (우, 상)
				for (int i = 0; i < 4; ++i) {
					int[][] visited = new int[N][M];
					for (int j = 0; j < N; j++) {
						visited[j] = prev[j].clone();
					}
					visited = overSee(visited, x, y, i);
					visited = overSee(visited, x, y, (i + 1) % 4);
					check(cctvIndex + 1, visited);
				}
				break;
			case 4:
				// (상, 좌, 하), (좌, 하, 우), (하, 우, 상), (우, 상, 좌)
				for (int i = 0; i < 4; ++i) {
					int[][] visited = new int[N][M];
					for (int j = 0; j < N; j++) {
						visited[j] = prev[j].clone();
					}
					visited = overSee(visited, x, y, i);
					visited = overSee(visited, x, y, (i + 1) % 4);
					visited = overSee(visited, x, y, (i + 2) % 4);
					check(cctvIndex + 1, visited);
				}
				break;
			case 5:
				// (상, 좌, 하, 우)
				int[][] visited = new int[N][M];
				for (int j = 0; j < N; j++) {
					visited[j] = prev[j].clone();
				}
				visited = overSee(visited, x, y, 0);
				visited = overSee(visited, x, y, 1);
				visited = overSee(visited, x, y, 2);
				visited = overSee(visited, x, y, 3);
				check(cctvIndex + 1, visited);
				break;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cctv = new ArrayList<>();
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > 0 && map[i][j] < 6)
					cctv.add(new Cctv(i, j));
			}
		}
		check(0, map);
		System.out.println(answer);
	}

}
