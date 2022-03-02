package 기지국_교환학생;

import java.util.Scanner;

// 1. 수업이 있는 요일에 대해 시작점 처리 (머루르는 시간)
// 2. 시작점부터 N일동안 수강할때까지 날짜 계산

public class Solution_SWEA_13038_교환학생 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			int N = sc.nextInt();
			
			int[] week = new int[7];
			for (int i = 0; i < 7; i++) {
				week[i] = sc.nextInt();
			}
			
			int min =Integer.MAX_VALUE;
			for (int start = 0; start < 7; start++) { 
				//수업이 시작하는 모든 요일 처리
				if(week[start] == 0) continue; //수업이 열리지 않는 날은 패스
				int day = start, cnt =0;
				while(true) {
					if(week[day%7]==1) cnt++;
					++day;//하루 지남
					if(cnt == N) { //머무른 최소일수
						min = Math.min(min, day-start);
						break;
					}
				
				}
				
			}
			System.out.println("#"+tc+" "+min);
		}
		
	}

}
