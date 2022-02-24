import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_BOJ_1753_최단경로_G5_이재순_1792ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken())+1;
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		Node[] nodes = new Node[V];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int temp = Integer.parseInt(st.nextToken());
			nodes[temp] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), nodes[temp]);
		}
		int[] distance = new int[V];
		boolean[] visited = new boolean[V];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[K] = 0;
		for (int i = 1; i < V; i++) {
			int min = Integer.MAX_VALUE, current = 0;
			for (int j = 1; j < V; j++) {
				if (!visited[j]&&min>distance[j]) {
					min = distance[j];
					current = j;
				}
			}
			
			visited[current] = true;
			
			for (Node curNode = nodes[current]; curNode!=null; curNode = curNode.next) {
				if (!visited[curNode.vertex]&&distance[curNode.vertex]>distance[current]+curNode.weight) {
					distance[curNode.vertex] = distance[current]+curNode.weight;
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
	static class Node {
		int vertex, weight;
		Node next;
		public Node(int idx, int weight, Node next) {
			this.vertex = idx;
			this.weight = weight;
			this.next = next;
		}
	}
}
