package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_13300_방배정_B2_양소정 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int [][] arr = new int[2][7];
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			
			arr[s][g]++;
			
			
		}
		for (int i = 0; i <2; i++) {
			for (int j = 1; j <= 6; j++) {
				
				cnt+=arr[i][j]/K; 
				if(arr[i][j]%K!=0) cnt++;
				
			}
		}
		
		System.out.println(cnt);
		
		
	}

}
