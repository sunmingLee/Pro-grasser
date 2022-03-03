import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1493_수의새로운연산_D3_이재순_102ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int a = 0, b = 0;
			for (int i = (int)Math.pow(p*2, 0.5); i < 142; i++) {
				if (p<=gauss(i)) {
					p-=gauss(i-1);
					a=i;
					break;
				}
			}
			for (int i = (int)Math.pow(q*2, 0.5); i < 142; i++) {
				if (q<=gauss(i)) {
					q-=gauss(i-1);
					b=i;
					break;
				}
			}
			sb.append("#").append(tc).append(" ").append(gauss(a+b)+p+q).append("\n");
		}
		System.out.print(sb);
	}
	private static int gauss(int n) {
		if (n <= 0) return 0;
		return n*(n+1)/2;
	}
}
