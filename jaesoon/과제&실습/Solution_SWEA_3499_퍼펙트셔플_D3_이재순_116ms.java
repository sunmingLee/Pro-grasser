package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_3499_퍼펙트셔플_D3_이재순_116ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());//테스트케이스 T 입력
		for (int testcase = 0; testcase < T; testcase++) {
			sb.append("#").append(testcase+1);
			int N = Integer.parseInt(br.readLine()); //카드의 수 N(1 ≤ N ≤ 1,000)입력
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N2 = N/2+N%2;//카드의 절반
			String[] arr = new String[N2]; // 카드절반을 담는 배열
			for (int i = 0; i < N2; i++) arr[i]=st.nextToken();//카드절반 배열 생성
			N2 = N/2;
			for (int i = 0; i < N2; i++) sb.append(" ").append(arr[i]).append(" ").append(st.nextToken());
			if (N%2!=0) sb.append(" ").append(arr[N2]);
			sb.append("\n");
		}
		System.out.print(sb);
	}//end of main
}//end of class
