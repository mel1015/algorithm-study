package d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_1285_아름이의돌던지기_서울9반_신광식 {

	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("res/input_d2_1285.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int answer = Integer.MAX_VALUE;
			int count = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				int a = Math.abs(Integer.parseInt(st.nextToken()));
				if (answer > a) {
					answer = a;
					count = 1;
				} else if (answer == a) {
					count++;
				}
			}
			System.out.println("#" + tc + " " + answer + " " + count);
		}
		br.close();
	}

}
