package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_200731_백준_13549_숨바꼭질3 {
	static int n, k;
	static int[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		visit = new int[100001];
		Arrays.fill(visit, Integer.MAX_VALUE / 2);

		Queue<Integer> q = new LinkedList<>();
		q.offer(n);
		visit[n] = 0;

		int answer = 0;
		// 조건을 확인하면서 현재 위치에서 이동할 수 있는 모든 위치를 큐에 저장
		while (!q.isEmpty()) {
			int curr = q.poll();
			if (curr == k) {
				answer = visit[k];
				break;
			}
			if (curr + 1 < 100001 && visit[curr + 1] > visit[curr] + 1) {
				visit[curr + 1] = visit[curr] + 1;
				q.offer(curr + 1);
			}
			if (curr - 1 >= 0 && visit[curr - 1] > visit[curr] + 1) {
				visit[curr - 1] = visit[curr] + 1;
				q.offer(curr - 1);
			}
			if (curr * 2 < 100001 && visit[curr * 2] > visit[curr]) {
				visit[curr * 2] = visit[curr];
				q.offer(curr * 2);
			}
		}
		System.out.println(answer);

		br.close();
	}
}