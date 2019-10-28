package d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_5549_홀수일까짝수일까_서울9반_신광식 {

	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("res/input_d3_5431.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String num = br.readLine();
			int back = num.charAt(num.length() - 1) - '0';
			String answer = (back % 2 == 0) ? "Even" : "Odd";
			System.out.println("#" + tc + " " + answer);
		}
		br.close();
	}

}
