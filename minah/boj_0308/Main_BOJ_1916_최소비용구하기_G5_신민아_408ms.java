package boj_0308;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_1916_최소비용구하기_G5_신민아_408ms {
	static class Node implements Comparable<Node>{
		int end, weight;

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
		
		int cities = Integer.parseInt(br.readLine());
		int buses = Integer.parseInt(br.readLine());
		
		
		List<Node>[] nodes = new ArrayList[cities + 1];
		
		for(int i=1;i<nodes.length;i++) {
			nodes[i] = new ArrayList<Node>();
		}
	
		StringTokenizer st;
		for(int i=0;i<buses;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int fee = Integer.parseInt(st.nextToken());
			
			nodes[from].add(new Node(to, fee));
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		System.out.print(getLowestFee(start, end, nodes));
	}
	
	static private int getLowestFee(int start, int end, List<Node>[] nodes) {
		boolean[] visited = new boolean[nodes.length];
		int[] distances = new int[nodes.length];
		Arrays.fill(distances, Integer.MAX_VALUE);
		
		PriorityQueue<Node> pQueue = new PriorityQueue<Node>();
		distances[start] = 0;
		pQueue.offer(new Node(start, 0));
		
		while(!pQueue.isEmpty()) {
			Node current = pQueue.poll();
			
			if(current.end == end) return distances[end];
			if(visited[current.end]) continue;
			
			visited[current.end] = true;
			
			for(Node node : nodes[current.end]) {
				int tempDistance = distances[current.end] + node.weight;
				if(distances[node.end] > tempDistance) {
					distances[node.end] = tempDistance;
					pQueue.offer(new Node(node.end, distances[node.end]));
				}
			}
		}
		
		return distances[end];
	}

}
