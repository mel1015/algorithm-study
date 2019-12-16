package boj.Sol1211;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_16986_인싸들의가위바위보_서울9반_신광식 {
	static int n, k;
	static int[][] synastry, handSign;
	static boolean[] visit;
	static boolean isEnd;

	static void perm(int cnt) {
		if (isEnd)
			return;
		if (cnt == n + 1) {
			int[] idx = { 0, 1, 1, 1 };
			int[] win = { 0, 0, 0, 0 };
			int p1 = 1, p2 = 2, p3 = 3;
			while (true) {
				if (p1 > p2) {
					int temp = p1;
					p1 = p2;
					p2 = temp;
				}
				if (p1 == 1 && idx[1] > n)
					break;
				if (idx[p1] > 20 || idx[p2] > 20)
					break;
				int a = handSign[p1][idx[p1]++];
				int b = handSign[p2][idx[p2]++];
				if (synastry[a][b] == 2) {
					win[p1]++;
					int temp = p2;
					p2 = p3;
					p3 = temp;
					if (win[p1] == k)
						break;
				} else {
					win[p2]++;
					int temp = p1;
					p1 = p3;
					p3 = temp;
					if (win[p2] == k)
						break;
				}
			}
			if (win[1] >= k)
				isEnd = true;
			return;
		}
		for (int i = 1; i <= n; i++) {
			if (!visit[i]) {
				visit[i] = true;
				handSign[1][cnt] = i;
				perm(cnt + 1);
				visit[i] = false;
				handSign[1][cnt] = 0;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		synastry = new int[n + 1][n + 1];
		handSign = new int[4][21];
		visit = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				synastry[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 2; i < handSign.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < handSign[i].length; j++) {
				handSign[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		perm(1);
		if (isEnd)
			System.out.println(1);
		else
			System.out.println(0);
		br.close();
	}

}
