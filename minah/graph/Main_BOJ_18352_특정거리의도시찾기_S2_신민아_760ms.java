package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_18352_특정거리의도시찾기_S2_신민아_760ms {
	static class Node {
		int vertex; // 연결된 도시
		Node link;
		
		public Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int cityCount = Integer.parseInt(st.nextToken()); // 도시의 수
		int roadCount = Integer.parseInt(st.nextToken()); // 도로의 수
		
		int requestedDistance = Integer.parseInt(st.nextToken()); // 출력하는 거리 조건
		int start = Integer.parseInt(st.nextToken()); // 시작점
		
		Node[] cities = new Node[cityCount + 1]; // 도시 연결 정보 저장 배열
		
		for(int i=0;i<roadCount;i++) { // 도로 정보 저장
			st = new StringTokenizer(br.readLine(), " ");
			
			int from = Integer.parseInt(st.nextToken()); // 도로 시작
			int to = Integer.parseInt(st.nextToken()); // 도로 도착
			
			cities[from] = new Node(to, cities[from]); // 단방향이므로 한쪽 방향만 저장
		}
		
		int[] distances = searchLoadByBFS(cities, new int[cityCount+1], new boolean[cityCount+1], start); // 각 도시별 최단 거리 구하는 함수
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1;i<distances.length;i++) { // 조건에 맞는 도로 출력
			if(distances[i] == requestedDistance) { // 요구하는 거리와 같을때만 출력
				sb.append(i).append("\n");
			}
		}
		
		if(sb.length() < 1) { // 해당하는 조건이 없을 경우
			sb.append(-1); // -1 출력
		}
		
		System.out.print(sb.toString());
	}
	
	// 도시별 최단 거리 구하는 함수 : cities(도로 정보), distances(거리 정보), visited(방문 정보), start(시작점)
	private static int[] searchLoadByBFS(Node[] cities, int[] distances, boolean[] visited, int start) {
		Queue<Integer> calcQueue = new LinkedList<Integer>();
		calcQueue.offer(start);
		
		distances[0] = -1;
		visited[0] = true;
		
		visited[start] = true;
		
		while(!calcQueue.isEmpty()) {
			int current = calcQueue.poll();
			
			for(Node temp=cities[current];temp!=null;temp=temp.link) {
				if(!visited[temp.vertex]) {
					calcQueue.offer(temp.vertex);
					visited[temp.vertex] = true;
					distances[temp.vertex] = distances[current] + 1;
				}
			}
		}
		
		return distances;
	}

}
