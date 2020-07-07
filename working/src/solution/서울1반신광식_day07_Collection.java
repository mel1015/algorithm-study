package solution;

import java.util.*;;

public class 서울1반신광식_day07_Collection {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());

		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		System.out.println(year + " " + month);

		int days = 0;
		int[] daysOfMonth = new int[12];
		for (int i = 0; i < daysOfMonth.length; i++) {
			if (i == 3 || i == 5 || i == 8 || i == 10) {
				daysOfMonth[i] = 30;
			} else if (i == 1) {
				if ((year % 4 == 0) && (year % 100 != 0) || (year % 400) == 0)
					daysOfMonth[i] = 29;
				else
					daysOfMonth[i] = 28;
			} else {
				daysOfMonth[i] = 31;
			}
		}
		days = daysOfMonth[month];
		System.out.println(days + " days");
	}

}
