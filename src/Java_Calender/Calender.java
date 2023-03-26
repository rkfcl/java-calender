package Java_Calender;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;

public class Calender {

	private final static int[] Leap_Year_MaxDays = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private final static int[] MaxDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private final static String[] Days = { "SU", "MO", "TU", "WE", "TH", "FR", "SA" };

	private HashMap<Date, String> planmap = new HashMap<Date, String>();

	public void PlanMap(Date date, String str) {
		planmap.put(date, str);
	}

	public void cmdPlanMap(Date date) {
		System.out.println(planmap.get(date));
	}

	public int GetDayOfWeek(int year, int Month) {
		LocalDate date = LocalDate.of(year, Month, 1);
		DayOfWeek dayofweek = date.getDayOfWeek();
		return dayofweek.getValue();
	}

	public int GetMaxDays(int year, int Month) {
		if (leapYear(year, Month)) {
			return (Leap_Year_MaxDays[Month - 1]);
		}
		return (MaxDays[Month - 1]);
	}

	public boolean leapYear(int year, int Month) {
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			return true;
		}
		return false;
	}

	public void printCalender(int year, int month) {
		System.out.printf("	 %3d³â %3d¿ù\n", year, month);
		for (int i = 0; i < Days.length; i++) {
			System.out.printf("%4s", Days[i]);
		}
		System.out.println();
		System.out.println("----------------------------");
		for (int i = 0; i < GetDayOfWeek(year, month); i++) {
			System.out.printf("    ");
		}
		for (int i = 1; i <= GetMaxDays(year, month); i++) {
			System.out.printf("%4d", i);
			if ((i + GetDayOfWeek(year, month)) % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println();
	}

	public static void main(String[] args) throws IOException {

	}

}
