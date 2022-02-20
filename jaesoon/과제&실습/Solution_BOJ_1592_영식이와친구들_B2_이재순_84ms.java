import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_BOJ_1592_영식이와친구들_B2_이재순_84ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int ans = 0;
		int[] arr = new int[N];
		int idx = 0;
	while(true) {
			switch (arr[idx]%2) {
			case 0:
				idx = (idx+L)%N;
				if (++arr[idx]==M) {
					System.out.println(ans);
					return;
				}
				ans++;
				break;
			default:
				idx = (idx-(L-N))%N;
				if (++arr[idx]==M) {
					System.out.println(ans);
					return;
				}
				ans++;
				break;
			}
		}
	}
}
