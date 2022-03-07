import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1238_Contact_D4_신민아_listVer_미완성 {
	static int maxDepth, answer;
	
	static class Node {
		int vertex;
		Node link;
		public Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}
		
		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + "]";
		}
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		int testCase = 0;
		String line = "";
		Node[] nodes;
		while((line = br.readLine()) != null) {
			st = new StringTokenizer(line, " ");
			int length = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			maxDepth = 0;
			answer = 0;
			
			st = new StringTokenizer(br.readLine(), " ");
			nodes = new Node[length+1];
			
			while(st.hasMoreElements()) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				nodes[from] = new Node(to, nodes[from]);
			}
			
			dfs(nodes, new boolean[length+1], start, 0);
			
			sb.append("#").append(++testCase).append(" ").append(answer).append("\n");
		}
		
		System.out.print(sb.toString());
	}
	
	private static void dfs(Node[] nodes, boolean[] visit, int current, int curDepth) {
		visit[current] = true;
		
		if(curDepth > maxDepth || (curDepth == maxDepth && current > answer)) {
			maxDepth = curDepth;
			answer = current;
		}
		
		for(Node temp=nodes[current];temp!=null;temp=temp.link) {
			if(!visit[temp.vertex]) 
				dfs(nodes, visit, temp.vertex, curDepth+1);
		}
	}

}
