package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 기출_14502_Solution {
	static int R, C;
	static int[][] matrix;
	static boolean[][] visited;
	static int answer, infection, wall, virus;

	static int[] X = { -1, 0, 1, 0 };
	static int[] Y = { 0, -1, 0, 1 };

	static void DFS(int spot, int depth) {
		if (depth == 3) {
			infection = 0;
			for (int i = 0; i < R; i++) {
				Arrays.fill(visited[i], false);
			}

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (matrix[i][j] == 2) {
						spreadVirus(i, j);
					}
				}
			}
			answer = Math.max(answer, R * C - (wall + 3 + virus + infection));
			return;
		}

		for (int i = spot + 1; i < R * C; i++) {
			int nx = i / C;
			int ny = i % C;

			if (matrix[nx][ny] == 0) {
				matrix[nx][ny] = 1;
				DFS(i, depth + 1);
				matrix[nx][ny] = 0;
			}
		}
	}

	static void spreadVirus(int x, int y) {
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + X[i];
			int ny = y + Y[i];

			if (nx > -1 && nx < R && ny > -1 && ny < C && matrix[nx][ny] == 0 && !visited[nx][ny]) {
				infection++;
				spreadVirus(nx, ny);
			}
		}
	}

	public static void main(String args[]) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String[] mapSize = input.readLine().split(" ");

		R = Integer.parseInt(mapSize[0]);
		C = Integer.parseInt(mapSize[1]);
		matrix = new int[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String[] rows = input.readLine().split(" ");
			for (int j = 0; j < C; j++) {
				int value = Integer.parseInt(rows[j]);
				if (value == 1)
					wall++;
				else if (value == 2)
					virus++;
				matrix[i][j] = value;
			}
		}

		for (int i = 0; i < R * C; i++) {
			int x = i / C;
			int y = i % C;

			if (matrix[x][y] == 0) {
				matrix[x][y] = 1;
				DFS(i, 1);
				matrix[x][y] = 0;
			}
		}
		System.out.println(answer);
	}

}