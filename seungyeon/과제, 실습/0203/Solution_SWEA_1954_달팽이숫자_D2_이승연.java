/**
 * Solution_SWEA_1954_달팽이숫자_D2_이승연
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_SWEA_1954_달팽이숫자_D2_이승연 {
	public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		int T;
		T=Integer.parseInt(br.readLine());
		
		
		for(int test_case = 1; test_case <= T; test_case++){
            int n = 1;
            int N = Integer.parseInt(br.readLine());

            int[][] arr = new int[N][N];

            int r = 0;
            int c = 0;

            for(int i=0; i<=N/2; i++) {
                r = i;
                c = i;
                for(;c<N-1-i; c++) {
                    arr[r][c] = n++;
                }			

                for(;r<N-1-i; r++) {
                    arr[r][c] = n++;
                }

                for(;c>i; c--){
                    arr[r][c] = n++;
                }

                for(;r>i; r--) {
                    arr[r][c] = n++;
                }
            }

            if(N%2 != 0) {
                arr[r][c] = n;
            }

            sb.append("#"+test_case).append("\n");
            
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append("\n");
            }
		}
		
        System.out.println(sb.toString());
	}
}
