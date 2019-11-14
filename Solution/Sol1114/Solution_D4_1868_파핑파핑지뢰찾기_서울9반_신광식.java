package boj.Sol1114;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Solution_D4_1868_파핑파핑지뢰찾기_서울9반_신광식 {
	static int n, answer;
	static char[][] map;
	static int[][] bombMap;
	static boolean[][] visit;
	static int[] dx = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dy = { 0, 0, -1, 1, -1, 1, -1, 1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1868.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			answer = 0;
			map = new char[n][n];
			bombMap = new int[n][n];
			visit = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				map[i] = br.readLine().toCharArray();
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == '*') {
						// 지뢰 방문처리 => 탐색할 필요 X
						visit[i][j] = true;
						for (int d = 0; d < dx.length; d++) {
							// 지뢰 주변 8방향에 지뢰 개수 증가
							int nx = i + dx[d];
							int ny = j + dy[d];
							if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == '.') {
								bombMap[nx][ny]++;
							}
						}
					}
				}
			}
			// 주변에 지뢰가 없어서 한번에 확인되는 칸 처리
			Queue<int[]> q = new LinkedList<>();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (bombMap[i][j] == 0 && !visit[i][j]) {
						// 한번 클릭해서 다 열리므로 클릭 횟수 한번 증가
						answer++;
						visit[i][j] = true;
						q.add(new int[] { i, j });
						while (!q.isEmpty()) {
							int x = q.peek()[0];
							int y = q.poll()[1];
							for (int d = 0; d < dx.length; d++) {
								int nx = x + dx[d];
								int ny = y + dy[d];
								if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == '.' && !visit[nx][ny]) {
									// 주변에 지뢰가 없으면 계속 다음 칸을 열도록 큐에 넣고
									// 주변에 지뢰가 있으면 방문 처리만 해줌
									visit[nx][ny] = true;
									if (bombMap[nx][ny] == 0)
										q.add(new int[] { nx, ny });
								}
							}
						}
					}
				}
			}
			// 주변에 0이 없어서 한번에 탐색이 안되는 칸 => 각자 1번씩 눌러서 열어야함
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visit[i][j])
						answer++;
				}
			}
			System.out.println("#" + tc + " " + answer);
		}
		br.close();
	}

}
