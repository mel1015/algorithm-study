package jo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1278_배낭채우기2_서울9반_신광식 {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int[] weight = new int[n + 1];
		int[] value = new int[n + 1];
		int[][] dp = new int[n + 1][w + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= w; j++) {
				if (weight[i] > j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j - weight[i]] + value[i], dp[i - 1][j]);
				}
			}
		}
		System.out.println(dp[n][w]);
		br.close();
	}

}
