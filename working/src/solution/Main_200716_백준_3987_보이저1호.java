package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_200716_백준_3987_보이저1호 {
	static int n, m, pr, pc;
	static char[][] map;
	static int[][] visit;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static int changeDir(char planet, int dir) {
		int nextDir = -1;
		if (planet == '\\') {
			if (dir == 0)
				nextDir = 3;
			else if (dir == 1)
				nextDir = 2;
			else if (dir == 2)
				nextDir = 1;
			else if (dir == 3)
				nextDir = 0;
		} else {
			if (dir == 0)
				nextDir = 1;
			else if (dir == 1)
				nextDir = 0;
			else if (dir == 2)
				nextDir = 3;
			else if (dir == 3)
				nextDir = 2;
		}
		return nextDir;
	}

	// 네 방향으로 시그널을 보내보고 시간초 계산
	// 같은 위치에 같은 방향으로 방문한 적이 있다면 루프
	static int sendSignal(int d) {
		int time = 1;
		int nx = pr;
		int ny = pc;
		int dir = d;
		visit[nx][ny] = dir;
		while (true) {
			nx += dx[dir];
			ny += dy[dir];
			if (nx < 0 || nx >= n || ny < 0 || ny >= m || map[nx][ny] == 'C')
				break;
			if (visit[nx][ny] == dir)
				return -1;
			if (map[nx][ny] == '\\' || map[nx][ny] == '/') {
				dir = changeDir(map[nx][ny], dir);
			}
			time++;
			visit[nx][ny] = dir;
		}
		return time;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		visit = new int[n][m];

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}

		st = new StringTokenizer(br.readLine());
		pr = Integer.parseInt(st.nextToken()) - 1;
		pc = Integer.parseInt(st.nextToken()) - 1;

		int answer = 0;
		char dir = 'X';
		for (int d = 0; d < dx.length; d++) {
			for (int i = 0; i < n; i++) {
				Arrays.fill(visit[i], -1);
			}
			
			// 시간 계산
			int time = sendSignal(d);
			if (time > answer) {
				answer = time;
				if (d == 0)
					dir = 'U';
				else if (d == 1)
					dir = 'R';
				else if (d == 2)
					dir = 'D';
				else if (d == 3)
					dir = 'L';
			} else if (time == -1) {
				if (d == 0)
					dir = 'U';
				else if (d == 1)
					dir = 'R';
				else if (d == 2)
					dir = 'D';
				else if (d == 3)
					dir = 'L';
				System.out.println(dir);
				System.out.println("Voyager");
				System.exit(0);
			}
		}
		System.out.println(dir);
		System.out.println(answer);

		br.close();
	}
}