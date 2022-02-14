package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_6808_규영이와인영이의카드게임_D3_윤성도 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수
		
		//테스트 케이스의 수만큼 반복
		StringBuilder sb = new StringBuilder();
		for(int TC = 1; TC <= T; TC++) {
			boolean[] card = new boolean[19]; // 카드 정보
			for(int i = 1; i <= 18; i++) card[i] = true; // 1~18까지 카드 사용 가능
			int[] kyu = new int[9]; // 규영이의 카드 정보
			
			// 규영이의 카드 정보 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 9; i++) {
				kyu[i] = Integer.parseInt(st.nextToken());
				card[kyu[i]] = false; // 규영이가 뽑은 카드는 사용 불가
			}
			
			// 순열로 가능한 모든 경우
			int[] in = new int[9];
			int[] ans = new int[2];
			permu(card, kyu, in, ans, 0);
			// 정답 출력
			sb.append("#").append(TC).append(" ").append(ans[0]).append(" ").append(ans[1]).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void permu(boolean[] card, int[] kyu, int[] in, int[] ans, int num) {
		// 인영이의 카드가 9장이 되면 점수 계산
		if(num==9) {
			int kyuScore = 0, inScore = 0;
			for(int i = 0; i < 9; i++) {
				if(kyu[i]>in[i]) kyuScore += kyu[i] + in[i];
				else inScore += kyu[i] + in[i];
			}
			if(kyuScore > inScore) ans[0]++;
			else if(kyuScore < inScore) ans[1]++;
			return;
		}
		// 인영이의 카드가 9장이 될 때까지 가능한 카드를 추가
		for(int i = 1; i <= 18; i++) {
			if(card[i]==true) {
				card[i]=false;
				in[num]=i;
				permu(card, kyu, in, ans, num+1);
				card[i]=true;
			}
		}
	}
}
