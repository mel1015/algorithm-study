package d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_D2_1989_초심자의회문검사_서울9반_신광식 {

	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("res/input_d2_1928.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int answer = 0;
			String str = br.readLine();
			StringBuffer rev = new StringBuffer(str);
			rev.reverse();
			
			if (str.equals(rev.toString()))
				answer = 1;

			System.out.println("#" + tc + " " + answer);
		}
		br.close();
	}

}
