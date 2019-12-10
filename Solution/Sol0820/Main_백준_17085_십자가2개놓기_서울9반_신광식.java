package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_백준_17085_십자가2개놓기_서울9반_신광식 {
	public static int n, m, answer = 1;
	public static char[][] map;
	public static ArrayList<Pos> prob;

	static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	public static void findProb() {
		for (int i = 1; i < map.length - 1; i++) {
			for (int j = 1; j < map[i].length - 1; j++) {
				if (map[i][j] == '#' && map[i - 1][j] == '#' && map[i][j - 1] == '#' && map[i][j + 1] == '#'
						&& map[i + 1][j] == '#') {
					prob.add(new Pos(i, j));
				}
			}
		}
	}

	public static void makeCross(int idx, char[][] copyMap, int cnt, int res) {
		if (cnt == 2) {
			answer = Math.max(answer, res);
			return;
		}

		char[][] temp = new char[n][m];
		for (int i = 0; i < copyMap.length; i++) {
			temp[i] = copyMap[i].clone();
		}

		int x = prob.get(idx).x;
		int y = prob.get(idx).y;
		int depth = 1;
		while (true) {
			if (x - depth >= 0 && temp[x - depth][y] == '#' && x + depth < n && temp[x + depth][y] == '#'
					&& y + depth < m && temp[x][y + depth] == '#' && y - depth >= 0 && temp[x][y - depth] == '#') {
				temp[x][y] = '*';
				temp[x - depth][y] = '*';
				temp[x + depth][y] = '*';
				temp[x][y - depth] = '*';
				temp[x][y + depth] = '*';
				depth++;
			} else
				break;
		}
		res *= 1 + (4 * (depth - 1));
		for (int i = idx + 1; i < prob.size(); i++) {
			makeCross(i, temp, cnt + 1, res);
		}
		answer = Math.max(answer, res);
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_boj_17085.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int tc = 0; tc < 2; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			map = new char[n][m];
			prob = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				String line = br.readLine();
				map[i] = line.toCharArray();
			}
			findProb();
			for (int i = 0; i < prob.size(); i++) {
				makeCross(i, map, 0, 1);
			}
			System.out.println(answer);
		}
		br.close();
	}

}
