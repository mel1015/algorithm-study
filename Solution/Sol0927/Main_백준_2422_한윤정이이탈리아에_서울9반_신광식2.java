package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2422_한윤정이이탈리아에_서울9반_신광식2 {
	static int n, m, answer;
	static int[] combi;
	static boolean[] visit;
	static boolean[][] badMix;

	public static void permComb(int start, int count) {
		if (count == 3) {
			int a = combi[0];
			int b = combi[1];
			int c = combi[2];
			if (!badMix[a][b] && !badMix[b][c] && !badMix[a][c]) {
				answer++;
			}
			return;
		}

		for (int i = start; i <= n; i++) {
			if (!visit[i]) {
				visit[i] = true;
				combi[count] = i;
				permComb(i + 1, count + 1);
				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		combi = new int[m];
		visit = new boolean[n + 1];
		badMix = new boolean[n + 1][n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a > b) {
				int temp = a;
				a = b;
				b = temp;
			}
			badMix[a][b] = true;
		}
		permComb(1, 0);
		System.out.println(answer);
		br.close();
	}

}
