package d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_1976_시각덧셈_서울9반_신광식 {

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d2_1976.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int hour = 0, minute = 0;
			for (int i = 0; i < 2; i++) {
				hour += Integer.parseInt(st.nextToken());
				minute += Integer.parseInt(st.nextToken());
			}
			if (minute >= 60) {
				hour++;
				minute %= 60;
			}
			hour = hour % 12 == 0 ? 12 : hour % 12;
			System.out.println("#" + tc + " " + hour + " " + minute);
		}
		br.close();
	}

}
