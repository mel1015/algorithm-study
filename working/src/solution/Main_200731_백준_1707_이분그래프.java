package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_200731_백준_1707_이분그래프 {
	static int k, v, e;
	static ArrayList<Integer>[] graph;
	static int[] color;

	// 이분 그래프 => 
	// 인접한 정점끼리 서로 다른 색으로 칠해서 
	// 모든 정점을 두 가지 색으로만 칠할 수 있는 그래프
	static boolean bfs(int num) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(num);
		color[num] = 0;

		while (!q.isEmpty()) {
			int curr = q.poll();
			for (int i = 0; i < graph[curr].size(); i++) {
				int next = graph[curr].get(i);
				if (color[next] == color[curr]) {
					return false;
				} else if (color[next] == -1) {
					// 1 ^ color[curr] => 
					// (1 XOR 현재 정점의 색깔) 연산을 해서
					// 같으면 0이고 다르면 1을 반환하므로
					// 0과 1로 모든 정점의 색을 칠할 수 있음
					color[next] = 1 ^ color[curr];
					q.offer(next);
				}
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		k = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < k; tc++) {
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());

			graph = new ArrayList[v + 1];
			color = new int[v + 1];

			for (int i = 1; i <= v; i++) {
				graph[i] = new ArrayList<>();
				color[i] = -1;
			}

			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph[a].add(b);
				graph[b].add(a);
			}

			boolean isBipartite = true;
			// 모든 정점에 대해 BFS 탐색을 진행하여
			// 비연결 그래프에서도 모든 정점을 탐색하게 함
			for (int i = 1; i <= v && isBipartite; i++) {
				if (color[i] == -1) {
					isBipartite = bfs(i);
				}
			}

			if (isBipartite)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		br.close();
	}
}