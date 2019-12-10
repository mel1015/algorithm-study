package d5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_D5_7396_종구의딸이름짓기_서울9반_신광식 {
	static int n, m;
	static char[][] map;
	static boolean[][] visit;
	static StringBuilder sb;
	static int[] dx = { 1, 0 };
	static int[] dy = { 0, 1 };

	static class Pos {
		int x;
		int y;
		String s;

		public Pos(int x, int y, String s) {
			this.x = x;
			this.y = y;
			this.s = s;
		}
	}

	static void bfs() {
		PriorityQueue<Pos> q = new PriorityQueue<>(new Comparator<Pos>() {
			@Override
			public int compare(Pos o1, Pos o2) {
				return o1.s.compareTo(o2.s);
			}
		});
		sb.append(map[0][0]);
		q.add(new Pos(0, 0, sb.toString()));
		visit[0][0] = true;
		while (!q.isEmpty()) {
			Pos curr = q.poll();
			for (int i = 0; i < dx.length; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visit[nx][ny]) {
					visit[nx][ny] = true;
					sb = new StringBuilder();
					sb.append(curr.s).append(map[nx][ny]);
					String ns = sb.toString();
					if (nx == n - 1 && ny == m - 1)
						return;
					q.add(new Pos(nx, ny, ns));
				}
			}
		}
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new char[n][m];
			visit = new boolean[n][m];
			sb = new StringBuilder();
			for (int i = 0; i < n; i++) {
				map[i] = br.readLine().trim().toCharArray();
			}
			if (n == 1 && m == 1)
				bw.write("#" + tc + " " + map[0][0] + "\n");
			else {
				bfs();
				bw.write("#" + tc + " " + sb.toString() + "\n");
			}
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
