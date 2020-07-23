package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_200723_백준_9095_123더하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		int[] numbers = new int[t];
		int[] dp = new int[11];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		int maxNum = 0;
		for (int i = 0; i < t; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
			if (numbers[i] > maxNum)
				maxNum = numbers[i];
		}
		// A(n) = A(n-1) + A(n-2) + A(n-3)
		// 입력받은 수 중 최대 수 까지 계산
		for (int i = 4; i <= maxNum; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
		// 정답 출력
		for (int i = 0; i < t; i++) {
			System.out.println(dp[numbers[i]]);
		}

		br.close();
	}
}