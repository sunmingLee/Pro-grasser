package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JOL_1733_오목_양소정_156ms {
	static int []dx = {1,1,0,-1};
	static int []dy = {0,1,1,1};
	private static boolean[][][] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int[][]map = new int[20][20];
		for (int i = 1; i <=19; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 19; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visit = new boolean [20][20][4]
		
		for (int i = 1; i <= 19; i++) {
			for (int j = 1; j <= 19; j++) {
				for (int d = 0; d < 4; d++) {		
					if(map[i][j]!=0 && !visit[i][j][d]) { // 방문하지 않고 0이 아니고
						if((dfs(i,j,map,d,map[i][j]))==5) { 
						 System.out.println(map[i][j]);
						 System.out.println(i+" "+j);
						 System.exit(0);
							
						}
					}	
				}
			}		
		}
		System.out.println(0);
		
	}

	private static int dfs(int x,int y, int[][]map,int d, int color) {
		visit[x][y][d] = true;
		
		int xx = x+dx[d];
		int yy = y+dy[d];
		if(xx>0 && xx<= 19 && yy>0 && yy<=19 && map[x][y]== map[xx][yy]) {
			return dfs(xx,yy,map,d,map[xx][yy])+1; 
			
		}
		return 1;
	
	}

}
