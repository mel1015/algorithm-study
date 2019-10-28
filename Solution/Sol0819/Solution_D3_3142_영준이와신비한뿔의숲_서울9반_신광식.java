package d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_3142_영준이와신비한뿔의숲_서울9반_신광식 {

	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("res/input_d3_5431.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		loop: for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			for (int i = 1; i <= m; i++) {
				for (int j = 1; j <= m - i; j++) {
					if (i + j == m && i + 2 * j == n) {
						System.out.println("#" + tc + " " + i + " " + j);
						continue loop;
					}
				}
			}
		}
		br.close();
	}

}
