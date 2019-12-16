package boj.Sol1212;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_백준_15683_감시_서울9반_신광식 {
	static int n, m, answer;
	static int[][] map, cntMap;
	static ArrayList<int[]> cctv;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static void setMap(int x, int y, int dir) {
		int nx = x;
		int ny = y;
		while (true) {
			nx += dx[dir];
			ny += dy[dir];
			if (nx < 0 || nx >= n || ny < 0 || ny >= m || map[nx][ny] == 6)
				break;
			if (cntMap[nx][ny] != -1)
				cntMap[nx][ny]++;
		}
	}

	static void resetMap(int x, int y, int dir) {
		int nx = x;
		int ny = y;
		while (true) {
			nx += dx[dir];
			ny += dy[dir];
			if (nx < 0 || nx >= n || ny < 0 || ny >= m || map[nx][ny] == 6)
				break;
			if (cntMap[nx][ny] != -1)
				cntMap[nx][ny]--;
		}
	}

	static void dfs(int num) {
		if (num == cctv.size()) {
			int minVal = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (cntMap[i][j] == 0)
						minVal++;
				}
			}
			answer = Math.min(answer, minVal);
			return;
		}
		int cctvX = cctv.get(num)[0];
		int cctvY = cctv.get(num)[1];
		int cctvNum = cctv.get(num)[2];
		if (cctvNum == 1) {
			// 상
			setMap(cctvX, cctvY, 0);
			dfs(num + 1);
			resetMap(cctvX, cctvY, 0);
			// 하
			setMap(cctvX, cctvY, 1);
			dfs(num + 1);
			resetMap(cctvX, cctvY, 1);
			// 좌
			setMap(cctvX, cctvY, 2);
			dfs(num + 1);
			resetMap(cctvX, cctvY, 2);
			// 우
			setMap(cctvX, cctvY, 3);
			dfs(num + 1);
			resetMap(cctvX, cctvY, 3);
		} else if (cctvNum == 2) {
			// 상하
			setMap(cctvX, cctvY, 0);
			setMap(cctvX, cctvY, 1);
			dfs(num + 1);
			resetMap(cctvX, cctvY, 0);
			resetMap(cctvX, cctvY, 1);
			// 좌우
			setMap(cctvX, cctvY, 2);
			setMap(cctvX, cctvY, 3);
			dfs(num + 1);
			resetMap(cctvX, cctvY, 2);
			resetMap(cctvX, cctvY, 3);
		} else if (cctvNum == 3) {
			// 상우
			setMap(cctvX, cctvY, 0);
			setMap(cctvX, cctvY, 3);
			dfs(num + 1);
			resetMap(cctvX, cctvY, 0);
			resetMap(cctvX, cctvY, 3);
			// 우하
			setMap(cctvX, cctvY, 3);
			setMap(cctvX, cctvY, 1);
			dfs(num + 1);
			resetMap(cctvX, cctvY, 3);
			resetMap(cctvX, cctvY, 1);
			// 하좌
			setMap(cctvX, cctvY, 1);
			setMap(cctvX, cctvY, 2);
			dfs(num + 1);
			resetMap(cctvX, cctvY, 1);
			resetMap(cctvX, cctvY, 2);
			// 좌상
			setMap(cctvX, cctvY, 2);
			setMap(cctvX, cctvY, 0);
			dfs(num + 1);
			resetMap(cctvX, cctvY, 2);
			resetMap(cctvX, cctvY, 0);
		} else if (cctvNum == 4) {
			// 좌상우
			setMap(cctvX, cctvY, 2);
			setMap(cctvX, cctvY, 0);
			setMap(cctvX, cctvY, 3);
			dfs(num + 1);
			resetMap(cctvX, cctvY, 2);
			resetMap(cctvX, cctvY, 0);
			resetMap(cctvX, cctvY, 3);
			// 상우하
			setMap(cctvX, cctvY, 0);
			setMap(cctvX, cctvY, 3);
			setMap(cctvX, cctvY, 1);
			dfs(num + 1);
			resetMap(cctvX, cctvY, 0);
			resetMap(cctvX, cctvY, 3);
			resetMap(cctvX, cctvY, 1);
			// 우하좌
			setMap(cctvX, cctvY, 3);
			setMap(cctvX, cctvY, 1);
			setMap(cctvX, cctvY, 2);
			dfs(num + 1);
			resetMap(cctvX, cctvY, 3);
			resetMap(cctvX, cctvY, 1);
			resetMap(cctvX, cctvY, 2);
			// 하좌상
			setMap(cctvX, cctvY, 1);
			setMap(cctvX, cctvY, 2);
			setMap(cctvX, cctvY, 0);
			dfs(num + 1);
			resetMap(cctvX, cctvY, 1);
			resetMap(cctvX, cctvY, 2);
			resetMap(cctvX, cctvY, 0);
		} else if (cctvNum == 5) {
			// 상하좌우
			setMap(cctvX, cctvY, 0);
			setMap(cctvX, cctvY, 1);
			setMap(cctvX, cctvY, 2);
			setMap(cctvX, cctvY, 3);
			dfs(num + 1);
			resetMap(cctvX, cctvY, 0);
			resetMap(cctvX, cctvY, 1);
			resetMap(cctvX, cctvY, 2);
			resetMap(cctvX, cctvY, 3);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		cntMap = new int[n][m];
		cctv = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] >= 1 && map[i][j] < 6) {
					cctv.add(new int[] { i, j, map[i][j] });
					cntMap[i][j] = -1;
				} else if (map[i][j] == 6) {
					cntMap[i][j] = -1;
				}
			}
		}
		answer = Integer.MAX_VALUE;
		dfs(0);
		System.out.println(answer);
		br.close();
	}

}
