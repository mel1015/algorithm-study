package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_200730_백준_13023_ABCDE {
	static int n, m, answer;
	static ArrayList<Integer>[] friends;
	static boolean[] visit;

	static void dfs(int num, int cnt) {
		if (cnt == 5) {
			// 5명이 연결되어 있으면 조건의 친구 관계가 존재
			answer = 1;
			return;
		}
		for (int i = 0; i < friends[num].size(); i++) {
			int next = friends[num].get(i);
			if (!visit[next]) {
				visit[next] = true;
				dfs(next, cnt + 1);
				visit[next] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		// (5 <= n <= 2000), (1 <= m <= 2000)
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// n X m 크기의 배열로 만들면 DFS 탐색 시간이 오래걸림
		// => n개의 ArrayList에 친구만 추가해줌
		friends = new ArrayList[n];
		visit = new boolean[n];

		for (int i = 0; i < n; i++) {
			friends[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// 양방향으로 탐색 가능
			friends[a].add(b);
			friends[b].add(a);
		}

		answer = 0;
		// 조건에 answer == 0 을 걸어둠
		// dfs 탐색을 통해 5명이 연결되어 있으면 answer이 1로 바뀌므로
		// 더이상의 탐색을 안하게됨
		for (int i = 0; i < n && answer == 0; i++) {
			visit[i] = true;
			dfs(i, 1);
			visit[i] = false;
		}
		System.out.println(answer);

		br.close();
	}
}