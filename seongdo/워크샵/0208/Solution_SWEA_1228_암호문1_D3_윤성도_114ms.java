package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_SWEA_1228_암호문1_D3_윤성도_114ms {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String input;
		int TC = 1;
		
		while((input = br.readLine()) != null) {
			int N = Integer.parseInt(input);
			LinkedList<Integer> ll = new LinkedList<Integer>();
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				ll.add(Integer.parseInt(st.nextToken()));
			}
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				char command = st.nextToken().charAt(0);
				switch(command) {
				case 'I':
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for(int j = x; j < x + y; j++) ll.add(j, Integer.parseInt(st.nextToken()));
				}
			}
			bw.write("#" + TC++);
			Iterator<Integer> iter = ll.iterator();
			for(int i = 0; i < 10; i++) {
				bw.write(" " + iter.next());
			}
            bw.write("\n");
		}
		bw.close();
	}
}