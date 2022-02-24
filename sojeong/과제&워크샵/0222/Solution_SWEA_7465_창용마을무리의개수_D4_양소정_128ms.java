import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_7465_창용마을무리의개수_D4_양소정_128ms {
	private static int N,cnt;
	private static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int [][] adjMatrix = new int[N+1][N+1];
			visited = new boolean[N+1];
			cnt=0;
			for (int j = 0; j < M; j++) {
				st= new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adjMatrix[to][from] = adjMatrix[from][to] = 1; 
	
			}
			for (int j = 1; j <=N; j++) {
				if(!visited[j]) {
					dfs(adjMatrix,j);
					cnt++;
				
					
				}
			}
			sb.append("#").append(i+1).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	
	
	}
	public static void dfs(int[][] adjMatrix, int current) {
		
		visited[current] = true;
		
		
		
		//current정점에 인접정점 처리 (단, 방문하지 않은 인접정점만)
		for (int j = 1; j <= N; j++) {
			if(!visited[j] && adjMatrix[current][j]!=0) {
				dfs(adjMatrix, j);
				
			}
		}	
	
	
	}

}
