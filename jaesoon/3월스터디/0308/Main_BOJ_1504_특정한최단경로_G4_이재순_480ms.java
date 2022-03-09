import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_1504_특정한최단경로_G4_이재순_480ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		Node[] nodes = new Node[N+1];
		for (int i = 0,a,b,c; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			nodes[a] = new Node(b, c, nodes[a]);
			nodes[b] = new Node(a, c, nodes[b]);
		}
		st = new StringTokenizer(br.readLine());
		int V1 = Integer.parseInt(st.nextToken());
		int V2 = Integer.parseInt(st.nextToken());
		
		int[] distance1 = dijkstra(nodes, V1, N);
		int[] distance2 = dijkstra(nodes, V2, N);
		if (distance1[V2]==Integer.MAX_VALUE||((distance1[1] == Integer.MAX_VALUE||distance2[N] == Integer.MAX_VALUE)&&(distance1[N] == Integer.MAX_VALUE || distance2[1] == Integer.MAX_VALUE))) {
			System.out.println(-1);
		}
		else System.out.println(Math.min(distance1[1]+distance1[V2]+distance2[N], distance2[1]+distance1[V2]+distance1[N]));
	}
	
	private static int[] dijkstra(Node[] nodes, int start, int N) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		int[] distance = new int[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		pq.add(new Node(start, 0));
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (cur.weight>distance[cur.to]) continue;
			
			for (Node curNode = nodes[cur.to]; curNode !=null; curNode = curNode.next) {
				if (distance[curNode.to]>cur.weight+curNode.weight) {
					distance[curNode.to] = cur.weight + curNode.weight;
					pq.offer(new Node(curNode.to,distance[curNode.to]));
				}
			}
		}
		return distance;
	}
	
	static class Node implements Comparable<Node>{
		int to, weight;
		Node next;
		public Node(int to, int weight, Node next) {
			this.to = to;
			this.weight = weight;
			this.next = next;
		}
		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return this.weight-o.weight;
		}
	}
}
