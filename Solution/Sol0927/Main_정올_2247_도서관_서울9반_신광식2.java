package jo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_정올_2247_도서관_서울9반_신광식2 {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		ArrayList<int[]> using = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			using.add(new int[] { from, to });
		}
		Collections.sort(using, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0])
					return Integer.compare(o1[1], o2[1]);
				return Integer.compare(o1[0], o2[0]);
			}
		});
		int start = using.get(0)[0];
		int end = using.get(0)[1];
		int maxUse = end - start;
		int maxEmp = using.get(0)[0] - 1;
		for (int i = 1; i < using.size(); i++) {
			if (end >= using.get(i)[0]) {
				end = Math.max(end, using.get(i)[1]);
				maxUse = Math.max(maxUse, end - start);
			} else {
				maxUse = Math.max(maxUse, end - start);
				maxEmp = Math.max(maxEmp, using.get(i)[0] - end);
				start = using.get(i)[0];
				end = using.get(i)[1];
			}
		}
		System.out.println(maxUse + " " + maxEmp);
		br.close();
	}

}
