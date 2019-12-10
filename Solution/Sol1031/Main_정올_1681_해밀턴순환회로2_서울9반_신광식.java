package boj.Sol1031;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1681_해밀턴순환회로2_서울9반_신광식 {
	static int n, answer;
	static int[][] map, data, memo;

	public static int solve(int pos, int visited, int start) {
		if (memo[pos][visited] != 0)
			return memo[pos][visited];
		if (visited == (1 << n) - 1)
			return memo[pos][visited] = data[pos][start];

		int ret = Integer.MAX_VALUE / 2;
		for (int next = 0; next < n; next++) {
			if ((visited & (1 << next)) == 0 && data[pos][next] != 0) {
				int tmp = data[pos][next] + solve(next, visited | (1 << next), start);
				ret = Math.min(ret, tmp);
			}
		}
		memo[pos][visited] = ret;
		return ret;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		data = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (i != j & map[i][j] == 0)
					map[i][j] = Integer.MAX_VALUE / 2;
			}
		}
		answer = Integer.MAX_VALUE / 2;
		for (int i = 0; i < n; i++) {
			data[i] = map[i].clone();
		}
		memo = new int[n][1 << n];
		int tmp = solve(0, 1 << 0, 0);
		answer = Math.min(answer, tmp);
		System.out.println(answer);
		br.close();
	}

}
