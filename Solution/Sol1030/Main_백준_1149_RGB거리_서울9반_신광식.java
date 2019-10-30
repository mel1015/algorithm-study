package boj.Sol1030;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1149_RGB거리_서울9반_신광식 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] cost = new int[n][3];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 1; i < cost.length; i++) {
			cost[i][0] = cost[i][0] + Math.min(cost[i - 1][1], cost[i - 1][2]);
			cost[i][1] = cost[i][1] + Math.min(cost[i - 1][0], cost[i - 1][2]);
			cost[i][2] = cost[i][2] + Math.min(cost[i - 1][0], cost[i - 1][1]);
		}
		System.out.println(Math.min(cost[n - 1][0], Math.min(cost[n - 1][1], cost[n - 1][2])));
		br.close();
	}

}
