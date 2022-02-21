package IM;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_2292_벌집_B2_양소정_80ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt =1;
		int ans =1;
		while(true) {
			if(N<=cnt) {
				break;
			}
			cnt +=ans*6; // 6의 배수로 증가
			ans++; //합겹씩 증가
			
		}
		System.out.println(ans);
	}		
}
