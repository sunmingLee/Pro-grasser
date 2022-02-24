package 백트래킹그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


//인접리스트로 풀면 메모리초과. 테케는 맞지만,, 틀림
public class Main_BOJ_18352_특정거리의도시찾기_S2_양소정 {
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
	private static StringBuilder sb = new StringBuilder();

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
		
		//sb 역순출력
		sb.setLength(sb.length()-1);
		sb.reverse();
		System.out.println(sb);
	}

	private static void bfs(Node[] adjList,int start) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		
		q.offer(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {	
			if(cnt == K) {
				while(!q.isEmpty()) {
					sb.append(q.poll()).append("\n");		
				}	
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
