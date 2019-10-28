package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기출_13458_신광식 {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st, st2;

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		// 배열 데이터 읽어올 StringTokenizer
		st = new StringTokenizer(br.readLine());
		// B와 C 읽어올 StringTokenizer
		st2 = new StringTokenizer(br.readLine());
		int b = Integer.parseInt(st2.nextToken());
		int c = Integer.parseInt(st2.nextToken());

		long answer = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken()) - b;
			answer++;
			int mok = arr[i] / c;
			if (arr[i] < 0) {
				// 총감독관 한명으로 감독 가능
				continue;
			} else if ((mok * c) >= arr[i]) {
				// C * 몫이 인원 수보다 많으면 몫만 더해주면 됨
				answer += mok;
			} else {
				// C * 몫이 인원 수보다 적으면 몫 + 1
				answer += mok + 1;
			}
		}
		System.out.println(answer);
		br.close();
	}

}
