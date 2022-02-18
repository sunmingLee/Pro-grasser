package com.ssafy.IM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2798_블랙잭_B2_윤성도_80ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    int ans = 0;
	    int[] cards = new int[N];
	    st = new StringTokenizer(br.readLine());
	    for(int i=0; i<N; i++) cards[i] = Integer.parseInt(st.nextToken());
	    for(int i=0; i<N-2; i++){
	        for(int j=i+1; j<N-1; j++){
	            for(int k=j+1; k<N; k++){
	                int sum = cards[i] + cards[j] + cards[k];
	                if(ans<sum && sum<=M){
	                    ans=sum;
	                }
	            }
	        }
	    }
	    System.out.println(ans);
	}
}
