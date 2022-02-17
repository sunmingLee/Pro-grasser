package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 상담원으로 일하고 있는 백준이는 퇴사를 하려고 한다. 오늘부터 N+1일째 되는 날 퇴사를 하기 위해서, 남은 N일 동안 최대한 많은 상담을
 * 하려고 한다. 백준이는 비서에게 최대한 많은 상담을 잡으라고 부탁을 했고, 비서는 하루에 하나씩 서로 다른 사람의 상담을 잡아놓았다.
 * 각각의 상담은 상담을 완료하는데 걸리는 기간 Ti와 상담을 했을 때 받을 수 있는 금액 Pi로 이루어져 있다.
 *
 * 상담을 적절히 했을 때, 백준이가 얻을 수 있는 최대 수익을 구하는 프로그램을 작성하시오
 */
public class Main_BOJ_14501_퇴사_S3_이선민_80ms {

	private static int[][] schedule;
	private static int N, money;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); // 퇴사까지 남은 일 수
		schedule = new int[2][N + 1]; // 상담 일정표(날짜와 인덱스를 맞추기위해 N+1크기로 정함)
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			schedule[0][i] = Integer.parseInt(st.nextToken()); // 0행 : 상담을 완료하는데 걸리는 기간
			schedule[1][i] = Integer.parseInt(st.nextToken()); // 1행 : 상담을 했을때 받을수 있는 금액
		}

		money = 0; // 얻을 수 있는 최대이익
		makeSchedule(1, 0);

		System.out.print(money);
	} // end of main

	private static void makeSchedule(int date, int tempMoney) {
		// 이번에 확인할 상담의 완료 기간이 퇴사날짜를 넘는다면
		if (date > N) {
			// 지금까지 합한 이익과 최대 이익 비교
			money = tempMoney > money ? tempMoney : money;
			return;
		}

		if (date + schedule[0][date] <= N + 1) { // 퇴사 마지막날에 딱 상담이 완료되는 경우까지 포함
			makeSchedule(date + schedule[0][date], tempMoney + schedule[1][date]);
		} else {	// 현재날짜의 상담스케줄이 퇴사기간을 넘어가면 리턴해줄수있도록 한번더 메서드 실행
			makeSchedule(date + schedule[0][date], tempMoney);
		}
		
		// 다음날짜의 상담스케줄 확인
		makeSchedule(date + 1, tempMoney);

	} // end of makeSchedule

} // end of class
