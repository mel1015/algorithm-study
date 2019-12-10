package d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D2_1954_달팽이숫자_서울9반_신광식 {

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d2_1954.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];

			int count = 1;
			int size = n - 1;
			int dir = 1;
			int change = 1;
			int row = 0;
			int col = 0;
			// 시작 => 첫행 세팅
			for (; col <= size; col++) {
				arr[row][col] = count++;
			}
			col--;
			while (count < (n * n)) {
				for (int i = 0; i < size; i++) {
					row += dir;
					arr[row][col] = count++;
				}
				change++;
				if (change % 2 == 0) {
					dir *= -1;
				}
				for (int i = 0; i < size; i++) {
					col += dir;
					arr[row][col] = count++;
				}
				change++;
				size--;
			}
			System.out.println("#" + tc);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
		br.close();
	}

}
