package boj.Sol1017;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_16235_나무재테크_서울9반_신광식 {
	public static int n, m, k, answer;
	public static int[][] food, supply;
	public static ArrayList<Integer>[][] map;
	public static int[] dx = { -1, 1, 0, 0, -1, -1, 1, 1 };
	public static int[] dy = { 0, 0, -1, 1, -1, 1, -1, 1 };

	public static void springSummer() {
		for (int row = 1; row <= n; row++) {
			for (int col = 1; col <= n; col++) {
				if (!map[row][col].isEmpty()) {
					int deadTrees = 0;
					for (int i = 0; i < map[row][col].size(); i++) {
						if (food[row][col] >= map[row][col].get(i)) {
							food[row][col] -= map[row][col].get(i);
							map[row][col].set(i, map[row][col].get(i) + 1);
						} else {
							deadTrees += map[row][col].get(i) / 2;
							map[row][col].remove(i);
							answer--;
							i--;
						}
					}
					food[row][col] += deadTrees;
				}
			}
		}
	}

	public static void fallWinter() {
		for (int row = 1; row <= n; row++) {
			for (int col = 1; col <= n; col++) {
				if (!map[row][col].isEmpty()) {
					for (int i = 0; i < map[row][col].size(); i++) {
						if (map[row][col].get(i) % 5 == 0) {
							for (int d = 0; d < dx.length; d++) {
								int nx = row + dx[d];
								int ny = col + dy[d];
								if (nx >= 1 && nx <= n && ny >= 1 && ny <= n) {
									map[nx][ny].add(0, 1);
									answer++;
								}
							}
						}
					}
				}
				food[row][col] += supply[row][col];
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		food = new int[n + 1][n + 1];
		supply = new int[n + 1][n + 1];
		map = new ArrayList[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = new ArrayList<>();
				food[i][j] = 5;
				supply[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			map[x][y].add(z);
		}
		answer = m;
		for (int i = 0; i < k; i++) {
			springSummer();
			fallWinter();
		}
		System.out.println(answer);
		br.close();
	}
}
