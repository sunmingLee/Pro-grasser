import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_BOJ_2606_바이러스_S3_이재순_76ms {
	private static int[] parents, cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());// 수의 갯수, 1≤n≤100
		int m = Integer.parseInt(br.readLine());// 커맨드의 갯수
		parents = new int[n + 1];
		for (int i = 1; i <= n; i++) parents[i] = i;
		cnt = new int[n+1];
		Arrays.fill(cnt, 1);
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			unionset(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		System.out.println(cnt[1]-1);
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
		}else {
			if (aRoot<bRoot) {
				parents[bRoot] = aRoot;
				cnt[aRoot] += cnt[bRoot];
			}
			else {
				parents[aRoot] = bRoot;
				cnt[bRoot] += cnt[aRoot];
			}
		}
		return true;
	}
}
