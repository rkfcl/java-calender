package Java_Calender;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class prompt {
	public void runPrompt() {
		Calender cal = new Calender();

		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in, "euc-kr"));
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while (true) {

			System.out.println("+----------------------+");
			System.out.println("| 1. 일정 등록");
			System.out.println("| 2. 일정 검색");
			System.out.println("| 3. 달력 보기");
			System.out.println("| 4. 도움말");
			System.out.println("| 5. 종료");
			System.out.println("+----------------------+");
			try {
				int N = Integer.parseInt(br.readLine());
				switch (N) {
				case 1:
					ScheduleRegistration(br, cal);
					break;
				case 2:
					cmdplan(br, cal);
					break;
				case 3:
					cmdcal(br, cal);
					break;
				case 4:

					break;
				case 5:
					br.close();
					return;
				default:
					System.out.println("잘못된 값 입력");
					continue;
				}
			} catch (NumberFormatException | IOException e) {
				System.out.println("잘못된 값 입력!");
				continue;
			}

		}
	}

	public void cmdcal(BufferedReader br, Calender cal) {
		while (true) {
			System.out.println("년도와 달을 입력하세요(exit=-1)");
			try {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int Y = Integer.parseInt(st.nextToken());
				if (Y == -1) {
					break;
				}
				int M = Integer.parseInt(st.nextToken());

				if (M > 12 || M < 1) {
					System.out.println("잘못된 날짜 입력");
					continue;
				}
				cal.printCalender(Y, M);
				break;
			} catch (IOException e) {
				continue;
			}
		}
	}

	public void ScheduleRegistration(BufferedReader br, Calender cal) {
		while (true) {
			Date Date = null;
			String schedule = null;
			System.out.println("년도와 달 날짜를 입력 하시오.");
			try {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int YY = Integer.parseInt(st.nextToken());
				int MM = Integer.parseInt(st.nextToken());
				int DD = Integer.parseInt(st.nextToken());
				String YMD = String.format("%04d-%02d-%02d", YY, MM, DD);
				try {
					Date = new SimpleDateFormat("yyyy-MM-dd").parse(YMD);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} catch (IOException e) {
				continue;
			}
			System.out.println("일정 내용을 입력 하시오.");
			try {
				schedule = br.readLine();

			} catch (IOException e) {
				e.printStackTrace();
			}
			cal.PlanMap(Date, schedule);
			break;
		}

	}

	public void cmdplan(BufferedReader br,Calender cal) {
		Date Date = null;
		System.out.println("년도와 달 날짜를 입력 하시오.");
		while (true) {
			try {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int YY = Integer.parseInt(st.nextToken());
				int MM = Integer.parseInt(st.nextToken());
				int DD = Integer.parseInt(st.nextToken());
				String YMD = String.format("%04d-%02d-%02d", YY, MM, DD);
				try {
					Date = new SimpleDateFormat("yyyy-MM-dd").parse(YMD);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} catch (IOException e) {
				continue;
			}
			cal.cmdPlanMap(Date);
			break;
		}
	}

	public static void main(String[] args) throws IOException {
		prompt p = new prompt();
		p.runPrompt();

	}

}