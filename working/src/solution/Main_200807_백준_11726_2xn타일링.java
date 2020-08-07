package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_200807_백준_11726_2xn타일링 {
	static int n;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		// 점화식
		// DP(N) = DP(N - 1) + DP(N - 2) (n >= 3)
		// DP(N) = N (1 <= n <= 2)
		if (n == 1 || n == 2) {
			System.out.println(n);
		} else {
			dp = new int[n + 1];
			dp[1] = 1;
			dp[2] = 2;
			for (int i = 3; i <= n; i++) {
				dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
			}
			System.out.println(dp[n]);
		}

		br.close();
	}
}