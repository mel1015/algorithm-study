package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1231_중위순회_서울9반_신광식2 {
	public static int N;
	public static String[] a;

	public static void inorder(int i) {
		if (i <= N) {
			inorder(2 * i);
			System.out.print(a[i - 1]);
			inorder(2 * i + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1231.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine());
			a = new String[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				a[i] = st.nextToken();
			}
			System.out.print("#" + tc + " ");
			inorder(1);
			System.out.println();
		}
		br.close();
	}

}
