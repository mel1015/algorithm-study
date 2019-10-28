package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_D4_4672_수진이의팰린드롬_서울9반_신광식 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_4672.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			char[] w = br.readLine().toCharArray();
			Arrays.sort(w);
			int answer = 0;
			for (int i = 0; i < w.length; i++) {
				for (int j = i + 1; j <= w.length; j++) {
					String subStr = String.valueOf(w).substring(i, j);
					StringBuilder sb = new StringBuilder(subStr);
					String revStr = sb.reverse().toString();
					if (subStr.equals(revStr))
						answer++;
				}
			}
			System.out.println("#" + tc + " " + answer);
		}
		br.close();
	}

}