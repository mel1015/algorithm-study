package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_2422_한윤정이이탈리아에_서울9반_신광식 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		boolean[][] badMix = new boolean[n + 1][n + 1];
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
		int answer = 0;
		for (int i = 1; i <= n - 2; i++) {
			for (int j = i + 1; j <= n - 1; j++) {
				for (int k = j + 1; k <= n; k++) {
					if (!badMix[i][j] && !badMix[j][k] && !badMix[i][k])
						answer++;
				}
			}
		}
		System.out.println(answer);
		br.close();
	}

}
