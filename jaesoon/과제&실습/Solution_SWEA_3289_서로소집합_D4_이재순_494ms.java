import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_3289_서로소집합_D4_이재순_494ms {
	private static int[] parents;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int testcase = 1; testcase <=T; testcase++) {
			sb.append("#").append(testcase).append(" ");
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());//수의 갯수, 1≤n≤1,000,000
			int m = Integer.parseInt(st.nextToken());//커맨드의 갯수, 1≤m≤100,000
			parents = new int[n+1];
			for (int i = 1; i <= n; i++) {
				parents[i] = i;
			}
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				switch (st.nextToken()) {
				case "0":
					unionset(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
					break;
				case "1":
					if (findset(Integer.parseInt(st.nextToken()))==findset(Integer.parseInt(st.nextToken()))) sb.append(1);
					else sb.append(0);
					break;
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	private static int findset(int a) {
		if (a == parents[a]) {
			return a;
		}
		return parents[a] = findset(parents[a]);
	}
	private static boolean unionset(int a, int b) {
		int aRoot = findset(a);
		int bRoot = findset(b);
		if (aRoot == bRoot) {
			return false;
		}
		parents[aRoot] = bRoot;
		return true;
	}
}
