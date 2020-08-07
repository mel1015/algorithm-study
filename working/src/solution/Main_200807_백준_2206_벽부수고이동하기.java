package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_200807_백준_2206_벽부수고이동하기 {
	static int n, m;
	static int[][] map;
	static int[][][] dist;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		// 큐에 (x, y, 벽을 부수고 온지 여부)를 삽입
		// 0이면 그냥, 1이면 벽을 부수고 온 것
		q.offer(new int[] { 0, 0, 0 });
		dist[0][0][0] = 1;
		dist[0][0][1] = 1;

		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			int wall = q.poll()[2];

			for (int d = 0; d < dx.length; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
					if (map[nx][ny] == 1 && wall == 0) {
						// 벽을 만났고, 부순적이 없다면
						dist[nx][ny][1] = dist[x][y][wall] + 1;
						q.offer(new int[] { nx, ny, 1 });
					} else if (map[nx][ny] == 0 && dist[nx][ny][wall] > dist[x][y][wall] + 1) {
						dist[nx][ny][wall] = dist[x][y][wall] + 1;
						q.offer(new int[] { nx, ny, wall });
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		// 벽을 부수고 온건지, 그냥 온건지 체크하기 위해 dist 배열 선언
		// 벽을 부수고 왔다면 [x][y][1]에 이동 거리 저장, 
		// 부수지 않고 왔다면 [x][y][0]에 저장
		map = new int[n][m];
		dist = new int[n][m][2];

		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = line.charAt(j) - '0';
				for (int k = 0; k < 2; k++) {
					dist[i][j][k] = Integer.MAX_VALUE / 2;
				}
			}
		}

		bfs();
		int answer = Math.min(dist[n - 1][m - 1][0], dist[n - 1][m - 1][1]);
		System.out.println(answer == Integer.MAX_VALUE / 2 ? -1 : answer);

		br.close();
	}
}