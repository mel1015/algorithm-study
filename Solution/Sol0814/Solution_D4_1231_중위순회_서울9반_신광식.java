package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1231_중위순회_서울9반_신광식 {
	public static String[] val;

	class Tree {
		class Node {
			int data;
			Node left, right;
		}

		Node root;

		public void inorder(Node root) {
			if (root != null) {
				inorder(root.left);
				System.out.print(val[root.data - 1]);
				inorder(root.right);
			}
		}

		public void makeTree(int d1, int d2) {
			if (root == null) {
				root = new Node();
				root.data = d1;
			}
			makeTree(root, d1, d2);
		}

		public Node makeTree(Node root, int d1, int d2) {
			if (root == null) {
				root = new Node();
				root.data = d2;
				return root;
			}
			if (root.data == d1) {
				if (root.left == null) {
					root.left = makeTree(root.left, d1, d2);
				} else if (root.right == null) {
					root.right = makeTree(root.right, d1, d2);
				}
				return root;
			}
			makeTree(root.left, d1, d2);
			makeTree(root.right, d1, d2);
			return root;
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1231.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int tc = 1; tc <= 10; tc++) {
			Tree t = new Solution_D4_1231_중위순회_서울9반_신광식().new Tree();
			int N = Integer.parseInt(br.readLine());
			val = new String[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int root = Integer.parseInt(st.nextToken());
				val[i] = st.nextToken();
				while (st.hasMoreTokens()) {
					t.makeTree(root, Integer.parseInt(st.nextToken()));
				}
			}
			System.out.print("#" + tc + " ");
			t.inorder(t.root);
			System.out.println();
		}
		br.close();
	}

}
