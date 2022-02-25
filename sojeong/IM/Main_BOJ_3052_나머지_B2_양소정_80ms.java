package IM;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_3052_나머지_B2_양소정_80ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean []v = new boolean [10001];
		int cnt =0;
		for (int i = 0; i <10; i++) {
			int N = Integer.parseInt(br.readLine());
			int a = N%42;
			
			if(!v[a]) {
				v[a]= true;
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}
}
