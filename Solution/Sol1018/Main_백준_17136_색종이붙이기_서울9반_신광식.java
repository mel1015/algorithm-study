package boj.Sol1018;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_17136_색종이붙이기_서울9반_신광식 {
	static int answer, cntOne;
	static int[][] map;
	static int[] paper = { 0, 5, 5, 5, 5, 5 };

	// size만큼의 색종이를 사용할 수 있는지 확인
	public static boolean check(int r, int c, int size) {
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (map[i][j] == 0)
					return false;
			}
		}
		return true;
	}

	// 방문한 점을 XOR 연산
	public static void setVisited(int r, int c, int size) {
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				map[i][j] = map[i][j] ^ 1;
			}
		}
	}

	public static void Backtracking(int r, int cnt, int total) {
		if (answer <= cnt)
			return; // 현재 값보다 색종이를 많이쓰면 가지치기
		if (total == cntOne) { // 1을 다 채운 경우
			answer = Math.min(answer, cnt);
			return;
		}
		for (int i = r; i < 10; i++) { // r부터 시작
			for (int j = 0; j < 10; j++) {
				if (map[i][j] == 1) {
					boolean flag = false; // 큰 색종이로 덮을 수 있으면 이후 색종이는 확인해 보지 않아도 된다
					for (int k = 5; k >= 1; k--) {
						if ((i + k) <= 10 && (j + k) <= 10 && paper[k] > 0) {
							if (!flag) {
								flag = check(i, j, k); // k*k 색종이를 덮을 수 있으면 check = true
							}
							if (flag) {
								setVisited(i, j, k);
								paper[k]--;
								Backtracking(i, cnt + 1, total + k * k);
								paper[k]++;
								setVisited(i, j, k);
							}
						}
					}
					if (!flag)
						return; // 색종이를 못덮는 경우
				}
				if (map[i][j] == 1)
					return; // 덮고나서도 해당좌표를 못지우는경우
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[10][10];
		cntOne = 0;
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					cntOne++;
				}
			}
		}
		answer = Integer.MAX_VALUE;
		Backtracking(0, 0, 0);
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
		br.close();
	}

}
