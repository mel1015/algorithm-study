package d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D2_2005_파스칼의삼각형_서울9반_신광식 {
	public static int[][] pascal = new int[11][12];

	public static void makePascal() {
		pascal[0][1] = 1;
		for (int i = 1; i < pascal.length; i++) {
			for (int j = 1; j <= i + 1; j++) {
				pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
			}
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d2_2005.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		makePascal();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println("#" + tc);
			for (int i = 0; i < n; i++) {
				for (int j = 1; j <= i + 1; j++) {
					System.out.print(pascal[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

}
