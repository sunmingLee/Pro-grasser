import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_BOJ_2798_블랙잭_B2_이재순_88ms {
	private static int N, M, ans = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] cards = new int[N];
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		combination(0, 0, cards, 0);
		System.out.println(ans);
	}
	private static void combination(int cnt, int start, int[] cards, int sum) {
		if (sum>M) return;
		if (cnt==3) {
			if (sum==M) {
				System.out.println(M);
				System.exit(0);
			}
			if (sum>ans) {
				ans = sum;
			}
			return;
		}
		
		for (int i = start; i < N; i++) {
			combination(cnt+1, i+1, cards, sum+cards[i]);
		}
	}
}
