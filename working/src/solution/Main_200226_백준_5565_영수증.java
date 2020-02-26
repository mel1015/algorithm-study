package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_200226_백준_5565_영수증 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int totalPrice = Integer.parseInt(br.readLine());
		for (int i = 0; i < 9; i++) {
			totalPrice -= Integer.parseInt(br.readLine());
		}
		System.out.println(totalPrice);
		br.close();
	}

}
