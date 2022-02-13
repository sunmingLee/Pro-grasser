package Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BOJ_11725_트리의부모찾기_S2_양소정 {
	private static int N;
	private static int[] parents; // 
	private static boolean []visit;
	private static List<Integer>[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		list= new ArrayList[N+1];
		visit = new boolean[N+1];
		parents = new int[N+1];
		StringTokenizer st;
	
    // 정점별 연결된 노드 추가 위해 
		for (int i = 1; i <= N; i++) {
			list[i] =  new ArrayList<Integer>();
		}
		
		for (int i = 1; i <N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b); //정점 연결
			list[b].add(a);
			
		}
		dfs(1); //루트부터 시작
		
    //출력
		for (int i = 2; i <= N; i++) {
			System.out.println(parents[i]);
		}	
	}//end of main
  
	public static void dfs(int v) {
		visit[v] = true;  
		
		for (int i : list[v]) {
			if(!visit[i]) {			
			parents[i] = v;	
			dfs(i);
			}
		}
	}
}//end of class
