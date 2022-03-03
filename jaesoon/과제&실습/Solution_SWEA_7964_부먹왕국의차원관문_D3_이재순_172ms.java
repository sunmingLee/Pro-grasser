import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_7964_부먹왕국의차원관문_D3_이재순_172ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			boolean[] chawon = new boolean[N];
			String line = br.readLine();
			for (int i = 0, idx = 0; i < N; i++, idx+=2) if (line.charAt(idx)=='1') chawon[i] = true;
			int ans = 0;
loop:		for (int i = 0; i < N;) {
				for (int j = 0; j < D; j++) {
					if (chawon[i++]) continue loop;
				}
				ans++;
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}
}
