package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_200710_백준_11559_PuyoPuyo {
	static int n, m;
	static char[][] map;
	static int[][] visit;
	static int[] countChar;
	static Queue<int[]> removeQ;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	// BFS 탐색을 통해 상하좌우로 4개 이상이 붙어있는 뿌요들을 찾음
	static void bfs(int x, int y, int step) {
		Queue<int[]> q = new LinkedList<>();
		Queue<int[]> tempRemoveQ = new LinkedList<>();
		q.offer(new int[] { x, y });
		tempRemoveQ.offer(new int[] { x, y });
		visit[x][y] = step;

		int cnt = 1;
		char color = map[x][y];
		while (!q.isEmpty()) {
			int cx = q.peek()[0];
			int cy = q.poll()[1];
			for (int d = 0; d < dx.length; d++) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m && visit[nx][ny] != step) {
					if (map[nx][ny] == color) {
						cnt++;
						visit[nx][ny] = step;
						q.offer(new int[] { nx, ny });
						tempRemoveQ.offer(new int[] { nx, ny });
					}
				}
			}
		}
		// 4개 이상이 붙어있을 때만 지우는 큐에 추가
		if (cnt >= 4) {
			removeQ.addAll(tempRemoveQ);
		}
	}

	// 뿌요들이 터진 후 맵 정리
	static void mapSet() {

		// 뿌요 터트리기
		// 터진 위치 빈공간으로, 해당 열의 뿌요 수 감소, 뿌요가 지워진 열 체크
		boolean[] removedCol = new boolean[m];
		while (!removeQ.isEmpty()) {
			int x = removeQ.peek()[0];
			int y = removeQ.poll()[1];
			map[x][y] = '.';
			countChar[y]--;
			removedCol[y] = true;
		}

		// 뿌요가 지워졌고, 해당 열에 뿌요가 남아 있다면
		// 열의 아래부터 뿌요의 색을 큐에 넣고
		// 맵 아래부터 차곡차곡 채워줌
		for (int col = 0; col < m; col++) {
			if (removedCol[col] && countChar[col] > 0) {
				Queue<Character> q = new LinkedList<>();
				for (int row = n - 1; row >= 0; row--) {
					if (map[row][col] != '.') {
						q.offer(map[row][col]);
						map[row][col] = '.';
					}
				}
				int row = n - 1;
				while (!q.isEmpty()) {
					char c = q.poll();
					map[row--][col] = c;
				}
			}
		}
	}

	static void printMap() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = 12;
		m = 6;
		map = new char[n][m];
		visit = new int[n][m];
		countChar = new int[m];
		removeQ = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			map[i] = line.toCharArray();
			for (int j = 0; j < m; j++) {
				// 각 열마다 뿌요가 몇 개 있는지 세어둠
				if (map[i][j] != '.')
					countChar[j]++;
			}
		}

		int step = 0;
		int answer = 0;
		while (true) {
			// step => visit 배열을 초기화 하지 않기 위해 사용함
			step++;
			for (int i = n - 1; i >= 0; i--) {
				for (int j = m - 1; j >= 0; j--) {
					if (map[i][j] != '.' && visit[i][j] != step) {
						bfs(i, j, step);
					}
				}
			}
			// 지워지는 블럭이 있다면 1연쇄 추가
			if (removeQ.size() > 0) {
				answer++;
				mapSet();
//				printMap();
			} else
				break;
		}
		System.out.println(answer);

		br.close();
	}
}