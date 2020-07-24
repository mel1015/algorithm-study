package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_200724_백준_10971_외판원순회2 {
	static int n;
	static long answer;
	static int[][] w;
	static boolean[] visit;

	static void dfs(int start, int last, int cost, int cnt) {
		if (cnt == n - 1) {
			// 시작 도시로 돌아올 수 없으면 리턴
			if (w[last][start] == 0)
				return;
			// 오는 경로가 있다면 비용 계산
			answer = Math.min(answer, cost + w[last][start]);
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!visit[i] && w[last][i] > 0) {
				visit[i] = true;
				dfs(start, i, cost + w[last][i], cnt + 1);
				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		w = new int[n][n];
		visit = new boolean[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				w[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		answer = Long.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (w[i][j] == 0)
					continue;
				
				// 시작점과 첫 방문 도시 체크
				visit[i] = true;
				visit[j] = true;
				
				// DFS 탐색
				dfs(i, j, w[i][j], 1);
				
				// 백트래킹
				visit[i] = false;
				visit[j] = false;
			}
		}
		System.out.println(answer);

		br.close();
	}
}