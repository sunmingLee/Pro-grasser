import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_SWEA_1940_가랏RC카_D2_이재순_95ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int ans = 0;
			int v = 0;
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				switch (line.charAt(0)) {
				case '1':
					v += line.charAt(2)-'0';
					ans += v;
					break;
				case '2':
					v= Math.max(v - line.charAt(2)+'0',0);
					ans += v;
					break;
				default:
					ans += v;
					break;
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
