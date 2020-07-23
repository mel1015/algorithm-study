package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_200723_백준_2309_일곱난쟁이 {
	static int n;
	static int[] heights;
	static int[] p;

	static boolean nextCombi() {
		// 1. 교환이 필요한 위치를 찾는다. i-1을 찾는것
		int i = n - 1;
		while (i > 0 && p[i - 1] >= p[i])
			--i;

		if (i == 0)
			return false;// 이미 가장 큰순열이므로 다음 순열 없음

		// 2. i-1 위차값이랑 교환할 j값 찾기
		int j = n - 1;
		while (p[i - 1] >= p[j])
			--j;

		// 3. i-1 위치값하고 j위치값 교환
		swap(i - 1, j);

		// 4. i-1 위치 뒤쪽으로 가장 작은 순열로 정렬
		j = n - 1;
		while (i < j) {
			swap(i, j);
			++i;
			--j;
		}
		return true;
	}

	static void swap(int a, int b) {
		int tmp = p[a];
		p[a] = p[b];
		p[b] = tmp;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = 9;
		heights = new int[n];
		for (int i = 0; i < n; i++) {
			heights[i] = Integer.parseInt(br.readLine());
		}

		p = new int[n];
		p[n - 1] = p[n - 2] = p[n - 3] = p[n - 4] = p[n - 5] = p[n - 6] = p[n - 7] = 1;
		Arrays.sort(p);

		// 현재 풀이 => 조합으로 9개중 7개를 뽑는다
		// 쉬운 풀이 => 9개중 2개를 뽑아, 키의 총합에서 뺀 값이 100이면 답
		int[] answer = new int[7];
		do {
			int sum = 0;
			int idx = 0;
			for (int i = 0; i < n; i++) {
				if (p[i] == 1) {
					sum += heights[i];
					answer[idx++] = heights[i];
				}
			}
			if (sum == 100) {
				Arrays.sort(answer);
				for (int i = 0; i < answer.length; i++) {
					System.out.println(answer[i]);
				}
				break;
			}
		} while (nextCombi());

		br.close();
	}
}