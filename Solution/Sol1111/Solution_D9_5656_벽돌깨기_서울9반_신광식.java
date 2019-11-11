package boj.Sol1111;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution_D9_5656_벽돌깨기_서울9반_신광식 {
	static int n, w, h, countBrick, answer;
	static int[][] map, copyMap;
	static int[] shoot;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int brickOut() {
		// 남아있는 벽돌 수
		int leftBrick = countBrick;
		// 중복 순열로 shoot 배열 넘김 => 구슬을 떨어뜨릴 열의 번호가 담긴 배열
		for (int i = 0; i < shoot.length; i++) {
			// 연쇄되어 제거 되는 벽돌의 좌표, 범위를 담아둘 큐
			// 벽돌이 하나라도 제거된 열 번호를 저장할 셋 => 해당 열의 벽돌을 떨어뜨려주기 위해
			Queue<int[]> q = new LinkedList<>();
			HashSet<Integer> set = new HashSet<>();
			for (int row = 0; row < h; row++) {
				if (copyMap[row][shoot[i]] != 0) {
					// 구슬을 떨어뜨린 열에서 처음으로 제거되는 벽돌 큐에 추가
					q.add(new int[] { row, shoot[i], copyMap[row][shoot[i]] - 1 });
					set.add(shoot[i]);
					copyMap[row][shoot[i]] = 0;
					leftBrick--;
					break;
				}
			}
			while (!q.isEmpty()) {
				int x = q.peek()[0];
				int y = q.peek()[1];
				int range = q.poll()[2];
				for (int d = 0; d < dx.length; d++) {
					int nx = x;
					int ny = y;
					for (int loop = 0; loop < range; loop++) {
						nx += dx[d];
						ny += dy[d];
						if (nx >= 0 && nx < h && ny >= 0 && ny < w && copyMap[nx][ny] != 0) {
							// 범위가 0이면 큐에 추가할 필요 없이 맵만 0으로 변경
							// 범위가 0보다 크면 큐에 추가 => 연쇄 제거를 위해
							if (copyMap[nx][ny] - 1 > 0)
								q.add(new int[] { nx, ny, copyMap[nx][ny] - 1 });
							set.add(ny);
							copyMap[nx][ny] = 0;
							leftBrick--;
						}
					}
				}
			}
			// 남은 벽돌이 없으면 더이상의 계산 불필요
			if (leftBrick == 0)
				break;
			// 마지막 구슬을 떨어 뜨린 뒤의 벽돌들은 아래로 떨어뜨려줄 필요가 없음
			if (i < shoot.length - 1) {
				// set 안에는 벽돌이 제거된 열 번호가 들어있음
				for (Integer col : set) {
					ArrayList<Integer> remainBrick = new ArrayList<>();
					// 해당 열의 0이 아닌 모든 벽돌을 remainBrick 리스트에 저장
					for (int row = h - 1; row >= 0; row--) {
						if (copyMap[row][col] != 0) {
							remainBrick.add(copyMap[row][col]);
							copyMap[row][col] = 0;
						}
					}
					// 맵의 아래부터 벽돌을 다시 추가
					for (int j = 0; j < remainBrick.size(); j++) {
						copyMap[h - 1 - j][col] = remainBrick.get(j);
					}
				}
			}
		}
		return leftBrick;
	}

	static void perm(int cnt) {
		if (cnt == n) {
			// answer이 0이면 이미 모든 블럭이 제거되었으므로 더 이상 진행할 필요 X
			if (answer != 0) {
				for (int i = 0; i < h; i++) {
					copyMap[i] = map[i].clone();
				}
				int afterBrick = brickOut();
				answer = Math.min(answer, afterBrick);
			}
			return;
		}
		// 중복 순열 => 000, 001, 002, ...
		// answer이 0이면 이미 모든 블럭이 제거되었으므로 더 이상 진행할 필요 X
		for (int i = 0; i < w && answer != 0; i++) {
			shoot[cnt] = i;
			perm(cnt + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d9_5656.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			map = new int[h][w];
			copyMap = new int[h][w];
			shoot = new int[n];
			countBrick = 0;
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] != 0)
						countBrick++;
				}
			}
			answer = Integer.MAX_VALUE;
			perm(0);
			System.out.println("#" + tc + " " + answer);
		}
		br.close();
	}

}
