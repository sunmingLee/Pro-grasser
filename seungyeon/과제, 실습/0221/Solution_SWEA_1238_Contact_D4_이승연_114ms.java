import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_SWEA_1238_Contact_D4_이승연_114ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		boolean[][] adjMatrix;
		int testCase = 1;
		
		String input; 
		
//		while((input = br.readLine()) != null) {
		while(!(input = br.readLine()).isEmpty()) {
			adjMatrix = new boolean[101][101];
			st = new StringTokenizer(input, " ");
			int length = Integer.parseInt(st.nextToken());
			int sp = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine(), " ");

			for(int i=0; i<length/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				adjMatrix[from][to] = true;
			}
			
			sb.append("#").append(testCase++).append(" ").append(bfs(adjMatrix, sp)).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static int bfs(boolean[][] adjMatrix, int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[101]; // tree와의 차이점 
		
		queue.offer(start);
		visited[start] = true; 
		int current = 0;
		int[] last_elements = null;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			last_elements = new int[size];
			int idx = 0;
			
			while(--size>=0) {
				current = queue.poll();
				last_elements[idx++] = current;
				
				// current 정점의 인접정점 처리 (단, 방문하지 않은 인접정점만)
				for(int j=1; j<=100; j++) {
					if(!visited[j] && adjMatrix[current][j]) { // 방문하지 않았고 인접한 얘들만 
						queue.offer(j);
						visited[j] = true;
					}
				}
			}
		}
		
		int last_max = 0; 
		
		for(int i=0; i<last_elements.length; i++) {
			last_max = Math.max(last_max, last_elements[i]);
		}
		
		return last_max;
	}
	
}
