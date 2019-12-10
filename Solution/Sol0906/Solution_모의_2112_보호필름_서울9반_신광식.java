package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution_모의_2112_보호필름_서울9반_신광식 {
	public static int d, w, k, answer;
	public static int[][] film, copyMap;
	public static boolean[] visit;
	public static ArrayList<Integer> changeRow;

	public static boolean checkFilm() {
		boolean accept = true;
		for (int col = 0; col < w; col++) {
			int prev = copyMap[0][col], cnt = 1, maxCnt = 0;
			for (int row = 1; row < d; row++) {
				if (prev == copyMap[row][col]) {
					cnt++;
					if (cnt >= k) {
						maxCnt = cnt;
						break;
					}
				} else {
					maxCnt = Math.max(maxCnt, cnt);
					cnt = 1;
					prev = copyMap[row][col];
				}
			}
			if (maxCnt < k) {
				accept = false;
				break;
			}
		}
		return accept;
	}

	public static void dfs(int start, int cnt) {
		if (checkFilm()) {
			answer = Math.min(answer, cnt);
			return;
		}
		if (cnt >= k - 1)
			return;
		for (int i = start; i < d; i++) {
			if (!visit[i]) {
				visit[i] = true;
				Arrays.fill(copyMap[i], 0);
				dfs(i + 1, cnt + 1);
				Arrays.fill(copyMap[i], 1);
				dfs(i + 1, cnt + 1);
				visit[i] = false;
				copyMap[i] = film[i].clone();
			}
		}
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_mo_2112.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			d = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			film = new int[d][w];
			visit = new boolean[d];
			copyMap = new int[d][w];
			changeRow = new ArrayList<>();
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < w; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
					copyMap[i][j] = film[i][j];
				}
			}
			answer = k;
			dfs(0, 0);
			System.out.println("#" + tc + " " + answer);
		}
		br.close();
	}

}
