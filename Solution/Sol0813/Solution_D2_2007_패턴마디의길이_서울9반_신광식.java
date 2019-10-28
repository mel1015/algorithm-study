package d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_D2_2007_패턴마디의길이_서울9반_신광식 {

	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("res/input_d2_1928.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int answer = 0;
			String str = br.readLine();
			for (int i = 1; i < str.length(); i++) {
				if (str.charAt(0) == str.charAt(i)) {
					String substr = str.substring(0, i);
					String comp = str.substring(i, i + i);
					if (substr.equals(comp)) {
						answer = i;
						break;
					}
				}
			}

			System.out.println("#" + tc + " " + answer);
		}
		br.close();
	}

}
