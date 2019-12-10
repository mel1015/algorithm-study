package jo;

import java.util.Arrays;
import java.util.Scanner;

public class Main_정올_2634_사냥꾼_서울9반_신광식2 {

	public static int binarySearch(int[] a, int key) {
		int start = 0;
		int end = a.length - 1;

		int middle = (start + end) / 2;
		while (start <= end) {
			middle = (start + end) / 2;
			if (a[middle] == key) {
				return middle;
			} else if (a[middle] > key) {
				end = middle - 1;
			} else {
				start = middle + 1;
			}
		}
		return middle;
	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int l = sc.nextInt();
		int[] fire = new int[m];
		for (int i = 0; i < m; i++) {
			fire[i] = sc.nextInt();
		}
		Arrays.sort(fire);
		int answer = 0;
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if (b > l) {
				continue;
			}
			int idx = binarySearch(fire, a);
			if (Math.abs(fire[idx] - a) + b <= l) {
				answer++;
				continue;
			} else if (idx - 1 >= 0 && Math.abs(fire[idx - 1] - a) + b <= l) {
				answer++;
				continue;
			} else if (idx + 1 < fire.length && Math.abs(fire[idx + 1] - a) + b <= l) {
				answer++;
				continue;
			}
		}
		System.out.println(answer);
		sc.close();
	}

}
