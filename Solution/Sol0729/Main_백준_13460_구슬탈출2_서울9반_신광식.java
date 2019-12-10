package boj;

import java.util.Scanner;

public class 기출_13460_신광식 {

	public static int N, M, answer;
	public static char[][] map;
	// 방향 => 0:우, 1:하, 2:좌, 3:상
	public static int[] dx = { 0, 1, 0, -1 };
	public static int[] dy = { 1, 0, -1, 0 };
	public static Point hole;

	// 특정 좌표(구슬 ,구멍) 저장할 클래스
	static class Point {
		int x, y;

		Point() {

		}

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	// 방향 변경을 위한 메소드
	// 이전 기울인 방향이 오른쪽이면 왼쪽으로 기울일 필요가 없음 => 원위치
	public static int getDir(int dir, int i) {
		// 이전 기울인 방향이 오른쪽이나 왼쪽일 때
		if (dir == 0 || dir == 2) {
			// 추가 매개변수 i를 통해 다음 방향을 위나 아래로
			if (i == 0)
				return 1;
			else
				return 3;
		} else {
			// 이전 기울인 방향이 위쪽이나 아래쪽일 때
			// 추가 매개변수 i를 통해 다음 방향을 오론쪽이나 왼쪽으로
			if (i == 0)
				return 0;
			else
				return 2;
		}
	}

	public static void dfs(Point red, Point blue, int dir, int count) {
		// 10번 넘어가면 실패
		if (count > 10)
			return;

		// 방향은 2방향만 탐색하면 된다
		// 이전이 위쪽이거나 아래쪽 => 다음 기울일 방향은 오른쪽이나 왼쪽
		for (int i = 0; i < 2; i++) {
			// 빨간 구슬, 파란 구슬의 좌표 가져오기
			// 이동한 거리를 저장할 Count 변수
			int rx = red.x, ry = red.y;
			int bx = blue.x, by = blue.y;
			int rCount = 0, bCount = 0;

			// 빨간 구슬 굴리기
			while (true) {
				rx += dx[dir];
				ry += dy[dir];
				rCount++;
				if (map[rx][ry] == 'O') {
					break;
				}
				if (map[rx][ry] != '.') {
					rx -= dx[dir];
					ry -= dy[dir];
					rCount--;
					break;
				}
			}
			// 파란 구슬 굴리기
			while (true) {
				bx += dx[dir];
				by += dy[dir];
				bCount++;
				if (map[bx][by] == 'O') {
					break;
				}
				if (map[bx][by] != '.') {
					bx -= dx[dir];
					by -= dy[dir];
					bCount--;
					break;
				}
			}

			// 공 위치 판단
			if (bx == hole.x && by == hole.y)
				// 파란공이 먼저 들어가든 같이 들어가든 실패
				return;
			else if (rx == bx && ry == by) {
				// 이동한 위치가 같을 때 => 이동한 거리가 작은애가 먼저 그 위치에 도달함
				if (rCount > bCount) {
					rx -= dx[dir];
					ry -= dy[dir];
				} else {
					bx -= dx[dir];
					by -= dy[dir];
				}
			} else if (rx == hole.x && ry == hole.y) {
				// 빨간공만 구멍에 도착했을 때, 기울인 횟수 중 최소값으로 변경
				answer = Math.min(answer, count);
			}

			// 새로운 위치에서 다음 방향으로 구슬 굴리기
			Point nRed = new Point(rx, ry);
			Point nBlue = new Point(bx, by);
			dfs(nRed, nBlue, getDir(dir, i), count + 1);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();
		map = new char[N][M];
		Point red = null, blue = null;

		for (int i = 0; i < N; i++) {
			String line = sc.nextLine();
			map[i] = line.toCharArray();
			for (int j = 0; j < map[i].length; j++) {
				// 각 구슬의 위치를 Point 클래스로 저장하고
				// 이동가능한 위치('.')로 변경
				if (map[i][j] == 'R') {
					red = new Point(i, j);
					map[i][j] = '.';
				} else if (map[i][j] == 'B') {
					blue = new Point(i, j);
					map[i][j] = '.';
				} else if (map[i][j] == 'O') {
					hole = new Point(i, j);
				}
			}
		}

		answer = Integer.MAX_VALUE;
		for (int i = 0; i < 4; i++) {
			dfs(red, blue, i, 1);
		}
		System.out.println((answer == Integer.MAX_VALUE) ? -1 : answer);
		sc.close();
	}
}
