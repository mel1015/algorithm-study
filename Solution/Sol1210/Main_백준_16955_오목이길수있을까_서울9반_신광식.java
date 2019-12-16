package boj.Sol1210;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_16955_오목이길수있을까_서울9반_신광식 {
	static char[][] map;
	static boolean[][] visit;
	static int[] dx = { 0, 1, 1, 1 };
	static int[] dy = { 1, 1, 0, -1 };

	static boolean dfs(int i, int j, int dir, int cnt) {
		if (cnt == 5) {
			return true;
		}
		int nx = i + dx[dir];
		int ny = j + dy[dir];
		boolean isWin = false;
		if (!isWin && nx >= 0 && nx < 10 && ny >= 0 && ny < 10 && map[nx][ny] == 'X')
			isWin = dfs(nx, ny, dir, cnt + 1);
		return isWin;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[10][10];
		for (int i = 0; i < map.length; i++) {
			map[i] = br.readLine().toCharArray();
		}
		boolean isWin = false;
		outLoop: for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				// 모든 빈칸에 구사과의 돌을 놓아보고 5개가 되는지 완전탐색
				if (map[i][j] == '.') {
					map[i][j] = 'X';
					for (int row = 0; row < 10; row++) {
						for (int col = 0; col < 10; col++) {
							if (map[row][col] == 'X') {
								for (int d = 0; d < dx.length && !isWin; d++) {
									isWin = dfs(row, col, d, 1);
								}
								if (isWin)
									break outLoop;
							}
						}
					}
					map[i][j] = '.';
				}
			}
		}
		if (isWin)
			System.out.println(1);
		else
			System.out.println(0);
		br.close();
	}

}
