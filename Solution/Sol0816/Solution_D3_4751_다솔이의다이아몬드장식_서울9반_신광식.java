package d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D3_4751_다솔이의다이아몬드장식_서울9반_신광식 {

	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("res/input_d3_4751.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			String str = br.readLine();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < str.length(); j++) {
					if (i % 4 == 0) {
						if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '.') {
							sb.append(".#..");
						} else {
							sb.append("..#..");
						}
					} else if (i % 2 == 1) {
						if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '.') {
							sb.append("#.#.");
						} else {
							sb.append(".#.#.");
						}
					} else if (i == 2) {
						if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '#') {
							sb.append("." + str.charAt(j) + ".#");
						} else {
							sb.append("#." + str.charAt(j) + ".#");
						}
					}
				}
				sb.append("\n");
			}
			System.out.print(sb);
		}
	}

}
