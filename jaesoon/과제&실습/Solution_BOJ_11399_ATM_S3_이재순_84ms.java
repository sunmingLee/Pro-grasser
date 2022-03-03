import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_BOJ_11399_ATM_S3_이재순_84ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] q = new int[N];
		for (int i = 0; i < N; i++) {
			q[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(q);
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += q[i]*(N-i);
		}
		System.out.println(sum);
	}
}
