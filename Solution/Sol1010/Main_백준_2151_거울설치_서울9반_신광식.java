package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_백준_2151_거울설치_서울9반_신광식 {
	static int n, answer;
	static char[][] map;
	static int[][][] visit;
	static ArrayList<int[]> door;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static void dfs(int x, int y, int cnt, int dir) {
		if (x == door.get(0)[0] && y == door.get(0)[1]) {
			answer = Math.min(answer, cnt);
			return;
		}
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		// visit[nx][ny][dir] > cnt + 1 => 갱신이 가능한 경우에만
		if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] != '*' && visit[nx][ny][dir] > cnt + 1) {
			if (map[nx][ny] == '!') {
				// 다음 좌표가 거울이면
				// 거울을 만들지 않고 이전 방향으로 계속 보내봄
				visit[nx][ny][dir] = cnt;
				dfs(nx, ny, cnt, dir);
				
				// 거울을 만들고 방향을 바꿔줌
				visit[nx][ny][dir] = cnt + 1;
				if (dir == 0 || dir == 1) {
					dfs(nx, ny, cnt + 1, 2);
					dfs(nx, ny, cnt + 1, 3);
				} else {
					dfs(nx, ny, cnt + 1, 0);
					dfs(nx, ny, cnt + 1, 1);
				}
			} else {
				// 거울이 아니면
				// 현재까지 cnt개의 거울을 거쳐서 도달할 수 있음
				visit[nx][ny][dir] = cnt;
				dfs(nx, ny, cnt, dir);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		door = new ArrayList<>();
		// 상하좌우 4방향에서 빛이 올 수 있으므로 n*n*4 크기의 배열 생성
		visit = new int[n][n][4];
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				// 최솟값 갱신을 위해 visit배열의 네 방향은 최대값으로
				Arrays.fill(visit[i][j], 987654321);
				if (map[i][j] == '#')
					door.add(new int[] { i, j });
			}
		}
		answer = Integer.MAX_VALUE;
		for (int i = 0; i < dx.length; i++) {
			// 시작점 0으로
			visit[door.get(1)[0]][door.get(1)[1]][i] = 0;
			dfs(door.get(1)[0], door.get(1)[1], 0, i);
		}
		System.out.println(answer);
		br.close();
	}

}
