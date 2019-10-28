package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 기출_14501_신광식 {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int[] dp = new int[20];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			// 각 날의 데이터를 입력 받으면서
			int time = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			// 현재 날짜의 상담 금액이 다음날의 금액 보다 크면
			// 다음 날의 값을 현재 날짜의 값으로 바꿈 => 이전에 번 돈을 가져옴
			System.out.println("현재 일:" + (i + 1));
			if (dp[i] > dp[i + 1]) {
				dp[i + 1] = dp[i];
				System.out.println("벌어둔 돈 가져오기: " + (i + 1) + " to " + (i + 1 + 1));
				System.out.println(Arrays.toString(dp));
			}
			// 현재 입력된 날의 상담을 수락한 값 dp[i] + cost가
			// 상담이 끝나는날의 값 dp[i + time] 보다 크면
			// 상담의 끝나는 날의 값은 현재 상담을 수락한 값으로 변경 => 최대값 갱신
			if (dp[i + time] < dp[i] + cost) {
				dp[i + time] = dp[i] + cost;
				System.out.println((i + 1) + "일자 일하기:" + (i + time + 1) + "일에 돈들어옴");
				System.out.println(Arrays.toString(dp));
			}
			System.out.println();
		}
		System.out.println(dp[n]);
		br.close();
	}

}
