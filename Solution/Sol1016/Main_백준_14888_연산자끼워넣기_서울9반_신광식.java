package boj.Sol1016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_14888_연산자끼워넣기_서울9반_신광식 {
	public static int n, maxValue, minValue;
	public static int[] num, op;

	public static void dfs(int plus, int minus, int mul, int div, int result, int idx) {
		// 마지막 숫자까지 연산이 끝나면 값 갱신
		if (idx == n) {
			maxValue = Math.max(maxValue, result);
			minValue = Math.min(minValue, result);
			return;
		}

		// 가능한 모든 연산자 순서 조합으로 dfs실행
		if (plus > 0) {
			dfs(plus - 1, minus, mul, div, result + num[idx], idx + 1);
		}
		if (minus > 0) {
			dfs(plus, minus - 1, mul, div, result - num[idx], idx + 1);
		}
		if (mul > 0) {
			dfs(plus, minus, mul - 1, div, result * num[idx], idx + 1);
		}
		if (div > 0) {
			dfs(plus, minus, mul, div - 1, result / num[idx], idx + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		num = new int[n];
		op = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < num.length; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < op.length; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}

		maxValue = Integer.MIN_VALUE;
		minValue = Integer.MAX_VALUE;
		dfs(op[0], op[1], op[2], op[3], num[0], 1);

		System.out.println(maxValue);
		System.out.println(minValue);
	}

}
