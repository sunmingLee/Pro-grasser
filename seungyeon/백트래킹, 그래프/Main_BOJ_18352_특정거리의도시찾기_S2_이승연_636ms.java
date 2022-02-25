import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main_BOJ_18352_특정거리의도시찾기_S2_이승연_636ms {
	static class Node{
		int vertex; 
		Node link;
	
		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		} 
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); // 도시의 개수 2<=N<=300000
		int M = Integer.parseInt(st.nextToken()); // 도로의 개수 1<=M<=1000000
		int K = Integer.parseInt(st.nextToken()); // 거리 정보 1<=K<=300000
		int X = Integer.parseInt(st.nextToken()); // 출발 도시의 번호 1<=X<=N
		
		Node[] adjList = new Node[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, adjList[from]);
		}
		
		boolean[] result = new boolean[N+1];
		
		bfs(adjList, result, X, N, K);
		
		boolean flag = false;
		
		for(int i=1; i<=N; i++) {
			if(result[i]) {
				sb.append(i).append("\n");
				flag = true;
			}
		}
		
		if(!flag) {
			sb.append("-1");
		}
		
		System.out.println(sb.toString());
	} // end of main
	
	public static void bfs(Node[] adjList, boolean[] result, int start, int N, int K) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N+1];
		
		queue.offer(start);
		visited[start] = true; 
		int level = 0;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
//			System.out.println("size: "+size);
			while(--size >= 0) {
				int current = queue.poll();
//				System.out.println(current);
				if(level == K) {
					result[current] = true;
				}
				
				// current 정점의 인접정점 처리 (단, 방문하지 않은 인접정점만)
				for(Node temp=adjList[current]; temp != null; temp=temp.link) { // 현재 정점의 head, 반드시 인접한 정점이 있어야 함. 다음 노드로 가야함. 
					if(!visited[temp.vertex]) { 
						queue.offer(temp.vertex);
						visited[temp.vertex] = true;
					}
				}
			}
			level++;
			if(level>K) return;
		}
	}
} // end of class
