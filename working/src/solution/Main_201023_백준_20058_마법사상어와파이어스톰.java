package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_201023_백준_20058_마법사상어와파이어스톰 {
	static int n, q, size, iceSum, iceMax;
	static int[][] map, visit;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	// BFS 탐색으로 가장 큰덩어리를 찾으면서 얼음의 합도 구하기
	static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		visit[i][j] = 1;
		q.offer(new int[] { i, j });

		int maxSize = 0;
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.poll()[1];
			iceSum += map[x][y];
			maxSize++;
			for (int d = 0; d < dx.length; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx >= 0 && nx < size && ny >= 0 && ny < size && map[nx][ny] > 0 && visit[nx][ny] == 0) {
					visit[nx][ny] = 1;
					q.offer(new int[] { nx, ny });
				}
			}
		}
		iceMax = Math.max(maxSize, iceMax);
	}

	// 얼음 녹이기
	// 상하좌우로 인접한 얼음의 개수가 3개 미만이면 녹이기
	static void meltingIce() {
		ArrayList<int[]> meltingList = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (map[i][j] > 0) {
					int count = 0;
					for (int d = 0; d < dx.length; d++) {
						int ni = i + dx[d];
						int nj = j + dy[d];
						if (ni >= 0 && ni < size && nj >= 0 && nj < size && map[ni][nj] > 0) {
							count++;
						}
					}
					if (count < 3) {
						meltingList.add(new int[] { i, j });
					}
				}
			}
		}
		for (int i = 0; i < meltingList.size(); i++) {
			int x = meltingList.get(i)[0];
			int y = meltingList.get(i)[1];
			map[x][y] = map[x][y] > 0 ? map[x][y] - 1 : 0;
		}
	}

	// 맵 회전시키기
	// [https://yabmoons.tistory.com/602] 참고
	static void rotateMap(int x, int y, int divide) {
		int square = divide / 2;
		for (int number = 0; number < square; number++) {
			int startX = x + number;
			int startY = y + number;
			int endX = x + divide - number - 1;
			int endY = y + divide - number - 1;

			int xIdx = endX;
			int yIdx = startY;
			int idx = 0;
			ArrayList<Integer> temp = new ArrayList<>();
			for (int i = startX; i < endX; i++) {
				temp.add(map[i][startY]);
			}
			for (int i = startX; i < endX; i++) {
				map[i][startY] = map[endX][yIdx++];
			}
			for (int i = startY; i < endY; i++) {
				map[endX][i] = map[xIdx--][endY];
			}
			for (int i = endX; i > startX; i--) {
				map[i][endY] = map[startX][yIdx--];
			}
			for (int i = endY; i > startY; i--) {
				map[startX][i] = temp.get(idx++);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		size = (int) Math.pow(2.0, n);
		map = new int[size][size];
		visit = new int[size][size];

		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < size; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < q; i++) {
			int level = Integer.parseInt(st.nextToken());
			if (level > 0) {
				// 각 레벨마다 회전을 시작할 x,y좌표
				int divide = (int) Math.pow(2.0, level);
				for (int x = 0; x < size; x += divide) {
					for (int y = 0; y < size; y += divide) {
						rotateMap(x, y, divide);
					}
				}
			}
			meltingIce();
		}

		// 남아있는 얼음의 합과 가장 큰덩어리의 크기 구하기
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (map[i][j] > 0 && visit[i][j] == 0) {
					bfs(i, j);
				}
			}
		}
		System.out.println(iceSum);
		System.out.println(iceMax);
		br.close();
	}

}
