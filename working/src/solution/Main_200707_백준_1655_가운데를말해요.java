package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// [https://yabmoons.tistory.com/478] 참고
public class Main_200707_백준_1655_가운데를말해요 {
	static int n;
	static int[] numbers;
	static PriorityQueue<Integer> maxPQ, minPQ;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		numbers = new int[n];
		maxPQ = new PriorityQueue<>(Collections.reverseOrder());
		minPQ = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 0; i < n; i++) {
			if (maxPQ.size() > minPQ.size())
				minPQ.add(-numbers[i]);
			else
				maxPQ.add(numbers[i]);

			if (maxPQ.isEmpty() == false && minPQ.isEmpty() == false) {
				if (maxPQ.peek() > -minPQ.peek()) {
					int maxValue = maxPQ.poll();
					int minValue = -minPQ.poll();

					maxPQ.add(minValue);
					minPQ.add(-maxValue);
				}
			}
			System.out.println(maxPQ.peek());
		}
		br.close();
	}
}