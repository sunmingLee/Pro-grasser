import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2096_내려가기_G4_이승연_336ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 1<=N<=100000
		int[][] grid = new int[N+1][3];
		
		StringTokenizer st;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			grid[i][0] = Integer.parseInt(st.nextToken());
			grid[i][1] = Integer.parseInt(st.nextToken());
			grid[i][2] = Integer.parseInt(st.nextToken());
		}
		
		int[][] maxDp = new int[N+1][3];
		int[][] minDp = new int[N+1][3];
		
		for(int i=0; i<3; i++) {
			maxDp[0][i] = grid[0][i];
			minDp[0][i] = grid[0][i];
		}
		
		for(int i=1; i<=N; i++) {
			maxDp[i][0] = Math.max(maxDp[i-1][0], maxDp[i-1][1]) + grid[i][0];
			maxDp[i][1] = Math.max(Math.max(maxDp[i-1][0], maxDp[i-1][1]), maxDp[i-1][2]) + grid[i][1];
			maxDp[i][2] = Math.max(maxDp[i-1][1], maxDp[i-1][2]) + grid[i][2];
			
			minDp[i][0] = Math.min(minDp[i-1][0], minDp[i-1][1]) + grid[i][0];
			minDp[i][1] = Math.min(Math.min(minDp[i-1][0], minDp[i-1][1]), minDp[i-1][2]) + grid[i][1];
			minDp[i][2] = Math.min(minDp[i-1][1], minDp[i-1][2]) + grid[i][2];
		}
		
		int max_result = Math.max(Math.max(maxDp[N][0], maxDp[N][1]), maxDp[N][2]);
		int min_result = Math.min(Math.min(minDp[N][0], minDp[N][1]), minDp[N][2]);
		
		System.out.println(max_result+" "+min_result);
	}
}
