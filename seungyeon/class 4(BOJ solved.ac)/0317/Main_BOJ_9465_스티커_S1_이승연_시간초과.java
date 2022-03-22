import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_9465_스티커_S1_이승연_시간초과 {
	private static int max_result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int testCase=1; testCase<=TC; testCase++) {
			int N = Integer.parseInt(br.readLine()); // 1<=N<=100000
			
			int[][] stickers = new int[2][N];
			
			String[] str_arr = br.readLine().split(" ");
			for(int i=0; i<N; i++) {
				stickers[0][i] = Integer.parseInt(str_arr[i]);
			}
			
			str_arr = br.readLine().split(" ");
			for(int i=0; i<N; i++) {
				stickers[1][i] = Integer.parseInt(str_arr[i]);
			}
			
			max_result = 0; 
			
			calcScore(0, 0, 0, N, stickers);
			calcScore(1, 0, 0, N, stickers);
			
			sb.append(max_result).append("\n");
		}
		
		System.out.print(sb.toString());
	}
	
	public static void calcScore(int temp_r, int temp_c, int temp_sum, int N, int[][] stickers) {		
		if(temp_c >= N) {
			max_result = Math.max(max_result, temp_sum);
			return; 
		}

		temp_sum += stickers[temp_r][temp_c];

		calcScore((temp_r+1)%2, temp_c+1, temp_sum, N, stickers);
		calcScore((temp_r+1)%2, temp_c+2, temp_sum, N, stickers);
	}
}
