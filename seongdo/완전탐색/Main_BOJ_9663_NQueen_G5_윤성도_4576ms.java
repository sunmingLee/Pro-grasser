package com.ssafy.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_9663_NQueen_G5_윤성도_4576ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		int[] info = new int[N];
		for(int i = 0; i < N; i++) {
			info[0] = i;
			ans += queen(info, 1, N);
		}
		System.out.println(ans);
	}
	public static int queen(int[] info, int index, int N) {
		if(index==N) return 1;
		int ans = 0;
		boolean chk;
		for(int i = 0; i < N; i++) {
			chk = true;
			for(int j = 0; j < index; j++) {
				if(i==info[j] || i + index == j + info[j] || i - index == info[j] - j) {
					chk = false;
					break;
				}
			}
			if(chk) {
				info[index] = i;
				ans += queen(info, index + 1, N);
			}
		}
		return ans;
	}
}