package boj.Sol1107;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution_D9_5644_무선충전_서울9반_신광식 {
	static ArrayList<Integer>[][] map;
	static int[][] playerMap, move, bc;
	static int moveTime, bcCount;
	static int[] dx = { 0, -1, 0, 1, 0 };
	static int[] dy = { 0, 0, 1, 0, -1 };

	static void makeMap() {
		for (int i = 0; i < bc.length; i++) {
			int x = bc[i][1] - 1;
			int y = bc[i][0] - 1;
			int c = bc[i][2];
			map[x][y].add(i);
			Queue<int[]> q = new LinkedList<>();
			q.add(new int[] { x, y });
			while (!q.isEmpty()) {
				int[] curr = q.poll();
				for (int d = 1; d < dx.length; d++) {
					int nx = curr[0] + dx[d];
					int ny = curr[1] + dy[d];
					if (nx >= 0 && nx < 10 && ny >= 0 && ny < 10 && !map[nx][ny].contains(i)) {
						int distance = Math.abs(x - nx) + Math.abs(y - ny);
						if (distance <= c) {
							map[nx][ny].add(i);
							q.add(new int[] { nx, ny });
						}
					}
				}
			}
		}
	}

	static int move() {
		int charge = 0;
		int aX = 0, aY = 0, bX = 9, bY = 9;
		playerMap[aX][aY] = 1;
		playerMap[bX][bY] = 2;
		for (int time = 0; time <= moveTime; time++) {
			int aPick = -1, bPick = -1;
			int aCharge = 0, bCharge = 0;
			boolean aSub = false, bSub = false;
			if (map[aX][aY].size() > 0) {
				if (map[aX][aY].size() > 1) {
					Collections.sort(map[aX][aY], new Comparator<Integer>() {
						@Override
						public int compare(Integer o1, Integer o2) {
							return -Integer.compare(bc[o1][3], bc[o2][3]);
						}
					});
					aSub = true;
				}
				aPick = map[aX][aY].get(0);
				aCharge = bc[map[aX][aY].get(0)][3];
			}
			if (map[bX][bY].size() > 0) {
				if (map[bX][bY].size() > 1) {
					Collections.sort(map[bX][bY], new Comparator<Integer>() {
						@Override
						public int compare(Integer o1, Integer o2) {
							return -Integer.compare(bc[o1][3], bc[o2][3]);
						}
					});
					bSub = true;
				}
				bPick = map[bX][bY].get(0);
				bCharge = bc[map[bX][bY].get(0)][3];
			}
			if (aPick >= 0 && bPick >= 0 && aPick == bPick) {
				if (aSub && bSub) {
					int subA = bc[map[aX][aY].get(1)][3];
					int subB = bc[map[bX][bY].get(1)][3];
					if (aCharge + subB >= bCharge + subA) {
						charge += aCharge + subB;
					} else if (aCharge + subB <= bCharge + subA) {
						charge += bCharge + subA;
					}
				} else if (aSub && !bSub) {
					int subA = bc[map[aX][aY].get(1)][3];
					charge += bCharge + subA;
				} else if (!aSub && bSub) {
					int subB = bc[map[bX][bY].get(1)][3];
					charge += aCharge + subB;
				} else if (!aSub && !bSub) {
					charge += aCharge;
				}
			} else if (aPick >= 0 && bPick >= 0 && aPick != bPick) {
				charge += aCharge + bCharge;
			} else if (aPick >= 0 && bPick < 0) {
				charge += aCharge;
			} else if (bPick >= 0 && aPick < 0) {
				charge += bCharge;
			}
			playerMap[aX][aY] = 0;
			playerMap[bX][bY] = 0;
			if (time < moveTime) {
				aX += dx[move[0][time]];
				aY += dy[move[0][time]];
				bX += dx[move[1][time]];
				bY += dy[move[1][time]];
			}
			playerMap[aX][aY] = 1;
			playerMap[bX][bY] = 2;
		}
		return charge;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d9_5644.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			moveTime = Integer.parseInt(st.nextToken());
			bcCount = Integer.parseInt(st.nextToken());
			move = new int[2][moveTime];
			bc = new int[bcCount][4];
			map = new ArrayList[10][10];
			playerMap = new int[10][10];
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					map[i][j] = new ArrayList<>();
				}
			}
			for (int i = 0; i < move.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < move[i].length; j++) {
					move[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < bc.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < bc[i].length; j++) {
					bc[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			makeMap();
			System.out.println("#" + tc + " " + move());
		}
		br.close();
	}

}
