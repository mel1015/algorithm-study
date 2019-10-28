package boj.Sol1023;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_17822_원판돌리기_서울9반_신광식 {
	static int n, m, t;
	static int[][] pan;
	static boolean[][] visit;
	static ArrayList<int[]> removeList;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static void rotate(int num, int dir, int count) {
		if (dir == 0) {
			while (count > 0) {
				int temp = pan[num][m - 1];
				for (int i = m - 1; i > 0; i--) {
					pan[num][i] = pan[num][i - 1];
				}
				pan[num][0] = temp;
				count--;
			}
		} else {
			while (count > 0) {
				int temp = pan[num][0];
				for (int i = 0; i < m - 1; i++) {
					pan[num][i] = pan[num][i + 1];
				}
				pan[num][m - 1] = temp;
				count--;
			}
		}
	}

	static void bfs(int i, int j) {
		visit[i][j] = true;
		if (pan[i][j] == 0)
			return;
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { i, j });
		int cnt = 0;
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.poll()[1];
			for (int d = 0; d < dx.length; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (ny >= m)
					ny = 0;
				if (ny < 0)
					ny = m - 1;
				if (nx > 0 && nx <= n && ny >= 0 && ny < m && !visit[nx][ny]) {
					if (pan[x][y] == pan[nx][ny]) {
						visit[nx][ny] = true;
						removeList.add(new int[] { nx, ny });
						q.add(new int[] { nx, ny });
						cnt++;
					}
				}
			}
		}
		if (cnt > 0)
			removeList.add(new int[] { i, j });
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		pan = new int[n + 1][m];
		visit = new boolean[n + 1][m];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				pan[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			for (int j = x; j <= n; j++) {
				if (j % x == 0)
					rotate(j, d, k);
			}
			int sum = 0;
			int digitCnt = 0;
			removeList = new ArrayList<>();
			for (int row = 1; row <= n; row++) {
				for (int col = 0; col < m; col++) {
					if (pan[row][col] > 0) {
						sum += pan[row][col];
						digitCnt++;
					}
					if (!visit[row][col])
						bfs(row, col);
				}
			}
			if (removeList.isEmpty()) {
				double aver = (sum * 1.0) / digitCnt;
				for (int row = 1; row <= n; row++) {
					for (int col = 0; col < m; col++) {
						if (pan[row][col] == 0)
							continue;
						if (pan[row][col] < aver)
							pan[row][col]++;
						else if (pan[row][col] > aver)
							pan[row][col]--;
					}
				}
			} else {
				for (int j = 0; j < removeList.size(); j++) {
					int row = removeList.get(j)[0];
					int col = removeList.get(j)[1];
					pan[row][col] = 0;
				}
			}
			for (int j = 1; j <= n; j++) {
				Arrays.fill(visit[j], false);
			}
			removeList.clear();
		}
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < m; j++) {
				sum += pan[i][j];
			}
		}
		System.out.println(sum);
		br.close();
	}

}
