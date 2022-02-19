package com.ssafy.IM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BOJ_2309_일곱난쟁이_B2_윤성도_76ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = -100;
		int[] dwarf = new int[9];
		for(int i = 0; i < 9; i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
			sum+=dwarf[i];
		}
		Arrays.sort(dwarf);
		for(int i = 0; i < 9; i++) {
			for(int j = i + 1; j < 9; j++) {
				if(dwarf[i]+dwarf[j] == sum) {
					StringBuilder sb = new StringBuilder();
					for(int k = 0; k < 9; k++) {
						if(k==i || k==j) continue;
						sb.append(dwarf[k]).append("\n");
					}
					System.out.println(sb.toString());
					return;
				}
			}
		}
	}
}
