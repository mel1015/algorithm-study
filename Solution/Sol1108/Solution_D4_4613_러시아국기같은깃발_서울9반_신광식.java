package boj.Sol1108;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution_D4_4613_러시아국기같은깃발_서울9반_신광식 {
	static int n, m;
	static String[][] flag;

	static int coloringFlag(int white, int blue, int red) {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i < white && !flag[i][j].equals("W"))
					cnt++;
				else if (i >= white && i < white + blue && !flag[i][j].equals("B"))
					cnt++;
				else if (i >= white + blue && i < white + blue + red && !flag[i][j].equals("R"))
					cnt++;
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_4613.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			flag = new String[n][m];
			for (int i = 0; i < n; i++) {
				flag[i] = br.readLine().split("");
			}
			int answer = Integer.MAX_VALUE;
			for (int i = 1; i <= n - 2; i++) {
				for (int j = 1; j <= n - i - 1; j++) {
					for (int k = 1; k <= n - i - j; k++) {
						if (i + j + k == n) {
							int cnt = coloringFlag(i, j, k);
							answer = Math.min(answer, cnt);
						} else if (i + j + k > n)
							break;
					}
				}
			}
			System.out.println("#" + tc + " " + answer);
		}
		br.close();
	}

}
