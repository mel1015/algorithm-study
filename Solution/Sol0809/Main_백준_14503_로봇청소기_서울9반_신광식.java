package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 기출_14503_신광식 {
	static int n, m, answer = 0;
	static int[][] map;
	static int[][] visit;
	// 0:북, 1:동, 2:남, 3:서
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static void printMap() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.printf("%3d", map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	static void cleanRoom(int x, int y, int d) {
		int nx = 0;
		int ny = 0;
		boolean dustFlag = false;
		// 시작점 청소
		map[x][y] = 2;
		answer++;
		while (true) {
//			printMap();
			dustFlag = false;
			// 4방향 탐색
			for (int i = 0; i < 4; i++) {
				// 조건을 보면 먼지가 있든 없든 왼쪽을 확인하면 왼쪽으로 회전한다
				d = (d + 3) % 4;
				nx = x + dx[d];
				ny = y + dy[d];
				// 범위 체크, 청소 할 수 있으면 청소하고 dustFlag를 true로 변경
				if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 0) {
					map[nx][ny] = 2;
					x = nx;
					y = ny;
					answer++;
					dustFlag = true;
					break;
				}
			}
			// 먼지가 있으면 계속 진행
			if (dustFlag)
				continue;
			// 없으면 후진
			nx = x - dx[d];
			ny = y - dy[d];
			// 벽이 아니기만 하면 후진 가능 => map[nx][ny] != 1
			if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] != 1) {
				x = nx;
				y = ny;
				continue;
			} else {
				return;
			}
		}
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit = new int[n][m];

		String[] robot = br.readLine().split(" ");
		int x = Integer.parseInt(robot[0]);
		int y = Integer.parseInt(robot[1]);
		int d = Integer.parseInt(robot[2]);

		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cleanRoom(x, y, d);
		System.out.println(answer);

		br.close();
	}

}
