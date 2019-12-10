package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main_백준_14225_부분수열의합_서울9반_신광식 {
	static int n;
	static int[] seq;
	static TreeSet<Integer> set;

	static void subSeq(int k, int sum) {
		if (k == n) {
			set.add(sum);
			return;
		}
		subSeq(k + 1, sum + seq[k]);
		subSeq(k + 1, sum);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		seq = new int[n];
		set = new TreeSet<>();
		for (int i = 0; i < n; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		subSeq(0, 0);
		for (int i = 1; i < Integer.MAX_VALUE; i++) {
			if (!set.contains(i)) {
				System.out.println(i);
				break;
			}
		}
		br.close();
	}

}
