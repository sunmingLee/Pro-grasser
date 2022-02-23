import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_SWEA_1238_Contact_D4_양소정_120ms {

	
	private static int N;
	private static int ans=0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			N = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());	
		
			int [][] adjMatrix = new int[N+1][N+1]; 
		
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());	
				adjMatrix[from][to] = 1; 
				
			}
			bfs(adjMatrix,S);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
		
		
	} //end of main
	
	public static void bfs(int [][] adjMatrix, int start) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N+1];
		int max = 0;
		queue.offer(start);
		visited[start] = true;
		 
		while(!queue.isEmpty()) {
			int size = queue.size();
			max = 0;
			for (int j = 0; j < size; j++) {
				int current = queue.poll();
				max = Math.max(current, max); //같은 레벨 최대크기 max에 저장
				for (int i = 1; i < adjMatrix[current].length; i++) {
					if(adjMatrix[current][i] == 1 && !visited[i]) {
						queue.offer(i);
						visited[i] = true;
					}	
				}
			}
			ans = max; //반복문 나왔다는 건 마지막 레벨까지 다 돌았다는 것
		}
	}

}
