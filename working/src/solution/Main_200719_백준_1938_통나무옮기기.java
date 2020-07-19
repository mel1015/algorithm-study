package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_200719_백준_1938_통나무옮기기 {
	static int n, answer;
	static char[][] map;
	static int[][][] visit;
	static int[] btree, goal;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static boolean checkAround(int x, int y) {
		// 왼쪽 꼭지점을 찾아서 3X3 칸이 비어있는지 체크
		int leftUpX = x - 1;
		int leftUpY = y - 1;
		int rightDownX = x + 1;
		int rightDownY = y + 1;
		if (leftUpX >= 0 && leftUpY >= 0 && rightDownX < n && rightDownY < n) {
			for (int i = leftUpX; i <= rightDownX; i++) {
				for (int j = leftUpY; j <= rightDownY; j++) {
					if (map[i][j] != '0')
						return false;
				}
			}
		}
		return true;
	}

	static boolean checkRange(int x, int y, int isVertical) {
		boolean canMove = false;
		if (isVertical == 1) {
			// 가로 모양일 때
			if (x >= 0 && x < n && y >= 1 && y <= n - 2) {
				if (map[x][y - 1] == '0' && map[x][y] == '0' && map[x][y + 1] == '0') {
					canMove = true;
				}
			}
		} else {
			// 세로 모양일 떄
			if (x >= 1 && x <= n - 2 && y >= 0 && y < n) {
				if (map[x - 1][y] == '0' && map[x][y] == '0' && map[x + 1][y] == '0') {
					canMove = true;
				}
			}
		}
		return canMove;
	}

	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { btree[0], btree[1], btree[2], 0 });
		visit[btree[0]][btree[1]][btree[2]] = 1;

		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			int isVertical = q.peek()[2];
			int cnt = q.poll()[3];
			if (x == goal[0] && y == goal[1] && isVertical == goal[2]) {
				answer = Math.min(answer, cnt);
				return;
			}
			// 상하좌우 이동
			for (int d = 0; d < dx.length; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (checkRange(nx, ny, isVertical) && visit[nx][ny][isVertical] == 0) {
					visit[nx][ny][isVertical] = 1;
					q.offer(new int[] { nx, ny, isVertical, cnt + 1 });
				}
			}
			// 현재 위치에서 회전 가능하면 회전해서 큐에 넣음
			if (checkAround(x, y) && checkRange(x, y, 1 ^ isVertical) && visit[x][y][1 ^ isVertical] == 0) {
				visit[x][y][1 ^ isVertical] = 1;
				q.offer(new int[] { x, y, 1 ^ isVertical, cnt + 1 });
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		map = new char[n][n];
		visit = new int[n][n][2];

		boolean findB = false;
		boolean findE = false;
		int bx = 0, by = 0, ex = 0, ey = 0;
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < n && (!findB || !findE); j++) {
				if (!findB && map[i][j] == 'B') {
					findB = true;
					bx = i;
					by = j;
				}
				if (!findE && map[i][j] == 'E') {
					findE = true;
					ex = i;
					ey = j;
				}
			}
		}

		// 통나무의 중심점 찾기
		if (bx + 1 < n && map[bx + 1][by] == 'B') {
			// 세로 모양
			btree = new int[] { bx + 1, by, 0 };
			map[bx][by] = '0';
			map[bx + 1][by] = '0';
			map[bx + 2][by] = '0';
		} else if (by + 1 < n && map[bx][by + 1] == 'B') {
			// 가로모양
			btree = new int[] { bx, by + 1, 1 };
			map[bx][by] = '0';
			map[bx][by + 1] = '0';
			map[bx][by + 2] = '0';
		}

		// 목표지점 중심점 찾기
		if (ex + 1 < n && map[ex + 1][ey] == 'E') {
			// 세로 모양
			goal = new int[] { ex + 1, ey, 0 };
			map[ex][ey] = '0';
			map[ex + 1][ey] = '0';
			map[ex + 2][ey] = '0';
		} else if (ey + 1 < n && map[ex][ey + 1] == 'E') {
			// 가로 모양
			goal = new int[] { ex, ey + 1, 1 };
			map[ex][ey] = '0';
			map[ex][ey + 1] = '0';
			map[ex][ey + 2] = '0';
		}

		answer = Integer.MAX_VALUE;
		bfs();
		System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);

		br.close();
	}
}