import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1967_트리의지름_G4_이재순_168ms {
	static int max;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Node[] nodes = new Node[N+1];
		StringTokenizer st;
		for (int i = 1, a; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			nodes[a] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), nodes[a]);
		}
		dfs(nodes, nodes[1]);
		System.out.println(max);
	}
	private static int dfs(Node[] nodes, Node cur) {
		if (cur == null) return 0;
		int first = 0, second = 0, temp;
		for (Node curNode = cur ; curNode != null; curNode = curNode.next) {
			temp = dfs(nodes, nodes[curNode.to])+curNode.weight;
			if (temp>first) {
				second = first;
				first = temp;
			}
			else if(temp>second) second = temp;
		}
		if (max<first+second) max = first+second;
		return first;
	}
	
	static class Node {
		int to, weight;
		Node next;
		public Node(int to, int weight, Node next) {
			this.to = to;
			this.weight = weight;
			this.next = next;
		}
	}
}
