package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_200701_백준_19236_청소년상어 {
	static int n, answer;
	static int[][] map;
	static Fish[] fishArr;
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };

	static class Fish {
		int x;
		int y;
		int dir;
		boolean isDead;

		public Fish(int x, int y, int dir, boolean isDead) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.isDead = isDead;
		}

		public Fish(Fish fish) {
			this.x = fish.x;
			this.y = fish.y;
			this.dir = fish.dir;
			this.isDead = fish.isDead;
		}

		@Override
		public String toString() {
			return "Fish [x=" + x + ", y=" + y + ", dir=" + dir + ", isDead=" + isDead + "]";
		}

	}

	static void copyState(int[][] beforeMap, int[][] changeMap, Fish[] beforeFishArr, Fish[] changeFishArr) {
		for (int i = 0; i < n; i++) {
			changeMap[i] = beforeMap[i].clone();
		}
		for (int i = 1; i <= 16; i++) {
			changeFishArr[i] = new Fish(beforeFishArr[i]);
		}
	}

	static void fishMove() {
		for (int i = 1; i < 17; i++) {
			if (fishArr[i].isDead)
				continue;
			int x = fishArr[i].x;
			int y = fishArr[i].y;
			int dir = fishArr[i].dir;

			for (int d = 0; d < dx.length; d++) {
				int nd = (dir + d) % 8;
				int nx = x + dx[nd];
				int ny = y + dy[nd];
				// map의 값이 -1 => 상어가 있는 자리
				if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] != -1) {
					// map의 값이 0 => 빈 공간
					if (map[nx][ny] == 0) {
						map[nx][ny] = i;
						map[x][y] = 0;
						fishArr[i].x = nx;
						fishArr[i].y = ny;
						fishArr[i].dir = nd;
					} else {
						// 다른 물고기와 자리 변경
						fishArr[map[nx][ny]].x = x;
						fishArr[map[nx][ny]].y = y;
						map[x][y] = map[nx][ny];
						map[nx][ny] = i;
						fishArr[i].x = nx;
						fishArr[i].y = ny;
						fishArr[i].dir = nd;
					}
					break;
				}
			}
		}
	}

	static void dfs(int sharkX, int sharkY, int sharkD, int sum) {
		answer = Math.max(answer, sum);
		int[][] cMap = new int[n][n];
		Fish[] cFishArr = new Fish[17];
		// 현재 상태 복사
		copyState(map, cMap, fishArr, cFishArr);
		fishMove();

		for (int i = 1; i <= 3; i++) {
			int nx = sharkX + dx[sharkD] * i;
			int ny = sharkY + dy[sharkD] * i;
			if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
				if (map[nx][ny] == 0)
					continue;
				int fishNum = map[nx][ny];
				int nDir = fishArr[fishNum].dir;

				// 상어 이동
				map[sharkX][sharkY] = 0;
				map[nx][ny] = -1;
				fishArr[fishNum].isDead = true;
				dfs(nx, ny, nDir, sum + fishNum);
				// 백트래킹
				map[sharkX][sharkY] = -1;
				map[nx][ny] = fishNum;
				fishArr[fishNum].isDead = false;
			}
		}
		// 이전 상태로 되돌리기
		copyState(cMap, map, cFishArr, fishArr);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = 4;
		map = new int[n][n];
		fishArr = new Fish[17];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken()) - 1;
				map[i][j] = num;
				fishArr[num] = new Fish(i, j, dir, false);
			}
		}
		int num = map[0][0];
		int dir = fishArr[num].dir;
		fishArr[num].isDead = true;
		map[0][0] = -1;

		dfs(0, 0, dir, num);
		System.out.println(answer);

		br.close();
	}

}
