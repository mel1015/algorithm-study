package d4;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D4_1211_Ladder2_서울9반_신광식 {
	public static int[][] arr;

	public static int findRoute(int x, int y) {
		int count = 0;
		while (x < 99) {
			// 아래로
			x++;
			count++;
			if (y - 1 >= 0 && arr[x][y - 1] == 1) {
				// 왼쪽으로 갈 수 있는 최대한
				while (true) {
					y--;
					count++;
					if (y - 1 < 0 || arr[x][y - 1] == 0) {
						break;
					}
				}
			} else if (y + 1 <= 99 && arr[x][y + 1] == 1) {
				// 오른쪽으로 갈 수 있는 최대한
				while (true) {
					y++;
					count++;
					if (y + 1 > 99 || arr[x][y + 1] == 0) {
						break;
					}
				}
			}
		}
		return count;
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1211.txt"));
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int T = sc.nextInt();
			arr = new int[100][100];

			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			int count = 0, min = Integer.MAX_VALUE, idx = 0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[0][j] == 1) {
					count = findRoute(0, j);
					if (count <= min) {
						min = count;
						idx = j;
					}
				}
			}
			System.out.println("#" + T + " " + idx);
		}
		sc.close();
	}
}
