package jo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_정올_2247_도서관_서울9반_신광식 {

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
				return Integer.compare(o1[0], o2[0]);
			}
		});
		ArrayList<int[]> list = new ArrayList<>();
		list.add(using.get(0));
		for (int i = 1; i < using.size(); i++) {
			int currFrom = using.get(i)[0];
			int currTo = using.get(i)[1];
			int size = list.size();
			boolean make = true;
			for (int j = 0; j < size; j++) {
				int listFrom = list.get(j)[0];
				int listTo = list.get(j)[1];
				if (currFrom <= listTo && listTo <= currTo) {
					list.remove(j);
					list.add(new int[] { listFrom, currTo });
					make = false;
				} else if (currFrom >= listFrom && currTo <= listTo) {
					make = false;
					continue;
				}
			}
			if (make) {
				list.add(using.get(i));
			}
		}
		int maxUse = 0, maxEmp = 0;
		if (list.size() == 1) {
			maxUse = list.get(0)[1] - list.get(0)[0];
		} else {
			for (int i = 0; i < list.size(); i++) {
				maxUse = Math.max(maxUse, list.get(i)[1] - list.get(i)[0]);
			}
			maxEmp = list.get(0)[0] - 1;
			for (int i = 0; i < list.size() - 1; i++) {
				maxEmp = Math.max(maxEmp, list.get(i + 1)[0] - list.get(i)[1]);
			}
		}
		System.out.println(maxUse + " " + maxEmp);
		br.close();
	}

}
