import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_BOJ_1753_최단경로_G5_이재순_600ms { 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken())+1;//노드의 갯수+1, 1 ≤ V-1 ≤ 20,000
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		Node[] nodes = new Node[V];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int temp = Integer.parseInt(st.nextToken());
			nodes[temp] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), nodes[temp]);
		}
		int[] distance = new int[V];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[K] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.offer(new Node(K, 0, null));
		while(!pq.isEmpty()) {
			Node cur= pq.poll();
			if (distance[cur.vertex]<cur.weight) {
				continue;
			}
			
			for (Node curNode = nodes[cur.vertex]; curNode!=null; curNode = curNode.next) {
				if (distance[curNode.vertex]>distance[cur.vertex]+curNode.weight) {
					distance[curNode.vertex] = distance[cur.vertex]+curNode.weight;
					pq.offer(new Node(curNode.vertex,distance[curNode.vertex],null));
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < V; i++) {
			if (distance[i]==Integer.MAX_VALUE) {
				sb.append("INF\n");
			}else sb.append(distance[i]).append("\n");
		}
		System.out.println(sb);
		
	}
	static class Node implements Comparable<Node>{
		int vertex, weight;
		Node next;
		public Node(int idx, int weight, Node next) {
			this.vertex = idx;
			this.weight = weight;
			this.next = next;
		}
		@Override
		public int compareTo(Node o) {
			return this.weight-o.weight;
		}
	}
}
