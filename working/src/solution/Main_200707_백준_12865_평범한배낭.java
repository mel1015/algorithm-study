package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_200707_백준_12865_평범한배낭 {
	static int n, k;
	static int[] w, v, dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		w = new int[n + 1];
		v = new int[n + 1];
		dp = new int[k + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}
		
		// 중복 사용을 없애기 위해 K부터 1까지 감소하는 방식 
		for (int i = 1; i <= n; i++) {
			for (int j = k; j >= 1; j--) {
				if (w[i] <= j)
					dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
				else break;
			}
		}
		System.out.println(dp[k]);

		br.close();
	}
}