package com.ssafy.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_6603_로또_S2_윤성도_88ms_NP {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			if(k==0) break;
			int[] num = new int[k];
			int[] com = new int[k];
			for(int i = 0; i < k; i++) {
				num[i] = Integer.parseInt(st.nextToken());
				if(i < 6) com[i] = 0;
				else com[i] = 1;
			}
			do {
				for(int i = 0; i < k; i++) if(com[i]==0) sb.append(num[i]).append(" ");
				sb.append("\n");
			}while(nextPermutation(com));
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	private static boolean nextPermutation(int[] list) {
		int i = list.length - 1;
		int j = list.length - 1;
		while(i > 0 && list[i-1] >= list[i]) --i;
		if(i <= 0) return false;
		while(list[i-1] >= list[j]) --j;
		swap(list, i-1, j);
		j = list.length - 1;
		for(; i < j; ++i, --j) {
			swap(list, i, j);
		}
		return true;
	}
	private static void swap(int[] list, int a, int b) {
		int tmp = list[a];
		list[a] = list[b];
		list[b] = tmp;
	}
}
