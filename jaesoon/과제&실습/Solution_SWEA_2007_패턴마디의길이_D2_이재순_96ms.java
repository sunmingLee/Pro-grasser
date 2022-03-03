import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_SWEA_2007_패턴마디의길이_D2_이재순_96ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			String line = br.readLine();
			int ans = 30;
loop:		for (int i = 1, temp=0; i < 11; i++, temp = 0) {
				int r = 30 / i - 1;
				for (int j = 0; j < r; j++) {
					if (!line.substring(temp, temp + i).equals(line.substring(temp + i, temp + i + i))) {
						break;
					}
					temp += i;
				}
				if (temp == r*i) {
					ans = i;
					break loop;
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}
}
