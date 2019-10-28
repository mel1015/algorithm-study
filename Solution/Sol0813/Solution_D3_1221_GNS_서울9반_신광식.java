package d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution_D3_1221_GNS_서울9반_신광식 {
	// enum 선언
	public enum Number {
		ZRO, ONE, TWO, THR, FOR, FIV, SIX, SVN, EGT, NIN
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1221.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			br.readLine();
			String[] str = br.readLine().split(" ");

			Arrays.sort(str, new Comparator<String>() {
				// enum을 사용해서 비교
				@Override
				public int compare(String o1, String o2) {
					return Number.valueOf(o1).ordinal() - Number.valueOf(o2).ordinal();
				}

			});

			System.out.print("#" + tc + " ");
			for (int i = 0; i < str.length; i++) {
				System.out.print(str[i] + " ");
			}
			System.out.println();
		}
	}

}
