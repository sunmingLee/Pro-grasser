import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_SWEA_4789_성공적인공연기획_D3_이재순_107ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			String line = br.readLine();
			int size = line.length();
			int ans = 0;
			for (int i = 1, sum = line.charAt(0)-'0'; i < size; i++) {
				if (sum<i) {
					ans++;
					sum+=line.charAt(i)-'/';
					continue;
				}
				sum+=line.charAt(i)-'0';
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}
}
