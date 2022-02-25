package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_3985_롤케이크_B1_양소정_88ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());

		int amax = 0; // 기대되는 조각 개수
		int bmax = 0; // 실제 조각 개수
		int ans1=0;  //기대 번호
		int ans2=0;  //실제 번호
		
		boolean[] v = new boolean[L+1];
	
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p =Integer.parseInt(st.nextToken());
			int k =Integer.parseInt(st.nextToken());
			int max = k-p; // 기대되는 조각 수
			if(amax < max) {  //기대되는 조각수 많은거 갱신
				amax =max;
				ans1 =i;
			}
			
			int cnt =0;  //i번째 실제 조각 수 
			for (int j = p; j <= k; j++) {
				if(!v[j]) { 
					v[j] = true; 
					cnt++;      
				}
				
			}
			if(bmax < cnt) {
				bmax =cnt;
				ans2 =i;
			}
			
		}
		System.out.println(ans1);
		System.out.println(ans2);
	}
}
