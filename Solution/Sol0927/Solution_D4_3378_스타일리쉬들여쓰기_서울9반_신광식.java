package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_3378_스타일리쉬들여쓰기_서울9반_신광식 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_3378.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int P = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());

			int[][] RCSI_P = new int[P][4];
			int[][] RCS_Q = new int[Q][3];

			int openR = 0, openC = 0, openS = 0;
			for (int p = 0; p < P; p++) {
				RCSI_P[p][0] = openR;
				RCSI_P[p][1] = openC;
				RCSI_P[p][2] = openS;
				String line = br.readLine().trim();
				boolean isBeforeChars = true;
				int len = line.length();
				for (int i = 0; i < len; i++) {
					if (line.charAt(i) == '.') {
						if (isBeforeChars)
							RCSI_P[p][3]++;
					} else {
						isBeforeChars = false;
						switch (line.charAt(i)) {
						case '(':
							openR++;
							break;
						case ')':
							openR--;
							break;
						case '{':
							openC++;
							break;
						case '}':
							openC--;
							break;
						case '[':
							openS++;
							break;
						case ']':
							openS--;
							break;
						}
					}
				}
			}

			openR = 0;
			openC = 0;
			openS = 0;
			for (int q = 0; q < Q; q++) {
				RCS_Q[q][0] = openR;
				RCS_Q[q][1] = openC;
				RCS_Q[q][2] = openS;
				String line = br.readLine().trim();
				int len = line.length();
				for (int i = 0; i < len; i++) {
					switch (line.charAt(i)) {
					case '(':
						openR++;
						break;
					case ')':
						openR--;
						break;
					case '{':
						openC++;
						break;
					case '}':
						openC--;
						break;
					case '[':
						openS++;
						break;
					case ']':
						openS--;
						break;
					}
				}
			}

			int R = -1, C = -1, S = -1;

			int cntR = 0, cntC = 0, cntS = 0;
			for (int r = 1; r <= 20; r++) {
				for (int c = 1; c <= 20; c++) {
					for (int s = 1; s <= 20; s++) {
						boolean isAllSolved = true;
						for (int p = 1; p < P; p++) {
							if (r * RCSI_P[p][0] + c * RCSI_P[p][1] + s * RCSI_P[p][2] != RCSI_P[p][3]) {
								isAllSolved = false;
								break;
							}
						}
						if (isAllSolved) {
							if (R != r) {
								R = r;
								cntR++;
							}
							if (C != c) {
								C = c;
								cntC++;
							}
							if (S != s) {
								S = s;
								cntS++;
							}
						}
					}
				}
			}
			sb.append('#').append(tc);
			for (int q = 0; q < Q; q++) {
				if ((RCS_Q[q][0] != 0 && cntR != 1) || (RCS_Q[q][1] != 0 && cntC != 1)
						|| (RCS_Q[q][2] != 0 && cntS != 1)) {
					int tmpRes = -1;
					for (int p = 0; p < P; p++) {
						int idxA = -1, idxB = -1;
						int zeroCnt = 0;
						if (RCSI_P[p][0] == 0 && RCS_Q[q][0] == 0) {
							idxA = 1;
							idxB = 2;
							zeroCnt++;
						}
						if (RCSI_P[p][1] == 0 && RCS_Q[q][1] == 0) {
							idxA = 0;
							idxB = 2;
							zeroCnt++;
						}
						if (RCSI_P[p][2] == 0 && RCS_Q[q][2] == 0) {
							idxA = 0;
							idxB = 1;
							zeroCnt++;
						}

						if (zeroCnt != 1)
							continue;
						int pA = RCSI_P[p][idxA], pB = RCSI_P[p][idxB];
						int qA = RCS_Q[q][idxA], qB = RCS_Q[q][idxB];

						if (pA == 0 || pB == 0)
							continue;
						if (pA * qB == pB * qA) {
							tmpRes = qA * RCSI_P[p][3] / pA;
						}
					}
					sb.append(' ').append(tmpRes);
				} else {
					sb.append(' ').append(R * RCS_Q[q][0] + C * RCS_Q[q][1] + S * RCS_Q[q][2]);
				}
			}
			sb.append('\n');
		}

		System.out.print(sb.toString());
		br.close();
	}
}