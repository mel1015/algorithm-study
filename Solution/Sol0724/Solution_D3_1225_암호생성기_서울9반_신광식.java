package d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D3_1225_암호생성기_서울9반_신광식 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1225.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			Queue<Integer> q = new LinkedList<Integer>();

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				q.offer(Integer.parseInt(st.nextToken()));
			}

			// 종료 플래그
			boolean isEnd = false;
			while (!isEnd) {
				for (int i = 1; i <= 5 && !isEnd; i++) {
					// 리스트의 맨 앞의 값에 1~5를 빼고
					int front = q.poll() - i;
					if (front <= 0) {
						// 0보다 작은 값이되면 종료
						isEnd = true;
						front = 0;
					}
					q.offer(front);
				}
			}
			System.out.print("#" + T + " ");
			for (int i = 0; i < 8; i++) {
				System.out.print(q.poll() + " ");
			}
			System.out.println();
		}
	}
}
