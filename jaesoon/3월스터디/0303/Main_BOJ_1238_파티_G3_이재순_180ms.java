import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_1238_파티_G3_이재순_180ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());//학생 수, 1 ≤ N ≤ 1,000
		int M = Integer.parseInt(st.nextToken());//단방향 도로의 수, 1 ≤ M ≤ 10,000
		int X = Integer.parseInt(st.nextToken());//파티장
		Node[] forward = new Node[N+1];//도로를 정방향으로 기록하는 노드배열
		Node[] backward = new Node[N+1];//도로를 역방향으로 기록하는 노드배열
		//초기화
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			forward[a] = new Node(b, weight, forward[a]);//정방향 저장
			backward[b] = new Node(a, weight, backward[b]);//역방향 저장
		}
		
		Distance[] distance = new Distance[N+1];
		for (int i = 0; i <= N; i++) distance[i] = new Distance();
		
		distance[X].toParty = 0;
		distance[X].toHome = 0;
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		//프로세스 진행
		//첫번째 다익스트라 진행(정방향 - 파티장에서 집으로 가는 길이)
		pq.offer(new Node(X, 0, null));
		while(!pq.isEmpty()) {
			Node cur= pq.poll();
			if (distance[cur.vertex].toHome<cur.weight) {
				continue;
			}
			
			for (Node curNode = forward[cur.vertex]; curNode!=null; curNode = curNode.next) {
				if (distance[curNode.vertex].toHome>distance[cur.vertex].toHome+curNode.weight) {
					distance[curNode.vertex].toHome = distance[cur.vertex].toHome+curNode.weight;
					pq.offer(new Node(curNode.vertex,distance[curNode.vertex].toHome,null));
				}
			}
		}
		//두번째 다익스트라 진행(역방향 - 집에서 파티장으로 가는 길이)
		pq.offer(new Node(X, 0, null));
		while(!pq.isEmpty()) {
			Node cur= pq.poll();
			if (distance[cur.vertex].toParty<cur.weight) {
				continue;
			}
			
			for (Node curNode = backward[cur.vertex]; curNode!=null; curNode = curNode.next) {
				if (distance[curNode.vertex].toParty>distance[cur.vertex].toParty+curNode.weight) {
					distance[curNode.vertex].toParty = distance[cur.vertex].toParty+curNode.weight;
					pq.offer(new Node(curNode.vertex,distance[curNode.vertex].toParty,null));
				}
			}
		}
		Arrays.sort(distance);//집-파티장, 파티장-집의 거리 합을 기준으로 정렬
		//출력
		System.out.println(distance[1].toHome+distance[1].toParty);//distance[0]은 Integer.MAX_VALUE
	}
	static class Distance implements Comparable<Distance>{
		int toParty, toHome;
		public Distance() {
			toParty = Integer.MAX_VALUE;
			toHome = Integer.MAX_VALUE;
		}
		@Override
		public int compareTo(Distance o) {
			if (this.toHome==Integer.MAX_VALUE||this.toParty==Integer.MAX_VALUE) {
				return -1;
			}
			else if (o.toHome==Integer.MAX_VALUE||o.toParty==Integer.MAX_VALUE) {
				return 1;
			}
			
			return o.toParty+o.toHome-this.toParty-this.toHome;
		}
	}
	static class Node implements Comparable<Node>{
		int vertex, weight;
		Node next;
		
		public Node(int vertex, int weight, Node next) {
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
		@Override
		public int compareTo(Node o) {
			return this.weight-o.weight;
		}
	}
}
