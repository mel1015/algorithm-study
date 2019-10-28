package jo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_정올_1370_회의실배정_서울9반_신광식 {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int[][] meetings = new int[n][3];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			meetings[i][0] = Integer.parseInt(st.nextToken());
			meetings[i][1] = Integer.parseInt(st.nextToken());
			meetings[i][2] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(meetings, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}

		});
		ArrayList<int[]> list = new ArrayList<>();
		list.add(meetings[0]);

		for (int i = 1; i < meetings.length; i++) {
			if (list.get(list.size() - 1)[2] <= meetings[i][1]) {
				list.add(meetings[i]);
			}
		}
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)[0] + " ");
		}
		br.close();
	}

}
