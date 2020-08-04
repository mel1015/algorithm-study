package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_200804_백준_1182_부분수열의합 {
	static int n, s, answer;
	static int[] numbers, visit, combi;

	// Combination으로 2 ~ N개까지의 순열을 만들어 합을 계산 
	static void permcomb(int start, int count, int r) {
		if (count == r) {
			int sum = 0;
			for (int i = 0; i < combi.length; i++) {
				sum += combi[i];
			}
			if (sum == s)
				answer++;
			return;
		}
		for (int i = start; i < n; i++) {
			if (visit[i] == 0) {
				visit[i] = 1;
				combi[count] = numbers[i];
				permcomb(i, count + 1, r);
				visit[i] = 0;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());

		numbers = new int[n];
		visit = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
			if (numbers[i] == s) {
				answer++;
			}
		}

		for (int i = 2; i <= n; i++) {
			combi = new int[i];
			permcomb(0, 0, i);
		}
		System.out.println(answer);

		br.close();
	}
}