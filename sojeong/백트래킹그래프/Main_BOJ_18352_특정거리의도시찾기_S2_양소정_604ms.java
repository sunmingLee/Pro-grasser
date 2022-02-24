package 백트래킹그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_18352_특정거리의도시찾기_S2_양소정_604ms {
	static class Node{
			
			int vertex;
			Node link;
			
			public Node(int vertex, Node link) {
				super();
				this.vertex = vertex;
				this.link = link;
			}			
		}
	
	private static int N,M,K,X;
	private static int[][] arr;
	private static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N =Integer.parseInt(str[0]);
		M =Integer.parseInt(str[1]);
		K =Integer.parseInt(str[2]);
		X =Integer.parseInt(str[3]);
		Node[] adjList = new Node[N+1];
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from]= new Node(to,adjList[from]);
		
		}
		
		bfs(adjList,X);
		
		
		
		
	}

	private static void bfs(Node[] adjList,int start) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		
		q.offer(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {	
			if(cnt == K) {
				int size =q.size();
				int []ans = new int[size];
				//다른풀이 pq에 넣어서 출력해도됨
				for (int i = 0; i < size; i++)
					ans[i] = q.poll();
				Arrays.sort(ans);
				StringBuilder sb = new StringBuilder();
				for (int i : ans)
					sb.append(i).append("\n");
				System.out.println(sb.toString());
				return;	
			}
		
			int size = q.size();
			for (int i = 0; i < size ; i++) {
				
				start= q.poll();
				
					
				for (Node temp =adjList[start]; temp != null; temp = temp.link) {
					
					if(!visited[temp.vertex]) {
						q.offer(temp.vertex);
						visited[temp.vertex] = true;
					}
				}
			}
			cnt++;
			
		}
	
	System.out.println("-1");
	System.exit(0);
	}
}
