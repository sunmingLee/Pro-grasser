package Implementation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_2292_벌집_B2_이선민_72ms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 찾아가야하는 방 번호

		int ans = 1;
		int min = 1, max = 1;
		while (N < min || max < N) {
			min = max + 1;
			max = max + 6 * ans;
			ans++;
		}
		System.out.print(ans);
	}
}
