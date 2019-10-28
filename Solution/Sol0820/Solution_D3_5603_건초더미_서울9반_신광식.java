package d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_D3_5603_건초더미_서울9반_신광식 {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];

			int sum = 0;
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(br.readLine());
				sum += arr[i];
			}
			Arrays.sort(arr);

			int toMake = sum / n;
			int low = 0;
			int answer = 0;
			for (int i = arr.length - 1; i >= low;) {
				int diff = toMake - arr[low];
				if (arr[i] - diff >= toMake) {
					arr[i] -= diff;
					arr[low] += diff;
					answer += diff;
					low++;
				} else {
					diff = arr[i] - toMake;
					arr[i] -= diff;
					arr[low] += diff;
					answer += diff;
				}
				if (arr[i] == toMake)
					i--;
			}
			System.out.println("#" + tc + " " + answer);
		}
		br.close();
	}

}
