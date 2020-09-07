package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_200902_백준_15591_MooTube_Silver {
	static int n, query, k, v;
	static ArrayList<Node>[] usado;
	static boolean[] visit;

	static class Node {
		int num;
		int value;

		public Node(int num, int value) {
			this.num = num;
			this.value = value;
		}

		@Override
		public String toString() {
			return num + "," + value;
		}

	}

	// 시작 정점 v에서 모든 정점을 탐색하면서
	// 유사도가 k 이상인 모든 정점을 큐에 추가
	static int bfs() {
		int count = 0;
		Queue<Integer> q = new LinkedList<>();
		q.offer(v);
		visit[v] = true;

		while (!q.isEmpty()) {
			int curr = q.poll();
			for (int i = 0; i < usado[curr].size(); i++) {
				Node next = usado[curr].get(i);
				if (!visit[next.num] && next.value >= k) {
					visit[next.num] = true;
					q.offer(next.num);
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		query = Integer.parseInt(st.nextToken());

		usado = new ArrayList[n + 1];
		visit = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			usado[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			Node node = new Node(q, r);
			usado[p].add(node);
			node = new Node(p, r);
			usado[q].add(node);
		}

		for (int i = 0; i < query; i++) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			System.out.println(bfs());
			Arrays.fill(visit, false);
		}

		br.close();
	}
}