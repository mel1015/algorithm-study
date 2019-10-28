package boj.Sol1016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_14889_스타트와링크_서울9반_신광식 {
	static int n, answer;
	static int[][] stat;
	static boolean[] visit;

	static void combi(int start, int cnt) {
		if (cnt == n / 2) {
			int teamStart = 0;
			int teamLink = 0;
			for (int i = 0; i < n; i++) {
				if (visit[i]) {
					for (int j = i; j < n; j++) {
						if (visit[j]) {
							teamStart += stat[i][j];
							teamStart += stat[j][i];
						}
					}
				} else {
					for (int j = i; j < n; j++) {
						if (!visit[j]) {
							teamLink += stat[i][j];
							teamLink += stat[j][i];
						}
					}
				}
			}
			answer = Math.min(answer, Math.abs(teamStart - teamLink));
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
		stat = new int[n][n];
		visit = new boolean[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				stat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		answer = 987654321;
		combi(0, 0);
		System.out.println(answer);
		br.close();
	}

}
