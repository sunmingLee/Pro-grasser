import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_1916_최소비용구하기_G5_이승연_336ms {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 도시의 개수(1<=N<=1000)
		int M = Integer.parseInt(br.readLine()); // 버스의 개수(1<=M<=100000)
		int[][] adjMatrix = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++)
			Arrays.fill(adjMatrix[i], -1); // 가중치가 0이 될 수 있다. 
		
		StringTokenizer st;
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			if(adjMatrix[from][to] == -1 || adjMatrix[from][to]>weight) {
				adjMatrix[from][to] = weight;
			}
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int SP = Integer.parseInt(st.nextToken());
		int FP = Integer.parseInt(st.nextToken());
		
		int max_value = 100000000;
		int[] distance = new int[N+1];
		Arrays.fill(distance, max_value);
		distance[SP] = 0;
		boolean[] visited = new boolean[N+1];
		
		for(int i=1; i<=N; i++) {
			int min = max_value;
			int current = 0;
			for(int j=1; j<=N; j++) {
				if(!visited[j] && min>distance[j]) {
					min = distance[j];
					current = j;
				}
			}
			
			visited[current] = true;
			if(current == FP) break; 
			
			for(int j=1; j<=N; j++) {
				if(!visited[j] && adjMatrix[current][j]!=-1 && distance[j]>distance[current]+adjMatrix[current][j]) {
					distance[j] = distance[current]+adjMatrix[current][j];
				}
			}
		}
		
		System.out.println(distance[FP]);
	}
}
