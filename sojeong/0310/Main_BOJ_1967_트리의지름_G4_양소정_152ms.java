
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1967_트리의지름_G4_양소정_152ms {
	
	static class Node{
		int v; //다음간선
		int w; //가중치
		Node link;
		
		public Node(int v, int w, Node link) {
			super();
			this.v = v;
			this.w = w;
			this.link = link;
		}
		
	}

	private static int ans;
	private static int vv;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine()); //노드의 개수
		Node[] adj = new Node[V + 1];
		for (int i = 0; i < V-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[from] = new Node(to, w, adj[from]);
			adj[to] = new Node(from, w, adj[to]);
			
		}
		boolean[] visited = new boolean[V+1];
		dfs(adj,1,visited,0);
		visited = new boolean[V+1];
		dfs(adj,vv,visited,0);
		
		System.out.println(ans);
	}

	private static void dfs(Node[] adj,int start, boolean[] visited,int sum) {
		if(sum > ans) {
			vv = start; 
			ans = sum;
		}
		
		visited[start]= true;
		for (Node temp = adj[start]; temp != null; temp = temp.link) {
			if(!visited[temp.v]) {
				dfs(adj,temp.v,visited,sum+temp.w);
			}
		}
	}

}
