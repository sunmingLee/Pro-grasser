package IM;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_2999_비밀이메일_B1_양소정_76ms{
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String msg = br.readLine();
		int N = msg.length();
		int sqrt = (int) Math.sqrt(N); //sqrt함수 제곱근
		int R = 0, C = 0;
		for(int i=1; i<=sqrt; i++) {
			if(N%i==0) {
				R = i;
				C = N/i;
			}
		}
		
		char map [][] = new char[R][C];
		int idx =0;
		for (int i = 0; i <C; i++) {
			for (int j = 0; j < R; j++) {
				map[j][i] = msg.charAt(idx++);
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
		}
		
	}

}
