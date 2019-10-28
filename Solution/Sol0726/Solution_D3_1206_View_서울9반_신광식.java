package d3;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D3_1206_View_서울9반_신광식 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1206.txt"));
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N];

			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}

			int answer = 0;
			for (int i = 0; i < arr.length; i++) {
				int view = Integer.MAX_VALUE;
				if (arr[i] > 0) {
					if (arr[i - 2] < arr[i] && arr[i - 1] < arr[i] 
							&& arr[i + 1] < arr[i] && arr[i + 2] < arr[i]) {
						view = Math.min(view, arr[i] - arr[i - 2]);
						view = Math.min(view, arr[i] - arr[i - 1]);
						view = Math.min(view, arr[i] - arr[i + 1]);
						view = Math.min(view, arr[i] - arr[i + 2]);
						answer += view;
					}
				}
			}
			System.out.println("#" + tc + " " + answer);
		}
	}
}
