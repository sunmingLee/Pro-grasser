import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1984_중간평균값구하기_D2_이재순_120ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			st = new StringTokenizer(br.readLine());
			int sum = 0;
			for (int i = 0, temp; i < 10; i++) {
				if ((temp = Integer.parseInt(st.nextToken()))<min) min = temp;
				if (temp>max) max = temp;
				sum += temp;
			}
			sb.append("#").append(tc).append(" ").append(String.format("%.0f", (sum-min-max)/8.0)).append("\n");
		}
		System.out.print(sb);
	}
}
