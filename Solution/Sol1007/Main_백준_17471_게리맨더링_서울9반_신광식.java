package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_백준_17471_게리맨더링_서울9반_신광식 {
	static int n, aTeamVal, bTeamVal, answer;
	static int[] people;
	static boolean[] visit;
	static int[][] adj;
	static ArrayList<Integer> aTeam, bTeam;

	static void dfs(int start, boolean team) {
		if (team) {
			aTeam.remove(Integer.valueOf(start));
			aTeamVal += people[start];
			for (int i = 0; i < n; i++) {
				if (adj[start][i] == 1 && aTeam.contains(i))
					dfs(i, true);
			}
		} else {
			bTeam.remove(Integer.valueOf(start));
			bTeamVal += people[start];
			for (int i = 0; i < n; i++) {
				if (adj[start][i] == 1 && bTeam.contains(i))
					dfs(i, false);
			}
		}
	}

	static void union(int start, int count) {
		if (count == n - 1)
			return;
		else if (count > 0) {
			aTeamVal = bTeamVal = 0;
			aTeam = new ArrayList<>();
			bTeam = new ArrayList<>();
			for (int i = 0; i < visit.length; i++) {
				if (visit[i])
					aTeam.add(i);
				else
					bTeam.add(i);
			}
			dfs(aTeam.get(0), true);
			dfs(bTeam.get(0), false);
			if (aTeam.isEmpty() && bTeam.isEmpty()) {
				answer = Math.min(answer, Math.abs(aTeamVal - bTeamVal));
			}
		}
		for (int i = start; i < n; i++) {
			if (!visit[i]) {
				visit[i] = true;
				union(i, count + 1);
				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());

		people = new int[n];
		visit = new boolean[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}

		adj = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < cnt; j++) {
				adj[i][Integer.parseInt(st.nextToken()) - 1] = 1;
			}
		}

		if (n == 2) {
			answer = Math.abs(people[0] - people[1]);
		} else {
			answer = Integer.MAX_VALUE;
			union(0, 0);
		}
		System.out.println((answer == Integer.MAX_VALUE) ? -1 : answer);

		br.close();
	}

}
