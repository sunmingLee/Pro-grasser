import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BOJ_11725_트리의부모찾기_S2_양소정_644ms {
	private static int N; //노드의 개수
	private static int[] parents; // 부모 노드 저장
	private static boolean []visit; //방문 체크
	private static List<Integer>[] list;  //각 노드별 연결된 노드 표시

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		list= new ArrayList[N+1];
		visit = new boolean[N+1];
		parents = new int[N+1];
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		for (int i = 1; i <= N; i++) {
			list[i] =  new ArrayList<Integer>();
		}
		
		//노드 별 연결
		for (int i = 1; i <N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);  
			list[b].add(a);
			
		}
		
		DFS(1);
		
		for (int i = 2; i <= N; i++) {
			sb.append(parents[i]).append("\n");
		}
		System.out.println(sb);
		
		
	}//end of main

	public static void DFS(int v) {
		visit[v] = true;
		
		for (int i : list[v]) {
			if(!visit[i]) {			
			parents[i] = v;	
			DFS(i);
			}
		}
		
	}
	
}//end of class
