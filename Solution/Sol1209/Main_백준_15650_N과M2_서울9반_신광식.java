package boj.Sol1209;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_15650_N과M2_서울9반_신광식 {
	public static int n, m;
	public static int[] data, visit, result;

	public static void permcomb(int start, int count) {
		if (count == m) {
			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		// 0부터 시작하면 중복 순열, start부터 시작하면 중복 조합
		for (int i = start; i < n; i++) {
			if (visit[i] == 0) {
				visit[i] = 1;
				result[count] = data[i];
				permcomb(i, count + 1);
				visit[i] = 0;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		data = new int[n];
		visit = new int[n];
		result = new int[m];
		for (int i = 0; i < data.length; i++) {
			data[i] = i + 1;
		}
		permcomb(0, 0);
		br.close();
	}

}
