import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_BOJ_13300_방배정_B2_이재순_80ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] girl = new int[55], boy = new int[55];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			switch (line.charAt(0)) {
			case '1':
				boy[line.charAt(2)]++;
				break;
			default:
				girl[line.charAt(2)]++;
				break;
			}
		}
		int ans = 0;
		for (int i = 49; i < 55; i++) {
			if (boy[i]!=0) {
				if (boy[i]%K!=0) {
					ans++;
				}
				ans += boy[i]/K;
			}
			if (girl[i]!=0) {
				if (girl[i]%K!=0) {
					ans++;
				}
				ans += girl[i]/K;
			}
		}
		System.out.println(ans);
	}
}
