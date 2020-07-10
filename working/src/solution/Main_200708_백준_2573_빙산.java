package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_200708_백준_2573_빙산 {
	static int n, m, answer;
	static boolean isDivide;
	static int[][] map, visit;
	static Queue<Ice> ice;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static class Ice {
		int x;
		int y;
		int time;

		public Ice(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}

		@Override
		public String toString() {
			return "(" + x + "," + y + "," + time + ")";
		}
	}

	static boolean bfs() {
		Ice tempIce = ice.peek();
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { tempIce.x, tempIce.y });
		visit[tempIce.x][tempIce.y] = answer;

		int iceCnt = ice.size();
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.poll()[1];
			iceCnt--;
			for (int d = 0; d < dx.length; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] > 0 && visit[nx][ny] != answer) {
					visit[nx][ny] = answer;
					q.offer(new int[] { nx, ny });
				}
			}
		}
		return iceCnt > 0 ? true : false;
	}

	static void mapSet() {
		for (int qSize = ice.size(); qSize > 0; qSize--) {
			Ice cIce = ice.poll();
			if (cIce.time <= 0) {
				map[cIce.x][cIce.y] = 0;
			} else {
				map[cIce.x][cIce.y] = cIce.time;
				ice.offer(cIce);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit = new int[n][m];
		ice = new LinkedList<>();

		isDivide = false;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > 0) {
					ice.add(new Ice(i, j, map[i][j]));
				}
			}
		}

		while (!isDivide) {
			answer++;
			for (int qSize = ice.size(); qSize > 0; qSize--) {
				Ice cIce = ice.poll();
				int waterCnt = 0;
				for (int d = 0; d < dx.length; d++) {
					int nx = cIce.x + dx[d];
					int ny = cIce.y + dy[d];
					if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 0) {
						waterCnt++;
					}
				}
				cIce.time -= waterCnt;
				ice.offer(cIce);
			}
			mapSet();
//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < m; j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}
			if (ice.isEmpty()) {
				answer = 0;
				break;
			}
			isDivide = bfs();
		}
		System.out.println(answer);

		br.close();
	}
}