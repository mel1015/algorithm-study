package boj.Sol1023;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_백준_17780_새로운게임_서울9반_신광식 {
	static int n, k;
	static int[][] colorMap;
	static Mal[][] map;
	static ArrayList<Mal> mals;
	static int[] dx = { 0, 0, 0, -1, 1 };
	static int[] dy = { 0, 1, -1, 0, 0 };

	static class Mal {
		int x;
		int y;
		int dir;
		boolean bottom;
		StringBuilder up;

		public Mal(int x, int y, int dir, boolean bottom, StringBuilder up) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.bottom = bottom;
			this.up = up;
		}
	}

	static void move(Mal currMal, int nx, int ny) {
		map[currMal.x][currMal.y] = null;
		currMal.x = nx;
		currMal.y = ny;
		if (map[nx][ny] == null) {
			map[nx][ny] = currMal;
		} else {
			currMal.bottom = false;
			map[nx][ny].up.append(currMal.up);
		}
		if (currMal.up.length() > 1) {
			for (int j = 0; j < currMal.up.length(); j++) {
				int num = currMal.up.charAt(j) - '0';
				mals.get(num).x = nx;
				mals.get(num).y = ny;
			}
		}
	}

	static void moveAndReverse(Mal currMal, int nx, int ny) {
		map[currMal.x][currMal.y] = null;
		currMal.x = nx;
		currMal.y = ny;
		currMal.bottom = false;
		currMal.up.reverse();
		mals.get(currMal.up.charAt(0) - '0').bottom = true;
		mals.get(currMal.up.charAt(0) - '0').up = currMal.up;
		if (map[nx][ny] == null) {
			map[nx][ny] = currMal;
		} else {
			mals.get(currMal.up.charAt(0) - '0').bottom = false;
			map[nx][ny].up.append(currMal.up);
		}
		if (currMal.up.length() > 1) {
			for (int j = 0; j < currMal.up.length(); j++) {
				int num = currMal.up.charAt(j) - '0';
				mals.get(num).x = nx;
				mals.get(num).y = ny;
			}
		}
	}

	static void backMove(Mal currMal) {
		if (currMal.dir == 1 || currMal.dir == 3)
			currMal.dir++;
		else
			currMal.dir--;
		int nx = currMal.x + dx[currMal.dir];
		int ny = currMal.y + dy[currMal.dir];
		if (nx <= 0 || nx > n || ny <= 0 || ny > n) {
			map[currMal.x][currMal.y] = currMal;
		} else if (nx > 0 && nx <= n && ny > 0 && ny <= n) {
			if (colorMap[nx][ny] == 2) {
				map[currMal.x][currMal.y] = currMal;
			} else if (colorMap[nx][ny] == 0) {
				move(currMal, nx, ny);
			} else if (colorMap[nx][ny] == 1) {
				moveAndReverse(currMal, nx, ny);
			}
		}
	}

	static boolean playGame() {
		for (int i = 0; i < mals.size(); i++) {
			Mal currMal = mals.get(i);
			if (!currMal.bottom)
				continue;
			if (currMal.up.length() >= 4)
				return true;
			int nx = currMal.x + dx[currMal.dir];
			int ny = currMal.y + dy[currMal.dir];
			if (nx > 0 && nx <= n && ny > 0 && ny <= n) {
				if (colorMap[nx][ny] == 0) {
					move(currMal, nx, ny);
				} else if (colorMap[nx][ny] == 1) {
					moveAndReverse(currMal, nx, ny);
				} else if (colorMap[nx][ny] == 2) {
					backMove(currMal);
				}
			} else {
				backMove(currMal);
			}
			// 말이 4개 쌓였으면 리턴
			for (int j = 0; j < mals.size(); j++) {
				if (mals.get(j).bottom && mals.get(j).up.length() >= 4)
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		colorMap = new int[n + 1][n + 1];
		map = new Mal[n + 1][n + 1];
		mals = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				colorMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			Mal mal = new Mal(x, y, dir, true, new StringBuilder(i + ""));
			mals.add(mal);
			map[x][y] = mal;
		}
		int turn = 0;
		boolean end = false;
		while (turn < 1010 && !end) {
			turn++;
			end = playGame();
		}
		System.out.println((turn > 1000) ? -1 : turn);
		br.close();
	}

}
