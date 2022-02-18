package com.ssafy.IM;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_2851_슈퍼마리오_B1_윤성도_72ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		for(int i = 0; i < 10; i++) {
			int tmp = Integer.parseInt(br.readLine());
			sum += tmp;
			if(sum>100) {
				sum = sum<<1 <= 200 + tmp ? sum : sum-tmp;
				break;
			}
		}
		System.out.println(sum);
	}
}