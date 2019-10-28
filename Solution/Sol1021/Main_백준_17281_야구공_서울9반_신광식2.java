package boj.Sol1021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_백준_17281_야구공_서울9반_신광식2 {
	static int n, answer;
	static int[][] inning;
	static int[] batting, visit;
	static ArrayList<Integer> runner;

	static int playBall() {
		int score = 0;
		int j = 1;
		for (int i = 0; i < n; i++) {
			int outCnt = 0;
			while (outCnt < 3) {
				int bat = inning[i][batting[j++]];
				if (bat == 0) {
					outCnt++;
				} else if (bat == 4) {
					score += runner.size() + 1;
					runner.clear();
				} else {
					int size = runner.size();
					for (int k = 0; k < size; k++) {
						int next = runner.get(k) + bat;
						if (next > 3) {
							runner.remove(k);
							score++;
							size--;
							k--;
						} else {
							runner.set(k, next);
						}
					}
					runner.add(bat);
				}
				if (j == 10)
					j = 1;
			}
			runner.clear();
		}
		return score;
	}

	static void perm(int cnt) {
		if (cnt == 10) {
			runner.clear();
			int score = playBall();
			answer = Math.max(answer, score);
			return;
		}
		for (int i = 1; i <= 9; i++) {
			if (visit[i] == 0) {
				visit[i] = 1;
				batting[i] = cnt;
				perm(cnt + 1);
				visit[i] = 0;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		inning = new int[n][10];
		batting = new int[10];
		visit = new int[10];
		runner = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= 9; j++) {
				inning[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visit[4] = 1;
		batting[4] = 1;
		answer = 0;
		perm(2);
		System.out.println(answer);
		br.close();
	}

}
