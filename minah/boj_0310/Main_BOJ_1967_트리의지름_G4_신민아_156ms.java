package boj_0310;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// tree의 특성을 이용하자! : cycle이 없기 때문에 경로는 유일무이하며, 임의의 정점에서부터 가장 먼 지점과 가장 먼 지점으로부터 가장 먼 지점이 루트가 겹칠수밖에 없음!
// 따라서 두번만 검사하면 된다 --> 1167과 다를 바가 없음
// canceled idea : 트리의 지름은 반드시 root를 지나야 하므로 root에서부터 가장 먼 곳 중 1,2 순위를 골라서 더하기 --> 예시 보니 아님 ㅎ
public class Main_BOJ_1967_트리의지름_G4_신민아_156ms {
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
		
		if(edgeCount == 1) { // 예외 케이스 : 정점이 1개인 경우 간선이 없으므로 예외처리 필요
			System.out.print(0); // 간선이 없으므로 0 출력
			return; // 종료
		}
		
		Node[] tree = new Node[edgeCount + 1];
		StringTokenizer st;
		String line = "";
		while((line = br.readLine()) != null){
			st = new StringTokenizer(line, " ");
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			tree[from] = new Node(to, weight, tree[from]); // 양방향으로 저장
			tree[to] = new Node(from, weight, tree[to]);
		}
		
		searchTreeByDFS(tree, new boolean[edgeCount + 1], 1, 0); // root로부터 가장 먼 정점을 찾기(이러면 가장 끝에 있는 정점을 찾음)
		searchTreeByDFS(tree, new boolean[edgeCount + 1], maxDistanceEdge, 0); // root로부터 가장 먼 정점에서 가장 먼 정점을 구함
		
		System.out.print(maxDistance);
		
		
	}
	
	static void searchTreeByDFS(Node[] tree, boolean[] visited, int current, int curWeight) {
		visited[current] = true;
		
		if(tree[current].link == null) { // 더 이상 갈 곳이 없다면
			if(maxDistance < curWeight) { // 현재 가중치의 합이 현재까지 구해진 최대 가중치의 합보다 크다면
				maxDistance = curWeight; // 가중치 업데이트
				maxDistanceEdge = current; // 임의의 시작점으로부터 가장 먼 정점을 구함
			}
		}
		
		for(Node temp=tree[current];temp!=null;temp=temp.link) {
			if(!visited[temp.vertex]) {
				searchTreeByDFS(tree, visited, temp.vertex, curWeight + temp.weight);
			}
		}
	}

}
