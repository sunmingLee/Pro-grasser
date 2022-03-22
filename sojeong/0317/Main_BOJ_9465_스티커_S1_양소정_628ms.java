
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_9465_스티커_S1_양소정_628ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st1 = null;
		StringTokenizer st2 = null;
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][]dp =new int[2][N+1];
			st1 = new StringTokenizer(br.readLine());
			st2 = new StringTokenizer(br.readLine());
			
			dp[0][1] = Integer.parseInt(st1.nextToken());
			dp[1][1] = Integer.parseInt(st2.nextToken());
			for (int i = 2; i <= N; i++) {
				dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + Integer.parseInt(st1.nextToken());
				dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + Integer.parseInt(st2.nextToken());
			}
			sb.append(Math.max(dp[0][N], dp[1][N])).append("\n");
			
		}
		System.out.println(sb);
		
	}
	

}
