package jo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1077_배낭채우기1_서울9반_신광식 {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int[] weight = new int[n + 1];
		int[] value = new int[n + 1];
		int[] dp = new int[w + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= n; i++) {
			for (int j = weight[i]; j <= w; j++) {
				dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
			}
		}
		System.out.println(dp[w]);
		br.close();
	}

}
