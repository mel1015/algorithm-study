package d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_4466_최대성적표만들기_서울9반_신광식 {

	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("res/input_d3_5431.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[] score = new int[n];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < score.length; i++) {
				score[i] = -Integer.parseInt(st.nextToken());
			}
			Arrays.sort(score);
			int sum = 0;
			for (int j = 0; j < k; j++) {
				sum += -score[j];
			}
			System.out.println("#" + tc + " " + sum);
		}
		br.close();
	}

}
