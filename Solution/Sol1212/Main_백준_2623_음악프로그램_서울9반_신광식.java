package boj.Sol1212;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_2623_음악프로그램_서울9반_신광식 {
	static int n, m;
	static Node[] adjList;
	static int[] inDegree;
	static boolean[] visited;

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
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		adjList = new Node[n + 1];
		inDegree = new int[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			while (st.hasMoreTokens()) {
				int to = Integer.parseInt(st.nextToken());
				adjList[from] = new Node(to, adjList[from]);
				inDegree[to]++;
				from = to;
			}
		}
		String answer = go();
		System.out.println(answer == null ? 0 : answer);
		br.close();
	}

	static String go() {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			if (inDegree[i] == 0)
				q.offer(i);
		}
		StringBuilder sb = new StringBuilder();
		int visitCnt = 0;
		while (!q.isEmpty()) {
			int current = q.poll();
			visitCnt++;
			sb.append(current).append("\n");

			// 현재 정점의 인접정점 처리(진입차수 감소 => 간선 끊음)
			Node temp = adjList[current];
			while (temp != null) {
				if (--inDegree[temp.vertex] == 0)
					q.offer(temp.vertex);
				temp = temp.next;
			}
		}
		return visitCnt == n ? sb.toString() : null;
	}

}
