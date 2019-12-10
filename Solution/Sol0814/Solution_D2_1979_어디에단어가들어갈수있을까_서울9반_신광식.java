package d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_D2_1979_어디에단어가들어갈수있을까_서울9반_신광식 {

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d2_1979.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int answer = 0;
			String[][] map = new String[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int rCount = 0;
				for (int j = 0; j < n; j++) {
					map[i][j] = st.nextToken();
					if (map[i][j].equals("1")) {
						rCount++;
					} else {
						if (rCount == k) {
							answer++;
						}
						rCount = 0;
					}
				}
				if (rCount == k) {
					answer++;
				}
			}
			for (int i = 0; i < n; i++) {
				int cCount = 0;
				for (int j = 0; j < n; j++) {
					if (map[j][i].equals("1")) {
						cCount++;
					} else {
						if (cCount == k) {
							answer++;
						}
						cCount = 0;
					}
				}
				if (cCount == k) {
					answer++;
				}
			}

			System.out.println("#" + tc + " " + answer);
		}
		br.close();
	}

}
