import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_BOJ_2999_비밀이메일_B1_이재순_76ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = line.length();
		int R = 1;
		for (int i = (int)Math.pow(N, 0.5); i > 0; i--) {
			if (N%i==0) {
				R = i;
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < R; i++) {
			for (int j = i; j < N; j+=R) {
				sb.append(line.charAt(j));
			}
		}
		System.out.println(sb);
	}
}
