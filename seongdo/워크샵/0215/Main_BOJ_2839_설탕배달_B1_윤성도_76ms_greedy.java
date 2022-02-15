package com.ssafy.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_2839_설탕배달_B1_윤성도_76ms_greedy{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		
		while(N>=0) {
			if(N%5==0) {
				System.out.println(ans+N/5);
				return;
			}
			N-=3;
			ans++;
		}
		System.out.println(-1);
	}
}