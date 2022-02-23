import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_3234_준환이의양팔저울_D4_이재순_600ms {
	static int ans;
	static int[][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int testcase = 0; testcase < T; testcase++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] chu = new int[N];
			int sum = 0;
			for (int i = 0; i < N; i++) {
				chu[i] = Integer.parseInt(st.nextToken());
				sum+=chu[i];
			}
			dp = new int[sum+1][1<<N];
			ans = 0;
			
			permutation(0, sum, 0, chu, N);
			sb.append("#").append(testcase+1).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}
	private static void permutation(int flag, int totalLeft, int diff, int[] chu, int N) {
		if (diff<0) 	return;
		if (dp[diff][flag] != 0) {
			ans += dp[diff][flag];
			return;
		}
		if (totalLeft<=diff) {
			int a = 0;
			int left=1;
			for (int i = 0; i < N; i++) {
				if ((flag&1<<i)==0) {
					left*=++a;
				}
			}
			dp[diff][flag] = left*(1<<a);
			ans += dp[diff][flag];
			return;
		}
		for (int i = 0; i < N; i++) {
			if ((flag&1<<i)==0) {
				int temp = chu[i];
				permutation(flag|1<<i, totalLeft-temp, diff+temp, chu, N);
				permutation(flag|1<<i, totalLeft-temp, diff-temp, chu, N);
			}
		}
	}
}
