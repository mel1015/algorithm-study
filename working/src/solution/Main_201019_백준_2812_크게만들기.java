package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_201019_백준_2812_크게만들기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		String num = br.readLine();

		Deque<Character> dq = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			while (k > 0 && !dq.isEmpty() && (int) (dq.peekLast() - '0') < (int) (num.charAt(i) - '0')) {
				dq.pollLast();
				k--;
			}
			dq.offerLast(num.charAt(i));
		}
		if (k > 0) {
			while (k > 0) {
				dq.pollLast();
				k--;
			}
		}
		for (int i = dq.size(); i > 0; i--) {
			System.out.print(dq.pollFirst());
		}
		System.out.println();
		br.close();
	}

}
