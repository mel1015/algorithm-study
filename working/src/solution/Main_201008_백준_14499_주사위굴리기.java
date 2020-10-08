package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_201008_백준_14499_주사위굴리기 {
	static int n, m, k;
	static int[][] map;
	static int[] dice = { 0, 0, 0, 0, 0, 0 };
	static int[] dx = { 0, 0, 0, -1, 1 };
	static int[] dy = { 0, 1, -1, 0, 0 };

	static void diceMove(int dir) {
		// dice 배열
		// (0, 뒤), (1, 위),(2, 앞), (3, 아래), (4, 좌), (5, 우)
		// 방향 1, 2, 3, 4 => 동, 서, 북, 남

		int temp = 0;
		if (dir == 1) {
			// 동쪽 => 위,아래,좌,우 변경
			temp = dice[1];
			dice[1] = dice[4];
			dice[4] = dice[3];
			dice[3] = dice[5];
			dice[5] = temp;
		} else if (dir == 2) {
			// 서쪽 => 위,아래,좌,우 변경
			temp = dice[1];
			dice[1] = dice[5];
			dice[5] = dice[3];
			dice[3] = dice[4];
			dice[4] = temp;
		} else if (dir == 3) {
			// 북쪽 => 위,앞,아래,뒤 변경
			temp = dice[1];
			dice[1] = dice[2];
			dice[2] = dice[3];
			dice[3] = dice[0];
			dice[0] = temp;
		} else {
			// 남쪽 => 위,앞,아래,뒤 변경
			temp = dice[1];
			dice[1] = dice[0];
			dice[0] = dice[3];
			dice[3] = dice[2];
			dice[2] = temp;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			int dir = Integer.parseInt(st.nextToken());
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if (nx < 0 || nx >= n || ny < 0 || ny >= m)
				continue;
			x = nx;
			y = ny;

			// 주사위 굴림
			diceMove(dir);
			
			// 이동한 칸의 데이터에 따라 조건 처리
			int mapData = map[nx][ny];
			if (mapData == 0) {
				map[nx][ny] = dice[3];
			} else {
				dice[3] = mapData;
				map[nx][ny] = 0;
			}
			System.out.println(dice[1]);
		}
		br.close();
	}
}