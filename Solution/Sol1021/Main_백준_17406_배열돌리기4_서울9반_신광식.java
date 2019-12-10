package boj.Sol1021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_백준_17406_배열돌리기4_서울9반_신광식 {
	static int n, m, k, answer;
	static int[][] map, copyMap;
	static int[] visit, arr, data;
	static ArrayList<int[]> command;

	static void rotate(int r, int c, int s) {
		int fromRow = r - s;
		int fromCol = c - s;
		int toRow = r + s;
		int toCol = c + s;

		while (fromRow < toRow) {
			int temp = copyMap[fromRow][fromCol];
			for (int i = fromRow; i < toRow; i++) {
				copyMap[i][fromCol] = copyMap[i + 1][fromCol];
			}
			for (int i = fromCol; i < toCol; i++) {
				copyMap[toRow][i] = copyMap[toRow][i + 1];
			}
			for (int i = toRow; i > fromRow; i--) {
				copyMap[i][toCol] = copyMap[i - 1][toCol];
			}
			for (int i = toCol; i > fromCol; i--) {
				copyMap[fromRow][i] = copyMap[fromRow][i - 1];
			}
			copyMap[fromRow][fromCol + 1] = temp;
			fromRow++;
			fromCol++;
			toRow--;
			toCol--;
		}
	}

	static void perm(int cnt) {
		if (cnt == k) {
			for (int i = 0; i < visit.length; i++) {
				int r = command.get(visit[i] - 1)[0];
				int c = command.get(visit[i] - 1)[1];
				int s = command.get(visit[i] - 1)[2];
				rotate(r, c, s);
			}
			for (int i = 1; i <= n; i++) {
				int sum = 0;
				for (int j = 1; j <= m; j++) {
					sum += copyMap[i][j];
				}
				answer = Math.min(answer, sum);
				copyMap[i] = map[i].clone();
			}
			return;
		}
		for (int i = 0; i < k; i++) {
			if (visit[i] == 0) {
				visit[i] = cnt + 1;
				perm(cnt + 1);
				visit[i] = 0;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n + 1][m + 1];
		copyMap = new int[n + 1][m + 1];
		command = new ArrayList<>();
		visit = new int[k];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			copyMap[i] = map[i].clone();
		}
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			command.add(new int[] { r, c, s });
		}
		answer = Integer.MAX_VALUE;
		perm(0);
		System.out.println(answer);
		br.close();
	}

}
