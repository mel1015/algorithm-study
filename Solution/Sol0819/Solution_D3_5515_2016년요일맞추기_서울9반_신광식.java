package d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_5515_2016년요일맞추기_서울9반_신광식 {
	public static int[] month = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	public static int[] day = { 3, 4, 5, 6, 0, 1, 2 };

	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("res/input_d3_5431.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			int days = 0;
			for (int i = 0; i < m - 1; i++) {
				days += month[i];
			}
			days += d;
			int answer = day[days % 7];
			System.out.println("#" + tc + " " + answer);
		}
		br.close();
	}

}
