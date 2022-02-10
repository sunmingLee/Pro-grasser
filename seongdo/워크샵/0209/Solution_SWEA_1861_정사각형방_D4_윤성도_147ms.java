package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * N2개의 방이 N×N형태로 늘어서 있다.
 * 위에서 i번째 줄의 왼쪽에서 j번째 방에는 1이상 N2 이하의 수 Ai,j가 적혀 있으며, 이 숫자는 모든 방에 대해 서로 다르다.
 * 당신이 어떤 방에 있다면, 상하좌우에 있는 다른 방으로 이동할 수 있다.
 * 물론 이동하려는 방이 존재해야 하고, 이동하려는 방에 적힌 숫자가 현재 방에 적힌 숫자보다 정확히 1 더 커야 한다.
 * 처음 어떤 수가 적힌 방에서 있어야 가장 많은 개수의 방을 이동할 수 있는지 구하는 프로그램을 작성하라.
 */

public class Solution_SWEA_1861_정사각형방_D4_윤성도_147ms {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static StringTokenizer st;
	private static int T, N, tmp, num[][], K, ans[], dif;
	
	public static void main(String[] args) throws IOException{
		T = Integer.parseInt(br.readLine()); // 테스트케이스의 수 입력
		for(int TC = 1; TC <= T; TC++) {
			N = Integer.parseInt(br.readLine()); // 방 크기 입력
			num = new int[N*N+1][2]; // 방 번호(1~N*N)에 해당하는 i,j값 저장할 배열
			ans = new int[]{1, 1}; // 답 {방 번호, 갈 수 있는 방의 수}
			for(int i = 0; i < N; i++) { // 방 번호 입력
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					tmp= Integer.parseInt(st.nextToken());
					num[tmp][0] = i;
					num[tmp][1] = j;
				}
			} // 방 번호 입력 끝
			
			K = 1; // 현재 방 번호보다 1 큰 방이 갈 수 있는 방의 수, N*N은 더 큰 방이 없으므로 무조건 1
			for(int i = N*N-1; i > 0; i--) { // N*N-1번 방부터 1번방까지 1씩 감소하며 탐색
				dif = Math.abs(num[i+1][0] - num[i][0]) + Math.abs(num[i+1][1] - num[i][1]);
				if(dif == 1) K++;
				else { // 주변에 큰 방이 없을 때만 실행
					if(K >= ans[1]) {
						ans[1] = K;
						ans[0] = i+1;
					}
					K = 1;
				}
			}
			if(K >= ans[1]) { // 1번방이 최대값일 경우를 확인
				ans[1] = K;
				ans[0] = 1;
			}
			
			bw.write("#" + TC + " " + ans[0] + " " + ans[1] + "\n");
		} // 테스트케이스 반복 끝
		bw.close(); // 출력
	} // end of main
} // end of class