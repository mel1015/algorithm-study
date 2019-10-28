package boj.Sol1016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_14890_경사로_서울9반_신광식 {
	public static int N, L, answer;
	public static int[][] map;

	public static void rowRoad() {
		for (int i = 0; i < N; i++) {
			int preVal = map[i][0];
			int roadCnt = 1;
			boolean isRoad = true;
			for (int j = 1; j < N && isRoad; j++) {
				if (map[i][j] == preVal) {
					roadCnt++;
				} else if (map[i][j] - preVal == -1) {
					// 내리막 => 현재칸부터 앞의 L칸이 같아야 함
					preVal = map[i][j];
					for (int k = 0; k < L; k++) {
						if (j + k >= N || preVal != map[i][j + k]) {
							isRoad = false;
							break;
						}
					}
					j += L - 1;
					roadCnt = 0;
				} else if (map[i][j] - preVal == 1) {
					// 오르막 => 현재까지 평지가 L칸 이상이어야 경사로 가능
					if (roadCnt < L) {
						isRoad = false;
						break;
					} else {
						preVal = map[i][j];
						roadCnt = 1;
						continue;
					}
				} else if (Math.abs(map[i][j] - preVal) > 1) {
					isRoad = false;
					break;
				}
			}
			if (isRoad) {
//				System.out.println(i + "번째 Row");
				answer++;
			}
		}
	}

	public static void colRoad() {
		for (int i = 0; i < N; i++) {
			int preVal = map[0][i];
			int roadCnt = 1;
			boolean isRoad = true;
			for (int j = 1; j < N && isRoad; j++) {
				if (map[j][i] == preVal) {
					roadCnt++;
				} else if (map[j][i] - preVal == -1) {
					// 내리막 => 현재칸부터 앞의 L칸이 같아야 함
					preVal = map[j][i];
					for (int k = 0; k < L; k++) {
						if (j + k >= N || preVal != map[j + k][i]) {
							isRoad = false;
							break;
						}
					}
					j += L - 1;
					roadCnt = 0;
				} else if (map[j][i] - preVal == 1) {
					// 오르막 => 현재까지 평지가 L칸 이상이어야 경사로 가능
					if (roadCnt < L) {
						isRoad = false;
						break;
					} else {
						preVal = map[j][i];
						roadCnt = 1;
						continue;
					}
				} else if (Math.abs(map[j][i] - preVal) > 1) {
					isRoad = false;
					break;
				}
			}
			if (isRoad) {
//				System.out.println(i + "번째 Col");
				answer++;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		answer = 0;
		rowRoad();
		colRoad();
		System.out.println(answer);
		br.close();
	}

}
