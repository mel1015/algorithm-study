package boj.Sol1016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_17070_파이프옮기기1_서울9반_신광식_dp {
	static int n, answer;
	static int[][] map;
	static int[][][] dp;

	static void dpMove() {
		dp[1][2][0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == 1 && j == 2)
					continue;
				if (map[i][j] == 0) {
					// 가로 => 가로와 대각선인 상태에서 만들 수 있음
					dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];
					// 세로 => 세로와 대각선인 상태에서 만들 수 있음
					dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];
					if (map[i][j - 1] != 1 && map[i - 1][j] != 1) {
						// 대각선 => 모든 상태에서 만들 수 있지만 3개의 칸을 확인해야함
						dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
					}
				}
			}
		}
		answer = dp[n][n][0] + dp[n][n][1] + dp[n][n][2];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new int[n + 1][n + 1];
		dp = new int[n + 1][n + 1][3];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		answer = 0;
		dpMove();
		System.out.println(answer);
		br.close();
	}

}
