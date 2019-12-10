package d3;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_1215_회문1_서울9반_신광식 {
	static char[][] strArr = new char[8][8];
	static int Answer = 0;

	// 입력된 문자열을 거꾸로 만들기
	public static String reverseString(String s) {
		return (new StringBuffer(s)).reverse().toString();
	}

	// 회문 세기 => 사이즈를 줄여나가면서 현재 문자열과 뒤집힌 문자열을 비교, 똑같다면 회문
	public static void countPalindrome(int strSize) {
		for (int i = 0; i < 8; i++) {
			// 현재 행의 문자열
			String str = new String(strArr[i]);
			
			// 문자열 사이즈 줄여나가기 => 8자리 문자열 => 7자리 문자열 ... 
			for (int j = 0; j < 8; j++) {
				// 사이즈가 8자리보다 크면 문자열 크기 초과
				if (j + strSize > 8)
					break;
				// substring(시작 index, 끝 index): 시작 index부터 끝 index만큼의 길이로 문자열 자르기
				String subStr = str.substring(j, j + strSize);
				// reverseString(string): 위에 선언한 문자열 뒤집기 함수
				String revStr = reverseString(subStr);
				// 현재 문자열과 뒤집힌 문자열 비교
				if (subStr.equals(revStr))
					Answer++;
			}
		}
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1215.txt"));
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int strSize = Integer.parseInt(sc.nextLine());
			Answer = 0;
			
			// 입력 받기
			for (int i = 0; i < 8; i++) {
				String line = sc.nextLine();
				strArr[i] = line.toCharArray();
			}
			// 회문 세기
			countPalindrome(strSize);
			// 세로열 회문을 세기위해 전치행렬로 변경
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (i < j) {
						char temp = strArr[i][j];
						strArr[i][j] = strArr[j][i];
						strArr[j][i] = temp;
					}
				}
			}
			// 전치행렬 회문 세기
			countPalindrome(strSize);
			System.out.println("#" + tc + " " + Answer);
		}
	}

}
