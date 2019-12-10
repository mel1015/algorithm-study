package d6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D6_1266_소수완제품확률_서울9반_신광식 {
	public static double skillOfMasterA, skillOfMasterB;
	public static double primeOfMasterA, primeOfMasterB;
	public static double[] percentA, percentB;
	public static int[] prime = { 2, 3, 5, 7, 11, 13, 17 };

	public static double nCr(int n, int r) {
		if (r == 0)
			return 1.0;
		return (1.0 * n) / r * nCr(n - 1, r - 1);
	}

	public static void solution() {
		for (int i = 1; i <= 18; i++) {
			percentA[i] = nCr(18, i) * Math.pow(skillOfMasterA, i) * Math.pow(1 - skillOfMasterA, 18 - i);
			percentB[i] = nCr(18, i) * Math.pow(skillOfMasterB, i) * Math.pow(1 - skillOfMasterB, 18 - i);
		}

		for (int i = 0; i < prime.length; i++) {
			primeOfMasterA += percentA[prime[i]];
			primeOfMasterB += percentB[prime[i]];
		}
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d6_1266.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			skillOfMasterA = Integer.parseInt(st.nextToken()) / 100.0;
			skillOfMasterB = Integer.parseInt(st.nextToken()) / 100.0;

			percentA = new double[19];
			percentB = new double[19];

			primeOfMasterA = primeOfMasterB = 0.0;
			solution();
			double answer = primeOfMasterA + primeOfMasterB - (primeOfMasterA) * (primeOfMasterB);
			System.out.printf("#%d %.6f\n", tc, answer);
		}
	}

}
