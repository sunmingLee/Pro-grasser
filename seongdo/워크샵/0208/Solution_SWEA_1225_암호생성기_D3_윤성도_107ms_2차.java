package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_SWEA_1225_암호생성기_D3_윤성도_107ms_2차 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input;
		
		while((input = br.readLine()) != null) {
			bw.write("#" + input);
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int min = Integer.MAX_VALUE;
			int[] arr = new int[8];
			for(int i = 0; i < 8; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				if(arr[i] < min) min = arr[i];
			}
			for(int i = 0; i < 8; i++) {
				arr[i] -= (min / 15 - 1) * 15;
			}
			int index = 0;
			int cur = 0;
			while(true) {
				index = index % 5 + 1;
				if(arr[cur] <= index) {
					arr[cur++] = 0;
					break;
				}
				arr[cur] -= index;
				cur = (cur + 1) % 8;
			}
			for(int i = 0; i < 8; i++) {
				bw.write(" " + arr[cur]);
				cur = (cur + 1) % 8;
			}
			bw.write("\n");
		}
		bw.close();
	}
}
