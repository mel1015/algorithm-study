package boj.Sol1119;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_17836_공주님을구해라_서울9반_신광식 {
	static int n, m, t, gramAnswer, answer;
	static int[][] map, timeMap;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	// (0,0)부터 BFS 실행
	// 공주를 구할 수 있으면 timeMap[n-1][m-1]의 값이 바뀜
	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 0, 0 });
		timeMap[0][0] = 0;
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.poll()[1];
			// 그람을 구했으면 그 위치부터 공주까지의 최단거리 계산
			if (map[x][y] == 2)
				gramAnswer = timeMap[x][y] + Math.abs(x - (n - 1)) + Math.abs(y - (m - 1));
			for (int d = 0; d < dx.length; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] != 1 && timeMap[nx][ny] == Integer.MAX_VALUE) {
					timeMap[nx][ny] = timeMap[x][y] + 1;
					q.add(new int[] { nx, ny });
				}
			}

		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		timeMap = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				timeMap[i][j] = Integer.MAX_VALUE;
			}
		}
		answer = Integer.MAX_VALUE;
		gramAnswer = Integer.MAX_VALUE;
		bfs();
		answer = Math.min(timeMap[n - 1][m - 1], gramAnswer);
		if (answer <= t)
			System.out.println(answer);
		else
			System.out.println("Fail");
		br.close();
	}

}
