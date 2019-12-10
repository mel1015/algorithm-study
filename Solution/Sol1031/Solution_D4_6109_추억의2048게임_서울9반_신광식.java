package boj.Sol1031;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution_D4_6109_추억의2048게임_서울9반_신광식 {
	static int n;
	static String dirStr;
	static int[][] map, changeMap;

	static void move() {
		if (dirStr.equals("up")) {
			for (int col = 0; col < n; col++) {
				int idx = 0;
				for (int row = 0; row < n; row++) {
					if (map[row][col] != 0) {
						if (changeMap[idx][col] == 0) {
							changeMap[idx][col] = map[row][col];
						} else if (changeMap[idx][col] == map[row][col]) {
							changeMap[idx][col] = changeMap[idx][col] * 2;
							idx++;
						} else if (changeMap[idx][col] != map[row][col]) {
							changeMap[++idx][col] = map[row][col];
						}
					}
				}
			}
		} else if (dirStr.equals("down")) {
			for (int col = 0; col < n; col++) {
				int idx = n - 1;
				for (int row = n - 1; row >= 0; row--) {
					if (map[row][col] != 0) {
						if (changeMap[idx][col] == 0) {
							changeMap[idx][col] = map[row][col];
						} else if (changeMap[idx][col] == map[row][col]) {
							changeMap[idx][col] = changeMap[idx][col] * 2;
							idx--;
						} else if (changeMap[idx][col] != map[row][col]) {
							changeMap[--idx][col] = map[row][col];
						}
					}
				}
			}
		} else if (dirStr.equals("right")) {
			for (int row = 0; row < n; row++) {
				int idx = n - 1;
				for (int col = n - 1; col >= 0; col--) {
					if (map[row][col] != 0) {
						if (changeMap[row][idx] == 0) {
							changeMap[row][idx] = map[row][col];
						} else if (changeMap[row][idx] == map[row][col]) {
							changeMap[row][idx] = changeMap[row][idx] * 2;
							idx--;
						} else if (changeMap[row][idx] != map[row][col]) {
							changeMap[row][--idx] = map[row][col];
						}
					}
				}
			}
		} else if (dirStr.equals("left")) {
			for (int row = 0; row < n; row++) {
				int idx = 0;
				for (int col = 0; col < n; col++) {
					if (map[row][col] != 0) {
						if (changeMap[row][idx] == 0) {
							changeMap[row][idx] = map[row][col];
						} else if (changeMap[row][idx] == map[row][col]) {
							changeMap[row][idx] = changeMap[row][idx] * 2;
							idx++;
						} else if (changeMap[row][idx] != map[row][col]) {
							changeMap[row][++idx] = map[row][col];
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_6109.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			dirStr = st.nextToken();
			map = new int[n][n];
			changeMap = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			move();
			System.out.println("#" + tc);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(changeMap[i][j] + " ");
				}
				System.out.println();
			}
		}
		br.close();
	}

}
