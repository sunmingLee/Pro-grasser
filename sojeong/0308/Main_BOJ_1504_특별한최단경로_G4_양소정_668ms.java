
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_1504_특별한최단경로_G4_양소정_668ms{

	static class Node implements Comparable<Node>{
		int v,w;
		Node link;
		
		public Node(int v,int w, Node link) {
			super();
			this.v = v;
			this.w = w;
			this.link = link;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.w-o.w;
		}	
		
	}
	private static int N;

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		Node[] adj = new Node[N+1];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[from] = new Node(to,w,adj[from]);
			adj[to]= new Node(from,w,adj[to]);
			
		}
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		int[] distance = new int[N+1]; 
		boolean[] visited = new boolean[N+1]; 
		
		long res1 = 0;
        res1 += dijkstra(1, v1 , distance, visited,adj);
        res1 += dijkstra(v1, v2,distance, visited,adj);
        res1 += dijkstra(v2, N, distance, visited,adj);

        long res2 = 0;
        res2 += dijkstra(1, v2, distance, visited,adj);
        res2 += dijkstra(v2, v1, distance, visited,adj);
        res2 += dijkstra(v1, N, distance, visited,adj);
        long result = (res1 >= Integer.MAX_VALUE && res2 >= Integer.MAX_VALUE) ? -1 : Math.min(res1, res2);
        
        System.out.println(result);

		
	}
	private static long dijkstra(int start, int end , int[] distance, boolean[] visited, Node[] adj) {
		PriorityQueue<Node> pQueue = new PriorityQueue<Node>();
		pQueue.offer(new Node(start, 0, null)); //시작점과 비용 넣음
		
		Arrays.fill(visited, false);
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0; // 시작점 0으로
		
		while(!pQueue.isEmpty()) {
			// 단계1 : 최소비용이 확정되지 않은 정점중 최소비용의 정점 선택
			int current = pQueue.poll().v; 
			
			if(visited[current]) continue; //굳이 다 돌 필요없으니 ~
			
			visited[current] = true;
			
			
			for (Node node = adj[current]; node!=null; node = node.link) {
                if (distance[node.v] > distance[current] + node.w) {
                    distance[node.v] = distance[current] + node.w;
                    pQueue.add(new Node(node.v, distance[node.v],null));
                }
            }
		}
		return distance[end];
	}
}
