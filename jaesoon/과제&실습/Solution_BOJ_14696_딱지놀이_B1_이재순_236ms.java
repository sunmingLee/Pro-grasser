import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_BOJ_14696_딱지놀이_B1_이재순_236ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int[] aDeck = new int[5], bDeck = new int[5];
		for (int i = 0; i < N; i++) {
			Arrays.fill(aDeck, 0);
			Arrays.fill(bDeck, 0);
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			for (int j = 0; j < a; j++) {
				aDeck[Integer.parseInt(st.nextToken())]++;
			}
			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());
			for (int j = 0; j < b; j++) {
				bDeck[Integer.parseInt(st.nextToken())]++;
			}
			for (int j = 4; j > 0; j--) {
				if (aDeck[j] > bDeck[j]) {
					sb.append("A").append("\n");
					break;
				}else if (aDeck[j] < bDeck[j]) {
					sb.append("B").append("\n");
					break;
				}
				else if(j==1) sb.append("D").append("\n");
			}
		}
		System.out.print(sb);
	}
}
