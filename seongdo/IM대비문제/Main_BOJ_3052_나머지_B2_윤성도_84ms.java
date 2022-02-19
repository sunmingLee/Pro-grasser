package com.ssafy.IM;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_3052_나머지_B2_윤성도_84ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] chk = new boolean[42];
		int ans = 0, n = 10;
		while(n-->0) {
			int tmp = Integer.parseInt(br.readLine())%42;
			if(chk[tmp]) continue;
			chk[tmp] = true;
			ans++;
		}
		System.out.println(ans);
	}
}