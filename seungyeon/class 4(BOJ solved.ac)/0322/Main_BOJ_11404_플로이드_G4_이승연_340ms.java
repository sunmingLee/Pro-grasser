import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_11404_플로이드_G4_이승연_340ms {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int[][] area = new int[n+1][n+1];
		
		for(int i=0; i<=n; i++) {
			Arrays.fill(area[i], 10000000);			
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			area[r][c] = Math.min(Integer.parseInt(st.nextToken()), area[r][c]);
		}
		
		
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				if(i == k) continue;
				for(int j=1; j<=n; j++) {
					if(i == j || j == k) continue;
					if(area[i][j] > area[i][k] + area[k][j]) {
						area[i][j] = area[i][k] + area[k][j];
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(i == j || area[i][j] == 10000000) {
					sb.append('0').append(" ");
				} else {
					sb.append(area[i][j]).append(" ");
				}
			}
			sb.append("\n");
		}
		
		System.out.print(sb.toString());
	}
}
