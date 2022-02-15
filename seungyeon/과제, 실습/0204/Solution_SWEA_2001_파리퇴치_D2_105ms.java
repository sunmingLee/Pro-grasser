import java.io.BufferedReader;
import java.io.InputStreamReader;

 
public class Solution_SWEA_2001_파리퇴치_D2_105ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());

		for(int testCase=1; testCase<=TC; testCase++) {
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int M = Integer.parseInt(input[1]);
			
			int[][] int_arr = new int[N][N];
			int result = 0;
			int max = 0; 
			
			for(int i=0; i<N; i++) {
				String[] srr = br.readLine().split(" ");
				for(int j=0; j<N; j++) {
					int_arr[i][j] = Integer.parseInt(srr[j]);
				}
			}
			int num = N-M+1;
			
			for(int i=0; i<num; i++) {
				int r=i;
				for(int j=0; j<num; j++) {
					int c=j;
					result = 0;
					for(int k=0; k<M; k++) {
						for(int l=0; l<M; l++) {
							result += int_arr[r+k][c+l];
						}
					}

					if(result > max) {
						max = result; 
					}
				}
			}
			
			sb.append("#").append(testCase).append(" ").append(max).append("\n");
		}
		System.out.print(sb.toString());
	}
}

