package boj_0303;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// tree의 특성을 이용하자! : cycle이 없기 때문에 경로는 유일무이하며, 임의의 정점에서부터 가장 먼 지점과 가장 먼 지점으로부터 가장 먼 지점이 루트가 겹칠수밖에 없음!
// 따라서 두번만 검사하면 된다
public class Main_BOJ_1167_트리의지름_G3_신민아_560ms {
	static int maxDistance;
	static int maxDistanceEdge;
	
	static class Node { // 정점의 정보
		int vertex; // 다음 간선
		int weight; // 가중치
		Node link; // 링크
		
		public Node(int vertex, int weight, Node link) {
			this.vertex = vertex;
			this.weight = weight;
			this.link = link;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int edgeCount = Integer.parseInt(br.readLine());
		
		Node[] tree = new Node[edgeCount];
		StringTokenizer st;
		for(int i=0;i<edgeCount;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken()) - 1; // 정점을 0부터 시작
			int to;
			
			while((to = Integer.parseInt(st.nextToken()) - 1) != -2) { // 한 줄에서 -1을 마주치기 전까지 간선 정보를 저장
				tree[from] = new Node(to, Integer.parseInt(st.nextToken()), tree[from]);
				
			}
		}
		
		searchTreeByDFS(tree, new boolean[edgeCount], 0, 0); // 임의의 정점으로부터 가장 먼 정점을 찾기
		searchTreeByDFS(tree, new boolean[edgeCount], maxDistanceEdge, 0); // 임의의 정점으로부터 구해진 가장 먼 정점에서 가장 먼 정점을 구함
		
		System.out.print(maxDistance);
		
		
	}
	
	static void searchTreeByDFS(Node[] tree, boolean[] visited, int current, int curWeight) {
		visited[current] = true;
		
		if(tree[current].link == null) { // 더 이상 갈 곳이 없다면
			if(maxDistance < curWeight) { // 현재 가중치의 합이 현재까지 구해진 최대 가중치의 합보다 크다면
				maxDistance = curWeight; // 가중치 업데이트
				maxDistanceEdge = current; // 임의의 시작점으로부터 가장 먼 정점을 구함
			} // 여기서 리턴을 쓰면 안..되네..?
		}
		
		for(Node temp=tree[current];temp!=null;temp=temp.link) {
			if(!visited[temp.vertex]) {
				searchTreeByDFS(tree, visited, temp.vertex, curWeight + temp.weight);
			}
		}
	}

}
