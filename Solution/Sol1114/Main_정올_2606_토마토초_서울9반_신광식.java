package boj.Sol1114;

import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_정올_2606_토마토초_서울9반_신광식 {
	static int m, n, h;
	static int[][][] tomato;
	static int[][] dir = { { -1, 0, 0 }, { 1, 0, 0 }, { 0, -1, 0 }, { 0, 1, 0 }, { 0, 0, -1 }, { 0, 0, 1 } };

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new InputStreamReader(System.in));

		m = sc.nextInt();
		n = sc.nextInt();
		h = sc.nextInt();
		tomato = new int[n][m][h];
		Queue<int[]> q = new LinkedList<int[]>();
		int leftTomato = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					tomato[j][k][i] = sc.nextInt();
					if (tomato[j][k][i] == 1) {
						q.add(new int[] { j, k, i });
					} else if (tomato[j][k][i] == 0) {
						leftTomato++;
					}
				}
			}
		}
		if (q.isEmpty())
			System.out.println("0");
		else {
			int answer = 0;
			while (!q.isEmpty()) {
				int x = q.peek()[0];
				int y = q.peek()[1];
				int z = q.poll()[2];
				for (int d = 0; d < dir.length; d++) {
					int nz = z + dir[d][0];
					int nx = x + dir[d][1];
					int ny = y + dir[d][2];
					if (nx >= 0 && nx < n && ny >= 0 && ny < m && nz >= 0 && nz < h && tomato[nx][ny][nz] == 0) {
						q.add(new int[] { nx, ny, nz });
						tomato[nx][ny][nz] = tomato[x][y][z] + 1;
						leftTomato--;
						answer = Math.max(answer, tomato[nx][ny][nz] - 1);
					}
				}
				if (leftTomato == 0)
					break;
			}
			if (leftTomato != 0)
				System.out.println("-1");
			else
				System.out.println(answer);
		}
		sc.close();
	}
}