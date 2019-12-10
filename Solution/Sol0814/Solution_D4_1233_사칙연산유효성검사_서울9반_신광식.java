package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1233_사칙연산유효성검사_서울9반_신광식 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1233.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {
			int n = Integer.parseInt(br.readLine());
			int answer = 1;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				if (st.countTokens() == 4) {
					st.nextToken();
					String str = st.nextToken();
					char op = str.charAt(0);
					if (Character.isDigit(op)) {
						answer = 0;
					}
				} else if (st.countTokens() == 2) {
					st.nextToken();
					String str = st.nextToken();
					if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
						answer = 0;
					}
				}
			}
			System.out.println("#" + tc + " " + answer);
		}
		br.close();
	}

}