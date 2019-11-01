package boj.Sol1101;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_17825_주사위윷놀이_서울9반_신광식 {
	static int answer;
	// move: 던져서 나온 주사위의 값, order: 각 주사위의 값을 4개의 말에게 할당한 순서
	static int[] move, order;
	// 점수판 표현: 바깥쪽 한바퀴, 안쪽의 좌측, 아래, 우측, 위
	static int[][] score = { { 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40 },
			{ 10, 13, 16, 19 }, { 20, 22, 24 }, { 30, 28, 27, 26 }, { 25, 30, 35 } };
	// 방문 배열
	static boolean[][] visit;
	// 말에게 주사위 값들을 할당해준 배열
	static ArrayList<Integer>[] mals;

	static int diceGame() {
		int totalScore = 0;
		boolean canUpdate = true;
		// 각 말의 주사위 인덱스, 방향, 이동한 위치
		int[][] malIdxDirTot = new int[4][3];
		// order 배열에 저장되어있는 순서대로 말들을 이동
		for (int i = 0; i < order.length && canUpdate; i++) {
			int malNum = order[i];
			int idx = malIdxDirTot[malNum][0];
			// dir: 0 바깥 크게, 1 안쪽 좌측, 2 안쪽 아래, 3 안쪽 우측, 4 안쪽 위
			int dir = malIdxDirTot[malNum][1];
			int tot = malIdxDirTot[malNum][2];
			// 도착 지점에 도착
			if (tot == -1)
				continue;
			// 현재 말의 주사위 값 => 이동할 칸 수
			int move = mals[malNum].get(idx);
			// 이전 위치 방문 해제
			visit[dir][tot] = false;
			// 현재 스코어 배열에서 이동한 칸 수 
			tot = malIdxDirTot[malNum][2] = tot + move;
			// 인덱스 증가
			malIdxDirTot[malNum][0]++;
			idx = malIdxDirTot[malNum][0];
			if (dir == 0) {
				// 바깥 스코어판을 따라서 도는 경우
				if (tot == 5) {
					// 첫번째 파란색 칸
					dir = malIdxDirTot[malNum][1] = 1;
					tot = malIdxDirTot[malNum][2] = 0;
				} else if (tot == 10) {
					// 두번째 파란색 칸
					dir = malIdxDirTot[malNum][1] = 2;
					tot = malIdxDirTot[malNum][2] = 0;
				} else if (tot == 15) {
					// 세번째 파란색 칸
					dir = malIdxDirTot[malNum][1] = 3;
					tot = malIdxDirTot[malNum][2] = 0;
				} else if (tot > 20) {
					// 도착
					tot = malIdxDirTot[malNum][2] = -1;
					continue;
				}
			} else {
				// 파란색 칸을 밟고 안으로 들어온 경우
				if (dir == 1 || dir == 3) {
					// 안쪽 좌측, 우측
					if (tot > 3 && tot < 8) {
						// 25를 넘어 위로 꺾은 상황
						dir = malIdxDirTot[malNum][1] = 4;
						tot = malIdxDirTot[malNum][2] = tot - 4;
					} else if (tot >= 8) {
						// 도착
						tot = malIdxDirTot[malNum][2] = -1;
						continue;
					}
				} else if (dir == 2) {
					// 안쪽 아래
					if (tot > 2 && tot < 7) {
						// 25를 넘어 위로 꺾은 상황
						dir = malIdxDirTot[malNum][1] = 4;
						tot = malIdxDirTot[malNum][2] = tot - 3;
					} else if (tot >= 7) {
						// 도착
						tot = malIdxDirTot[malNum][2] = -1;
						continue;
					}
				} else if (dir == 4) {
					// 안쪽 위
					if (tot > 3) {
						tot = malIdxDirTot[malNum][2] = -1;
						continue;
					}
				}
			}
			int currScore = 0;
			if (dir == 4 && tot == 3) {
				// 최고점 도착 => 바깥 스코어판으로 만들어놔서 따로 처리
				// 4방향에서 올 수 있으므로
				currScore = score[0][20];
				if (!visit[0][20])
					visit[0][20] = true;
				else
					canUpdate = false;
			} else {
				currScore = score[dir][tot];
				if (!visit[dir][tot])
					visit[dir][tot] = true;
				else
					canUpdate = false;
			}
			totalScore += currScore;
		}
		if (canUpdate)
			return totalScore;
		else
			return -1;
	}

	static void dfs(int cnt, int run) {
		if (cnt == 10) {
			// 주사위 10개를 모두 사용했을 때
			int totalScore = diceGame();
			answer = Math.max(answer, totalScore);
			for (int i = 0; i < visit.length; i++) {
				Arrays.fill(visit[i], false);
			}
			return;
		}
		// 추가적으로 말을 출발시킬 수 있을 때
		if (run < 4) {
			// 기존에 출발해 있는 말들을 이동
			for (int i = 0; i < mals.length; i++) {
				if (!mals[i].isEmpty()) {
					mals[i].add(move[cnt]);
					order[cnt] = i;
					dfs(cnt + 1, run);
					mals[i].remove(mals[i].size() - 1);
				}
			}
			// 새로운 말 추가
			mals[run].add(move[cnt]);
			order[cnt] = run;
			dfs(cnt + 1, run + 1);
			mals[run].remove(mals[run].size() - 1);
		} else {
			// 말을 추가할 수 없을 때
			// 기존에 출발해 있는 말들을 이동
			for (int i = 0; i < mals.length; i++) {
				if (!mals[i].isEmpty()) {
					mals[i].add(move[cnt]);
					order[cnt] = i;
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
		order = new int[10];
		mals = new ArrayList[4];
		// 점수판의 크기에 맞추어 visit배열 생성
		visit = new boolean[5][21];
		for (int i = 0; i < 10; i++) {
			move[i] = Integer.parseInt(st.nextToken());
			if (i < 4)
				mals[i] = new ArrayList<>();
		}
		answer = 0;
		// 첫번째는 무조건 1번말(인덱스 0번)이 이동
		order[0] = 0;
		mals[0].add(move[0]);
		dfs(1, 1);
		System.out.println(answer);
		br.close();
	}

}
