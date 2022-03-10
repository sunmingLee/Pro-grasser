import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_1967_트리의지름_G4_이승연_152ms_dfs {
	static class Node{
		int no; 
		int weight;
		Node link;
		
		public Node(int no, int weight, Node link) {
			super();
			this.no = no;
			this.weight = weight;
			this.link = link;
		}
	}

	private static int max;
	private static int max_idx;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 노드의 개수 (1<=N<=10000)
		
		StringTokenizer st;

		Node[] adjList = new Node[N+1];
		
		for(int i=1; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjList[from] = new Node(to, weight, adjList[from]);
			adjList[to] = new Node(from, weight, adjList[to]);
		}
		
		max = 0;
		max_idx = 0;
		
		dfs(1, 0, adjList, new boolean[N+1]);
		
		max = 0; 
		
		dfs(max_idx, 0, adjList, new boolean[N+1]);
		
		System.out.println(max);
	}
	
	public static void dfs(int current, int distance, Node[] adjList, boolean[] visited) {
		if(max < distance) {
			max = distance;
			max_idx = current;
		}
		visited[current] = true; 
		
		for(Node temp=adjList[current]; temp!=null; temp=temp.link) {
			if(visited[temp.no]) continue;
			
			dfs(temp.no, temp.weight+distance, adjList, visited);
		}
	}
}
