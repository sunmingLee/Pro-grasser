import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_1753_최단경로_G5_신민아_768ms {
	static class Node implements Comparable<Node>{
		int end, weight; // 정점 번호, 출발지에서 자신으로의 최소 비용
		
		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int edges = Integer.parseInt(st.nextToken());
		int endes = Integer.parseInt(st.nextToken());
		
		List<Node>[] nodes = new ArrayList[edges + 1];
		int startEdge = Integer.parseInt(br.readLine());
//		int end = V - 1;
		
		for(int i=1;i<=edges;i++) {
			nodes[i] = new ArrayList<Node>();
		}
		
		for (int i = 0; i < endes; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			nodes[from].add(new Node(to, weight));
		}
		
		int[] distance = new int[edges + 1]; // 출발지에서 자신으로 오는 최소 비용
		boolean[] visited = new boolean[edges + 1]; // 최소 비용 확정 여부
		PriorityQueue<Node> pQueue = new PriorityQueue<Node>();
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[startEdge] = 0;
		pQueue.offer(new Node(startEdge, distance[startEdge]));
		
		while(!pQueue.isEmpty()) {
			// 단계 1 : 최소 비용이 확정되지 않은 정점 중 최소 비용의 정점 선택
			Node current = pQueue.poll();
			
			if(visited[current.end]) { // 이미 최단거리가 확정되었으면 아래 로직을 수행할 필요 x
				continue;
			}
			visited[current.end] = true;
//			if(current == end) break; // 출발지에서 원하는 도착지만 얻으면 끝나는 코드
			
			// 단계 2 : 선택된 정점을 경유지로 하여 아직 최소 비용이 확정되지 않은 다른 정점의 최소 비용 고려
			for (Node node : nodes[current.end]) {
				// 이미 위에서 visited가 true일 경우 continue로 넘어가고 for문에서 연결된 노드만 대상으로 반복하므로 거리만 비교
				int tempDistance = distance[current.end] + node.weight;
				if(distance[node.end] > tempDistance) {
					distance[node.end] = tempDistance;
					pQueue.offer(new Node(node.end, distance[node.end]));
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1;i<=edges;i++) {
			sb.append(distance[i] == Integer.MAX_VALUE ? "INF" : distance[i]);
			sb.append("\n");
		}
		
		System.out.print(sb.toString());
	}

}
