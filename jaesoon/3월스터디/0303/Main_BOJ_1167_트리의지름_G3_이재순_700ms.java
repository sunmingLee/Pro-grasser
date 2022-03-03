import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1167_트리의지름_G3_이재순_700ms {
	static int ans, idx;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine())+1;//트리 정점의 갯수+1, 2 ≤ V-1 ≤ 100,000
		Node[] nodes = new Node[V];
		StringTokenizer st;
		//초기화
		for (int i = 1, temp, cur; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			cur = Integer.parseInt(st.nextToken());
			while ((temp = Integer.parseInt(st.nextToken())) != -1) {
				nodes[cur] = new Node(temp, Integer.parseInt(st.nextToken()), nodes[cur]);
			}
		}
		//프로세스 진행
		dfs(1, 0, 0, nodes); //임의의 점 1부터 dfs진행
		dfs(idx, 0, 0, nodes);//임의의 점 1로부터 가장 멀리 떨어진 idx부터 dfs진행
		//출력
		System.out.println(ans);
	}
	
	private static void dfs(int curIdx, int sum, int prevIdx, Node[] nodes) {
		if (sum>ans) {//정답 갱신
			ans = sum;
			idx = curIdx;
		}
		for (Node curNode = nodes[curIdx]; curNode!=null; curNode = curNode.next) {
			if (curNode.vertex != prevIdx) //직전에 방문한곳이 아니라면 진행(트리구조라서 직전 노드로만 안가면 중복이 일어나지 않는다)
				dfs(curNode.vertex, sum+curNode.weight, curIdx, nodes);
		}
	}
	
	static class Node {
		int vertex, weight;
		Node next;
		public Node(int vertex, int weight, Node next) {
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
	}
}
