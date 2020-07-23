package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_200721_백준_9613_GCD합 {
	static int n;
	static long answer;
	static int[] numbers;

	static int gcd(int a, int b) {
		if (b <= 0)
			return a;
		return gcd(b, a % b);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			answer = 0;
			st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			numbers = new int[n];
			for (int i = 0; i < numbers.length; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) {
					answer += gcd(numbers[i], numbers[j]);
				}
			}
			System.out.println(answer);
		}

		br.close();
	}
}