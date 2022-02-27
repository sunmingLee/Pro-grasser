import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_BOJ_2292_벌집_B2_이재순_76ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if (N==1) {System.out.println(1); return;}
		int a = 1;
		int i =0;
		while (true) {
			if (a<N&&N<=(a+=i++*6)) {
				System.out.println(i);
				return;
			}
		}
	}
}
