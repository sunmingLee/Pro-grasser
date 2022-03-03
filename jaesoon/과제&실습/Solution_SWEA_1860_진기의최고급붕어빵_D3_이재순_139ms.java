import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_1860_진기의최고급붕어빵_D3_이재순_139ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
loop:	for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc);
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(arr);
			for (int i = 0; i < N; i++) 
				if (arr[i]/M*K<=i) {
					sb.append(" Impossible\n");
					continue loop;
				}
			sb.append(" Possible\n");
		}
		System.out.print(sb);
	}
}
