package d3;

import java.util.Scanner;

public class Solution_D3_1289_원재의메모리복구하기_서울9반_신광식 {
	// 선택된 인덱스부터 뒤의 모든 값을 하나의 문자로 변경하는 함수
	static char[] change(char[] arr, char c, int idx) {
		for (int i = idx; i < arr.length; i++) {
			arr[i] = c;
		}
		return arr;
	}

	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int count = 0;
			String str = sc.next();

			char[] prevArr = str.toCharArray();
			char[] makeArr = new char[prevArr.length];

			for (int i = 0; i < makeArr.length; i++) {
				makeArr[i] = '0';
			}
			
			// [100, 000] 0번 인덱스부터 전부 1로     => [100, 111]
			// [100, 111] 1번 인덱스부터 전부 0으로  => [100, 100]
			for (int i = 0; i < prevArr.length; i++) {
				if (prevArr[i] != makeArr[i]) {
					makeArr = change(makeArr, prevArr[i], i);
//					System.out.println(Arrays.toString(makeArr));
					count++;
				}
			}
			System.out.println("#" + tc + " " + count);
		}
	}
}
