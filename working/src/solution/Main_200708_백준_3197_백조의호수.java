package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_200708_백준_3197_백조의호수 {
	static int r, c, answer;
	static boolean find;
	static char[][] map;
	static boolean[][] visit;
	static int[] swan;
	static Queue<int[]> swanQ, swanNQ, q, nq;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static void swanBfs() {
		while (!swanQ.isEmpty() && !find) {
			int x = swanQ.peek()[0];
			int y = swanQ.poll()[1];
			for (int d = 0; d < dx.length; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx >= 0 && nx < r && ny >= 0 && ny < c && !visit[nx][ny]) {
					if (map[nx][ny] == '.') {
						visit[nx][ny] = true;
						swanQ.offer(new int[] { nx, ny });
					} else if (map[nx][ny] == 'L') {
						visit[nx][ny] = true;
						find = true;
						break;
					} else if (map[nx][ny] == 'X') {
						visit[nx][ny] = true;
						swanNQ.offer(new int[] { nx, ny });
					}
				}
			}
		}
	}

	static void waterBfs() {
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.poll()[1];
			for (int d = 0; d < dx.length; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
					if (map[nx][ny] == 'X') {
						map[nx][ny] = '.';
						nq.offer(new int[] { nx, ny });
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		visit = new boolean[r][c];
		swan = new int[2];
		swanQ = new LinkedList<>();
		swanNQ = new LinkedList<>();
		q = new LinkedList<>();
		nq = new LinkedList<>();

		for (int i = 0; i < r; i++) {
			String line = br.readLine();
			map[i] = line.toCharArray();
			for (int j = 0; j < c; j++) {
				if (map[i][j] != 'X') {
					q.offer(new int[] { i, j });
				}
				if (map[i][j] == 'L') {
					swan[0] = i;
					swan[1] = j;
				}
			}
		}

		find = false;
		swanQ.offer(swan);
		visit[swan[0]][swan[1]] = true;
		while (!find) {
			swanBfs();
			if (!find) {
				waterBfs();
				q.addAll(nq);
				swanQ.addAll(swanNQ);

				nq.clear();
				swanNQ.clear();
				answer++;
			}
		}
		System.out.println(answer);

		br.close();
	}
}