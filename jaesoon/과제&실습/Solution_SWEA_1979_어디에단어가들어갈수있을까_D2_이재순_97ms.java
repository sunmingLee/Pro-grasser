import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1979_어디에단어가들어갈수있을까_D2_이재순_97ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			int[] col = new int[N];
			int ans = 0, row = 0;
			String line = br.readLine();
			for (int j = 0, idx=0; j < N; j++, idx+=2) {
				if ((map[0][j] =line.charAt(idx))=='1') {
					row++;
					col[j]++;
				}
				else {
					if (row==K) ans++;
					row = 0;
				}
			}
			if (row==K) ans++;
			for (int i = 1; i < N; i++) {
				line = br.readLine();
				row = 0;
				for (int j = 0, idx=0; j < N; j++, idx+=2) {
					if ((map[i][j] =line.charAt(idx))=='1') {
						row++;
						col[j]++;
					}
					else {
						if (row==K) ans++;
						if (col[j]==K) ans++;
						row = 0;
						col[j] = 0;
					}
				}
				if (row==K) ans++;
			}
			for (int i = 0; i < N; i++) {
				if (col[i]==K) ans++;
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}
}
