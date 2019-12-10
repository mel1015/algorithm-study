package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_D4_1219_길찾기_서울9반_신광식2 {
	public static ArrayList<Integer>[] graph;
	public static boolean[] visit;
	public static int answer = 0;

	public static void dfs(int start) {
		visit[start] = true;
		if (start == 99) {
			answer = 1;
			return;
		}
		for (int i = 0; i < graph[start].size(); i++) {
			if (!visit[graph[start].get(i)])
				dfs(graph[start].get(i));
		}
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1219.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());

			graph = new ArrayList[n];
			visit = new boolean[100];

			for (int i = 0; i < n; i++) {
				graph[i] = new ArrayList<>();
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				graph[from].add(to);
			}

			answer = 0;
			dfs(0);
			System.out.println("#" + t + " " + answer);
		}
		br.close();
	}

}
