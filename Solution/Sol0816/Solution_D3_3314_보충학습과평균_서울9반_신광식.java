package d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_3314_보충학습과평균_서울9반_신광식 {

	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("res/input_d3_3314.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			int sum = 0;
			while (st.hasMoreTokens()) {
				int score = Integer.parseInt(st.nextToken());
				if (score < 40) {
					sum += 40;
				} else
					sum += score;
			}
			System.out.println("#" + tc + " " + (sum / 5));

		}
	}

}
