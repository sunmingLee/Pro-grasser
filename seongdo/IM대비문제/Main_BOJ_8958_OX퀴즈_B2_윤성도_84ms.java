package com.ssafy.IM;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_8958_OX퀴즈_B2_윤성도_84ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			int point = 0, ans = 0;
			char[] tmp = br.readLine().toCharArray();
			for(char i : tmp) {
				switch(i) {
				case 'O':
					point++;
					ans += point;
					break;
				case 'X':
					point = 0;
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
}
