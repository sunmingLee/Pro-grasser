import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DijkstraTest1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		
		int[][] adjMatrix = new int[V][V];
		int start = 0;
//		int end = V - 1;
		
		StringTokenizer st;
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < V; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] distance = new int[V]; // 출발지에서 자신으로 오는 최소 비용
		boolean[] visited = new boolean[V]; // 최소 비용 확정 여부
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		
		for (int i = 0; i < V; i++) {
			// 단계 1 : 최소 비용이 확정되지 않은 정점 중 최소 비용의 정점 선택
			int min = Integer.MAX_VALUE;
			int current = 0;
			for (int j = 0; j < V; j++) {
				if(!visited[j] && min > distance[j]) {
					min = distance[j];
					current = j;
				}
			}
			
			visited[current] = true;
//			if(current == end) break; // 출발지에서 원하는 도착지만 얻으면 끝나는 코드
			
			// 단계 2 : 선택된 정점을 경유지로 하여 아직 최소 비용이 확정되지 않은 다른 정점의 최소 비용 고려
			for (int j = 0; j < V; j++) {
				if(!visited[j] && adjMatrix[current][j] != 0 
						&& distance[j] > distance[current] + adjMatrix[current][j]) {
					distance[j] = distance[current] + adjMatrix[current][j];
				}
			}
		}
		
		System.out.print(Arrays.toString(distance));
//		System.out.println(distance[end]);
	}

}
