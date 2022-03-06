package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main_BOJ_1916_최소비용구하기_G5_이승연_PQ_352ms {
	static class Vertex implements Comparable<Vertex>{
		int no; 
		int minDistance;
		
		public Vertex(int no, int minDistance) {
			super();
			this.no = no;
			this.minDistance = minDistance;
		}

		@Override
		public int compareTo(Vertex o) {
			return minDistance - o.minDistance; // 오름차순
		}
	}
	
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
		
		PriorityQueue<Vertex> pQueue = new PriorityQueue<Vertex>();
		
		int max_value = 100000000;
		boolean[] visited = new boolean[N+1];
		int[] distance = new int[N+1];
		Arrays.fill(distance, max_value);
		distance[SP] = 0;
		pQueue.offer(new Vertex(SP, 0));
		
		while(!pQueue.isEmpty()) {
			Vertex current = pQueue.poll();
			
			if(visited[current.no]) continue;
			visited[current.no] = true;
//			if(current.no == FP) continue;
			
			for(int j=1; j<=N; j++) {
				if(!visited[j] && adjMatrix[current.no][j]!=-1 && distance[j]>distance[current.no]+adjMatrix[current.no][j]) {
					distance[j] = distance[current.no]+adjMatrix[current.no][j];
					pQueue.offer(new Vertex(j, distance[j]));
				}
			}
		}
		
		System.out.println(distance[FP]);
	}
}
