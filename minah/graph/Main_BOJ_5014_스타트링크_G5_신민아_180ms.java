package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_5014_스타트링크_G5_신민아_180ms {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int totalFloor = Integer.parseInt(st.nextToken()); // 전체 층 개수
		int start = Integer.parseInt(st.nextToken()); // 시작 지점
		int goal = Integer.parseInt(st.nextToken()); // 도착 지점
		
		int upFloorCount = Integer.parseInt(st.nextToken()); // 올라가는 층 수
		int downFloorCount = Integer.parseInt(st.nextToken()); // 내려가는 층 수
		
		String answer = getFloorDistances(new int[totalFloor + 1], new boolean[totalFloor + 1], start, goal, upFloorCount, downFloorCount);
		
		System.out.print(answer);
		
	}
	
	private static String getFloorDistances(int[] floorStatus, boolean[] visited, int start, int goal, int up, int down) {
		floorStatus[0] = -1;
		visited[0] = true;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			int nextUp = current + up;
			if(nextUp < floorStatus.length && !visited[nextUp]) {
				queue.offer(nextUp);
				visited[nextUp] = true;
				floorStatus[nextUp] = floorStatus[current] + 1;
			}
			
			int nextDown = current - down;
			if(nextDown > 0 && !visited[nextDown]) {
				queue.offer(nextDown);
				visited[nextDown] = true;
				floorStatus[nextDown] = floorStatus[current] + 1;
			}
			
			if(visited[goal]) {
				return new StringBuilder().append(floorStatus[goal]).toString();
			}
		}
		
		
		return "use the stairs";
	}

}
