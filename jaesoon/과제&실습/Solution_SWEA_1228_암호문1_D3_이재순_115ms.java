package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_SWEA_1228_암호문1_D3_이재순_115ms {
	public static void main(String[] args) throws IOException {
		BufferedReader	br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N,M,n,idx,temp;
		LinkedList<Integer> ll = new LinkedList<Integer>();
		for (int i = 1; i < 11; i++) {
			sb.append("#").append(i);
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			if(N>10) for (int j = 0; j < 10; j++) ll.add(Integer.parseInt(st.nextToken()));
			else{
				for (int j = 0; j < 10; j++) {
					if (j<N) ll.add(Integer.parseInt(st.nextToken()));
					else ll.add(0);
				}
			}
			M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				while (st.hasMoreTokens()&&!st.nextToken().equals("I")) {}
				idx = Integer.parseInt(st.nextToken());
				n = Integer.parseInt(st.nextToken());
				temp = Integer.min(10-idx, n);
				for (int j2 = 0; j2 < n; j2++) {
					if (j2<temp) {
						ll.add(idx++,Integer.parseInt(st.nextToken()));
						ll.removeLast();
					}
					else break;
				}
			}
			for (Integer integer : ll) sb.append(" ").append(integer);
			ll.clear();
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
