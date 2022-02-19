package com.ssafy.IM;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_2292_벌집_B2_윤성도_76ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()) - 1;
		int ans = 1;
		for(int i = 6; N > 0; N-=i, i+=6) ans++;
		System.out.println(ans);
	}
}
