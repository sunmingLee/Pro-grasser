package com.ssafy.JO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JO_1828_냉장고_윤성도_137ms {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] temp = new int[N][2];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			temp[i][0] = Integer.parseInt(st.nextToken()); // i번째 물질의 최저보관온도
			temp[i][1] = Integer.parseInt(st.nextToken()); // i번째 물질의 최고보관온도
		}
		Arrays.sort(temp, (A, B) -> A[1] - B[1]);
		
		int low = 1, high = 0, answer = 1;
		while(low < N) {
			if(temp[low][0] > temp[high][1]) {
				answer++;
				high = low;
			}
			else low++;
		}
		System.out.println(answer);
	}
}
