package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_SWEA_3499_퍼펙트셔플_D3_윤성도 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int T, N, i, size;
	static String[] name;
	static boolean odd;
	static Queue<String> first = new LinkedList<String>();
	static Queue<String> second = new LinkedList<String>();
	
	public static void main(String[] args) throws IOException{
		T = Integer.parseInt(br.readLine());
		for(int TC = 1; TC <= T; TC++) {
			bw.write("#" + TC);
			N = Integer.parseInt(br.readLine());
			size = N/2;
			if(N%2==1) odd = true;
			else odd = false;
			name = br.readLine().split(" ");
			
			for(i = 0; i < size; i++) first.offer(name[i]);
			if(odd) first.offer(name[i++]);
			for(; i < N; i++) second.offer(name[i]);
			for(i = 0; i < size; i++) {
				bw.write(" " + first.poll());
				bw.write(" " + second.poll());
			}
			if(odd) bw.write(" " + first.poll());
			bw.write("\n");
		}
		bw.close();
	}
}
