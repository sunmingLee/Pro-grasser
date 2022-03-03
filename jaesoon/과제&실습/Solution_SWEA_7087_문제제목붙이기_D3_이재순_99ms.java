import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_SWEA_7087_문제제목붙이기_D3_이재순_99ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			boolean[] arr = new boolean[91];
			for (int i = 0; i < N; i++) arr[br.readLine().charAt(0)] = true;
			int ans = 0;
			for (int i = 65; i < 91; i++) {
				if (arr[i]) ans++;
				else break;
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}
}
