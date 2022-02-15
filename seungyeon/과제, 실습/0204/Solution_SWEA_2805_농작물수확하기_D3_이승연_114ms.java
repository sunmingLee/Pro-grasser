import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_SWEA_2805_농작물수확하기_D3_이승연_114ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int testCase=1; testCase <= TC; testCase++) {
			int N = Integer.parseInt(br.readLine());
			char[][] grid = new char[N][N];
			int result = 0;

			sb.append("#").append(testCase).append(" ");
			
			for(int i=0; i<N; i++) {
				String st = br.readLine();
				for(int j=0; j<N; j++) {
					grid[i][j] = st.charAt(j);
				}
			}
			
			for(int i=0; i<N; i++) {
				int blank = Math.abs(N/2 - i);
				int num = i<=N/2 ? 2*i+1 : 2*(N-i) -1;
				
				for(int j=blank; j<num+blank; j++) {
					result += grid[i][j] - '0';
				}
			}
			
			sb.append(result).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
