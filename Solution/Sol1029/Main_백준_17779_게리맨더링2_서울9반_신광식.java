package boj.Sol1029;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_백준_17779_게리맨더링2_서울9반_신광식 {
	static int n, totalSum, fifth, answer;
	static int[][] map, divMap;
	static ArrayList<Integer> divide, section;
	static int[] dx = { 1, 1, -1, -1 };
	static int[] dy = { -1, 1, 1, -1 };

	static void divideLeftMap(int fromRow, int toRow, int fromCol, int toCol, int num) {
		int sum = 0;
		for (int i = fromRow; i < toRow; i++) {
			for (int j = fromCol; j < toCol; j++) {
				if (divMap[i][j] != 0)
					break;
				divMap[i][j] = num;
				sum += map[i][j];
			}
		}
		fifth -= sum;
		section.add(sum);
	}

	static void divideRightMap(int fromRow, int toRow, int fromCol, int toCol, int num) {
		int sum = 0;
		for (int i = fromRow; i < toRow; i++) {
			for (int j = toCol - 1; j >= fromCol; j--) {
				if (divMap[i][j] != 0)
					break;
				divMap[i][j] = num;
				sum += map[i][j];
			}
		}
		fifth -= sum;
		section.add(sum);
	}

	static void makeFifth(int x, int y, int d1, int d2) {
		int nx = x, ny = y;
		for (int loop = 0; loop < d1; loop++) {
			nx += dx[0];
			ny += dy[0];
			divMap[nx][ny] = 5;
		}
		for (int loop = 0; loop < d2; loop++) {
			nx += dx[1];
			ny += dy[1];
			divMap[nx][ny] = 5;
		}
		for (int loop = 0; loop < d1; loop++) {
			nx += dx[2];
			ny += dy[2];
			divMap[nx][ny] = 5;
		}
		for (int loop = 0; loop < d2; loop++) {
			nx += dx[3];
			ny += dy[3];
			divMap[nx][ny] = 5;
		}
	}

	static void combi(int start, int cnt) {
		if (cnt == 2) {
			for (int i = 0; i < n - 2; i++) {
				for (int j = 1; j < n - 1; j++) {
					boolean canMake = true;
					int d1 = divide.get(0);
					int d2 = divide.get(1);
					int nx = i, ny = j;
					for (int d = 0; d < dx.length; d++) {
						if (d % 2 == 0) {
							nx += dx[d] * d1;
							ny += dy[d] * d1;
						} else {
							nx += dx[d] * d2;
							ny += dy[d] * d2;
						}
						if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
							canMake = false;
							break;
						}
					}
					if (canMake) {
						fifth = totalSum;
						makeFifth(i, j, d1, d2);
						divideLeftMap(0, i + d1, 0, j + 1, 1);
						divideRightMap(0, i + d2 + 1, j + 1, n, 2);
						divideLeftMap(i + d1, n, 0, j - d1 + d2, 3);
						divideRightMap(i + d2 + 1, n, j - d1 + d2, n, 4);
						section.add(fifth);
						Collections.sort(section);
						answer = Math.min(section.get(4) - section.get(0), answer);
						section.clear();
						for (int k = 0; k < n; k++) {
							Arrays.fill(divMap[k], 0);
						}
					}
				}
			}
			return;
		}
		for (int i = 1; i < n; i++) {
			divide.add(i);
			combi(i, cnt + 1);
			divide.remove(divide.size() - 1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		divMap = new int[n][n];
		divide = new ArrayList<>();
		section = new ArrayList<>();
		answer = Integer.MAX_VALUE;
		totalSum = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				totalSum += map[i][j];
			}
		}
		combi(1, 0);
		System.out.println(answer);
		br.close();
	}

}
