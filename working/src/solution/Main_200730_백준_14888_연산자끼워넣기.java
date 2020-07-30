package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_200730_백준_14888_연산자끼워넣기 {
	static int n, maxAnswer, minAnswer;
	static int[] numbers;

	static void dfs(int add, int sub, int mul, int div, int cnt, int sum) {
		if (cnt == n - 1) {
			maxAnswer = Math.max(maxAnswer, sum);
			minAnswer = Math.min(minAnswer, sum);
			return;
		}
		if (add > 0)
			dfs(add - 1, sub, mul, div, cnt + 1, sum + numbers[cnt + 1]);
		if (sub > 0)
			dfs(add, sub - 1, mul, div, cnt + 1, sum - numbers[cnt + 1]);
		if (mul > 0)
			dfs(add, sub, mul - 1, div, cnt + 1, sum * numbers[cnt + 1]);
		if (div > 0)
			dfs(add, sub, mul, div - 1, cnt + 1, sum / numbers[cnt + 1]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		numbers = new int[n];
		maxAnswer = Integer.MIN_VALUE;
		minAnswer = Integer.MAX_VALUE;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int add = Integer.parseInt(st.nextToken());
		int sub = Integer.parseInt(st.nextToken());
		int mul = Integer.parseInt(st.nextToken());
		int div = Integer.parseInt(st.nextToken());

		dfs(add, sub, mul, div, 0, numbers[0]);

		System.out.println(maxAnswer);
		System.out.println(minAnswer);

		br.close();
	}
}