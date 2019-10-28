package d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_2805_농작물수확하기_서울9반_신광식2 {
	public static char[][] farm;

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_2805.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int mid = n / 2;
			int sum = 0;

			for (int i = 0; i < n; i++) {
				int idx = Math.abs(mid - i);
				char[] ch = br.readLine().substring(idx, n - idx).toCharArray();
				for (int j = 0; j < ch.length; j++) {
					sum += ch[j] - '0';
				}
			}
			System.out.println("#" + tc + " " + sum);
		}
		br.close();
	}

}