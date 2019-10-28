package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_2206_벽부수고이동하기_서울9반_신광식 {
	static int n, m, answer;
	static char[][] map;
	static boolean[][][] visit;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	// 좌표(x, y), 벽을 부셨는지 여부 thru, 현재까지 경로 길이 cnt
	static class Move {
		int x;
		int y;
		int thru;
		int cnt;

		public Move(int x, int y, int thru, int cnt) {
			this.x = x;
			this.y = y;
			this.thru = thru;
			this.cnt = cnt;
		}
	}

	// BFS를 도는 과정에서 벽을 만나면 부수고 경로를 만듬
	// 1.벽을 만났고, 현재까지 벽을 부순적이 없으면 => 벽을 부수고 경로를 만듬
	// 2.길이고 방문하지 않았으면
	// visit[n][m][0] => 벽을 부수지 않고 방문
	// visit[n][m][1] => 벽을 부수고 방문
	static int bfs() {
		Queue<Move> q = new LinkedList<>();
		q.offer(new Move(0, 0, 0, 1));
		visit[0][0][0] = true;
		while (!q.isEmpty()) {
			Move curr = q.poll();
			if (curr.x == n - 1 && curr.y == m - 1)
				return curr.cnt;

			for (int d = 0; d < 4; d++) {
				int nx = curr.x + dx[d];
				int ny = curr.y + dy[d];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
					if (map[nx][ny] == '1' && curr.thru == 0) {
						// 1번
						visit[nx][ny][curr.thru + 1] = true;
						q.offer(new Move(nx, ny, curr.thru + 1, curr.cnt + 1));
					} else if (map[nx][ny] == '0' && visit[nx][ny][curr.thru] == false) {
						// 2번
						visit[nx][ny][curr.thru] = true;
						q.offer(new Move(nx, ny, curr.thru, curr.cnt + 1));
					}
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		visit = new boolean[n][m][2];
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		answer = bfs();
		System.out.println(answer);
		br.close();
	}

}
