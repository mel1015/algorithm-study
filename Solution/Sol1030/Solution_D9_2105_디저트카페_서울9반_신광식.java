package boj.Sol1030;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution_D9_2105_디저트카페_서울9반_신광식 {
	static int n, answer;
	static int[][] map;
	static boolean[] visit;
	static ArrayList<Integer> divide, dessert;
	static int[] dx = { 1, 1, -1, -1 };
	static int[] dy = { -1, 1, 1, -1 };

	static boolean dessertCafe(int x, int y, int d1, int d2) {
		int nx = x, ny = y;
		for (int loop = 0; loop < d1; loop++) {
			nx += dx[0];
			ny += dy[0];
			if (!visit[map[nx][ny]]) {
				visit[map[nx][ny]] = true;
				dessert.add(map[nx][ny]);
			} else
				return false;
		}
		for (int loop = 0; loop < d2; loop++) {
			nx += dx[1];
			ny += dy[1];
			if (!visit[map[nx][ny]]) {
				visit[map[nx][ny]] = true;
				dessert.add(map[nx][ny]);
			} else
				return false;
		}
		for (int loop = 0; loop < d1; loop++) {
			nx += dx[2];
			ny += dy[2];
			if (!visit[map[nx][ny]]) {

				visit[map[nx][ny]] = true;
				dessert.add(map[nx][ny]);
			} else
				return false;
		}
		for (int loop = 0; loop < d2; loop++) {
			nx += dx[3];
			ny += dy[3];
			if (!visit[map[nx][ny]]) {
				visit[map[nx][ny]] = true;
				dessert.add(map[nx][ny]);
			} else
				return false;
		}
		return true;
	}

	static void permComb(int cnt) {
		if (cnt == 2) {
			for (int i = 0; i < n - 2; i++) {
				for (int j = 1; j < n - 1; j++) {
					boolean canMake = true;
					int d1 = divide.get(0);
					int d2 = divide.get(1);
					int nx = i, ny = j;
					for (int d = 0; d < dx.length; d++) {
						if (d % 2 == 0) {
							nx += dx[d] * d1;
							ny += dy[d] * d1;
						} else {
							nx += dx[d] * d2;
							ny += dy[d] * d2;
						}
						if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
							canMake = false;
							break;
						}
					}
					if (canMake && dessertCafe(i, j, d1, d2)) {
						answer = Math.max(answer, dessert.size());
					}
					dessert.clear();
					Arrays.fill(visit, false);
				}
			}
			return;
		}
		for (int i = n - 2; i >= 1; i--) {
			divide.add(i);
			permComb(cnt + 1);
			divide.remove(divide.size() - 1);
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d9_2105.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			visit = new boolean[101];
			divide = new ArrayList<>();
			dessert = new ArrayList<>();
			answer = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			permComb(0);
			System.out.println("#" + tc + " " + ((answer == 0) ? -1 : answer));
		}
		br.close();
	}

}
