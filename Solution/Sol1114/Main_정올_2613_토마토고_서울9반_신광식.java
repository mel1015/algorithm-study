package boj.Sol1114;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_정올_2613_토마토고_서울9반_신광식 {
	static int m, n;
	static int[][] tomato;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		tomato = new int[n][m];
		Queue<int[]> q = new LinkedList<int[]>();
		int leftTomato = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				if (tomato[i][j] == 1) {
					q.add(new int[] { i, j });
				} else if (tomato[i][j] == 0) {
					leftTomato++;
				}
			}
		}
		if (q.isEmpty())
			System.out.println("0");
		else {
			int answer = 0;
			while (!q.isEmpty()) {
				int x = q.peek()[0];
				int y = q.poll()[1];
				for (int d = 0; d < dx.length; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					if (nx >= 0 && nx < n && ny >= 0 && ny < m && tomato[nx][ny] == 0) {
						q.add(new int[] { nx, ny });
						tomato[nx][ny] = tomato[x][y] + 1;
						leftTomato--;
						answer = Math.max(answer, tomato[nx][ny] - 1);
					}
				}
				if (leftTomato == 0)
					break;
			}
			if (leftTomato != 0)
				System.out.println("-1");
			else
				System.out.println(answer);
		}
	}
}