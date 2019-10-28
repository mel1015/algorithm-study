package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_7733_치즈도둑_서울9반_신광식 {
	public static int n, answer;
	public static int[][] map;
	public static boolean[][] visit;
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	public static void eatCheese(int day) {
		int count = 0;
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			Arrays.fill(visit[i], false);
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visit[i][j] && map[i][j] > day) {
					count++;
					visit[i][j] = true;
					q.offer(new int[] { i, j });

					while (!q.isEmpty()) {
						int[] curr = q.poll();
						for (int k = 0; k < 4; k++) {
							int nx = curr[0] + dx[k];
							int ny = curr[1] + dy[k];
							if (nx < 0 || nx >= n || ny < 0 || ny >= n || visit[nx][ny] || map[nx][ny] <= day)
								continue;
							visit[nx][ny] = true;
							q.offer(new int[] { nx, ny });
						}
					}
				}
			}
		}
		answer = Math.max(count, answer);
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_7733.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			visit = new boolean[n][n];
			int high = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > high)
						high = map[i][j];
				}
			}
			answer = 1;
			for (int i = 1; i < high; i++) {
				eatCheese(i);
			}
			System.out.println("#" + tc + " " + answer);
		}
		br.close();
	}

}
