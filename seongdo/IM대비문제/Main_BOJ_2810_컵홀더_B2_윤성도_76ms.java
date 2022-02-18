package com.ssafy.IM;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_2810_컵홀더_B2_윤성도_76ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int L = 0;
		String input = br.readLine();
		for(int i = 0; i < N; i++) if(input.charAt(i)=='L') L++;
		System.out.println(Math.min(N, N+1-L/2));
	}
}
