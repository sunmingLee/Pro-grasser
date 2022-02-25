package IM;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_8320_직사각형을만드는방법_B2_양소정_80ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		
		int cnt = 0;
		for (int i = 1; i <=N; i++) {
			for (int j = i; i*j <=N; j++) {  //가로 세로 곱은 사용된 갯수.  
				cnt++;						//정사각형 부터 열추가하면 안겹침
			}
		}
		System.out.println(cnt);
		
	}
}
