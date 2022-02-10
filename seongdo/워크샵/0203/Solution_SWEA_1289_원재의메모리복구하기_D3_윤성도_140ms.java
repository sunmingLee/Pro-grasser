package com.ssafy.SWEA;

import java.util.Scanner;

public class Solution_SWEA_1289_원재의메모리복구하기_D3_윤성도_140ms {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for(int TC=1; TC<=T; TC++) {
			char chk = '0';
			int count = 0;
			String input = sc.nextLine();
			for(int i = 0; i < input.length(); i++) {
				if(input.charAt(i)!=chk) {
					count++;
					if(chk=='0') {
						chk++;
					}else {
						chk--;
					}
				}
			}
			System.out.printf("#%d %d\n", TC, count);
		}
	}
}