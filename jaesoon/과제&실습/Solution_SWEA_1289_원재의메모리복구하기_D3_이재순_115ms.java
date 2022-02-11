package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_SWEA_1289_원재의메모리복구하기_D3_이재순_115ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for (int i = 0; i < testcase; i++) {
			String line = br.readLine();
			char idx = '0';
			int cnt = 0;
			int size = line.length();
			for (int j = 0; j < size; j++) {
				if (idx != line.charAt(j) ) {
					idx = line.charAt(j);
					cnt++;
				}
			}
			System.out.println("#"+(i+1)+" "+cnt);
		}
	}

}
