package d4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution_D4_7701_염라대왕의이름정렬_서울9반_신광식2 {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length())
					return o1.compareTo(o2);
				return Integer.compare(o1.length(), o2.length());
			}
		});
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			bw.write("#" + tc + "\n");
			int n = Integer.parseInt(br.readLine().trim());
			Set<String> set = new HashSet<>();
			for (int i = 0; i < n; i++) {
				String str = br.readLine().trim();
				if (!set.contains(str)) {
					set.add(str);
					pq.add(str);
				}
			}
			while (!pq.isEmpty()) {
				bw.write(pq.poll() + "\n");
			}
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
