package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_200723_백준_1476_날짜계산 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int e = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int maxE = 15;
		int maxS = 28;
		int maxM = 19;

		// checkS => s에서 28씩 증가하면서 s를 만들 수 있는 수
		int checkS = s;
		int answer = 0;
		while (true) {
			int modE = (checkS % maxE);
			if (modE == 0)
				modE = maxE;
			
			int modM = (checkS % maxM);
			if (modM == 0)
				modM = maxM;
			
			if (modE == e && modM == m) {
				answer = checkS;
				break;
			}
			checkS += 28;
		}
		System.out.println(answer);

		br.close();
	}
}