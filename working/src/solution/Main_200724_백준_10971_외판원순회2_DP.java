package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_200724_백준_10971_외판원순회2_DP {
	static int n;
	static int[][] weight;
	static int[][] dp;

	static int dpDfs(int here, int visited) {
		if (visited == (1 << n) - 1) {
			if (weight[here][0] == 0)
				return Integer.MAX_VALUE / 2;
			else
				return weight[here][0];
		}

		if (dp[here][visited] != -1)
			return dp[here][visited];

		int result = Integer.MAX_VALUE / 2;
		for (int i = 0; i < n; i++) {
			if ((visited & (1 << i)) == 0 && weight[here][i] > 0) {
				result = Math.min(result, weight[here][i] + dpDfs(i, visited | (1 << i)));
			}
		}
		return dp[here][visited] = result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		weight = new int[n][n];
		dp = new int[n][1 << n];

		for (int[] arr : dp) {
			Arrays.fill(arr, -1);
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				weight[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(dpDfs(0, 1 << 0));
		System.out.println();
		br.close();
	}
}