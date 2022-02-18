import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_3234_준환이의양팔저울_D4_이재순_DP_120ms {
	static int[][] dp;
	private static int[] chu;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int testcase = 0; testcase < T; testcase++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			chu = new int[N];
			int sum = 0;
			for (int i = 0; i < N; i++) {
				chu[i] = Integer.parseInt(st.nextToken());
				sum += chu[i];
			}
			dp = new int[sum + 1][1 << N];
			sb.append("#").append(testcase + 1).append(" ").append(permutation(0, sum, 0, N, 0)).append("\n");
		}
		System.out.print(sb);
	}

	private static int permutation(int flag, int totalLeft, int diff, int N, int cnt) {
		if (cnt == N) {
			return 1;
		}
		if (dp[diff][flag] != 0) {
			return dp[diff][flag];
		}
		if (totalLeft <= diff) {
			int a = 0;
			int left = 1;
			int r = N-cnt;
			for (int i = 0; i < r; i++) {
				left *= ++a;
			}
			return left * (1 << a);
		}
		int ans = 0;
		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) == 0) {
				int temp = chu[i];
				ans += permutation(flag | 1 << i, totalLeft - temp, diff + temp, N, cnt + 1);
				if (diff - temp >= 0) {
					ans += permutation(flag | 1 << i, totalLeft - temp, diff - temp, N, cnt + 1);
				}
			}
		}
		dp[diff][flag] = ans;
		return ans;
	}
}
