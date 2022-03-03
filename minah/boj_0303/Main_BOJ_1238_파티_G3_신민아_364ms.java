package boj_0303;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_1238_파티_G3_신민아_364ms {
	static class Vertex implements Comparable<Vertex> { // 정점 정보 저장 : 알아서 가까운 순으로 정렬
		int no, minDistance;

		public Vertex(int no, int minDistance) {
			this.no = no;
			this.minDistance = minDistance;
		}

		@Override
		public int compareTo(Vertex o) {
			return minDistance - o.minDistance;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int studentCount = Integer.parseInt(st.nextToken()); // 학생 수 (= 도시의 수)
		int roadCount = Integer.parseInt(st.nextToken()); // 도로의 수
		int partyLocation = Integer.parseInt(st.nextToken()) - 1; // 파티하는 도시(메모리 절약을 위해 -1을 일괄적으로 처리)
		
		int[][] villages = new int[studentCount][studentCount]; // 파티 장소에서 집으로 돌아갈 때의 최소 경로를 찾기위한 배열
		int[][] reverseVillages = new int[studentCount][studentCount]; // 집에서 파티 장소로 갈 때의 최소 경로를 찾기위한 배열
		
		for(int i=0;i<roadCount;i++) { // 도로의 수 만큼 정보 넣기
			st = new StringTokenizer(br.readLine(), " "); 
			
			int from = Integer.parseInt(st.nextToken()) - 1; // 도로의 시작 지점
			int to = Integer.parseInt(st.nextToken()) - 1; // 도로의 끝 지점
			int weight = Integer.parseInt(st.nextToken()); // 도로의 가중치
			
			villages[from][to] = weight; // 파티 장소  -> 집
			reverseVillages[to][from] = weight; // 집 -> 파티장소
		}
		
		int[] distancesToParty = searchShortestPath(partyLocation, reverseVillages); // 다익스트라 알고리즘으로 파티 장소로 가는 가장 짧은 경로들을 찾아좀
		int[] distancesFromParty = searchShortestPath(partyLocation, villages); // 집으로 가는 가장 짧은 경로를 찾아줌
		
		for(int i=0;i<studentCount;i++) { // 왕복 거리의 합산을 구해야 하므로 한 배열에 몰아주고
			distancesFromParty[i] += distancesToParty[i];
		}
		
		System.out.print(Arrays.stream(distancesFromParty).max().getAsInt()); // 최대값을 찾아서 출력, 파티 장소로 왕복이 불가능한 경우는 없으므로 간단하게 stream처리
	}
	
	// 다익스트라 알고리즘으로 각 정점 별로 가장 짧은 경로를 찾음
	// start : 시작지점, village : 마을의 도로 정보
	static int[] searchShortestPath(int start, int[][] village) {
		int[] distances = new int[village.length]; // 최단 경로들을 저장할 배열
		boolean[] visited = new boolean[village.length]; // visit 배열
		
		PriorityQueue<Vertex> pQueue = new PriorityQueue<Vertex>(); // 해당 위치에서 짧은 순으로 정렬하여 이동
		
		Arrays.fill(distances, Integer.MAX_VALUE); // 최소 경로 계산을 위한 초기화
		distances[start] = 0; // 시작점이므로 0으로 설정
		pQueue.offer(new Vertex(start, distances[start])); // 시작점의 정점을 넣어둠
		
		while(!pQueue.isEmpty()) {
			Vertex current = pQueue.poll(); // 시작점으로부터 가까운 정점을 먼저 꺼냄
			
			if(visited[current.no]) // 최단거리 확정 시 나감
				continue;
			
			visited[current.no] = true; // 방문 체크
			
			for(int i=0;i<village.length;i++) { // 선택 정점을 경유지로 하여 최소 비용이 확정되지 않은 정점의 최소 비용 계산
				int tempDistance = distances[current.no] + village[current.no][i]; // 시작점으로부터 현재 정점까지의 최단 거리 + 현재 정점부터 다음 정점까지의 거리
				
				if(!visited[i] && village[current.no][i] != 0 && distances[i] > tempDistance) { // 이미 확정x, 이동할 수 있고, 최단거리라고 작성된 것이 새로운 값보다 클 때 
					distances[i] = tempDistance; // 최단거리 업데이트
					pQueue.offer(new Vertex(i, distances[i])); // 큐에 업데이트
				}
			}
			
		}
		
		return distances;
	}

}
