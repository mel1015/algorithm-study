package jo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_정올_1370_회의실배정_Solution {

	public static class Meeting implements Comparable<Meeting> {
		int num;
		int start;
		int end;

		Meeting(int num, int start, int end) {
			this.num = num;
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting o) {
			return end - o.end;
		}
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		Meeting[] m = new Meeting[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			m[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(m);

		ArrayList<Meeting> list = new ArrayList<>();
		list.add(m[0]);
		for (int i = 1; i < m.length; i++) {
			if (list.get(list.size() - 1).end <= m[i].start) {
				list.add(m[i]);
			}
		}
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).num + " ");
		}
		br.close();
	}

}
