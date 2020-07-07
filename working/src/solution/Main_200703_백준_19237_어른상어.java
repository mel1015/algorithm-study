package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_200703_백준_19237_어른상어 {
	static int n, m, k, answer;
	static ArrayList<Integer>[][] map;
	static Pair[][] smellMap;
	static Shark[] sharks;
	static int[][][] priority;
	static int[] dx = { 0, -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 0, -1, 1 };

	static class Shark {
		int x;
		int y;
		int num;
		int dir;
		boolean isDead;

		public Shark(int x, int y, int num, int dir, boolean isDead) {
			this.x = x;
			this.y = y;
			this.num = num;
			this.dir = dir;
			this.isDead = isDead;
		}
	}

	static class Pair {
		int num;
		int timeLeft;

		public Pair(int num, int timeLeft) {
			this.num = num;
			this.timeLeft = timeLeft;
		}

		@Override
		public String toString() {
			return "(" + num + "," + timeLeft + ")";
		}
	}

	// 상어 이동
	static void sharkMove() {
		for (int i = 1; i < sharks.length; i++) {
			if (sharks[i].isDead)
				continue;
			int x = sharks[i].x;
			int y = sharks[i].y;
			int num = sharks[i].num;
			int dir = sharks[i].dir;

			boolean canMove = false;
			for (int d = 1; d <= 4; d++) {
				int nx = x;
				int ny = y;
				// 상어는 우선순위를 가지고 움직임
				int ndir = priority[num][dir][d];
				nx += dx[ndir];
				ny += dy[ndir];

				if (nx >= 0 && nx < n && ny >= 0 && ny < n && smellMap[nx][ny] == null) {
					map[nx][ny].add(num);
					map[x][y].remove((Integer) num);
					sharks[i].dir = ndir;
					sharks[i].x = nx;
					sharks[i].y = ny;
					canMove = true;
					break;
				}
			}

			if (!canMove) {
				for (int d = 1; d <= 4; d++) {
					int ndir = priority[num][dir][d];
					int nx = x + dx[ndir];
					int ny = y + dy[ndir];
					if (nx >= 0 && nx < n && ny >= 0 && ny < n && smellMap[nx][ny].num == sharks[i].num) {
						map[nx][ny].add(num);
						map[x][y].remove((Integer) num);
						sharks[i].dir = ndir;
						sharks[i].x = nx;
						sharks[i].y = ny;
						break;
					}
				}
			}
		}
	}

	static void sharkRunAway() {
		for (int i = 1; i < sharks.length; i++) {
			if (sharks[i].isDead)
				continue;
			int x = sharks[i].x;
			int y = sharks[i].y;
			if (map[x][y].size() > 1) {
				Collections.sort(map[x][y]);
				for (int j = 1; j < map[x][y].size(); j++) {
					sharks[map[x][y].get(j)].isDead = true;
					m--;
				}
				int remainNum = map[x][y].get(0);
				map[x][y].clear();
				map[x][y].add(remainNum);
			}
		}
	}

	static void sharkSmell() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (smellMap[i][j] != null) {
					smellMap[i][j].timeLeft--;
					if (smellMap[i][j].timeLeft == 0)
						smellMap[i][j] = null;
				}
			}
		}
		for (int i = 1; i < sharks.length; i++) {
			if (sharks[i].isDead)
				continue;
			int num = sharks[i].num;
			int x = sharks[i].x;
			int y = sharks[i].y;
			smellMap[x][y] = new Pair(num, k);
		}
	}

	static void printMap() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	static void printSmellMap() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(smellMap[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new ArrayList[n][n];
		smellMap = new Pair[n][n];
		sharks = new Shark[m + 1];
		priority = new int[m + 1][5][5];

		// 맵 입력
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = new ArrayList<>();
				int num = Integer.parseInt(st.nextToken());
				if (num > 0) {
					map[i][j].add(num);
					sharks[num] = new Shark(i, j, num, 0, false);
					smellMap[i][j] = new Pair(num, k);
				}
			}
		}

		// 초기 방향
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < sharks.length; i++) {
			sharks[i].dir = Integer.parseInt(st.nextToken());
		}

		// 방향 우선순위
		for (int i = 1; i < sharks.length; i++) {
			for (int j = 1; j <= 4; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 1; k <= 4; k++) {
					priority[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}

		while (true) {
			if (m == 1)
				break;
			else if (answer >= 1000) {
				answer = -1;
				break;
			}

//			System.out.println(answer + "초 후");
//			printMap();
//			printSmellMap();

			// 상어 이동
			sharkMove();
			sharkRunAway();
			sharkSmell();

			// 시간 증가
			answer++;
		}
		System.out.println(answer);

		br.close();
	}

}
