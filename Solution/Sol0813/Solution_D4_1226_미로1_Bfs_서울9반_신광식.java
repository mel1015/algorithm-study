package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_D4_1226_미로1_Bfs_서울9반_신광식 {
	public static char[][] map;
	public static boolean[][] visit;
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };
	public static int answer = 0;

	public static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void bfs(Pos start) {
		int x = start.x;
		int y = start.y;
		visit[x][y] = true;

		Queue<Pos> queue = new LinkedList<Pos>();
		queue.offer(start);
		while (!queue.isEmpty()) {
			Pos curr = queue.poll();
			for (int i = 0; i < dx.length; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];
				if (nx >= 1 && nx <= 15 && ny >= 1 && ny <= 15 && map[nx][ny] != '1' && !visit[nx][ny]) {
					if (map[nx][ny] == '3') {
						answer = 1;
						return;
					}
					visit[nx][ny] = true;
					queue.offer(new Pos(nx, ny));
				}
			}
		}
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1226.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			int T = Integer.parseInt(br.readLine());
			map = new char[16][16];
			visit = new boolean[16][16];
			for (int i = 0; i < 16; i++) {
				String line = br.readLine();
				map[i] = line.toCharArray();
			}
			answer = 0;
			bfs(new Pos(1, 1));
			System.out.println("#" + T + " " + answer);
		}
	}
}
