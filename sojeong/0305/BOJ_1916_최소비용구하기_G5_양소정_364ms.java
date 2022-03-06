package march0308;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//다익스트라

public class Main_BOJ_1916_최소비용구하기_G5_양소정_364ms{
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
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		
		Node[] adj = new Node[N+1];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[from] = new Node(to,w,adj[from]);
			
		}
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		int[] distance = new int[N+1]; 
		boolean[] visited = new boolean[N+1]; 
		
		
        PriorityQueue<Node> pQueue = new PriorityQueue<Node>();
        pQueue.offer(new Node(v1, 0, null)); //시작점과 비용 넣음
        
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[v1] = 0; // 시작점 0으로
        
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
        
        System.out.println(distance[v2]);

	}
}
