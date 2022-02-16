package com.ssafy.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_2839_설탕배달_B1_윤성도_76ms{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] bongji = {0, 1, 2, 1, 2};
		if(N==4 || N==7) System.out.println(-1);
		else System.out.println(N/5 + bongji[N%5]);
	}
}