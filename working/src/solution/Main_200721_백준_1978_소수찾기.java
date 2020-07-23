package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_200721_백준_1978_소수찾기 {
	static int n;
	static int[] numbers;
	static boolean[] notPrime;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		numbers = new int[n];
		notPrime = new boolean[1001];

		notPrime[0] = true;
		notPrime[1] = true;
		for (int i = 2; i <= Math.sqrt(1000); i++) {
			if (notPrime[i])
				continue;
			for (int j = i + i; j <= 1000; j += i) {
				notPrime[j] = true;
			}
		}

		st = new StringTokenizer(br.readLine());
		int answer = 0;
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (!notPrime[num])
				answer++;
		}
		System.out.println(answer);

		br.close();
	}
}