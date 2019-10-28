package d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_3282_01Knapsack_서울9반_신광식 {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			int[] weight = new int[n + 1];
			int[] value = new int[n + 1];
			int[][] dp = new int[n + 1][k + 1];

			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				weight[i] = Integer.parseInt(st.nextToken());
				value[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= k; j++) {
					if (weight[i] > j) {
						dp[i][j] = dp[i - 1][j];
					} else {
						dp[i][j] = Math.max(dp[i - 1][j - weight[i]] + value[i], dp[i - 1][j]);
					}
				}
			}
			System.out.println("#" + tc + " " + dp[n][k]);
		}
		br.close();
	}

}
