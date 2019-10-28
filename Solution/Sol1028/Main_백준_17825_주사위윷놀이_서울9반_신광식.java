package boj.Sol1028;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_17825_주사위윷놀이_서울9반_신광식 {
	static int answer;
	static int move[];
	static ArrayList<Integer>[] mals;
	static boolean[][] malPosition;

	static void dfs(int cnt, int run) {
		if (cnt == 10) {
			int score = 0;
			for (int i = 0; i < mals.length; i++) {
				int sum = 0;
				boolean firstCurve = false;
				boolean secondCurve = false;
				boolean thirdCurve = false;
				boolean innerCurve = false;
				for (int j = 0; j < mals[i].size(); j++) {
					int currMove = mals[i].get(j);
					sum += currMove;
					if (!firstCurve && sum == 5) {
						firstCurve = true;
						sum = 0;
						currMove = 0;
					} else if (!firstCurve && !secondCurve && sum == 10) {
						secondCurve = true;
						sum = 0;
						currMove = 0;
					} else if (!firstCurve && !secondCurve && !thirdCurve && sum == 15) {
						thirdCurve = true;
						sum = 0;
						currMove = 0;
					} else if ((firstCurve || secondCurve || thirdCurve) && sum == 4) {
						innerCurve = true;
						sum = 0;
						currMove = 0;
					}

					if (!firstCurve && !secondCurve && !thirdCurve && !innerCurve) {
						if (sum > 20)
							score += 0;
						else
							score += sum * 2;
					} else if (firstCurve && !innerCurve) {
						if (sum == 0)
							score += 10;
						else if (sum < 4)
							score += 10 + (3 * sum);
						else if (sum == 4)
							score += 25;
						else if (sum > 4 && sum < 8)
							score += 21 + sum;
						else if (sum >= 8 && sum <= 13)
							score += 30 + ((sum - 8) * 2);
					} else if (thirdCurve && !innerCurve) {
						if (sum == 0)
							score += 30;
						else if (sum < 4)
							score += 28 - sum;
						else if (sum == 4)
							score += 25;
						else if (sum > 4 && sum < 8)
							score += 19 - ((sum - 5) * 3);
					} else if (secondCurve) {
						if (sum == 0)
							score += 20;
						else if (sum < 3)
							score += 20 + (2 * sum);
						else if (sum >= 3 && sum < 7)
							score += 25 + ((sum - 3) * 5);
					} else if (innerCurve) {
						if (sum < 4)
							score += 25 + (5 * sum);
					}
				}
				if (sum > 20)
					break;
				if (firstCurve) {
					if (!malPosition[0][sum])
						malPosition[0][sum] = true;
					else if (sum > 0 && sum <= 20 && malPosition[0][sum])
						return;
				} else if (secondCurve) {
					if (!malPosition[1][sum])
						malPosition[1][sum] = true;
					else if (sum > 0 && sum <= 20 && malPosition[1][sum])
						return;
				} else if (innerCurve) {
					if (!malPosition[2][sum])
						malPosition[2][sum] = true;
					else if (sum > 0 && sum <= 20 && malPosition[2][sum])
						return;
				} else {
					if (!malPosition[3][sum])
						malPosition[3][sum] = true;
					else if (sum > 0 && sum <= 20 && malPosition[3][sum])
						return;
				}
			}
			for (int j = 0; j < malPosition.length; j++) {
				Arrays.fill(malPosition[j], false);
			}
			answer = Math.max(answer, score);
			return;
		}
		if (run < 4) {
			for (int i = 0; i < mals.length; i++) {
				if (!mals[i].isEmpty()) {
					mals[i].add(move[cnt]);
					dfs(cnt + 1, run);
					mals[i].remove(mals[i].size() - 1);
				}
			}
			mals[run].add(move[cnt]);
			dfs(cnt + 1, run + 1);
			mals[run].remove(mals[run].size() - 1);
		} else {
			for (int i = 0; i < mals.length; i++) {
				if (!mals[i].isEmpty()) {
					mals[i].add(move[cnt]);
					dfs(cnt + 1, run);
					mals[i].remove(mals[i].size() - 1);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		move = new int[10];
		mals = new ArrayList[4];
		malPosition = new boolean[4][21];
		for (int i = 0; i < 10; i++) {
			move[i] = Integer.parseInt(st.nextToken());
			if (i < 4)
				mals[i] = new ArrayList<>();
		}
		answer = 0;
		mals[0].add(move[0]);
		dfs(1, 1);
		System.out.println(answer);
		br.close();
	}

}
