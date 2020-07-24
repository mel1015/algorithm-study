package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_200724_백준_10973_이전순열 {
	static int n;
	static int[] p;

	static boolean prevPermutation() {
		// 1. 교환이 필요한 위치 찾기(i-1)
		int i = n - 1;
		while (i > 0 && p[i - 1] <= p[i])
			--i;
		if (i == 0)
			return false; // 이미 가장 작은 순열이므로 이전 순열 없음.

		// 2. i-1위치값이랑 교환할 j값 찾기(i-1 위치 뒤쪽에서)
		int j = n - 1;
		while (p[i - 1] <= p[j])
			--j;

		// 3. i-1위치값하고 j위치값 교환
		p[i - 1] ^= p[j];
		p[j] ^= p[i - 1];
		p[i - 1] ^= p[j];

		// 4. i-1위치 뒤쪽으로 가장 작은 순열로 정렬
		j = n - 1;
		while (i < j) {
			p[i] ^= p[j];
			p[j] ^= p[i];
			p[i] ^= p[j];
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		p = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}

		if (prevPermutation()) {
			for (int i = 0; i < n; i++) {
				System.out.print(p[i] + " ");
			}
		} else
			System.out.println(-1);

		br.close();
	}
}