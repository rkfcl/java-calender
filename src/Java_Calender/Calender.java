package Java_Calender;

import java.io.IOException;

public class Calender {
	private final static int[] MaxDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private final static String[] Days = { "SU", "MO", "TU", "WE", "TH", "FR", "SA" };

	public int GetMaxDays(int Month) {
		return (MaxDays[Month - 1]);
	}

	public void printCalender(int year, int month) {
		System.out.printf("	 %3d³â %3d¿ù\n", year, month);
		for (int i = 0; i < Days.length; i++) {
			System.out.printf("%4s", Days[i]);
		}
		System.out.println();
		System.out.println("----------------------------");
		for (int i = 1; i <= GetMaxDays(month); i++) {
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
