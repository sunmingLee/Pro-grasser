import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_7465_창용마을무리의개수_D4_이재순_121ms {
	private static int[] parents;
	private static boolean[] hasParent;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());//테스트케이스 수
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for (int testcase = 1; testcase <= T; testcase++) {
			st = new StringTokenizer(br.readLine());
			//초기화
			int N = Integer.parseInt(st.nextToken());//사람의 수, 1 ≤ N ≤ 100
			int M = Integer.parseInt(st.nextToken());//사람 관계 수, 0 ≤ M ≤ N(N-1)/2
			parents = new int[N+1];//idx사람의 부모를 저장
			hasParent = new boolean[N+1];//무리의 우두머리(root) : false, 나머지 : true
			for (int i = 1; i <= N; i++) {
				parents[i] = i;//자신의 부모를 자신으로 초기화
			}
			//프로세스 진행
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				unionset(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));//관계 설정
			}
			//출력
			int ans=0;
			for (int i = 1; i <= N; i++) {
				if (!hasParent[i]) {//무리의 우두머리라면 진행
					ans++;
				}
			}
			sb.append("#").append(testcase).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}
	
	private static int findparent(int a) {
		if (a == parents[a]) {
			return a;
		}
		return parents[a] = findparent(parents[a]);
	}
	
	private static boolean unionset(int a, int b) {
		int aRoot = findparent(a);
		int bRoot = findparent(b);
		if (aRoot == bRoot) {
			return false;
		}
		parents[bRoot] = aRoot;//랭크는 신경쓰지 않음
		hasParent[bRoot] = true;//부모가 있음을 저장 (= 우두머리가 아님)
		return true;
	}
}
