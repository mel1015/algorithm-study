package boj.Sol1114;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution_D4_5643_키순서_서울9반_신광식 {
	static int n, m, answer;
	static int[] small, tall;
	static ArrayList<Integer>[] smallList;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_5643.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			m = Integer.parseInt(br.readLine());
			small = new int[n + 1];
			tall = new int[n + 1];
			visit = new boolean[n + 1];
			// ArrayList 배열 선언&초기화
			smallList = new ArrayList[n + 1];
			for (int i = 1; i <= n; i++) {
				smallList[i] = new ArrayList<>();
			}
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int small = Integer.parseInt(st.nextToken());
				int tall = Integer.parseInt(st.nextToken());
				// 자신보다 키가 작은 번호를 추가
				smallList[tall].add(small);
			}
			// 각 학생에 대해 BFS 탐색
			for (int i = 1; i <= n; i++) {
				Queue<Integer> q = new LinkedList<>();
				q.add(i);
				while (!q.isEmpty()) {
					int curr = q.poll();
					for (int j = 0; j < smallList[curr].size(); j++) {
						int next = smallList[curr].get(j);
						if (!visit[next]) {
							visit[next] = true;
							q.add(next);
							// 자신보다 작은 학생 수 증가
							small[i]++;
							// 현재 학생이 next 학생보다 큼
							tall[next]++;
						}
					}
				}
				Arrays.fill(visit, false);
			}
			answer = 0;
			for (int i = 1; i <= n; i++) {
				// 자신보다 작은 학생 수, 큰 학생 수가 모두 확인되면 정답 증가
				if (small[i] + tall[i] == n - 1)
					answer++;
			}
			System.out.println("#" + tc + " " + answer);
		}
		br.close();
	}

}
