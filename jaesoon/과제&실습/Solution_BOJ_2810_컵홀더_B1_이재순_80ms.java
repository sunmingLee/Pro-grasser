import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_BOJ_2810_컵홀더_B1_이재순_80ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 1;
		String line = br.readLine();
		for (int i = 0; i < N; i++) {
			switch (line.charAt(i)) {
			case 'S':
				ans++;
				break;

			default:
				ans++;
				i++;
				break;
			}
		}
		System.out.println(Math.min(ans, N));
	}
}
