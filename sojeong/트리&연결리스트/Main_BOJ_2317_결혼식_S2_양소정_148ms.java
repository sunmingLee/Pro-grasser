import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
  상근이는 자신의 결혼식에 학교 동기 중 자신의 친구와 친구의 친구를 초대하기로 했다. 
  상근이의 동기는 모두 N명이고, 이 학생들의 학번은 모두 1부터 N까지이다. 상근이의 학번은 1이다.

 상근이는 동기들의 친구 관계를 모두 조사한 리스트를 가지고 있다. 
 이 리스트를 바탕으로 결혼식에 초대할 사람의 수를 구하는 프로그램을 작성하시오.
 */

public class Main_BOJ_2317_결혼식_S2_양소정_148ms {
	private static boolean[] visit; 
	private static List<Integer>[] list;
	private static int cnt =0; 
	private static int N;
	private static int M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); //상근이의 동기 수 (2 ≤ n ≤ 500)
		M = Integer.parseInt(br.readLine()); //리스트의 길이 (1 ≤ m ≤ 10000)
		visit = new boolean[N+1]; //방문체크 
		StringTokenizer st;
		
		list = new ArrayList[N+1];
		
		for (int i = 1; i <= N; i++) {
			list[i] =  new ArrayList<Integer>();
		}
		
		//노드별 연결
		for (int i = 0; i <M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);  
			list[b].add(a);		
		}
		
		DFS(1,0);
	
		for (int i = 2; i <= N; i++) { //방문한 노드 수 카운트
			if(visit[i]) cnt++;
		}
		
		System.out.println(cnt);
	
	
	} //end of main

	public static void DFS(int v, int d) {
		if(d==2) {		//깊이가 2이면 친구의 친구 넘기니까 종료
			return;
		}
		for (int i : list[v]) {		
				visit[i]=true;
				DFS(i,d+1);			
		}
		
	} 
}// end of class
