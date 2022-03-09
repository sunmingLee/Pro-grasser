package boj_0308;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// bellmanford의 idea : 마지막 정점까지 돌았을 때 계속 최단거리가 갱신이 된다면 음의 사이클이 존재!
// solving idea 1 : 시작 정점을 1부터 n까지 시작하여 음의 사이클이 존재할 경우 빠져나오기
// solving idea 2 : n+1번째 임의의 정점을 만들어 1~n까지 가중치가 0인 간선을 만들어서 모두 검사
public class Main_BOJ_1865_웜홀_G3_신민아_1000ms {
	static class Node{
		int end, weight;

		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}

	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		while(TC -- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int edges = Integer.parseInt(st.nextToken());
			int roads = Integer.parseInt(st.nextToken());
			int wormholes = Integer.parseInt(st.nextToken());
			
			List<Node>[] nodes = new ArrayList[edges + 1];
			
			// Initialization
			for(int i=1;i<nodes.length;i++) {
				nodes[i] = new ArrayList<Node>();
			}
			
			// 양방향 도로 정보 삽입
			for(int i=0;i<roads;i++) {
				st = new StringTokenizer(br.readLine(), " ");
				
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				nodes[from].add(new Node(to, weight));
				nodes[to].add(new Node(from, weight));
			}
			
			// 웜홀 정보 삽입
			for(int i=0;i<wormholes;i++) {
				st = new StringTokenizer(br.readLine(), " ");
				
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				nodes[from].add(new Node(to, -weight));
			}
			
			// 음의 사이클 존재 여부
			boolean hasMinusCycle = false;
			
			// 출발점 별로 음의 사이클이 있는지 확인
			for(int i=1;i<=edges;i++) {
				if(bellmanFord(i, edges, nodes)) {
					hasMinusCycle = true;
					break;
				}
			}
			
			sb.append(hasMinusCycle ? "YES\n" : "NO\n");
			
		}
		
		System.out.print(sb.toString());
	}
	
	// 음의 사이클이 있는지 확인 by bellmanFord : 음의 사이클이 있을 시, 계속 갱신되므로 이 점을 이용하여 true/false값 리턴
	static private boolean bellmanFord(int start, int edges, List<Node>[] nodes) {
		int[] distances = new int[nodes.length]; // 최단 거리
		Arrays.fill(distances, Integer.MAX_VALUE); // 초기화 by maxValue
		distances[start] = 0; // 시작점은 0으로부터 시작
		
		for(int i=1;i<nodes.length;i++) { // 
			boolean isUpdated = false; // 최단 거리 갱신 여부
			for(int j=1;j<nodes.length;j++) { // 다음에 방문할 정점
				int current = j; // 현재 위치
				for(Node node : nodes[j]) { // 간선들 선택
					
					if(distances[current] == Integer.MAX_VALUE) continue; // 몰?루
					
					int tempDistance = distances[current] + node.weight; // 최단거리 갱신용 신규 거리
					if(distances[node.end] > tempDistance) { // 새로운 거리 정보가 기존 최단 거리보다 짧은 경우 -> 갱신
						if(i == edges) return true; // 갱신이 마지막 정점까지 이어지는 경우
						
						distances[node.end] = tempDistance; // 최단 거리 갱신
						isUpdated = true; // 갱신 여부 o
					}
				}
			}
			if(!isUpdated) break; // 갱신이 안되었을 시 음의 사이클 x
		}
		
		return false;
	}

}
