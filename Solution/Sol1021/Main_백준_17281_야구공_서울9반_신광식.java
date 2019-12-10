package boj.Sol1021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_17281_야구공_서울9반_신광식 {
	static int n, answer;
	static int[][] inning;
	static int[] batting, visit;

	static int playBall() {
		Queue<Integer> q = new LinkedList<Integer>();
		int score = 0;
		int j = 0;
		for (int i = 0; i < n; i++) {
			int outCnt = 0;
			while (true) {
				j++;
				if (j > 9)
					j = 1;
				int bat = inning[i][batting[j]];
				if (bat == 0) {
					outCnt++;
					if (outCnt == 3)
						break;
				} else if (bat == 4) {
					score += q.size() + 1;
					q.clear();
				} else {
					int size = q.size();
					for (int k = 0; k < size; k++) {
						int curr = q.poll();
						int next = curr + bat;
						if (next >= 4)
							score++;
						else
							q.add(next);
					}
					q.add(bat);
				}
			}
			q.clear();
		}
		return score;
	}

	static void perm(int cnt) {
		if (cnt == 10) {
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
