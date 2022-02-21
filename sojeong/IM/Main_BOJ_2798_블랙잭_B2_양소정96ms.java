package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2798_블랙잭_B2_양소정96ms{
	private static int ans = 0;
	private static int N,M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int []arr = new int[N];
 		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		com(0,0,arr,0);
		
		System.out.println(ans);
	
	
	}

	private static void com(int cnt,int start,int[] arr,int sum) {
		if(cnt == 3) {
			if(sum<=M && sum>ans) {
				ans = sum;
			}
		return;
		}
		
		for (int i = start; i < N; i++) {
			
			com(cnt+1,i+1,arr,sum+arr[i]);
			
		}
	}
}
