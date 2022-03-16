import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_1504_특정한최단경로_G4_이승연_432ms {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); // 정점의 개수(2<=N<=800)
		int E = Integer.parseInt(st.nextToken()); // 간선의 개수(0<=E<=200000)
		int[][] adjMatrix = new int[N+1][N+1];
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjMatrix[from][to] = weight;
			adjMatrix[to][from] = weight;
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int V1 = Integer.parseInt(st.nextToken());
		int V2 = Integer.parseInt(st.nextToken());
		
		int max_value = 200000001;
		
		int[] distance = new int[N+1];
		Arrays.fill(distance, max_value);
		distance[1] = 0;
		int result1 = 0;
		boolean flag1 = false;
		
		// 1 -> V1 -> V2 -> N
		if(dijkstra(1, V1, adjMatrix, N, distance, new boolean[N+1], max_value)) {
			result1 += distance[V1];
			
			distance = new int[N+1];
			Arrays.fill(distance, max_value);
			distance[V1] = 0;
			
			if(dijkstra(V1, V2, adjMatrix, N, distance, new boolean[N+1], max_value)) {
				result1 += distance[V2];
				
				distance = new int[N+1];
				Arrays.fill(distance, max_value);
				distance[V2] = 0;
				
				if(dijkstra(V2, N, adjMatrix, N, distance, new boolean[N+1], max_value)) {
					result1 += distance[N];
					flag1 = true; 
				}
			}
		}
		
		distance = new int[N+1];
		Arrays.fill(distance, max_value);
		distance[1] = 0;
		int result2 = 0;
		boolean flag2 = false; 
		
		// 1 -> V2 -> V1 -> N
		if(dijkstra(1, V2, adjMatrix, N, distance, new boolean[N+1], max_value)) {
			result2 += distance[V2];
			
			distance = new int[N+1];
			Arrays.fill(distance, max_value);
			distance[V2] = 0;
			
			if(dijkstra(V2, V1, adjMatrix, N, distance, new boolean[N+1], max_value)) {
				result2 += distance[V1];
				
				distance = new int[N+1];
				Arrays.fill(distance, max_value);
				distance[V1] = 0;
				
				if(dijkstra(V1, N, adjMatrix, N, distance, new boolean[N+1], max_value)) {
					result2 += distance[N];
					flag2 = true; 
				}
			}
		}
		
		if(!flag1 && !flag2) {
			System.out.println("-1");
		} else {
			System.out.println(Math.min(result1, result2));
		}
	}
	
	public static boolean dijkstra(int start, int end, int[][] adjMatrix, int N, int[] distance, boolean[] visited, int max_value) {
		for(int i=1; i<=N; i++) {
			int min = max_value, current = 0; 
			
			for(int j=1; j<=N; j++) {
				if(!visited[j] && min>distance[j]) {
					min = distance[j];
					current = j;
				}
			}
			
			visited[current] = true;
			if(current == end) break;
			
			for(int j=1; j<=N; j++) {
				if(!visited[j] && adjMatrix[current][j]!=0 && distance[j]>distance[current]+adjMatrix[current][j]) {
					distance[j] = distance[current]+adjMatrix[current][j];
				}
			}
		}
		
		return distance[end] != max_value ? true : false;
	}
}
