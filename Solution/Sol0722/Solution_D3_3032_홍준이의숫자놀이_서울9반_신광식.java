package d3;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D3_3032_홍준이의숫자놀이_서울9반_신광식 {
	public static int[] xgcd(int a, int b) {
		int[] result = { 0, 0, 0 };
		int[] si = { 1, 0 };
		int[] ti = { 0, 1 };
		int q = 0;
		while (true) {
			q = a / b;
			a = a % b;
			si[0] = si[0] - q * si[1];
			ti[0] = ti[0] - q * ti[1];
			if (a == 0) {
				result[0] = b;
				result[1] = si[1];
				result[2] = ti[1];
				return result;
			}
			q = b / a;
			b = b % a;
			si[1] = si[1] - q * si[0];
			ti[1] = ti[1] - q * ti[0];
			if (b == 0) {
				result[0] = a;
				result[1] = si[0];
				result[2] = ti[0];
				return result;
			}
		}
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_3032.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int[] result = xgcd(A, B);
			if (result[0] != 1)
				System.out.println("#" + T + " " + -1);
			else
				System.out.println("#" + T + " " + result[1] + " " + result[2]);
		}
		sc.close();
	}

}
