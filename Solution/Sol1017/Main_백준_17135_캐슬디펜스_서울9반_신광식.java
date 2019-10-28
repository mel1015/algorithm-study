package boj.Sol1017;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_백준_17135_캐슬디펜스_서울9반_신광식 {
	static int n, m, d, maxTime, kill, answer;
	static int[][] map, copyMap;
	static boolean[] visit;
	static int[] ranger;
	static ArrayList<Pos> enemyList, copyEL;
	static PriorityQueue<Pos>[] killList;

	static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void enemyMove(ArrayList<Pos> removeList) {
		for (int i = 0; i < removeList.size(); i++) {
			if (copyEL.contains(removeList.get(i))) {
				kill++;
				copyEL.remove(removeList.get(i));
			}
		}
		for (int i = 0; i < copyEL.size(); i++) {
			copyEL.get(i).x++;
			if (copyEL.get(i).x >= n) {
				copyEL.remove(i);
				i--;
			}
		}
	}

	static void castleDefense() {
		int time = maxTime;
		while (time < n) {
			for (int i = 0; i < ranger.length; i++) {
				int rangerX = n;
				int rangerY = ranger[i];
				killList[i] = new PriorityQueue<>(new Comparator<Pos>() {
					@Override
					public int compare(Pos o1, Pos o2) {
						int distance1 = Math.abs(n - o1.x) + Math.abs(rangerY - o1.y);
						int distance2 = Math.abs(n - o2.x) + Math.abs(rangerY - o2.y);
						if (distance1 == distance2)
							return Integer.compare(o1.y, o2.y);
						return Integer.compare(distance1, distance2);
					}
				});
				for (int j = 0; j < copyEL.size(); j++) {
					int enemyX = copyEL.get(j).x;
					int enemyY = copyEL.get(j).y;
					int distance = Math.abs(rangerX - enemyX) + Math.abs(rangerY - enemyY);
					if (distance <= d) {
						Pos killedEnemy = copyEL.get(j);
						killList[i].add(killedEnemy);
					}
				}
			}
			ArrayList<Pos> removeList = new ArrayList<>();
			for (int i = 0; i < killList.length; i++) {
				if (!killList[i].isEmpty()) {
					Pos killedEnemy = killList[i].poll();
					if (copyEL.contains(killedEnemy)) {
						removeList.add(killedEnemy);
					}
				}
				killList[i].clear();
				;
			}
			enemyMove(removeList);
			time++;
		}
	}

	static void setRanger(int start, int cnt) {
		if (cnt == 3) {
			for (int i = 0; i < enemyList.size(); i++) {
				int x = enemyList.get(i).x;
				int y = enemyList.get(i).y;
				copyEL.add(new Pos(x, y));
			}
			kill = 0;
			castleDefense();
			answer = Math.max(answer, kill);
			copyEL.clear();
			return;
		}
		for (int i = start; i < m; i++) {
			if (!visit[i]) {
				visit[i] = true;
				ranger[cnt] = i;
				setRanger(i, cnt + 1);
				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		copyMap = new int[n][m];
		visit = new boolean[m];
		ranger = new int[3];
		enemyList = new ArrayList<>();
		copyEL = new ArrayList<>();
		killList = new PriorityQueue[3];
		boolean found = false;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (!found && map[i][j] == 1) {
					maxTime = i;
					found = true;
				}
				if (map[i][j] == 1)
					enemyList.add(new Pos(i, j));
			}
			copyMap[i] = map[i].clone();
		}
		setRanger(0, 0);
		System.out.println(answer);
	}

}
