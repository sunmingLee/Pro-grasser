import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_BOJ_11724_연결요소의개수_S2_이재순_456ms {
	private static int[] parents;
	static boolean[] hasRoot;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());// 수의 갯수, 1≤n≤1,000,000
		int M = Integer.parseInt(st.nextToken());// 커맨드의 갯수, 1≤m≤100,000
		parents = new int[N + 1];
		hasRoot = new boolean[N + 1];
		for (int i = 1; i <= N; i++)
			parents[i] = i;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			unionset(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		int ans = 0;
		for (int i = 1; i <= N; i++) if (!hasRoot[i]) ans++;
		System.out.println(ans);
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
		hasRoot[aRoot] = true;
		return true;
	}
}
