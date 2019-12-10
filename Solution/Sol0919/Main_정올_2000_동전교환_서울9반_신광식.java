package jo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_2000_동전교환_서울9반_신광식 {
	public static int[] coin;
	public static int[] dp;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(br.readLine());
		coin = new int[n];
		dp = new int[m + 1];

		for (int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= m; i++) {
			int min = Integer.MAX_VALUE / 2;
			for (int j = 0; j < coin.length; j++) {
				if (i - coin[j] >= 0) {
					if (min > dp[i - coin[j]])
						min = dp[i - coin[j]];
				}
			}
			dp[i] = min + 1;
		}
		System.out.println((dp[m] >= Integer.MAX_VALUE / 2) ? "impossible" : dp[m]);
		br.close();
	}

}
