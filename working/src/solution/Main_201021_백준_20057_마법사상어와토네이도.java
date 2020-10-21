package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_201021_백준_20057_마법사상어와토네이도 {
	static int n, answer;
	static int[][] map;
	// 방향 => 좌, 하, 우, 상
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { -1, 0, 1, 0 };
	// 좌하우상 순으로 토네이도가 이동할 때, 모래가 이동할 좌표와 퍼센트
	static int[][][] ratio = {
			{ { -2, 0, 2 }, { -1, -1, 10 }, { -1, 0, 7 }, { -1, 1, 1 }, { 0, -2, 5 }, { 1, -1, 10 }, { 1, 0, 7 },
					{ 1, 1, 1 }, { 2, 0, 2 } },
			{ { -1, -1, 1 }, { -1, 1, 1 }, { 0, -2, 2 }, { 0, -1, 7 }, { 0, 1, 7 }, { 0, 2, 2 }, { 1, -1, 10 },
					{ 1, 1, 10 }, { 2, 0, 5 } },
			{ { -2, 0, 2 }, { -1, -1, 1 }, { -1, 0, 7 }, { -1, 1, 10 }, { 0, 2, 5 }, { 1, -1, 1 }, { 1, 0, 7 },
					{ 1, 1, 10 }, { 2, 0, 2 } },
			{ { -2, 0, 5 }, { -1, -1, 10 }, { -1, 1, 10 }, { 0, -2, 2 }, { 0, -1, 7 }, { 0, 1, 7 }, { 0, 2, 2 },
					{ 1, -1, 1 }, { 1, 1, 1 } } };

	// 토네이도가 이동한 좌표와 방향을 받고
	// 주변에 모래를 더해줌
	// 범위에 벗어난다면 정담에 더해줌
	static void makeMap(int r, int c, int dir) {
		int sum = 0;
		for (int i = 0; i < ratio[dir].length; i++) {
			int nr = r + ratio[dir][i][0];
			int nc = c + ratio[dir][i][1];
			int add = (map[r][c] * ratio[dir][i][2]) / 100;
			if (add > 0) {
				sum += add;
				if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
					map[nr][nc] += add;
				} else {
					answer += add;
//					System.out.println("(" + r + ", " + c + ") => (" + nr + ", " + nc + ") ==> " + add
//							+ " added, answer = " + answer);
				}
			}
		}
		int nr = r + dr[dir];
		int nc = c + dc[dir];
		int add = map[r][c] - sum;
		if (add > 0) {
			if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
				map[nr][nc] += add;
			} else {
				answer += add;
//				System.out.println("(" + r + ", " + c + ") => (" + nr + ", " + nc + ") ==> " + add
//						+ " added, answer = " + answer);
			}
		}
		map[r][c] = 0;
	}

	static void printMap(int[][] pMap) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(pMap[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		answer = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 달팽이 모양 지도 그리기
		// (좌 하), (우 우 상 상), (좌 좌 좌 하 하 하), ... 
		int mid = n / 2;
		int mapCnt = (n * n) - 1;
		int dir = 0;
		int cntDir = 1;
		int nr = mid;
		int nc = mid;
		while (mapCnt > 0) {
			for (int j = 0; j < cntDir && mapCnt > 0; j++) {
				nr += dr[dir];
				nc += dc[dir];
				if (map[nr][nc] != 0)
					makeMap(nr, nc, dir);
//				printMap(map);
				mapCnt--;
			}
			dir = (dir + 1) % 4;
			for (int j = 0; j < cntDir && mapCnt > 0; j++) {
				nr += dr[dir];
				nc += dc[dir];
				if (map[nr][nc] != 0)
					makeMap(nr, nc, dir);
//				printMap(map);
				mapCnt--;
			}
			dir = (dir + 1) % 4;
			cntDir++;
		}
		System.out.println(answer);
		br.close();
	}

}
