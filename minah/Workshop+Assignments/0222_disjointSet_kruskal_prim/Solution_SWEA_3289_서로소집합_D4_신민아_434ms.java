import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_3289_서로소집합_D4_신민아_434ms {
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		sb = new StringBuilder();
		StringTokenizer st;
		for(int testCase=0;testCase<TC;testCase++) {
			sb.append("#").append(testCase+1).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			
			int[] parents = new int[Integer.parseInt(st.nextToken()) + 1];
			int opCount = Integer.parseInt(st.nextToken());
			
			for(int i=1;i<parents.length;i++) {
				parents[i] = i;
			}
			
			for(int i=0;i<opCount;i++) {
				st = new StringTokenizer(br.readLine(), " ");
				
				int op = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(op == 0)
					union(parents, a, b);
				else
					isSameSet(parents, a, b);
			}
			
			sb.append("\n");
		}
		
		System.out.print(sb.toString());
	}
	
	private static void isSameSet(int[] parents, int a, int b) {
		int aRoot = findSet(parents, a);
		int bRoot = findSet(parents, b);
		
		sb.append(aRoot == bRoot ? 1 : 0);
	}
	
	private static void union(int[] parents, int a, int b) {
		int aRoot = findSet(parents, a);
		int bRoot = findSet(parents, b);
		
		if(aRoot == bRoot) return;
		
		parents[bRoot] = aRoot;
	}
	
	private static int findSet(int[] parents, int a) {
		if(a == parents[a]) return a;
		
		return parents[a] = findSet(parents, parents[a]);
	}
}
