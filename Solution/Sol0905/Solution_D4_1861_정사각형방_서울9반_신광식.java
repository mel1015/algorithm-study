package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1861_정사각형방_서울9반_신광식 {
	public static int n, cnt;
	public static int[][] room, visit;
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	public static void dfs(int x, int y) {
		cnt++;
		visit[x][y] = 1;
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx >= 0 && nx < n && ny >= 0 && ny < n && room[x][y] + 1 == room[nx][ny])
				dfs(nx, ny);
		}
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1861.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			room = new int[n][n];
			visit = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int answer = 0;
			int minIdx = 0;
			cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (visit[i][j] == 0) {
						dfs(i, j);
						if (answer < cnt) {
							answer = cnt;
							minIdx = room[i][j];
						} else if (answer == cnt) {
							minIdx = Math.min(minIdx, room[i][j]);
						}
						cnt = 0;
					}
				}
			}
			System.out.println("#" + tc + " " + minIdx + " " + answer);
		}
		br.close();
	}

}
