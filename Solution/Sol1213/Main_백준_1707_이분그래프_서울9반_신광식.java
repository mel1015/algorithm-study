package boj.Sol1213;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_1707_이분그래프_서울9반_신광식 {
	static int k, v, e;
	static Node[] adjList;
	static int[] visit;
	static boolean isBipartite;

	static class Node {
		int vertex;
		Node next;

		public Node(int vertex, Node next) {
			this.vertex = vertex;
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", next=" + next + "]";
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			adjList = new Node[v + 1];
			visit = new int[v + 1];

			int from, to;
			for (int j = 0; j < e; j++) {
				st = new StringTokenizer(br.readLine());
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				adjList[from] = new Node(to, adjList[from]);
				adjList[to] = new Node(from, adjList[to]);
			}

			isBipartite = true;
			for (int j = 1; j <= v && isBipartite; j++) {
				if (visit[j] == 0) {
					isBipartite = bfs(j);
				}
			}
			if (isBipartite)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		br.close();
	}

	static boolean bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		visit[start] = 1;
		q.offer(start);
		while (!q.isEmpty()) {
			int current = q.poll();
			Node temp = adjList[current];
			while (temp != null) {
				if (visit[temp.vertex] == 0) {
					visit[temp.vertex] = ~visit[current];
					q.offer(temp.vertex);
				} else {
					if (visit[temp.vertex] == visit[current])
						return false;
				}
				temp = temp.next;
			}
		}
		return true;
	}

}
