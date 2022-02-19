import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_3234_준환이의양팔저울_D4_양소정_1602ms{

	private static int ans;


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int[] w = null;
		boolean[]visit = null;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N =Integer.parseInt(br.readLine());
			w = new int[N];
			visit = new boolean[N];
		
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				w[i] =Integer.parseInt(st.nextToken());
				
			}
			ans = 0;
			check(0,w,visit,0,0);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
			
			
		}//end of tc
		System.out.println(sb);
		
	}//end of main

	private static void check(int cnt, int[] w, boolean[] visit, int l, int r) {
		
		if(cnt == w.length) {
			ans++;
			return;
		}
		
		for (int i = 0; i < w.length; i++) {
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
