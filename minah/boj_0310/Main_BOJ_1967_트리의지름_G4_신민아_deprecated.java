package boj_0310;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// tree의 특성을 이용하자! : cycle이 없기 때문에 경로는 유일무이하며, 임의의 정점에서부터 가장 먼 지점과 가장 먼 지점으로부터 가장 먼 지점이 루트가 겹칠수밖에 없음!
// 따라서 두번만 검사하면 된다 --> 1167과 다를 바가 없음
// canceled idea : 트리의 지름은 반드시 root를 지나야 하므로 root에서부터 가장 먼 곳 중 1,2 순위를 골라서 더하기 --> 예시 보니 아님 ㅎ
// canceled reason : 만약 1 -> 2 -> 4, 5 + 1 -> 3 -> 6, 7 인 경우, 1->2->4와 1->2->5가 가장 먼 순위일 경우 이것도 트리의 지름
// 루트의 바로 아래 자식을 시작점으로 하여 제일 긴 2개를 정하는 방식,,? -> 자식이 2개라는 보장이 없으므로 자식의 개수만큼 for문을 돌려야함
// 루트의 자식으로부터 각 자식까지의 거리 계산
public class Main_BOJ_1967_트리의지름_G4_신민아_deprecated {
	static int[] maxDistance;
	
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
		boolean[] visited = new boolean[edgeCount + 1];
		maxDistance = new int[edgeCount + 1];
		
		StringTokenizer st;
		String line = "";
		while((line = br.readLine()) != null){
			st = new StringTokenizer(line, " ");
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			tree[from] = new Node(to, weight, tree[from]); // 단방향으로 저장
			tree[to] = new Node(from, weight, tree[to]);
		}
		
		for(Node temp=tree[1];temp!=null;temp=temp.link) {
			System.out.println(temp.vertex);
			searchTreeByDFS(tree, temp.vertex, 0, temp.vertex, visited);
		}
		
		System.out.print(Arrays.toString(maxDistance));
		
		
	}
	
	static void searchTreeByDFS(Node[] tree, int current, int curWeight, int trial, boolean[] visited) {
		visited[current] = true;
		
		if(tree[current].link == null) { // 더 이상 갈 곳이 없다면
			if(maxDistance[trial] < curWeight) { // 현재 가중치의 합이 현재까지 구해진 최대 가중치의 합보다 크다면
				maxDistance[trial] = curWeight; // 가중치 업데이트
			}
		}
		
		for(Node temp=tree[current];temp!=null;temp=temp.link) {
			if(!visited[temp.vertex]) {
				searchTreeByDFS(tree, temp.vertex, curWeight + temp.weight, trial, visited);
			}
		}
		
		visited[current] = false;
	}

}
