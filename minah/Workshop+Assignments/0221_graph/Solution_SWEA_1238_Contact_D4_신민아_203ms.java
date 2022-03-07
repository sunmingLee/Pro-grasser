import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/** "동시에"가 key point --> dfs로 구현하면 순서가 생기므로 bfs로 구현이 필요 */
public class Solution_SWEA_1238_Contact_D4_신민아_203ms {
	static int answer, depth[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		int testCase = 0;
		String line = "";
		int[][] matrix;
		while((line = br.readLine()) != null) {
			st = new StringTokenizer(line, " ");
			int length = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			answer = 0;
			
			st = new StringTokenizer(br.readLine(), " ");
			matrix = new int[101][101];
			depth = new int[101];
			
			for(int i=0;i<length/2;i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				matrix[from][to] = 1;
			}
			
			sb.append("#").append(++testCase).append(" ").append(bfs(matrix, start)).append("\n");
		}
		
		System.out.print(sb.toString());
	}
	
	private static int bfs(int[][] matrix, int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[101];
		
		queue.offer(start);
		visited[start] = true;
		depth[start] = 0;
		
		// 탐색
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			for(int i=1;i<matrix.length;i++) {
				if(!visited[i] && matrix[current][i] == 1) {
					queue.offer(i);
					visited[i] = true;
					depth[i] = depth[current] + 1;
				}
			}
		}
		
		int deepest = Arrays.stream(depth).max().getAsInt();
		
		for(int i=depth.length-1;i>=0;i--) {
			if(depth[i] == deepest) {
				return i;
			}
		}
		
		return start;
	}
}
