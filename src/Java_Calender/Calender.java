package Java_Calender;

import java.io.IOException;

public class Calender {
	private final static int[] Leap_Year_MaxDays = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private final static int[] MaxDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private final static String[] Days = { "SU", "MO", "TU", "WE", "TH", "FR", "SA" };

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
		for (int i = 1; i <= GetMaxDays(year, month); i++) {
			System.out.printf("%4d", i);
			if (i % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println();
	}

	public static void main(String[] args) throws IOException {

	}

}
