import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_6485_삼성시의버스노선_D3_이재순_125ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc);
			int N = Integer.parseInt(br.readLine());
			int[] C = new int[5001];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken())+1;
				for (int j = start; j < end; j++) C[j]++;
			}
			int P = Integer.parseInt(br.readLine());
			for (int i = 0; i < P; i++) {
				sb.append(" ").append(C[Integer.parseInt(br.readLine())]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
