import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_양팔저울 {
	private static int[] w;
	private static boolean[] visit;
	private static int N;
	private static int ans=0;


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N =Integer.parseInt(br.readLine());
			w = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				w[i] =Integer.parseInt(st.nextToken());
				
			}
			
			visit = new boolean[N];
			check(0,w,visit,0,0);
			sb.append("#").append(tc).append(" ").append(ans);
			
		}//end of tc
		
	}//end of main

	private static void check(int cnt, int[] w, boolean[] visit, int l, int r) {
	
		if(cnt == N) {
			ans++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(visit[i]) continue; 
			visit[i] =true;
			if(l >= r + w[i]) {//l값이 다음값 더한것보다 크면
				check(cnt+1, w, visit, l, r + w[i]); //오른쪽에 
			}
			check(cnt+1, w, visit, l+w[i], r); //왼쪽에
			visit[i] = false;
			
		}
	}
}
