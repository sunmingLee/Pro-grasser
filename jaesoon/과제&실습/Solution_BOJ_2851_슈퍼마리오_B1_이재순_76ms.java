import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_BOJ_2851_슈퍼마리오_B1_이재순_76ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp;
		int sum = -100;
		while ((temp = br.readLine()) != null) {
			int cur = Integer.parseInt(temp);
			if (Math.abs(sum)>=Math.abs(sum+cur)) {
				sum += cur;
			}
			else {
				System.out.println(sum+100);
				return;
			}
		}
		System.out.println(sum+100);
	}
}
