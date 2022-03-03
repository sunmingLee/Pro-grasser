import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_BOJ_8320_직사각형을만드는방법_B2_이재순_76ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int ans = 0;
		int max = (int)Math.pow(n, 0.5);
		for (int i = 1; i <= max; i++) {
			int a = i;
			while (a*i<=n) {
				ans++;
				a++;
			}
		}
		System.out.println(ans);
	}
}
