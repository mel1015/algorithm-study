package d4;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D4_1210_Ladder1_서울9반_신광식 {

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1210.txt"));
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int T = sc.nextInt();
			int[][] arr = new int[100][100];

			int x = 0, y = 0;
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = sc.nextInt();
					if (arr[i][j] == 2) {
						x = i;
						y = j;
					}

				}
			}

			while (x > 0) {
				// 위로
				x--;
				if (y - 1 >= 0 && arr[x][y - 1] == 1) {
					// 왼쪽으로 갈 수 있는 최대한
					while (true) {
						y--;
						if (y - 1 < 0 || arr[x][y - 1] == 0) {
							break;
						}
					}
				} else if (y + 1 <= 99 && arr[x][y + 1] == 1) {
					// 오른쪽으로 갈 수 있는 최대한
					while (true) {
						y++;
						if (y + 1 > 99 || arr[x][y + 1] == 0) {
							break;
						}
					}
				}
			}
			System.out.println("#" + T + " " + y);
		}
		sc.close();
	}
}
