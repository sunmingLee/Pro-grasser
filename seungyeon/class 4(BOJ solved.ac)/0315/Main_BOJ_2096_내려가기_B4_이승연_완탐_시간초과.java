import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2096_내려가기_B4_이승연_완탐_시간초과 {
	private static int max_result;
	private static int min_result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 1<=N<=100000
		int[][] grid = new int[N][3];
		
		StringTokenizer st;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			grid[i][0] = Integer.parseInt(st.nextToken());
			grid[i][1] = Integer.parseInt(st.nextToken());
			grid[i][2] = Integer.parseInt(st.nextToken());
		}
		
		max_result = 0; 
		min_result = 900001;
		
		for(int i=0; i<3; i++) {
			calc(i, N, 0, 0, grid);
		}
		
		System.out.println(max_result+" "+min_result);
	}
	
	public static void calc(int s_col, int N, int level, int sum, int[][] grid) {
		if(level == N) {
			max_result = Math.max(max_result, sum);
			min_result = Math.min(min_result, sum);
			
			return;
		}
		
		switch(s_col) {
		case 0:
			calc(0, N, level+1, sum+grid[level][0], grid);
			calc(1, N, level+1, sum+grid[level][0], grid);
			break;
		case 1:
			calc(0, N, level+1, sum+grid[level][1], grid);
			calc(1, N, level+1, sum+grid[level][1], grid);
			calc(2, N, level+1, sum+grid[level][1], grid);
			break;
		case 2:
			calc(1, N, level+1, sum+grid[level][2], grid);
			calc(2, N, level+1, sum+grid[level][2], grid);
			break;
		}
	}
}
