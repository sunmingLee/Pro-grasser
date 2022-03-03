import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_BOJ_3052_나머지_B2_이재순_76ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] remainder = new boolean[42];
		int ans = 0;
		for (int i = 0; i < 10; i++) {
			int temp = Integer.parseInt(br.readLine());
			if (!remainder[temp%42]) {
				ans++;
				remainder[temp%42] = true;
			}
		}
		System.out.println(ans);
	}
}
