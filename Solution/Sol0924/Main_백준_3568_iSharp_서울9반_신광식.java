package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_3568_iSharp_서울9반_신광식 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		String type = st.nextToken();
		while (st.hasMoreTokens()) {
			String p = st.nextToken();
			StringBuffer sbParam = new StringBuffer();
			StringBuffer sbType = new StringBuffer();
			for (int i = 0; i < p.length(); i++) {
				char a = p.charAt(i);
				if (a == ',' || a == ';') {
					continue;
				} else if (Character.isAlphabetic(a)) {
					sbParam.append(a);
				} else {
					if (a == '[')
						a = ']';
					else if (a == ']')
						a = '[';
					sbType.append(a);
				}
			}
			String revType = sbType.reverse().toString();
			String param = sbParam.toString();
			System.out.println(type + revType + " " + param + ";");
		}
		br.close();
	}

}
