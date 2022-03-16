import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_1967_트리의지름_G4_이승연_dijkstra_메모리초과 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int max_value = 1000000;
		
		StringTokenizer st;
		
		int[][] adjMatrix = new int[N+1][N+1];
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjMatrix[from][to] = weight;
			adjMatrix[to][from] = weight;
		}
		
		int[] distance = new int[N+1];
		Arrays.fill(distance, max_value);
		distance[1] = 0;
		
		dijkstra(N, max_value, distance, new boolean[N+1], adjMatrix);
		
		int max = 0;
		int max_idx = -1;
		for(int i=1; i<=N; i++) {
			if(distance[i] != max_value && max<distance[i]) {
				max = distance[i];
				max_idx = i;
			}
		}

		distance = new int[N+1];
		Arrays.fill(distance, max_value);
		distance[max_idx] = 0;
		
		dijkstra(N, max_value, distance, new boolean[N+1], adjMatrix);
		
		max = 0;
		for(int i=1; i<=N; i++) {
			if(distance[i] != max_value && max<distance[i]) {
				max = distance[i];
			}
		}
		
		System.out.println(max);
	}
	
	public static void dijkstra(int N, int max_value, int[] distance, boolean[] visited, int[][] adjMatrix) {
		for(int i=0; i<N; i++) {
			int min = max_value;
			int current = 0;
			
			for(int j=1; j<=N; j++) {
				if(!visited[j] && min>distance[j]) {
					min = distance[j];
					current = j;
				}
			}
			
			visited[current] = true; 
//			if(current == end) break;
			
			for(int j=1; j<=N; j++) {
				if(!visited[j] && adjMatrix[current][j]!=0 && distance[j]>distance[current]+adjMatrix[current][j]) {
					distance[j] = distance[current]+adjMatrix[current][j];
				}
			}
		}
	}
}
