package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_15684_사다리조작_서울9반_신광식 {
	public static int n, m, h, answer;
	public static int[][] map;

	public static boolean ladder() {
		// 시작 번호 startLine과 이동한 번호 col이 같으면 true 리턴
		boolean isSame = true;
		for (int startLine = 1; startLine < n; startLine++) {
			int row = 0;
			int col = startLine;
			while (row < h) {
				row++;
				if (map[row][col] == 1) {
					col++;
				} else if (map[row][col - 1] == 1) {
					col--;
				}
			}
			if (startLine != col) {
				isSame = false;
				break;
			}
		}
		return isSame;
	}

	public static void dfs(int cnt) {
		// 3회 초과하면 리턴
		if (cnt > 3)
			return;
		if (ladder()) {
			answer = Math.min(answer, cnt);
			return;
		}
		// 판별 후 사다리를 놓은게 3번이면 리턴
		if (cnt == 3)
			return;

		for (int col = 1; col < n; col++) {
			for (int row = 1; row <= h; row++) {
				if (map[row][col] == 1 || map[row][col - 1] == 1 || map[row][col + 1] == 1)
					continue;
				map[row][col] = 1;
				dfs(cnt + 1);
				map[row][col] = 0;

				// 같은 열에 반복해서 놓을 필요 X
				// 따라서 좌우로 이동할 가능성이 있는 상황에만 새로운 사다리 놓기
				while (true) {
					if (row >= h || map[row + 1][col + 1] == 1 || map[row + 1][col - 1] == 1)
						break;
					row++;
				}
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		map = new int[h + 1][n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
		}
		answer = Integer.MAX_VALUE;
		dfs(0);
		System.out.println((answer > 3) ? -1 : answer);
		br.close();
	}

}
