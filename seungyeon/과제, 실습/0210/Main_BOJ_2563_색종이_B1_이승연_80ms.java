import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2563_색종이_B1_이승연_80ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] grid = new int[100][100];
		
		int result = 0; 
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			for(int j=r; j<r+10; j++) {
				for(int k=c; k<c+10; k++) {
					if(grid[j][k] == 0){
						grid[j][k] = 1;
						result++;
					}
				}
			}
    }
		
		System.out.println(result);
	}
}
