import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1210_Ladder1_D4_양소정_152ms{
	public static void main(String[] args) throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] dy = {-1, 1};
		int tcxn = 100;
		int tcyn = 100;
		for(int tc=1;tc<=10;tc++) {
			br.readLine();
			int[][] lad = new int[tcxn+2][tcyn+2];
			for(int i=1;i<=tcxn;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=1;j<=tcxn;j++) {
				
				lad[i][j] = Integer.parseInt(st.nextToken());
				}
			} 
			int y = 0;
			for(int i=1;i<=tcyn;i++) {
				if(lad[tcxn][i]==2) {
					y = i;
					break;
				}
			}
			for(int i=tcxn;i>0;i--) {
				for(int j=0;j<2;j++) {
					if(lad[i][y+dy[j]]==1) {
						while(lad[i][y+dy[j]]==1){//계속올라가기
								y = y+dy[j];
							}
							break;
					}
				}
			}
			sb.append("#"+tc+" "+(y-1)+"\n");
		}
		System.out.println(sb);
	}
}
