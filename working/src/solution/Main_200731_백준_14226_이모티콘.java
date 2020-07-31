package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_200731_백준_14226_이모티콘 {
	static int s, answer;
	static int[][] visit;

	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 1, 0, 0 });
		visit[1][0] = 0;

		while (!q.isEmpty()) {
			int currCnt = q.peek()[0];
			int currClip = q.peek()[1];
			int currTime = q.poll()[2];

			if (currCnt == s) {
				answer = currTime;
				return;
			} else if (currCnt > s) {
				// 3번 연산
				if (currCnt - 1 > 0
						&& (visit[currCnt - 1][currClip] == 0 || visit[currCnt - 1][currClip] > currTime + 1)) {
					visit[currCnt - 1][currClip] = currTime + 1;
					q.offer(new int[] { currCnt - 1, currClip, currTime + 1 });
				}
			} else {
				// 1번 연산
				if (currCnt > currClip && (visit[currCnt][currCnt] == 0 || visit[currCnt][currCnt] > currTime + 1)) {
					visit[currCnt][currClip] = currTime + 1;
					q.offer(new int[] { currCnt, currCnt, currTime + 1 });
				}
				// 2번 연산
				if (visit[currCnt + currClip][currClip] == 0 || visit[currCnt + currClip][currClip] > currTime + 1) {
					visit[currCnt + currClip][currClip] = currTime + 1;
					q.offer(new int[] { currCnt + currClip, currClip, currTime + 1 });
				}
				// 3번 연산
				if (currCnt - 1 > 0
						&& (visit[currCnt - 1][currClip] == 0 || visit[currCnt - 1][currClip] > currTime + 1)) {
					visit[currCnt - 1][currClip] = currTime + 1;
					q.offer(new int[] { currCnt - 1, currClip, currTime + 1 });
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		s = Integer.parseInt(br.readLine());

		visit = new int[s * 2][s * 2];

		bfs();
		System.out.println(answer);

		br.close();
	}
}