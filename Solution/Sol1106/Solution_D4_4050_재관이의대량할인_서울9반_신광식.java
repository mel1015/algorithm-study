package boj.Sol1106;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution_D4_4050_재관이의대량할인_서울9반_신광식 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_4050.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] cost = new int[n];
			int sumCost = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
				sumCost += cost[i];
			}
			if (n > 3) {
				Arrays.sort(cost);
				int minCost = Integer.MAX_VALUE;
				int count = 0;
				for (int i = n; i >= 1; i--) {
					if (cost[i - 1] <= minCost) {
						minCost = cost[i - 1];
					}
					count++;
					if (count == 3) {
						sumCost -= minCost;
						minCost = Integer.MAX_VALUE;
						count = 0;
					}
				}
			}
			System.out.println("#" + tc + " " + sumCost);
		}
		br.close();
	}

}
