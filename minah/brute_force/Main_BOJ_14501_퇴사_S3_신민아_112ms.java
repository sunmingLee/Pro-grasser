package brute_force;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_14501_퇴사_S3_신민아_112ms {
	static int maxProfit = 0, workingDays;
	static boolean[] isScheduled;
	static int[] timeSpend, profit;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		workingDays = Integer.parseInt(br.readLine());
		
		isScheduled = new boolean[workingDays];
		timeSpend = new int[workingDays];
		profit = new int[workingDays];
		
		StringTokenizer st;
		for(int i=0;i<workingDays;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			timeSpend[i] = Integer.parseInt(st.nextToken());
			profit[i] = Integer.parseInt(st.nextToken());
		}
		
		getSubsetOfSchedules(0);
		
		System.out.print(maxProfit);
		
	}
	
	// 무식하게 모든 부분집합의 경우의 수를 찾아내는 코드
	private static void getSubsetOfSchedules(int cnt) {
		if(cnt == workingDays) { // 마지막 요소까지 고려 완료 시
			if(isAvailableSchedule()) { // 스케줄이 가능하다면
				int tempProfit = 0; // 해당 스케줄의 이익의 값
				
				for(int i=0;i<workingDays;i++) { // 스케줄이 있는 날마다 profit을 더해주기
					if(isScheduled[i]) tempProfit += profit[i];
				}
				
				maxProfit = Math.max(maxProfit, tempProfit); // 더 큰 값으로 저장
			}
			return;
		}
		
		isScheduled[cnt] = true; // 다음 스케줄 요소 고려
		getSubsetOfSchedules(cnt + 1);
		
		isScheduled[cnt] = false; // 다음 스케줄 요소 고려 x
		getSubsetOfSchedules(cnt + 1);
	}
	
	// 주어진 스케줄의 부분집합이 실제로 가능한지 찾아보는 메소드
	private static boolean isAvailableSchedule() {
		
		boolean[] schedule = new boolean[workingDays]; // 스케줄이 차있는지 확인하는 배열
		
		for(int i=0;i<workingDays;i++) { // 처음부터 마지막 날짜까지 고려
			if(isScheduled[i]) { // 스케줄링 된 날짜가 맞다면
				for(int j=i;j<i+timeSpend[i];j++) { // 스케줄링 한 날부터 스케줄이 끝나는 날까지 계산
					
					if(schedule[j] || i+timeSpend[i] > workingDays) // 이미 스케줄이 차있거나, 스케줄이 퇴사일 이후에도 지속되면
						return false; // 만들어질 수 없는 스케줄이므로 빠져나옴
					
					schedule[j] = true; // 스케줄이 비어있고, 퇴사일 안에 해당 스케줄이 동일하면 스케줄이 차있다고 표시
				}
			}
		}
		
		return true; // 모든 스케줄이 겹치지 않고 짤 수 있을때 true
	}

}
