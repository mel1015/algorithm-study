package d3;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_1208_Flatten_서울9반_신광식 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1208.txt"));
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int dump = sc.nextInt();
			int[] arr = new int[100];

			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			
			// 덤프 실행 => 정렬 후 가장 높은값 -1, 가장 낮은값 +1
			while (dump-- > 0) {
				Arrays.sort(arr);
				arr[99]--;
				arr[0]++;
			}
			Arrays.sort(arr);
			System.out.println("#" + tc + " " + (arr[99] - arr[0]));
		}
	}
}
