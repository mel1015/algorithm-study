package d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_D2_1961_숫자배열회전_서울9반_신광식 {

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d2_1961.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			String[][] map = new String[n][n];
			for (int i = 0; i < n; i++) {
				map[i] = br.readLine().split(" ");
			}

			System.out.println("#" + tc);
			for (int line = 0; line < n; line++) {
				StringBuilder sb = new StringBuilder();
				for (int i = n - 1; i >= 0; i--) {
					sb.append(map[i][line]);
				}
				sb.append(" ");
				for (int i = n - 1; i >= 0; i--) {
					sb.append(map[n - 1 - line][i]);
				}
				sb.append(" ");
				for (int i = 0; i < n; i++) {
					sb.append(map[i][n - 1 - line]);
				}
				System.out.println(sb);
			}
		}
		br.close();
	}

}
