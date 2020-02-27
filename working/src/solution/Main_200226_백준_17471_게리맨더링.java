package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_200226_백준_17471_게리맨더링 {
	static int n, answer;
	static int[] people;
	static int[][] adj;
	static boolean[] visit;
	static ArrayList<Integer> teamA, teamB;

	static int bfs(ArrayList<Integer> team) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(team.get(0));
		int teamValue = people[team.get(0)];
		team.remove((Integer) team.get(0));

		while (!q.isEmpty() && !team.isEmpty()) {
			int curr = q.poll();
			for (int i = 1; i < adj.length && !team.isEmpty(); i++) {
				if (adj[curr][i] == 1 && team.contains(i)) {
					q.offer(i);
					teamValue += people[i];
					team.remove((Integer) i);
				}
			}
		}
		if (team.isEmpty())
			return teamValue;
		else
			return -1;
	}

	static void comb(int start, int count, int limit) {
		if (count == limit) {
			for (int i = 1; i < visit.length; i++) {
				if (!visit[i]) {
					teamA.add(i);
				} else {
					teamB.add(i);
				}
			}
			int peopleA = bfs(teamA);
			int peopleB = bfs(teamB);
			if (peopleA > 0 && peopleB > 0) {
				answer = Math.min(answer, Math.abs(peopleA - peopleB));
			}
			teamA.clear();
			teamB.clear();
			return;
		}
		for (int i = start; i < people.length; i++) {
			if (!visit[i]) {
				visit[i] = true;
				comb(i, count + 1, limit);
				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		people = new int[n + 1];
		adj = new int[n + 1][n + 1];
		visit = new boolean[n + 1];
		teamA = new ArrayList<>();
		teamB = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < people.length; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			while (st.hasMoreTokens()) {
				int num = Integer.parseInt(st.nextToken());
				adj[i][num] = 1;
				adj[num][i] = 1;
			}
		}

		answer = Integer.MAX_VALUE;
		for (int i = 1; i <= n - 1; i++) {
			comb(1, 0, i);
			Arrays.fill(visit, false);
		}
		System.out.println((answer == Integer.MAX_VALUE) ? -1 : answer);
		br.close();
	}

}
