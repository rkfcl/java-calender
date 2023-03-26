package Java_Calender;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prompt {
	public void runPrompt() throws IOException {
		Calender cal = new Calender();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			
			System.out.println("년도와 달을 입력하세요");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int Y = Integer.parseInt(st.nextToken());
			if (Y == -1) {
				break;
			}
			int M = Integer.parseInt(st.nextToken());
			
			if (M > 12) {
				continue;
			}
			cal.printCalender(Y, M);

		}
		br.close();
	}

	public static void main(String[] args) throws IOException {
		prompt p = new prompt();
		p.runPrompt();

	}

}