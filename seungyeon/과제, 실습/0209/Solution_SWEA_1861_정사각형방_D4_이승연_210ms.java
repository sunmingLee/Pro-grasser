import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1861_정사각형방_D4_이승연_210ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};
		
		for(int testCase=1; testCase<=TC; testCase++) {
			int N = Integer.parseInt(br.readLine());
			int[][] grid = new int[N+2][N+2];
			
			// grid 초기화 
			for(int i=1; i<=N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j=1; j<=N; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max_result = 0;
			int sp_n = 0;
			
			for(int r=1; r<=N; r++) {
				for(int c=1; c<=N; c++) { // 모든 경우의 수 따지기 
					int result = 1;

					int temp_r = r;
					int temp_c = c;
					 
					while(true) {
						boolean flag = false; 
						int cur_n = grid[temp_r][temp_c]; // 현재 위치의 값
						
						for(int d=0; d<4; d++){ // 사방 중에 
							if(grid[temp_r+dir[d][0]][temp_c+dir[d][1]] == cur_n+1) { // (현재 위치 값+1)인 값이 있으면  
								temp_r += dir[d][0]; // 그 쪽으로 이동 
								temp_c += dir[d][1];
								result++; // 이동 횟수 +1
								flag = true; 
								break;
							}
						}

						if(!flag) { // 사방 중에 이동할 수 있는 방이 없으면 결과 저장 후 stop 
							if(max_result < result) {
								sp_n = grid[r][c];
								max_result = result;
							} else if(max_result == result){
								if(grid[r][c] < sp_n) {
									sp_n = grid[r][c];
								}
							}
							break;
						}
					}
				}
			}

			sb.append("#").append(testCase).append(" ");
			sb.append(sp_n).append(" ").append(max_result).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
