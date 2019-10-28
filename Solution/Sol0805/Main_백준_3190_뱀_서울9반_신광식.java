package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 기출_3190_신광식 {
	static int n, k, l, endTime = 0, dir = 3;
	static char[][] board;
	static ArrayList<Snake> snake;
	static int[] time;
	static char[] direction;
	// 상하좌우
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	// 뱀의 좌표를 저장할 클래스
	static class Snake {
		int x, y;

		Snake(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int getDir(int before, char dir) {
		// 0:상, 1:하, 2:좌, 3:우
		if (dir == 'L') {
			if (before == 0)
				return 2;
			if (before == 1)
				return 3;
			if (before == 2)
				return 1;
			else
				return 0;
		} else {
			if (before == 0)
				return 3;
			else if (before == 1)
				return 2;
			else if (before == 2)
				return 0;
			else
				return 1;
		}
	}

	static void moveSnake() {
		// 뱀의 머리 좌표 (x, y), 꼬리 좌표 (backX, backY)
		int x = 0, y = 0, backX, backY;
		for (int i = 0; i < time.length;) {
			// 시작 위치에 머리(H)표시, 큐에 추가
			board[x][y] = 'H';
			snake.add(new Snake(x, y));
			while (true) {
				// 뱀의 머리 이동
				// backX, backY에 움직이기 전의 머리 좌표 저장
				endTime++;
				backX = x;
				backY = y;
				x += dx[dir];
				y += dy[dir];

				// 범위를 벗어나거나 자신의 몸을 만나면 끝
				if (x >= n || x < 0 || y >= n || y < 0 || board[x][y] == 'B')
					return;
				// 사과를 만나면 몸을 추가
				if (board[x][y] == 'A') {
					snake.add(new Snake(x, y));
					board[x][y] = 'H';
					board[backX][backY] = 'B';
				} else {
					// 사과가 아니면 이동 => 머리를 다음칸으로 이동시키고, 몸을 당겨오기
					// 1. 머리만 있으면, 머리만 이동시키고 이전 칸을 빈칸으로
					// 2. 몸이 있으면, 머리를 이동시키고 움직이기전 자리에 B표시, 꼬리(큐의 맨앞)를 빈칸으로
					snake.add(new Snake(x, y));
					board[x][y] = 'H';
					if (snake.size() > 1) {
						board[backX][backY] = 'B';
						backX = snake.get(0).x;
						backY = snake.get(0).y;
					}
					board[backX][backY] = ' ';
					snake.remove(0);
				}
				// 현재 이동한 시간이 방향을 바꿀 시간이면 방향 바꿈
				if (endTime == time[i % l]) {
					dir = getDir(dir, direction[i++]);
				}
			}
		}
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		board = new char[n][n];
		k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			board[x][y] = 'A';
		}

		l = Integer.parseInt(br.readLine());
		time = new int[l];
		direction = new char[l];
		for (int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			char d = st.nextToken().charAt(0);
			time[i] = c;
			direction[i] = d;
		}
		snake = new ArrayList<>();
		moveSnake();
		System.out.println(endTime);
		br.close();
	}

}
