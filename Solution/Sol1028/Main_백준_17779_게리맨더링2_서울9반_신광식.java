package boj.Sol1028;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_백준_17779_게리맨더링2_서울9반_신광식 {
	static int n;
	static boolean[] visit;
	static int[][] map;
	static int[] dx = { -1, -1, 1, 1 };
	static int[] dy = { -1, 1, 1, -1 };

	static void divideMap() {

	}

	static void combi(int start, int cnt) {
		if (cnt == 2) {
			divideMap();
			return;
		}
		for (int i = start; i < n; i++) {
			if (!visit[i]) {
				visit[i] = true;
				combi(i, cnt + 1);
				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visit = new boolean[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		combi(1, 0);
		br.close();
	}

}
