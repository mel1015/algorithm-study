package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_16985_Maaaaaaaaaze_200210 {
	static final int n = 5;
	static int answer;
	static int[][][] map, rotateMap;
	static boolean[][][] visitMap;
	static int[] order, rotate;
	static boolean[] visit;
	static int[] dx = { -1, 1, 0, 0, 0, 0 };
	static int[] dy = { 0, 0, -1, 1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, -1, 1 };

	// 판 회전
	static void makeMap() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					rotateMap[i][j][k] = 1;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			int idx = order[i];
			int rotateCnt = rotate[i];

			if (rotateCnt == 0) {
				for (int x = 0; x < n; x++) {
					for (int y = 0; y < n; y++) {
						rotateMap[i][x][y] = map[idx][x][y];
					}
				}
			} else if (rotateCnt == 1) {
				for (int x = 0; x < n; x++) {
					for (int y = 0; y < n; y++) {
						if (map[idx][x][y] == 0) {
							rotateMap[i][y][4 - x] = 0;
						}
					}
				}
			} else if (rotateCnt == 2) {
				for (int x = 0; x < n; x++) {
					for (int y = 0; y < n; y++) {
						if (map[idx][x][y] == 0) {
							rotateMap[i][4 - x][4 - y] = 0;
						}
					}
				}
			} else if (rotateCnt == 3) {
				for (int x = 0; x < n; x++) {
					for (int y = 0; y < n; y++) {
						if (map[idx][x][y] == 0) {
							rotateMap[i][4 - y][x] = 0;
						}
					}
				}
			}
		}
	}

	// BFS탐색 => 상, 하, 좌, 우, 위, 아래
	// 0도, 90도, 180도, 270도 모두 회전시켜 보므로 
	// 0,0,0 에서 출발 => 4,4,4 에서 도착으로 구해도 답이 나옴
	static int bfs(int pMap[][][]) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 0, 0, 0, 0 });
		visitMap[0][0][0] = true;

		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			int z = q.peek()[2];
			int cnt = q.poll()[3];
			if (x == 4 && y == 4 && z == 4)
				return cnt;
			for (int d = 0; d < dx.length; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				int nz = z + dz[d];
				if (nx >= 0 && nx < n && ny >= 0 && ny < n && nz >= 0 && nz < n) {
					if (pMap[nz][nx][ny] == 1 && !visitMap[nz][nx][ny]) {
						visitMap[nz][nx][ny] = true;
						q.offer(new int[] { nx, ny, nz, cnt + 1 });
					}
				}
			}
		}
		return Integer.MAX_VALUE;
	}

	// 각 판을 시계 방향으로 회전시킬 횟수 => 중복 순열
	static void overlapPerm(int cnt) {
		if (cnt == 5) {
			makeMap();
			if (rotateMap[0][0][0] == 1 && rotateMap[4][4][4] == 1) {
				answer = Math.min(answer, bfs(rotateMap));
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						Arrays.fill(visitMap[i][j], false);
						Arrays.fill(rotateMap[i][j], -1);
					}
				}
			}
			return;
		}
		for (int i = 0; i < 4; i++) {
			rotate[cnt] = i;
			overlapPerm(cnt + 1);
		}
	}

	// 판을 쌓을 순서 => 중복 없는 순열
	// 판을 다 쌓고 회전하는 순서를 정함 => overlapPerm();
	static void perm(int start, int cnt) {
		if (cnt == 5) {
			overlapPerm(0);
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!visit[i]) {
				visit[i] = true;
				order[cnt] = i;
				perm(i, cnt + 1);
				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		map = new int[n][n][n];
		rotateMap = new int[n][n][n];
		visitMap = new boolean[n][n][n];
		order = new int[n];
		visit = new boolean[n];
		rotate = new int[n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < n; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
					rotateMap[i][j][k] = -1;
				}
			}
		}
		answer = Integer.MAX_VALUE;
		perm(0, 0);
		System.out.println((answer == Integer.MAX_VALUE) ? -1 : answer);
		br.close();
	}

}
