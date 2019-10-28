package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://yabmoons.tistory.com/154 
public class Main_백준_1937_욕심쟁이판다_서울9반_신광식 {
	static int n, answer;
	static int[][] map, memo;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int dpDFS(int x, int y) {
		if (memo[x][y] != 0)
			return memo[x][y];
		memo[x][y] = 1;
		for (int d = 0; d < dx.length; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
				if (map[x][y] < map[nx][ny]) {
					memo[x][y] = Math.max(memo[x][y], dpDFS(nx, ny) + 1);
				}
			}
		}
		return memo[x][y];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		memo = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		answer = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				answer = Math.max(answer, dpDFS(i, j));
			}
		}
		System.out.println(answer);
		br.close();
	}

}
