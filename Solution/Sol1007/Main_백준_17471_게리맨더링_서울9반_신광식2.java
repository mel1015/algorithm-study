package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_백준_17471_게리맨더링_서울9반_신광식2 {
	static int n, answer, sumA, sumB;
	static int[] people, visit;
	static int[][] adj;
	static ArrayList<Integer> teamA, teamB;

	static void dfs(int start, ArrayList<Integer> team) {
		team.remove((Integer) start);
		if (team.isEmpty())
			return;
		for (int i = 0; i < n; i++) {
			if (team.contains(i) && adj[start][i] == 1) {
				dfs(i, team);
			}
		}
	}

	static void combi(int start, int cnt) {
		if (cnt == n - 1) {
			return;
		}
		if (cnt > 0) {
			sumA = sumB = 0;
			for (int i = 0; i < n; i++) {
				if (visit[i] == 0) {
					sumA += people[i];
					teamA.add(i);
				} else {
					sumB += people[i];
					teamB.add(i);
				}
			}
			dfs(teamA.get(0), teamA);
			dfs(teamB.get(0), teamB);
			if (teamA.isEmpty() && teamB.isEmpty())
				answer = Math.min(answer, Math.abs(sumA - sumB));
			teamA.clear();
			teamB.clear();
		}
		for (int i = start; i < n; i++) {
			if (visit[i] == 0) {
				visit[i] = 1;
				combi(i, cnt + 1);
				visit[i] = 0;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		people = new int[n];
		visit = new int[n];
		adj = new int[n][n];
		teamA = new ArrayList<>();
		teamB = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			for (int j = 0; j < size; j++) {
				int v = Integer.parseInt(st.nextToken()) - 1;
				adj[i][v] = 1;
			}
		}
		if (n == 1) {
			System.out.println(-1);
		} else if (n == 2) {
			System.out.println(Math.abs(people[0] - people[1]));
		} else {
			answer = Integer.MAX_VALUE;
			combi(0, 0);
			System.out.println((answer == Integer.MAX_VALUE) ? -1 : answer);
		}
		br.close();
	}

}
