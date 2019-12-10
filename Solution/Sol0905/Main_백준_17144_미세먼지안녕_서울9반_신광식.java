package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_17144_미세먼지안녕_서울9반_신광식 {
	public static int r, c, t, answer;
	public static int[][] map, spreadMap;
	public static int[] cleaner;
	public static int[] upDx = { -1, 0, 1, 0 };
	public static int[] upDy = { 0, 1, 0, -1 };
	public static int[] downDx = { 1, 0, -1, 0 };
	public static int[] downDy = { 0, 1, 0, -1 };

	public static void spreadDust() {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] >= 5) {
					int count = 0;
					for (int d = 0; d < 4; d++) {
						int nx = i + upDx[d];
						int ny = j + upDy[d];
						if (nx >= 0 && nx < r && ny >= 0 && ny < c && map[nx][ny] != -1) {
							spreadMap[nx][ny] += map[i][j] / 5;
							count++;
						}
					}
					map[i][j] -= (map[i][j] / 5) * count;
				}
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				map[i][j] += spreadMap[i][j];
			}
			Arrays.fill(spreadMap[i], 0);
		}
	}

	public static void cleanAir() {
		int upClean = cleaner[0];
		int downClean = cleaner[1];
		int dir = 0, row = upClean - 1, col = 0;
		answer -= map[row][col];
		while (true) {
			int nr = row + upDx[dir];
			int nc = col + upDy[dir];
			if (nr == upClean && nc == 0) {
				map[row][col] = 0;
				break;
			}
			if (nr >= 0 && nr <= upClean && nc >= 0 && nc < c) {
				map[row][col] = map[nr][nc];
				row = nr;
				col = nc;
			} else {
				dir++;
				continue;
			}
		}
		dir = 0;
		row = downClean + 1;
		col = 0;
		answer -= map[row][col];
		while (true) {
			int nr = row + downDx[dir];
			int nc = col + downDy[dir];
			if (nr == downClean && nc == 0) {
				map[row][col] = 0;
				break;
			}
			if (nr >= downClean && nr < r && nc >= 0 && nc < c) {
				map[row][col] = map[nr][nc];
				row = nr;
				col = nc;
			} else {
				dir++;
				continue;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		map = new int[r][c];
		spreadMap = new int[r][c];
		cleaner = new int[2];
		answer = 0;
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1 && cleaner[0] == 0) {
					cleaner[0] = i;
					cleaner[1] = i + 1;
				} else if (map[i][j] > 0) {
					answer += map[i][j];
				}
			}
		}
		while (t > 0) {
			spreadDust();
			cleanAir();
			t--;
		}
		System.out.println(answer);
		br.close();
	}

}
