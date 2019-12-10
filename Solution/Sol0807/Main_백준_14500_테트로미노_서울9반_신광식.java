package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 기출_14500_신광식 {
	static int n, m, answer = 0;
	static int[][] map;
	static int[][] visit;
	// 0:동, 1:서, 2:북, 3:남
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	// ㅁ, ㅣ, L, Z 모양은 DFS로 만드는게 가능
	static void dfs(int i, int j, int cnt, int sum) {
		// 방문 처리
		visit[i][j] = 1;
		if (cnt == 4) {
			// 4칸 => 테트로미노 1개 완성
			// 최대값을 비교하고
			// 현재 방문을 0으로 초기화
			answer = Math.max(answer, sum);
			visit[i][j] = 0;
			return;
		}
		for (int d = 0; d < dx.length; d++) {
			int ni = i + dx[d];
			int nj = j + dy[d];
			if (ni >= 0 && ni < n && nj >= 0 && nj < m && visit[ni][nj] == 0) {
				dfs(ni, nj, cnt + 1, sum + map[ni][nj]);
			}
		}
		visit[i][j] = 0;
	}

	// ㅜ, ㅗ, ㅏ, ㅓ 모양은 DFS로 처리 불가하므로 따로 계산해준다
	static void notDfs() {
		// ㅜ
		for (int i = 0; i < n - 1; i++) {
			for (int j = 1; j < m - 1; j++) {
				int temp = map[i][j] + map[i + 1][j] + map[i][j - 1] + map[i][j + 1];
				answer = Math.max(answer, temp);
			}
		}
		// ㅗ
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m - 1; j++) {
				int temp = map[i][j] + map[i - 1][j] + map[i][j - 1] + map[i][j + 1];
				answer = Math.max(answer, temp);
			}
		}
		// ㅏ
		for (int i = 1; i < n - 1; i++) {
			for (int j = 0; j < m - 1; j++) {
				int temp = map[i][j] + map[i + 1][j] + map[i - 1][j] + map[i][j + 1];
				answer = Math.max(answer, temp);
			}
		}
		// ㅓ
		for (int i = 1; i < n - 1; i++) {
			for (int j = 1; j < m; j++) {
				int temp = map[i][j] + map[i + 1][j] + map[i - 1][j] + map[i][j - 1];
				answer = Math.max(answer, temp);
			}
		}
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				dfs(i, j, 1, map[i][j]);
			}
		}
		notDfs();
		System.out.println(answer);

		br.close();
	}

}
