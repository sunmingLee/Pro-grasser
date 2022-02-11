import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_16926_배열돌리기2_G5_이승연_548ms {
	private static int cur_sp; // 현재 회전시키는 사각형중 왼쪽 위 꼭짓점 좌표
	private static int cur_rotate; // 1회 회전에서 현재까지 회전시킨 사각형 수  
	private static int rotate_total_n; // 1회 회전에서 총 회전시켜야하는 사각형 수  
	private static String[][] grid;
	private static int R;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); // 가로 
		int M = Integer.parseInt(st.nextToken()); // 세로 
		R = Integer.parseInt(st.nextToken()); // 총 회전 횟수 
		
		grid = new String[N][M];
		
		rotate_total_n = N<M ? N/2 : M/2;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				grid[i][j] = st.nextToken();
			}
		}
		
		arrRotate(N, M);
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sb.append(grid[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void arrRotate(int r_num, int c_num) {
		// 기저파트 
		if(cur_rotate == rotate_total_n) return; 

		// 유도파트 
		int rotate_n = R%((r_num+c_num-2)*2); // S2와의 차이 : 회전하는 횟수가 한바퀴 원소보다 크면 반복됨.
		
		for(int ro=0; ro<rotate_n; ro++) {
			int r = cur_sp; 
			int c = cur_sp; 
			String temp = grid[r][c];
		
			for(int i=1; i<c_num; i++) { // ←
				grid[r][c] = grid[r][c+1];
				c++;
			}	
			for(int i=1; i<r_num; i++) { // ↑
				grid[r][c] = grid[r+1][c];
				r++;
			}
			for(int i=1; i<c_num; i++) { // →
				grid[r][c] = grid[r][c-1];
				c--;
			}
			for(int i=1; i<r_num-1; i++) { // ↓ 
				grid[r][c] = grid[r-1][c];
				r--;
			}
			
			grid[r][c] = temp;
			
		}
		
		cur_rotate++;
		cur_sp++;
		
		arrRotate(r_num-2, c_num-2);
	}
}
