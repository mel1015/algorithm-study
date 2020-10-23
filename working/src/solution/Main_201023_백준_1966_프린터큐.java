package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_201023_백준_1966_프린터큐 {
	static int n, m;
	static int[] priorities;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			priorities = new int[n];

			// 중요도 배열에 중요도와
			// 큐에 (중요도, 인덱스)를 넣어놓기
			Queue<int[]> q = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				int priority = Integer.parseInt(st.nextToken());
				priorities[i] = priority;
				q.offer(new int[] { priority, i });
			}

			// 중요도 배열 정렬 => 마지막 인덱스가 가장 중요도가 큼!!
			Arrays.sort(priorities);
			
			// count => 출력 횟수
			// maxIdx => 중요도 배열에서 가장 중요도가 큰 값의 인덱스
			int count = 1;
			int maxIdx = n - 1;
			
			// 현재 큐의 가장 앞에 있는 문서의 중요도가 가장 크다면 출력, 아니면 맨 뒤로
			// 출력한 문서의 인덱스가 내가 찾는 문서의 인덱스라면 정담 출력
			while (!q.isEmpty()) {
				int currPrior = q.peek()[0];
				int idx = q.poll()[1];
				if (currPrior == priorities[maxIdx]) {
					if (idx == m) {
						break;
					} else {
						count++;
						// 가장 큰 중요도의 문서가 출력되었으므로 그 다음으로 큰 중요도로
						maxIdx--;
					}
				} else {
					q.add(new int[] { currPrior, idx });
				}
			}
			System.out.println(count);
		}
		br.close();
	}

}
