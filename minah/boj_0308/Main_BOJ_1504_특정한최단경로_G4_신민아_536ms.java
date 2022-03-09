package boj_0308;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 유의할 점!! : 중간 경유 지점은 순서대로 방문할 필요 없음 + 도로는 양방향으로 통행 가능
// 정점의 개수가 적고 간선의 개수가 많기 때문에 인접 행렬로도 풀어보면 좋을 듯하다
public class Main_BOJ_1504_특정한최단경로_G4_신민아_536ms {
	static class Node implements Comparable<Node>{ // 정점 정보 저장
		int end;
		int weight;
		
		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return weight - o.weight;
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int edges = Integer.parseInt(st.nextToken()); // 총 정점의 수
		int vertexes = Integer.parseInt(st.nextToken()); // 총 간선의 수
		
		List<Node>[] nodes = new ArrayList[edges + 1]; // 간선을 잇는 인접리스트
		
		for(int i=1;i<=edges;i++) {
			nodes[i] = new ArrayList<Node>(); // initialization
		}
		
		for(int i=0;i<vertexes;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int from = Integer.parseInt(st.nextToken()); // 출발지(도착지)
			int to = Integer.parseInt(st.nextToken()); // 도착지(출발지)
			int weight = Integer.parseInt(st.nextToken()); // 거리
			
			nodes[from].add(new Node(to, weight)); // 도로가 양방향이기 때문에 양쪽으로 길을 내준다
			nodes[to].add(new Node(from, weight));
		}
		
		st = new StringTokenizer(br.readLine(), " "); // 방문해야 할 간선
		
		int[] points = new int[4]; // 방문할 간선들 관리
		points[0] = 1; // 시작점
		points[1] = Integer.parseInt(st.nextToken()); // 방문지점 1
		points[2] = Integer.parseInt(st.nextToken()); // 방문지점 2
		points[3] = edges; // 도착지
		
		int totalDistance1 = getTotalPath(points, nodes); // 1 -> v1 -> v2 -> 도착지
		
		swapPoints(points); // 반드시 경유지 1,2를 순서대로 다닐 필요는 없으므로 1,2를 스왑
		int totalDistance2 = getTotalPath(points, nodes); // 1 -> v2 -> v1 -> 도착지
		
		int answer = Integer.MAX_VALUE; // 정답을 MAX_VALUE로 초기화
		
		answer = Math.min(totalDistance1, totalDistance2); // totalDistance들 중 더 작은 값 구함
		
		System.out.print(answer == Integer.MAX_VALUE ? -1 : answer); // answer가 MAX_VALUE면 갈 수 없는 경우이므로 -1 출력, 아닐 시 정답 출력
		
	}
	
	// dijkstra by adjacent list
	// 도착지가 명확하게 제시되어 있으므로 도착지까지의 최단 거리 갱신 시 바로 종료하면 됨
	static private int getShortestPath(int start, int end, List<Node>[] nodes) {
		boolean[] visited = new boolean[nodes.length]; // 최단 거리 여부 체크
		int[] distances = new int[nodes.length]; // 최단 거리 저장
		Arrays.fill(distances, Integer.MAX_VALUE); // 최대 값으로 초기화
		
		PriorityQueue<Node> pQueue = new PriorityQueue<Node>(); // 방문할 정점들 추가
		distances[start] = 0; // 시작점 0으로 초기화
		pQueue.offer(new Node(start, distances[start])); // 정점 추가
		
		while(!pQueue.isEmpty()) { // 더 이상 갈 곳이 없을 때까지
			Node current = pQueue.poll(); // 현재 위치
			
			if(current.end == end) // 도착지까지 거리를 정했을 시
				return distances[end]; // 출발지로부터 도착지까지의 거리 반환
			
			if(visited[current.end]) // 이미 계산한 정점일 시
				continue; // 넘어감
			
			visited[current.end] = true; // 계산 체크
			
			// 계산 부분
			for(Node node : nodes[current.end]) { // 연결 된 정점을 계속 돌기
				int tempDistance = distances[current.end] + node.weight; // 임시 거리 : 출발지~현재까지의 거리와 현재로부터 다음 정점까지의 거리 더하기
				
				if(distances[node.end] > tempDistance) { // 새로 갱신된 거리가 짧을 시
					distances[node.end] = tempDistance; // 갱신
					pQueue.offer(new Node(node.end, distances[node.end])); // queue에 이동할 정점이라고 넣어줌
				}
			}
		}
		
		return distances[end]; // 반환
	}
	
	// 출발지로부터 도착지까지 경유지 1,2를 거쳐서 가는 메소드
	static private int getTotalPath(int[] points, List<Node>[] nodes) {
		int totalDistance = 0;
		
		for(int i=0;i<points.length - 1;i++) {
			int distance = getShortestPath(points[i], points[i+1], nodes);
			if(distance == Integer.MAX_VALUE) { // 중간에 갈 수 없는 길이 있으면 이 루트로는 갈 수 없으므로
				return Integer.MAX_VALUE; // 종료
			}
			totalDistance += distance;
		}

		return totalDistance;
	}
	
	// 경유지 1,2 순서 스왑
	static private void swapPoints(int[] points) {
		int temp = points[1];
		points[1] = points[2];
		points[2] = temp;
	}

}
