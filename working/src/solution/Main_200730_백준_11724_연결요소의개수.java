package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_200730_백준_11724_연결요소의개수 {
	static int n, m, answer;
	static ArrayList<Integer>[] graph;
	static boolean[] visit;

	static void bfs(int num) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(num);
		visit[num] = true;

		while (!q.isEmpty()) {
			int curr = q.poll();
			for (int i = 0; i < graph[curr].size(); i++) {
				int next = graph[curr].get(i);
				if (!visit[next]) {
					visit[next] = true;
					q.offer(next);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		// (1 <= n <= 1000), (0 <= m <= n*(n-1)/2)
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		// n X m 크기의 배열로 만들면 DFS 탐색 시간이 오래걸림
		// => n개의 ArrayList에 친구만 추가해줌
		graph = new ArrayList[n + 1];
		visit = new boolean[n + 1];

		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// 양방향으로 탐색 가능
			graph[a].add(b);
			graph[b].add(a);
		}

		// BFS 탐색으로 현재 정점(i)에서 방문 할 수 있는 모든 점을 방문
		// 다음 BFS 탐색이 이뤄진다면 연결 요소 개수 증가
		for (int i = 1; i <= n; i++) {
			if (!visit[i]) {
				answer++;
				bfs(i);
			}
		}
		System.out.println(answer);

		br.close();
	}
}