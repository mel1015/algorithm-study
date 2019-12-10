package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_백준_2933_미네랄_서울9반_신광식 {
	static int r, c;
	static char[][] map;
	static int[][] visit;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static boolean check(int nx, int ny) {
		if (nx >= 0 && nx < r && ny >= 0 && ny < c && map[nx][ny] == 'x')
			return true;
		return false;
	}

	static void dropMineral(int row, int col) {
		if (map[row][col] != 'x')
			return;
		Queue<int[]> q = new LinkedList<int[]>();
		ArrayList<int[]> cluster = new ArrayList<>();
		HashMap<Integer, Integer> colClust = new HashMap<>();

		boolean drop = true;
		visit[row][col] = 1;
		q.offer(new int[] { row, col });

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			cluster.add(curr);
			if (curr[0] == r - 1) {
				drop = false;
				break;
			}

			if (!colClust.containsKey(curr[1])) {
				colClust.put(curr[1], curr[0]);
			} else if (colClust.containsKey(curr[1]) && colClust.get(curr[1]) < curr[0]) {
				colClust.put(curr[1], curr[0]);
			}

			for (int d = 0; d < 4; d++) {
				int nx = curr[0] + dx[d];
				int ny = curr[1] + dy[d];
				if (nx >= 0 && nx < r && ny >= 0 && ny < c && visit[nx][ny] == 0 && map[nx][ny] == 'x') {
					visit[nx][ny] = 1;
					q.offer(new int[] { nx, ny });
				}
			}
		}

		if (drop) {
			Set<Integer> keys = colClust.keySet();
			int moveCount = Integer.MAX_VALUE;
			for (Integer cc : keys) {
				int rr = colClust.get(cc);
				int cnt = 0;
				while (rr != r - 1) {
					if (map[rr + 1][cc] == '.') {
						rr++;
						cnt++;
					} else
						break;
				}
				moveCount = Math.min(moveCount, cnt);
			}
			Collections.sort(cluster, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return Integer.compare(o2[0], o1[0]);
				}
			});
			for (int i = 0; i < cluster.size(); i++) {
				int[] mineral = cluster.get(i);
				if (map[mineral[0] + moveCount][mineral[1]] == '.') {
					map[mineral[0] + moveCount][mineral[1]] = 'x';
					map[mineral[0]][mineral[1]] = '.';
				} else {
					map[mineral[0]][mineral[1]] = '.';
				}
			}
		}

		for (int k = 0; k < r; k++) {
			Arrays.fill(visit[k], 0);
		}
	}

	public static void printMap() {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		visit = new int[r][c];
		for (int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int dir = 1;
		for (int i = 0; i < n; i++) {
			int row = r - Integer.parseInt(st.nextToken());
			if (dir == 1) {
				for (int j = 0; j < c; j++) {
					if (map[row][j] == 'x') {
						map[row][j] = '.';
						for (int d = 0; d < 4; d++) {
							int nx = row + dx[d];
							int ny = j + dy[d];
							if (check(nx, ny))
								dropMineral(nx, ny);
						}
						break;
					}
				}
			} else {
				for (int j = c - 1; j >= 0; j--) {
					if (map[row][j] == 'x') {
						map[row][j] = '.';
						for (int d = 0; d < 4; d++) {
							int nx = row + dx[d];
							int ny = j + dy[d];
							if (check(nx, ny))
								dropMineral(nx, ny);
						}
						break;
					}
				}
			}
			dir *= -1;
		}
		printMap();
		br.close();
	}

}
