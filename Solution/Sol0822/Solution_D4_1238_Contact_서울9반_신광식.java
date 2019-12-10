package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_1238_Contact_서울9반_신광식 {
	public static int n, start;
	public static ArrayList<Integer>[] graph;
	public static int[] visit;

	public static class Node {
		int num;
		int depth;

		public Node(int num, int depth) {
			this.num = num;
			this.depth = depth;
		}
	}

	public static void bfs(Node start) {
		visit[start.num] = start.depth;
		Queue<Node> q = new LinkedList<Node>();
		q.offer(start);
		while (!q.isEmpty()) {
			Node curr = q.poll();
			for (int i = 0; i < graph[curr.num].size(); i++) {
				if (visit[graph[curr.num].get(i)] == 0) {
					q.add(new Node(graph[curr.num].get(i), curr.depth + 1));
					visit[graph[curr.num].get(i)] = curr.depth + 1;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1238.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());

			graph = new ArrayList[n + 1];
			for (int i = 0; i < graph.length; i++) {
				graph[i] = new ArrayList<>();
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n / 2; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph[a].add(b);
			}
			visit = new int[n + 1];
			bfs(new Node(start, 1));

			int maxDepth = 0, nodeNum = 0;
			for (int i = 0; i < visit.length; i++) {
				if (visit[i] >= maxDepth) {
					maxDepth = visit[i];
					nodeNum = i;
				}
			}
			System.out.println("#" + tc + " " + nodeNum);
		}
		br.close();
	}

}
