package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_200828_백준_11727_2xn타일링2 {
	static int n;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		// 점화식
		// f(n - 1) => 1개
		// f(n - 2) => 2개
		// f(n) = f(n - 1) + 2 * f(n - 2)
		dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
		}
		System.out.println(dp[n]);

		br.close();
	}
}