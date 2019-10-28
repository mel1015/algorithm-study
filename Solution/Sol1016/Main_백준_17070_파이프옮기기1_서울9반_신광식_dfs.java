package boj.Sol1016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_17070_파이프옮기기1_서울9반_신광식_dfs {
	static int n, answer;
	static int[][] map;
	static int[][] change = { { 2, 0 }, { 2, 1 }, { 2, 1, 0 } };
	static int[] dx = { 0, 1, 1 };
	static int[] dy = { 1, 0, 1 };

	static boolean rangeCheck(int nx, int ny) {
		if (nx < n && ny < n)
			return true;
		return false;
	}

	static void dfs(int x, int y, int shape) {
		if (x == n - 1 && y == n - 1) {
			answer++;
			return;
		}
		
		boolean[] canMake = new boolean[3];
		int makeCnt = 0;
		for (int d = 0; d < dx.length; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (rangeCheck(nx, ny) && map[nx][ny] == 0 && !canMake[d]) {
				canMake[d] = true;
				makeCnt++;
			}
		}
		if(makeCnt==0)
			return;
		
		for (int i = 0; i < change[shape].length; i++) {
			if (change[shape][i] == 0 && canMake[0])
				dfs(x, y + 1, 0);
			else if (change[shape][i] == 1 && canMake[1])
				dfs(x + 1, y, 1);
			else if (change[shape][i] == 2 && canMake[0] && canMake[1] && canMake[2])
				dfs(x + 1, y + 1, 2);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		answer = 0;
		dfs(0, 1, 0);
		System.out.println(answer);
		br.close();
	}

}
