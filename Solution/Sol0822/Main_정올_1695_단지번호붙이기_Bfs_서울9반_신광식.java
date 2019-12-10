package jo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_정올_1695_단지번호붙이기_Bfs_서울9반_신광식 {
	public static char[][] map;
	public static boolean[][] visit;
	public static ArrayList<Integer> danzi;
	public static int n;
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	public static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void bfs(Pos start) {
		Queue<Pos> queue = new LinkedList<Pos>();
		int x = start.x;
		int y = start.y;
		int count = 0;

		if (visit[x][y])
			return;

		visit[x][y] = true;
		queue.offer(start);

		while (!queue.isEmpty()) {
			Pos curr = queue.poll();
			count++;
			for (int i = 0; i < dx.length; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];
				if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == '1' && !visit[nx][ny]) {
					visit[nx][ny] = true;
					queue.offer(new Pos(nx, ny));
				}
			}
		}
		danzi.add(count);
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_jo_1695.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		map = new char[n][n];
		visit = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			map[i] = line.toCharArray();
		}

		danzi = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == '1') {
					bfs(new Pos(i, j));
				}
			}
		}
		Collections.sort(danzi);
		System.out.println(danzi.size());
		for (int i = 0; i < danzi.size(); i++) {
			System.out.println(danzi.get(i));
		}
		br.close();
	}

}
