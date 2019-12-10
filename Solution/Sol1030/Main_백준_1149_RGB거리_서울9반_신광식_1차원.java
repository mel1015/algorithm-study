package boj.Sol1030;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1149_RGB거리_서울9반_신광식_1차원 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[3];
		int rCost = 0, gCost = 0, bCost = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			rCost = Integer.parseInt(st.nextToken()) + Math.min(dp[1], dp[2]);
			gCost = Integer.parseInt(st.nextToken()) + Math.min(dp[0], dp[2]);
			bCost = Integer.parseInt(st.nextToken()) + Math.min(dp[0], dp[1]);
			dp[0] = rCost;
			dp[1] = gCost;
			dp[2] = bCost;
		}
		System.out.println(Math.min(dp[0], Math.min(dp[1], dp[2])));
		br.close();
	}

}
