package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_200210_백준_1938_통나무옮기기 {
	static int n, answer;
	static char[][] map;
	static ArrayList<int[]> log, goal;

	static class Log {
		int x;
		int y;
		boolean isRow;

		public Log(int x, int y, boolean isRow) {
			this.x = x;
			this.y = y;
			this.isRow = isRow;
		}

		@Override
		public String toString() {
			return "Log [x=" + x + ", y=" + y + ", isRow=" + isRow + "]";
		}

	}

	static void bfs() {

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		map = new char[n][n];
		log = new ArrayList<>();
		goal = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 'B') {
					map[i][j] = '0';
					log.add(new int[] { i, j });
				} else if (map[i][j] == 'E') {
					map[i][j] = '0';
					goal.add(new int[] { i, j });
				}
			}
		}

		answer = Integer.MAX_VALUE;
		bfs();
		System.out.println((answer == Integer.MAX_VALUE) ? 0 : answer);

		br.close();
	}

}
