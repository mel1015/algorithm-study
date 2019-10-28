package d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D3_1213_String_서울9반_신광식 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1213.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			int n = Integer.parseInt(br.readLine());
			String subStr = br.readLine();
			StringBuffer str = new StringBuffer(br.readLine());

			int idx = 0, answer = 0;
			// StringBuffer의 indexOf 메소드 사용
			while (str.indexOf(subStr, idx) > 0) {
				answer++;
				idx = str.indexOf(subStr, idx) + subStr.length();
			}
			System.out.println("#" + n + " " + answer);
		}
		br.close();
	}
}
