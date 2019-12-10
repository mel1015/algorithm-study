package jo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1841_월드컵_서울9반_신광식 {
	static int[] win, draw, lose;
	static int[] gameA = { 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4 };
	static int[] gameB = { 1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5 };

	static int dfs(int n) {
		// 마지막 경기까지 온다면 가능
		if (n >= 15) {
			return 1;
		}
		int a = gameA[n];
		int b = gameB[n];
		// a의 승리가 가능하면
		if (win[a] != 0 && lose[b] != 0) {
			win[a]--;
			lose[b]--;
			if (dfs(n + 1) == 1)
				return 1;
			win[a]++;
			lose[b]++;
		}
		// a와 b의 무승부가 가능하면
		if (draw[a] != 0 && draw[b] != 0) {
			draw[a]--;
			draw[b]--;
			if (dfs(n + 1) == 1)
				return 1;
			draw[a]++;
			draw[b]++;
		}
		// b의 승리가 가능하면
		if (lose[a] != 0 && win[b] != 0) {
			lose[a]--;
			win[b]--;
			if (dfs(n + 1) == 1)
				return 1;
			lose[a]++;
			win[b]++;
		}
		return 0;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		win = new int[6];
		draw = new int[6];
		lose = new int[6];
		for (int tc = 0; tc < 4; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int winCnt = 0, drawCnt = 0, loseCnt = 0;
			for (int i = 0; i < 6; i++) {
				winCnt += win[i] = Integer.parseInt(st.nextToken());
				drawCnt += draw[i] = Integer.parseInt(st.nextToken());
				loseCnt += lose[i] = Integer.parseInt(st.nextToken());
			}
			if (winCnt + drawCnt + loseCnt != 30) {
				System.out.print(0 + " ");
			} else {
				int answer = dfs(0);
				System.out.print(answer + " ");
			}
		}
		br.close();
	}

}
