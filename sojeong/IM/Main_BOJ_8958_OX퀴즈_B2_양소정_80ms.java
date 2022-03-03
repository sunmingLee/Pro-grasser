package IM;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_8958_OX퀴즈_B2_양소정_80ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int ans =0; //도합
			int cnt =0; //누적합
			String str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				if(str.charAt(j)=='O') {
					cnt++; 
					ans +=cnt; 
					
				}else {
					cnt=0; //X면 0초기화
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
		
	}
}
