import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_9465_스티커_S1_이승연_728ms {
	private static int max_result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int testCase=1; testCase<=TC; testCase++) {
			int N = Integer.parseInt(br.readLine()); // 1<=N<=100000
			
			int[][] stickers = new int[2][N+1];
			
			String[] str_arr = br.readLine().split(" ");
			for(int i=1; i<=N; i++) {
				stickers[0][i] = Integer.parseInt(str_arr[i-1]);
			}
			
			str_arr = br.readLine().split(" ");
			for(int i=1; i<=N; i++) {
				stickers[1][i] = Integer.parseInt(str_arr[i-1]);
			}
			
			max_result = 0; 
			
			for(int temp_c=2; temp_c<=N; temp_c++) {
				stickers[0][temp_c] += Math.max(stickers[1][temp_c-1], stickers[1][temp_c-2]);
				stickers[1][temp_c] += Math.max(stickers[0][temp_c-1], stickers[0][temp_c-2]);
			}
			
			max_result = Math.max(stickers[0][N], stickers[1][N]);
			
			sb.append(max_result).append("\n");
		}
		
		System.out.print(sb.toString());
	}
}
