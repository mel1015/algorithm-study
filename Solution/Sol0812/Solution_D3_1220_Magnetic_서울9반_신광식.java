package d3;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_1220_Magnetic_서울9반_신광식 {
	static int countDeadlock(int[][] arr, int col) {
		int countDL = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i][col] == 1) {
				for (int j = i; j < arr.length; j++) {
					if (arr[j][col] == 2) {
						countDL++;
						i = j;
						break;
					}
				}
			}
		}
		return countDL;
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1220.txt"));
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int Answer = 0;
			int N = sc.nextInt();
			int[][] arr = new int[N][N];

			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					// 1:N극, 2:S극, 위쪽:N극, 아래쪽:S극
					arr[i][j] = sc.nextInt();
				}
			}

			for (int j = 0; j < arr.length; j++) {
				int countN = 0;
				int countS = 0;
				for (int i = 0; i < arr.length; i++) {
					if (arr[i][j] == 1)
						countN++;
					if (arr[i][j] == 2)
						countS++;
				}
				if (countN > 0 && countS > 0) {
					Answer += countDeadlock(arr, j);
				}
			}
			System.out.println("#" + tc + " " + Answer);
		}
		sc.close();
	}
}
