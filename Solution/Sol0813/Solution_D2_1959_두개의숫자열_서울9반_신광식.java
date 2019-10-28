package d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_1959_두개의숫자열_서울9반_신광식 {
	public static int answer = 0;

	public static void arrayMul(int[] a, int[] b) {
		if (a.length > b.length) {
			int[] temp = a.clone();
			a = b.clone();
			b = temp.clone();
		}
		for (int i = 0; i <= b.length - a.length; i++) {
			int result = 0;
			for (int j = 0; j < a.length; j++) {
				result += a[j] * b[j + i];
			}
			answer = Math.max(answer, result);
		}
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d2_1959.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			answer = 0;
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] a = new int[n];
			int[] b = new int[m];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}
			arrayMul(a, b);
			System.out.println("#" + tc + " " + answer);
		}
		br.close();
	}

}
