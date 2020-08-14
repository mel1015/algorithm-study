package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_200814_백준_3055_탈출 {
	static int n, m, holeX, holeY, answer;
	static char[][] map;
	static boolean[][] visit;
	static Queue<int[]> waterQ, goQ;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	// 고슴도치 이동 => goQ, 물 이동 => waterQ
	// 물을 먼저 퍼뜨리고 고슴도치가 이동할 수 있는 곳 큐에 담고 시간 증가
	static void bfs() {
		int time = 0;
		while (!goQ.isEmpty()) {
			for (int waterQSize = waterQ.size(); waterQSize > 0; waterQSize--) {
				int x = waterQ.peek()[0];
				int y = waterQ.poll()[1];
				for (int d = 0; d < dx.length; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == '.' && !(nx == holeX && ny == holeY)) {
						map[nx][ny] = '*';
						waterQ.offer(new int[] { nx, ny });
					}
				}
			}
			for (int goQSize = goQ.size(); goQSize > 0; goQSize--) {
				int x = goQ.peek()[0];
				int y = goQ.poll()[1];
				if (x == holeX && y == holeY) {
					answer = time;
					return;
				}
				for (int d = 0; d < dx.length; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == '.' && !visit[nx][ny]) {
						visit[nx][ny] = true;
						goQ.offer(new int[] { nx, ny });
					}
				}
			}
			time++;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][m];
		visit = new boolean[n][m];
		goQ = new LinkedList<>();
		waterQ = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == 'D') {
					holeX = i;
					holeY = j;
					map[i][j] = '.';
				} else if (map[i][j] == 'S') {
					map[i][j] = '.';
					visit[i][j] = true;
					goQ.offer(new int[] { i, j });
				} else if (map[i][j] == '*') {
					waterQ.offer(new int[] { i, j });
				}
			}
		}

		answer = Integer.MAX_VALUE;
		bfs();
		System.out.println(answer == Integer.MAX_VALUE ? "KAKTUS" : answer);

		br.close();
	}
}