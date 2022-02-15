import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1210_Ladder1_D4_이승연_137ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str;
		char[][] grid = new char[100][100];  
		
		while((str = br.readLine()) != null) {
			int TC = Integer.parseInt(str);
			
			sb.append("#").append(TC).append(" ");
			
			int sp_c = -1; 

			StringTokenizer st;
			
			// grid 초기화
			for(int i=0; i<99; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<100; j++) {
					grid[i][j] = st.nextToken().charAt(0);
				}
			}
			
			st = new StringTokenizer(br.readLine(), " ");

			for(int j=0; j<100; j++) {
				char c = st.nextToken().charAt(0);
				grid[99][j] = c;
				
				if(c == '2') {
					sp_c = j;
				}
			}

			int r = 99;
			int c = sp_c; // 마지막 행에서 2인 것부터 거꾸로 올라감

			while(r > 0) { // 첫번째 줄이 되기 전까지 
				if(c>0 && grid[r][c-1] == '1') { // 왼쪽이 존재하고 '1'일때
					c--; // 왼쪽으로 감 
					while(grid[r-1][c] != '1') { // 위가 1이 나올 때까지 왼쪽으로 감 
						c--;	
					}  
				} else if(c+1<100 && grid[r][c+1] == '1') { // 오른쪽이 존재하고 1일때 
					c++; // 오른쪽으로 감 
					while(grid[r-1][c] != '1') { // 위가 1이 나올 때까지 오른쪽으로 감 
						c++;	
					}
				}
				r--;
			}
			sb.append(c).append("\n");
		}
		System.out.println(sb.toString());
	}
}
