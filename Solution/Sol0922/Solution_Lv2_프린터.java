package pgm;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_Lv2_프린터 {

	public int solution(int[] priorities, int location) {
		int answer = 0;
		Queue<int[]> q = new LinkedList<>();
		int[] num = new int[priorities.length];
		for (int i = 0; i < priorities.length; i++) {
			q.offer(new int[] { priorities[i], i });
		}
		while (!q.isEmpty()) {
			int[] maxPrior = Collections.max(q, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return Integer.compare(o1[0], o2[0]);
				}
			});
			int[] currPrior = q.poll();
			if (maxPrior[0] > currPrior[0]) {
				q.add(currPrior);
			} else if (maxPrior[0] == currPrior[0]) {
				answer++;
				if (currPrior[1] == location) {
					break;
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		int[] priorities = { 2, 1, 3, 2 };
		int[] priorities1 = { 1, 1, 9, 1, 1, 1 };
		int location = 0;
		Solution_Lv2_프린터 sol = new Solution_Lv2_프린터();
		int answer = sol.solution(priorities1, location);
		System.out.println(answer);
	}

}
