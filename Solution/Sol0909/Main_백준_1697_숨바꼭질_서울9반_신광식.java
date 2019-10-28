package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_1697_숨바꼭질_서울9반_신광식 {
	public static int n, k, answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		int[] visit = new int[100001];
		if (n > k) {
			answer = n - k;
		} else if (n - k == 0) {
			answer = 0;
		} else {
			Queue<Integer> q = new LinkedList<>();
			q.offer(n);
			visit[n] = 1;
			while (!q.isEmpty()) {
				int curr = q.poll();
				int sub = curr - 1, sum = curr + 1, mul = curr * 2;
				if (sub >= 0 && (visit[sub] == 0 || visit[curr] + 1 < visit[sub])) {
					q.offer(sub);
					visit[sub] = visit[curr] + 1;
				}
				if (sum <= k && (visit[sum] == 0 || visit[curr] + 1 < visit[sum])) {
					q.offer(sum);
					visit[sum] = visit[curr] + 1;
				}
				if (mul <= k + 1 && (visit[mul] == 0 || visit[curr] + 1 < visit[mul])) {
					q.offer(mul);
					visit[mul] = visit[curr] + 1;
				}
			}
			answer = visit[k] - 1;
		}
		System.out.println(answer);
		br.close();
	}

}
