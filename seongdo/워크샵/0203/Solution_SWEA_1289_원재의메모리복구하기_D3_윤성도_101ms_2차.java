package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_SWEA_1289_원재의메모리복구하기_D3_윤성도_101ms_2차 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int TC=1; TC<=T; TC++) {
			String input = br.readLine();
			char chk = '0';
			int count = 0;
			int n = input.length();
			
			for(int i = 0; i < n; i++) {
				if(input.charAt(i) != chk) {
					chk = (char)(++count%2 + '0');
				}
			}
			sb.append("#" + TC + " " + count + "\n");
		}
		System.out.println(sb.toString());
	}
}