package com.ssafy.IM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2567_색종이2_S4_윤성도_80ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] white = new int[102][102];
		int black[] = new int[2];
		int dulle = 0;

		int n = Integer.parseInt(br.readLine());
		while(n-- > 0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			black[0] = Integer.parseInt(st.nextToken());
			black[1] = Integer.parseInt(st.nextToken());
			for(int i = black[0] ; i < black[0] + 10 ; i++ ){
				for(int j = black[1] ; j < black[1] + 10; j++ ){
					white[i][j] = 1;
				}
			}
		}

		for(int i = 1 ; i <= 100 ; i++ ){
			for (int j = 1 ; j <= 100 ; j++ ){
				if( white[i][j] == 1 ){
					if( white[i-1][j] == 0 )
						dulle++;
					if( white[i+1][j] == 0 )
						dulle++;
					if( white[i][j-1] == 0 )
						dulle++;
					if( white[i][j+1] == 0 )
						dulle++;
				}
			}
		}

		System.out.println(dulle);
	}
}
