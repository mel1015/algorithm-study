package boj.Sol1119;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_16988_Baaaaaaaaaduk2Easy_서울9반_신광식 {
	static int n, m, answer;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	// 상대방 돌을 BFS 탐색해서 상하좌우가 모두 1로 막혀있으면 죽은 돌
	// => 상하좌우 탐색 중 빈칸(0)이 나오면 살아있는 돌
	static int bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<int[]>();
		visit[i][j] = true;
		q.add(new int[] { i, j });
		int count = 0;
		boolean notDead = false;
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.poll()[1];
			count++;
			for (int d = 0; d < dx.length; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visit[nx][ny]) {
					if (map[nx][ny] == 2) {
						visit[nx][ny] = true;
						q.add(new int[] { nx, ny });
					} else if (map[nx][ny] == 0) {
						
						notDead = true;
					}
				}
			}
		}
		if (notDead)
			return 0;
		return count;
	}

	static void comb(int start, int cnt) {
		if (cnt == 2) {
			// 돌 2개를 놓고 상대방 돌을 BFS 탐색
			// => 잡은 돌이면 총합에 더해줌
			int sum = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == 2 && !visit[i][j]) {
						sum += bfs(i, j);
					}
				}
			}
			answer = Math.max(answer, sum);
			for (int i = 0; i < n; i++) {
				Arrays.fill(visit[i], false);
			}
			return;
		}
		// 바둑 돌이 놓이지 않은 모든 위치에 내 돌을 놓아봄
		for (int i = start; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					comb(i, cnt + 1);
					map[i][j] = 0;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		comb(0, 0);
		System.out.println(answer);
		br.close();
	}

}
