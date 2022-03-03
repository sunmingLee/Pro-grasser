import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BOJ_1167_트리의지름_G3_이승연_808ms {
	static class Edge{
		int to; 
		int distance;
		
		public Edge(int to, int distance) {
			super();
			this.to = to;
			this.distance = distance;
		} 
	}

	private static boolean[] visited;
	private static int max;
	private static int max_node;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int V = Integer.parseInt(br.readLine());
				
		ArrayList<Edge>[] edgeAdjList = new ArrayList[V+1];
		
		for(int i=0; i<=V; i++) {
			edgeAdjList[i] = new ArrayList<Edge>();
		}
		
		for(int i=0; i<V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int from = Integer.parseInt(st.nextToken());
			
			while(true) {
				int to = Integer.parseInt(st.nextToken());
				if(to == -1) break;
				int distance = Integer.parseInt(st.nextToken());
				
				edgeAdjList[from].add(new Edge(to, distance));
			}
		}
		// 임의의 노드에서 가장 먼 노드 구하고, 이 노드에서 다시 가장 먼 노드를 구하면 그게 트리의 최대 지름 
		// 임의의 노드에서 가장 먼 노드 구하기 
		visited = new boolean[V+1];
		visited[1] = true; // 임의의 노드 1 
		dfs(edgeAdjList, 1, 0);
		
		max = 0;
		
		visited = new boolean[V+1];
		visited[max_node] = true; // 임의의 노드에서 가장 먼 노드 
		dfs(edgeAdjList, max_node, 0);
		
		System.out.println(max);
	}
	
	public static void dfs(ArrayList<Edge>[] edgeAdjList, int from, int distance) {
		if(max < distance) {
			max = distance; 
			max_node = from; 
		}
		
		for(Edge e: edgeAdjList[from]) {
			if(!visited[e.to]) {
				visited[e.to] = true; 
				dfs(edgeAdjList, e.to, distance+e.distance);
//				visited[e.to] = false; 
			}
		}
	}
}
