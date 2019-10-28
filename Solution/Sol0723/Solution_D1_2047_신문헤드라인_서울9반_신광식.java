package d1;

import java.util.Scanner;

public class Solution_D1_2047_신문헤드라인_서울9반_신광식 {
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("res/input_d1_2047.txt"));
		Scanner sc = new Scanner(System.in);

		// 문장 입력받기
		String str = sc.nextLine();
		// toUpperCase()를 사용해서  str을 대문자로 변경
		String answer = str.toUpperCase();
		
		System.out.println(answer);
	}
}
