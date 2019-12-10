package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
	String item;
	int left;
	int right;

	public Node(String item, int left, int right) {
		this.item = item;
		this.left = left;
		this.right = right;
	}
}

public class Solution_D4_1232_사칙연산_서울9반_신광식 {
	public static Node[] tree;
	public static int Answer;
	public static int N;

	public static void calc() {
		for (int i = N; i >= 1; i--) {
			if (tree[i].left != 0) {
				int var1 = Integer.parseInt(tree[tree[i].left].item);
				int var2 = Integer.parseInt(tree[tree[i].right].item);
				switch (tree[i].item) {
				case "+":
					tree[i].item = String.valueOf((var1 + var2));
					break;
				case "-":
					tree[i].item = String.valueOf((var1 - var2));
					break;
				case "*":
					tree[i].item = String.valueOf((var1 * var2));
					break;
				case "/":
					tree[i].item = String.valueOf((var1 / var2));
					break;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1232.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine());
			tree = new Node[N + 1];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int idx = Integer.parseInt(st.nextToken());
				String value = st.nextToken();
				if (st.hasMoreTokens())
					tree[idx] = new Node(value, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				else
					tree[idx] = new Node(value, 0, 0);
			}
			calc();
			System.out.println("#" + tc + " " + tree[1].item);
		}
		br.close();
	}

}