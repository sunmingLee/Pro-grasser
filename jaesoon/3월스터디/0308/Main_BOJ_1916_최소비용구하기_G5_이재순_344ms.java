import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_1916_최소비용구하기_G5_이재순_344ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine())+1;
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Node[] nodes = new Node[N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			nodes[from] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), nodes[from]);
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Node> pq= new PriorityQueue<Node>();
		int[] distance = new int[N];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		pq.offer(new Node(start, 0, null));
		int test=0;
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (distance[cur.to]<cur.weight) {
				continue;
			}
			if (cur.to == end) break;
			for (Node curNode = nodes[cur.to]; curNode!=null ; curNode = curNode.next) {
				if (distance[curNode.to]>cur.weight + curNode.weight) {
					test++;
					distance[curNode.to]=cur.weight + curNode.weight;
					pq.offer(new Node(curNode.to, distance[curNode.to], null));
				}
			}
		}
		System.out.println(test);
		System.out.println(distance[end]);
		
	}
	
	static class Node implements Comparable<Node> {
		int to, weight;
		Node next;
		public Node(int to, int weight, Node next) {
			this.to = to;
			this.weight = weight;
			this.next = next;
		}
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
}

