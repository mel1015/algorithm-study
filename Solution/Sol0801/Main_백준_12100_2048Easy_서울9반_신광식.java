package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 기출_12100_신광식 {
	static int n, maxValue = 0;

	public static void dfs(int[][] map, int cnt) {
		if (cnt == 5) {
			// 5번 이동했으면 최대값 갱신
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] > maxValue) {
						maxValue = map[i][j];
					}
				}
			}
			return;
		}

		for (int dir = 0; dir < 4; dir++) {
			// temp 배열 => 다음 dfs의 매개변수로 보내는 새로운 맵
			// 각 방향으로 합치는 작업을 하고 temp 배열에 값을 넣어서 다음 dfs로 보내줌
			int[][] temp = new int[n][n];
			switch (dir) {
			case 0:
				// 위로 합치기
				for (int col = 0; col < n; col++) {
					int idx = 0;
					for (int row = 0; row < n; row++) {
						if (map[row][col] != 0) {
							if (temp[idx][col] == 0) {
								temp[idx][col] = map[row][col];
							} else if (temp[idx][col] == map[row][col]) {
								temp[idx][col] = temp[idx][col] * 2;
								idx++;
							} else if (temp[idx][col] != map[row][col]) {
								temp[++idx][col] = map[row][col];
							}
						}
					}
				}
				break;
			case 1:
				// 아래로 합치기
				for (int col = 0; col < n; col++) {
					int idx = n - 1;
					for (int row = n - 1; row >= 0; row--) {
						if (map[row][col] != 0) {
							if (temp[idx][col] == 0) {
								temp[idx][col] = map[row][col];
							} else if (temp[idx][col] == map[row][col]) {
								temp[idx][col] = temp[idx][col] * 2;
								idx--;
							} else if (temp[idx][col] != map[row][col]) {
								temp[--idx][col] = map[row][col];
							}
						}
					}
				}
				break;
			case 2:
				// 왼쪽으로 합치기
				for (int row = 0; row < n; row++) {
					int idx = 0;
					for (int col = 0; col < n; col++) {
						if (map[row][col] != 0) {
							if (temp[row][idx] == 0) {
								temp[row][idx] = map[row][col];
							} else if (temp[row][idx] == map[row][col]) {
								temp[row][idx] = temp[row][idx] * 2;
								idx++;
							} else if (temp[row][idx] != map[row][col]) {
								temp[row][++idx] = map[row][col];
							}
						}
					}
				}
				break;

			case 3:
				// 오른쪽으로 합치기
				for (int row = 0; row < n; row++) {
					int idx = n - 1;
					for (int col = n - 1; col >= 0; col--) {
						if (map[row][col] != 0) {
							if (temp[row][idx] == 0) {
								temp[row][idx] = map[row][col];
							} else if (temp[row][idx] == map[row][col]) {
								temp[row][idx] = temp[row][idx] * 2;
								idx--;
							} else if (temp[row][idx] != map[row][col]) {
								temp[row][--idx] = map[row][col];
							}
						}
					}
				}
				break;
			}
			dfs(temp, cnt + 1);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		int[][] board = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] > 0) {
					maxValue = Math.max(board[i][j], maxValue);
				}
			}
		}
		dfs(board, 0);
		System.out.println(maxValue);
	}

}
