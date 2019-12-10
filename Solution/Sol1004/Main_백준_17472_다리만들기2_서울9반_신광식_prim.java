package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_17472_다리만들기2_서울9반_신광식_prim {
	static int n, m, island;
	static int[][] map, graph;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	// 범위 체크
	static boolean rangeCheck(int nx, int ny) {
		if (nx >= 0 && nx < n && ny >= 0 && ny < m)
			return true;
		return false;
	}

	// 섬을 찾고, 섬들의 번호를 매길 BFS
	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });
		map[x][y] = island;
		while (!q.isEmpty()) {
			int cx = q.peek()[0];
			int cy = q.poll()[1];
			for (int d = 0; d < dx.length; d++) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];
				if (rangeCheck(nx, ny) && map[nx][ny] == -1) {
					map[nx][ny] = island;
					q.add(new int[] { nx, ny });
				}
			}
		}
	}

	// 다리를 각 방향으로 만들어보고 섬끼리 연결되면 인접그래프 생성
	static void dfs(int x, int y, int nx, int ny, int dir, int cnt) {
		nx += dx[dir];
		ny += dy[dir];
		if (rangeCheck(nx, ny)) {
			if (map[nx][ny] == 0)
				dfs(x, y, nx, ny, dir, cnt + 1);
			else {
				int sIsland = map[x][y] - 1;
				int eIsland = map[nx][ny] - 1;
				if (cnt >= 2) {
					graph[sIsland][eIsland] = Math.min(graph[sIsland][eIsland], cnt);
					graph[eIsland][sIsland] = Math.min(graph[eIsland][sIsland], cnt);
				}
			}
		}
	}

	// Prim 알고리즘
	public static int prim() {
		int[] weight = new int[island];
		Arrays.fill(weight, -1);
		weight[0] = 0;
		for (int k = 1; k < island; k++) {
			int minWeight = Integer.MAX_VALUE;
			int minVertex = 0;
			for (int i = 0; i < island; i++) {
				if (weight[i] < 0)
					continue;
				for (int j = 0; j < island; j++) {
					if (weight[j] >= 0)
						continue;
					if (minWeight > graph[i][j]) {
						minWeight = graph[i][j];
						minVertex = j;
					}
				}
			}
			weight[minVertex] = minWeight;
//			System.out.println(Arrays.toString(weight));
		}
		int sum = 0;
		for (int i = 0; i < island; i++) {
			if (weight[i] == -1)
				return -1;
			sum += weight[i];
		}
		return sum;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_boj_17472.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 0; tc < 20; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new int[n][m];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken()) * -1;
				}
			}

			// 섬 찾고 번호매기기
			island = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == -1) {
						island++;
						bfs(i, j);
					}
				}
			}

			// 인접행렬 만들기
			graph = new int[island][island];
			for (int i = 0; i < graph.length; i++) {
				for (int j = 0; j < graph.length; j++) {
					if (i == j)
						continue;
					graph[i][j] = Integer.MAX_VALUE;
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] != 0) {
						for (int d = 0; d < dx.length; d++) {
							int nx = i + dx[d];
							int ny = j + dy[d];
							if (rangeCheck(nx, ny)) {
								if (map[nx][ny] == 0) {
									dfs(i, j, nx, ny, d, 1);
								}
							}
						}
					}
				}
			}
			int answer = prim();
			System.out.println(answer);
		}
		br.close();
	}

}
