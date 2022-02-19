import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_BOJ_2839_설탕배달_B1_이재순_76ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());//배달해야하는 설탕kg, 3 ≤ N ≤ 5000
		int a = N/5;
		for (int i = a; i >= 0; i--) {
			if ((N-i*5)%3==0) {
				System.out.println(i+(N-i*5)/3);
				return;
			}
		}
		System.out.println(-1);
	}
}
