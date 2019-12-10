package d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_4301_콩많이심기_서울9반_신광식 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] map = new int[m][n];
			int answer = 0;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] == 0) {
						answer++;
						if (i + 2 < m)
							map[i + 2][j] = 2;
						if (j + 2 < n)
							map[i][j + 2] = 2;
					}
				}
			}
			System.out.println("#" + tc + " " + answer);
		}
		br.close();
	}

}
