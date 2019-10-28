package d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D2_1970_쉬운거스름돈_서울9반_신광식 {
	public static int[] money = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d2_1970.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < money.length; i++) {
				sb.append((n / money[i]) + " ");
				n %= money[i];
			}
			System.out.println("#" + tc + "\n" + sb);
		}
	}

}
