package boj.Sol1115;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_백준_17837_새로운게임2_서울9반_신광식 {
	static int n, k;
	static int[][] colorMap;
	static ArrayList<Mal>[][] malMap;
	static ArrayList<Mal> mals;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int[] newDir = { 1, 0, 3, 2 };

	// 좌표, 방향을 가지고있는 체스말 클래스
	static class Mal {
		int num;
		int x;
		int y;
		int dir;

		public Mal(int num, int x, int y, int dir) {
			this.num = num;
			this.x = x;
			this.y = y;
			this.dir = dir;
		}

		// 클래스 만들 때 toString 꼭 만들자 => 디버깅 쉬워짐
		@Override
		public String toString() {
			return num + "";
		}
	}

	// 0번부터 n-1번까지 각각의 말의 이동, 이동 후 좌표의 사이즈 리턴(쌓인 말의 개수)
	static int moveMal(int num) {
		Mal curMal = mals.get(num);
		int x = curMal.x;
		int y = curMal.y;
		int dir = curMal.dir;
		int nx = x + dx[dir];
		int ny = y + dy[dir];

		// 체스판 밖으로 벗어나거나 파란색을 밟았을 때
		if (nx < 0 || nx >= n || ny < 0 || ny >= n || colorMap[nx][ny] == 2) {
			curMal.dir = newDir[dir];
			nx = x + dx[curMal.dir];
			ny = y + dy[curMal.dir];
			// 또 다시 밖이나 파란색이면 방향만 바뀌고 사이즈 리턴
			if (nx < 0 || nx >= n || ny < 0 || ny >= n || colorMap[nx][ny] == 2)
				return malMap[x][y].size();
		}
		// 현재 위치의 쌓인 말 리스트, 다음 위치의 쌓인 말 리스트
		ArrayList<Mal> cur = malMap[x][y];
		ArrayList<Mal> next = malMap[nx][ny];
		
		// 현재 말이 현재 리스트의 몇번째에 있는지 확인 => subList 만들기 위해
		int index = 0;
		for (int i = 0; i < cur.size(); i++) {
			if (cur.get(i).num == num) {
				index = i;
				break;
			}
		}
		
		// subList를 만들어 현재 이동한 말과 현재 말 위에 쌓인 모든 말을 부분 리스트로 생성
		List<Mal> subList = new ArrayList<>();
		subList = cur.subList(index, cur.size());
		
		// 다음 위치가 빨간색이면 모든 말의 쌓여인는 순서 반대로 변경
		if (colorMap[nx][ny] == 1)
			Collections.reverse(subList);
		
		// subList 내의 모든 말의 좌표 변경 => 현재 말이 이동해서 위의 모든 말도 이동
		for (Iterator<Mal> it = subList.iterator(); it.hasNext();) {
			Mal mal = (Mal) it.next();
			mal.x = nx;
			mal.y = ny;
			// 다음 좌표에 추가
			next.add(mal);
		}
		// 현재 좌표에서 이동한 모든 말 삭제
		cur.removeAll(subList);
		return next.size();
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		colorMap = new int[n][n];
		malMap = new ArrayList[n][n];
		mals = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				malMap[i][j] = new ArrayList<>();
				colorMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken()) - 1;
			Mal mal = new Mal(i, x, y, dir);
			mals.add(mal);
			malMap[x][y].add(mal);
		}
		int turn = 0;
		boolean isEnd = false;
		while (turn <= 1000 && !isEnd) {
			turn++;
			for (int j = 0; j < k; j++) {
				if (moveMal(j) >= 4) {
					isEnd = true;
					break;
				}
			}
		}
		System.out.println((turn > 1000) ? -1 : turn);
		br.close();
	}

}
