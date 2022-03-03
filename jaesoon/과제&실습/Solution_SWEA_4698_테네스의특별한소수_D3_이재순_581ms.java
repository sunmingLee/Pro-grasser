import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_4698_테네스의특별한소수_D3_이재순_581ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		boolean[] list = new boolean[1000001];
		for (int i = 2; i < 1000001; i++) if (primeNumber(i)) list[i] = true;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int D = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int ans = 0;
			for (int i = A; i <= B; i++) {
				if (list[i]) {
					for (int j = 0,temp = i; j < 6; j++) {
						if (temp%10==D) {
							ans++;
							break;
						}
						if ((temp = temp/10)==0) break;
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}
	private static boolean primeNumber(int i) {
		int a = (int)Math.pow(i, 0.5);
		for (int j = 2; j <= a; j++) {
			if (i%j==0) {
				return false;
			}
		}
		return true;
	}
}
