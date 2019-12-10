package d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_D3_7985_RootedBinaryTree재구성_서울9반_신광식 {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			String[] inorder = br.readLine().split(" ");
			Queue<String[]> q = new LinkedList<>();
			ArrayList<String> tree = new ArrayList<>();
			q.add(inorder);
			while (!q.isEmpty()) {
				String[] curr = q.poll();
				if (curr.length == 1) {
					tree.add(curr[0]);
				}
				// 배열을 반씩 나누어서 중간값 => 루트 노드
				// 좌측 배열 => 왼쪽 트리
				// 우측 배열 => 오른쪽 트리
				int mid = curr.length / 2;
				if (mid > 0) {
					// 트리에 루트 노드 추가
					tree.add(curr[mid]);
					// 큐에 루트를 기준으로 왼쪽 트리와 오른쪽 트리 나누어 저장
					q.add(Arrays.copyOfRange(curr, 0, mid));
					q.add(Arrays.copyOfRange(curr, mid + 1, curr.length));
				}
			}
			System.out.print("#" + tc + " ");
			int depth = 0, idx = 0;
			while (depth != n) {
				// 깊이 별 노드의 개수 => 2^(depth-1)개
				for (int i = 0; i < (int) Math.pow(2, depth); i++) {
					System.out.print(tree.get(idx++) + " ");
				}
				System.out.println();
				depth++;
			}
		}
		br.close();
	}

}
