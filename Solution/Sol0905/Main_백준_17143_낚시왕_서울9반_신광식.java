package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_백준_17143_낚시왕_서울9반_신광식 {
	public static int r, c, m;
	public static Shark[][] map;
	public static ArrayList<Shark> sharks;
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, 1, -1 };

	static class Shark {
		int x;
		int y;
		int speed;
		int dir;
		int size;

		public Shark(int x, int y, int speed, int dir, int size) {
			this.x = x;
			this.y = y;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}
	}

	public static void sharkMove() {
		for (int i = 0; i < sharks.size(); i++) {
			Shark shark = sharks.get(i);
			int speed = shark.speed, nx = shark.x, ny = shark.y;
			while (speed > 0) {
				nx += dx[shark.dir];
				ny += dy[shark.dir];
				if (nx < 0) {
					shark.dir = 1;
					nx++;
					continue;
				} else if (nx > r - 1) {
					shark.dir = 0;
					nx--;
					continue;
				} else if (ny < 0) {
					shark.dir = 2;
					ny++;
					continue;
				} else if (ny > c - 1) {
					shark.dir = 3;
					ny--;
					continue;
				}
				speed--;
			}
			map[shark.x][shark.y] = null;
			shark.x = nx;
			shark.y = ny;
		}
		for (int i = 0; i < sharks.size(); i++) {
			Shark shark = sharks.get(i);
			if (map[shark.x][shark.y] == null) {
				map[shark.x][shark.y] = shark;
			} else if (map[shark.x][shark.y].size > shark.size) {
				sharks.remove(shark);
				i--;
			} else {
				sharks.remove(map[shark.x][shark.y]);
				map[shark.x][shark.y] = shark;
				i--;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new Shark[r][c];
		sharks = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int speed = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken()) - 1;
			int size = Integer.parseInt(st.nextToken());
			Shark shark = new Shark(x, y, speed, dir, size);
			sharks.add(shark);
			map[x][y] = shark;
		}
		int fisher = -1, answer = 0;
		while (fisher < c - 1) {
			fisher++;
			for (int i = 0; i < r; i++) {
				if (map[i][fisher] != null) {
					answer += map[i][fisher].size;
					sharks.remove(map[i][fisher]);
					map[i][fisher] = null;
					break;
				}
			}
			sharkMove();
		}
		System.out.println(answer);
		br.close();
	}

}
