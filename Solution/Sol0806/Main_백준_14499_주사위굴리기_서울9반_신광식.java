package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 기출_14499_신광식 {
	static int n, m;
	static int[][] map;
	static int[] commands;
	// 1:동, 2:서, 3:북, 4:남
	static int[] dx = { 0, 0, 0, -1, 1 };
	static int[] dy = { 0, 1, -1, 0, 0 };
	// 주사위 면의 값 => 0:위, 1:뒤, 2:우, 3:좌, 4:앞, 5:밑
	static int[] dice = { 0, 0, 0, 0, 0, 0 };

	// 각 방향으로 굴렸을 때 주사위 면의 값 변경
	static void diceChange(int dir) {
		int temp = 0;
		if (dir == 1) {
			temp = dice[0];
			dice[0] = dice[3];
			dice[3] = dice[5];
			dice[5] = dice[2];
			dice[2] = temp;
		} else if (dir == 2) {
			temp = dice[0];
			dice[0] = dice[2];
			dice[2] = dice[5];
			dice[5] = dice[3];
			dice[3] = temp;
		} else if (dir == 3) {
			temp = dice[0];
			dice[0] = dice[4];
			dice[4] = dice[5];
			dice[5] = dice[1];
			dice[1] = temp;
		} else {
			temp = dice[0];
			dice[0] = dice[1];
			dice[1] = dice[5];
			dice[5] = dice[4];
			dice[4] = temp;
		}
	}

	static void rollDice(int x, int y) {
		for (int i = 0; i < commands.length; i++) {
			int nx = x + dx[commands[i]];
			int ny = y + dy[commands[i]];
			// 범위를 벗어나면 명령 무시
			if (nx >= n || nx < 0 || ny >= m || ny < 0)
				continue;

			// 주사위 면의 값 변경, 윗면 출력
			diceChange(commands[i]);
			System.out.println(dice[0]);

			if (map[nx][ny] == 0) {
				map[nx][ny] = dice[5];
			} else {
				dice[5] = map[nx][ny];
				map[nx][ny] = 0;
			}
			x = nx;
			y = ny;
		}
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		commands = new int[k];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			commands[i] = Integer.parseInt(st.nextToken());
		}
		rollDice(x, y);
		br.close();
	}

}
