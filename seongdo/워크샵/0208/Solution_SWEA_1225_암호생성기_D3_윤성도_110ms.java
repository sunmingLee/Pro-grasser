package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_1225_암호생성기_D3_윤성도_110ms {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input;
		
		while((input = br.readLine()) != null) {
			bw.write("#" + input);
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int min = Integer.MAX_VALUE;
			Queue<Integer> q = new LinkedList<Integer>();
			for(int i = 0; i < 8; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp < min) min = tmp;
				q.offer(tmp);
			}
			for(int i = 0; i < 8; i++) q.offer(q.poll() - 15 * (min/15 - 1));
			int index = 0;
			while(true) {
				index = index % 5 + 1;
				if(q.peek() <= index) {
					q.poll();
					q.offer(0);
					break;
				}
				q.offer(q.poll() - index);
			}
			for(int i : q) bw.write(" " + i);
			bw.write("\n");
		}
		bw.close();
	}
}
