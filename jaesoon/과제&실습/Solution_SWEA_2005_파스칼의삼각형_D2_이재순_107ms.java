import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_SWEA_2005_파스칼의삼각형_D2_이재순_107ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append("\n");
			int N = Integer.parseInt(br.readLine());
			for (int i = 1; i <= N; i++) {
				int a = 1;
				for (int j = 1; j <= i; j++) {
					sb.append(a).append(" ");
					a = a*(i-j)/j;
				}
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
}
