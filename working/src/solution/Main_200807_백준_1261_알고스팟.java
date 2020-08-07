package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_200807_백준_1261_알고스팟 {
	static int n, m;
	static int[][] map, dist;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	// BFS 탐색을 하면서 해당 위치에 올 때까지 
	// 부순 벽의 개수가 최소가 될 경우만 갱신해줌
	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 0, 0 });
		dist[0][0] = 0;

		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.poll()[1];

			for (int d = 0; d < dx.length; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
					if (map[nx][ny] == 1) {
						if (dist[nx][ny] > dist[x][y] + 1) {
							dist[nx][ny] = dist[x][y] + 1;
							q.offer(new int[] { nx, ny });
						}
					} else {
						if (dist[nx][ny] > dist[x][y]) {
							dist[nx][ny] = dist[x][y];
							q.offer(new int[] { nx, ny });
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		// 미로를 입력 받을 map 배열과
		// 각 위치까지 부순 벽의 개수를 저장할 dist 배열
		map = new int[n][m];
		dist = new int[n][m];

		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = line.charAt(j) - '0';
				dist[i][j] = Integer.MAX_VALUE / 2;
			}
		}

		bfs();
		System.out.println(dist[n - 1][m - 1]);

		br.close();
	}
}