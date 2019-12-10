package d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_1948_날짜계산기_서울9반_신광식 {
	public static int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("res/input_d2_1948.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int fromMonth = Integer.parseInt(st.nextToken());
			int fromDay = Integer.parseInt(st.nextToken());
			int toMonth = Integer.parseInt(st.nextToken());
			int toDay = Integer.parseInt(st.nextToken());

			int answer = 0;
			if (fromMonth == toMonth) {
				answer = toDay - fromDay + 1;
			} else {
				answer += days[fromMonth] - fromDay;
				for (int i = fromMonth + 1; i < toMonth; i++) {
					answer += days[i];
				}
				answer += toDay + 1;
			}
			System.out.println("#" + tc + " " + answer);
		}
		br.close();
	}

}
