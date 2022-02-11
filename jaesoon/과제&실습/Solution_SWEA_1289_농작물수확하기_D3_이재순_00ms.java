package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_SWEA_1289_농작물수확하기_D3_이재순_00ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testcase = Integer.parseInt(br.readLine());
		for (int i = 0; i < testcase; i++) {
			sb.append("#").append((i + 1)).append(" ");
			int size = Integer.parseInt(br.readLine());
			int b = size / 2 + 1;
			int a = b;
			int c = -1;
			int start, end;
			int sum = 0;
			for (int j = 0; j < b; j++) {
				a--;
				c+=2;
				start = a;
				end = a + c;
				String s = br.readLine();
				for (int k = start; k < end; k++) {
					sum += s.charAt(k) - '0';
				}
			}
			for (int j = b; j < size; j++) {
				a++;
				c-=2;
				start = a;
				end = a + c;
				String s = br.readLine();
				for (int k = start; k < end; k++) {
					sum += s.charAt(k) - '0';
				}
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}// end of main
}// end of class