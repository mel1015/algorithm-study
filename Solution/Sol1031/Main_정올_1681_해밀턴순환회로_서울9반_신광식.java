package boj.Sol1031;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1681_해밀턴순환회로_서울9반_신광식 {
	static int n, answer;
	static int[][] map;
	static int[] order;
	static boolean[] visit;

	static void permComb(int count) {
		if (count == n) {
			int cost = 0;
			for (int i = 0; i < n; i++) {
				if (map[order[i]][order[i + 1]] == 0)
					return;
				cost += map[order[i]][order[i + 1]];
			}
			answer = Math.min(answer, cost);
			return;
		}
		for (int i = 1; i < n; i++) {
			if (!visit[i] && map[order[count - 1]][i] != 0) {
				visit[i] = true;
				order[count] = i;
				permComb(count + 1);
				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		order = new int[n + 1];
		visit = new boolean[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		answer = Integer.MAX_VALUE;
		permComb(1);
		System.out.println(answer);
		br.close();
	}

}
