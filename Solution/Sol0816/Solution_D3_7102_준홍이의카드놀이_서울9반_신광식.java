package d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_7102_준홍이의카드놀이_서울9반_신광식 {

	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("res/input_d3_3314.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] cnt = new int[41];
			int max = 0;
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					cnt[i + j]++;
					if (cnt[i + j] > max) {
						max = cnt[i + j];
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < cnt.length; i++) {
				if (cnt[i] == max) {
					sb.append(i + " ");
				}
			}
			System.out.println("#" + tc + " " + sb);

		}
	}

}
