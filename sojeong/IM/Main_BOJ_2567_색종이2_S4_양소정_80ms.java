package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2567_색종이2_S4_양소정_80ms{
	private static int[] dx = {-1,0,1,0}; //상 우 하 좌
	private static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans =0;
		int [][]map = new int[101][101];
		for (int tc = 0; tc < N; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int x =Integer.parseInt(st.nextToken());
			int y =Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k <10; k++) {
					
						map[x+j][y+k] = 1;	
				
				}
			}
		}
		
		for (int i = 0; i <100; i++) {
			for (int j = 0; j < 100; j++) {
				if(map[i][j]==1) {
					for (int k = 0; k < 4; k++) {
						int xx = i+dx[k];
						int yy = j+dy[k];
						if(xx<0 || xx>100 || yy<0 || yy>100) continue;  
						if(map[xx][yy]==0) ans++; //0이면 테두리
					}
				}
			}
		}	
		
		System.out.println(ans);

	}

}
