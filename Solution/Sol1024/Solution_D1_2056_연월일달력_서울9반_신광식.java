package boj.Sol1024;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_D1_2056_연월일달력_서울9반_신광식 {
	static int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			int ymd = Integer.parseInt(br.readLine());
			int year = ymd / 10000;
			ymd %= 10000;
			int month = ymd / 100;
			ymd %= 100;
			int day = ymd;
			if (month < 1 || month > 12)
				System.out.println("#" + tc + " " + -1);
			else if (day > days[month])
				System.out.println("#" + tc + " " + -1);
			else
				System.out.printf("#%d %04d/%02d/%02d\n", tc, year, month, day);
		}
		br.close();
	}

}
