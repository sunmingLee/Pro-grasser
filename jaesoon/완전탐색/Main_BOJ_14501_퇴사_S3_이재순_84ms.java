import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_14501_퇴사_S3_이재순_84ms {
	private static int N, ans;
	private static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		ans = Integer.MIN_VALUE;
		combination(0, 0);
		System.out.println(ans);
	}

	private static void combination(int start, int flag) {
		if (start == N) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if ((flag & 1 << i) != 0) {
					sum += arr[i][1];
				}
				if (sum > ans) {
					ans = sum;
				}
			}
			return;
		} // 기저조건
		
		for (int i = start; i < N; i++) {
			if (i+arr[i][0]<=N) {
				combination(i + arr[i][0], flag | 1 << i);
			}
		}
		combination(N,flag);
	}
}
