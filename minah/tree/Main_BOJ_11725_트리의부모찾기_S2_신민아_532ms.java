import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_11725_트리의부모찾기_S2_신민아_532ms {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int nodeCount = Integer.parseInt(br.readLine());
		
		List<Integer> treeInfo[] = new ArrayList[nodeCount+1]; // 각 노드 별 간선으로 연결 된 노드의 정보 : 쌍방향으로 저장
		
		for(int i=1;i<nodeCount+1;i++) { // ArrayList 초기화
			treeInfo[i] = new ArrayList<Integer>();
		}
		
		StringTokenizer st;
		
		int first = 0; // 첫번째 수
		int second = 0; // 두번째 수
		for(int i=0;i<nodeCount-1;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			first = Integer.parseInt(st.nextToken());
			second = Integer.parseInt(st.nextToken());
			
			treeInfo[first].add(second); // 어떤 것이 부모인지 모르므로 쌍방향으로 저장
			treeInfo[second].add(first);
			
		}
		
		// BFS로 탐색할 Queue --> DFS로도 탐색 가능하지만 재귀로 찾는 보단 BFS가 간단하고 메모리 상에서 이득일 것 같아 BFS 
		Queue<Integer> visitQueue = new LinkedList<Integer>();
		int[] parent = new int[nodeCount+1]; // 각 노드 별 부모의 정보를 저장할 배열
		visitQueue.add(1); // 1이 루트노드이므로 무조건 처음부터 탐색
		parent[1] = -1; // 1은 루트노드이므로 부모가 없으니 0이 아닌 값으로 초기화
		
		// BFS 활용
		while(!visitQueue.isEmpty()) {
			int curVisit = visitQueue.poll(); // 현재 queue에서 방문하는 노드 꺼냄
			
			for(int j=0;j<treeInfo[curVisit].size();j++) { // 현재 방문 중인 노드와 연결된 모든 노드들 조사
				int nextVisit = treeInfo[curVisit].get(j); // 다음에 방문할 노드 값 꺼냄
				if(parent[nextVisit] == 0) { // 다음에 방문할 노드의 부모를 못찾았다면
					parent[nextVisit] = curVisit; // 현재 노드가 다음 노드의 부모라고 저장
					visitQueue.offer(nextVisit); // 다음에 방문해야 하므로 방문 리스트에 offer
				}
			}
		}
		
		// 출력
		for(int i=2;i<treeInfo.length;i++) {
			sb.append(parent[i]).append("\n");
		}
		
		System.out.print(sb.toString());

	}

}
