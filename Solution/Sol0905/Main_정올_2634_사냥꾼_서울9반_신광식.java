package jo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_정올_2634_사냥꾼_서울9반_신광식 {

	public static int binarySearch(int[] fire, int a) {
		int start = 0;
		int end = fire.length - 1;

		int middle = (start + end) / 2;
		while (start <= end) {
			middle = (start + end) / 2;
			if (fire[middle] == a) {
				return middle;
			} else if (fire[middle] > a) {
				end = middle - 1;
			} else {
				start = middle + 1;
			}
		}
		return middle;
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int[] fire = new int[m];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < m; i++) {
			fire[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(fire);
		int answer = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (b > l) {
				continue;
			}
			int idx = binarySearch(fire, a);
			if (Math.abs(fire[idx] - a) + b <= l) {
				answer++;
			} else if (idx - 1 >= 0 && Math.abs(fire[idx - 1] - a) + b <= l) {
				answer++;
			} else if (idx + 1 < fire.length && Math.abs(fire[idx + 1] - a) + b <= l) {
				answer++;
			}
		}
		System.out.println(answer);
		br.close();
	}

}
