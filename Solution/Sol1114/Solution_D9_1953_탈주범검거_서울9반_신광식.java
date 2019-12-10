package boj.Sol1114;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution_D9_1953_탈주범검거_서울9반_신광식 {
	static int n, m, r, c, l, answer;
	static int[][] map, timeMap;
	static boolean[][][] canGo;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[] newDir = { 1, 0, 3, 2 };

	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		// 1시간 뒤에 맨홀이 위치한 터널 도착
		timeMap[r][c] = 1;
		answer++;
		q.add(new int[] { r, c });
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.poll()[1];
			for (int d = 0; d < dx.length; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				// 범위, 현재 좌표에서 갈 수있는 방향인지, 다음 좌표에서 올 수 있는 방향인지 체크
				if (nx >= 0 && nx < n && ny >= 0 && ny < m && canGo[x][y][d] && canGo[nx][ny][newDir[d]]
						&& timeMap[nx][ny] == 0) {
					// 시간 증가, 큐에 추가
					timeMap[nx][ny] = timeMap[x][y] + 1;
					q.add(new int[] { nx, ny });
					if (timeMap[nx][ny] <= l) {
						// 소요시간 이내에 도착할 수 있는 장소 개수 증가
						answer++;
					} else
						return;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d9_1953.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			answer = 0;
			map = new int[n][m];
			timeMap = new int[n][m];
			canGo = new boolean[n][m][4];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						// 0:상, 1:하, 2:좌, 3:우 => 4방향 다 가능
						Arrays.fill(canGo[i][j], true);
					} else if (map[i][j] == 2) {
						// 상, 하
						canGo[i][j][0] = true;
						canGo[i][j][1] = true;
					} else if (map[i][j] == 3) {
						// 좌, 우
						canGo[i][j][2] = true;
						canGo[i][j][3] = true;
					} else if (map[i][j] == 4) {
						// 상, 우
						canGo[i][j][0] = true;
						canGo[i][j][3] = true;
					} else if (map[i][j] == 5) {
						// 하, 우
						canGo[i][j][1] = true;
						canGo[i][j][3] = true;
					} else if (map[i][j] == 6) {
						// 하, 좌
						canGo[i][j][1] = true;
						canGo[i][j][2] = true;
					} else if (map[i][j] == 7) {
						// 상, 좌
						canGo[i][j][0] = true;
						canGo[i][j][2] = true;
					}
				}
			}
			bfs();
			System.out.println("#" + tc + " " + answer);
		}
		br.close();
	}

}
