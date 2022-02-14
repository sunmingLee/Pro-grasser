package tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_5567_결혼식_S2_신민아_152ms {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int friendCount = Integer.parseInt(br.readLine());
		
		List<Integer> friends[] = new ArrayList[friendCount+1];  // 각 노드 별 연결 정보를 쌍방향으로 저장하는 list
		
		for(int i=0;i<friendCount+1;i++) { // list 초기화
			friends[i] = new ArrayList<Integer>();
		}
		
		int TC = Integer.parseInt(br.readLine()); // 전체 친구 정보 수
		StringTokenizer st;
		
		for(int testCase=0;testCase<TC;testCase++) { // 주어진 정보마다 저장
			st = new StringTokenizer(br.readLine(), " ");
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());

			friends[first].add(second); // 쌍방향으로 연결 정보 저장
			friends[second].add(first);
		}
		
		boolean[] visited = new boolean[friendCount + 1]; // 해당 노드를 방문했는지 체크하는 배열 
		Queue<Integer> friendQueue = new LinkedList<Integer>(); // BFS용 queue
		int[] distance = new int[friendCount + 1]; // 각 노드 별 root(1)부터의 거리
		
		friendQueue.offer(1); // 1부터는 반드시 탐색하므로 queue에 삽입
		visited[1] = true; // 마찬가지로 1은 반드시 방문하므로 true
		distance[1] = 0; // 자기 자신과의 거리는 0
		
		int invited = 0; // 초대할 친구
		
		while(!friendQueue.isEmpty()) { // queue가 빌 때까지 반복
			int current = friendQueue.poll(); // 현재 위치를 반환

			if(distance[current] > 1) break; // 현재 위치의 distance가 root로부터 2 이상 떨어져있으면 중지
			
			for(int i=0;i<friends[current].size();i++) { 
				int nextFriend = friends[current].get(i); // 다음 친구
				if(!visited[nextFriend]) { // 방문하지 않았을 시
					visited[nextFriend] = true; // 방문 체크
					distance[nextFriend] = distance[current] + 1; // 거리를 부모노드보다 1 증가
					friendQueue.offer(nextFriend); // queue에 삽입 -> 다음에 방문
					invited++; // 친구 초대 완료
				}
			}
		}
	
		System.out.print(invited);
	}
}
