package boj.Sol1014;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_백준_16954_움직이는미로탈출_서울9반_신광식 {
	static int answer;
	static char[][] map;
	static boolean[][][] visit;
	static int[] dx = { -1, -1, -1, 0, 0, 0, 1, 1, 1 };
	static int[] dy = { -1, 0, 1, 1, 0, -1, -1, 0, 1 };

	static void dropMap() {
		for (int i = 7; i >= 1; i--) {
			map[i] = map[i - 1].clone();
		}
		Arrays.fill(map[0], '.');
	}

	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 7, 0, 0 });
		visit[7][0][0] = true;
		int time = 0;
		while (!q.isEmpty()) {
			int[] curr = q.poll();

			if ((curr[0] == 0 && curr[1] == 7) | (time >= 7 && curr[0] < 7)) {
				answer = 1;
				return;
			} else if (map[curr[0]][curr[1]] == '#') {
				if (q.isEmpty() || curr[2] != q.peek()[2]) {
					dropMap();
				}
				continue;
			}
			for (int d = 0; d < dx.length; d++) {
				int nx = curr[0] + dx[d];
				int ny = curr[1] + dy[d];
				if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8 && map[nx][ny] == '.') {
					if (!visit[nx][ny][curr[2] + 1]) {
						visit[nx][ny][curr[2] + 1] = true;
						q.add(new int[] { nx, ny, curr[2] + 1 });
					}
				}
			}
			if (q.isEmpty() || curr[2] != q.peek()[2]) {
				dropMap();
				time++;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[8][8];
		visit = new boolean[8][8][15];
		for (int i = 0; i < 8; i++) {
			map[i] = br.readLine().toCharArray();
		}
		answer = 0;
		bfs();
		System.out.println(answer);
		br.close();
	}

}
