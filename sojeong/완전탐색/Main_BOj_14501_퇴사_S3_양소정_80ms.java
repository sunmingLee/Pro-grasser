import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOj_14501_퇴사_S3_양소정_80ms {
	private static int N;
	private static int[][] info; //시간 수익
	
	private static StringBuilder sb;
	private static boolean[] visit;
	private static int ans=0; //최대금액
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine()); //퇴사하기까지 남은 날
		info = new int [N][2]; 
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			info[i][0] = Integer.parseInt(st.nextToken()); //시간
			info[i][1] = Integer.parseInt(st.nextToken()); //수익
		}
		visit = new boolean[N];
		DFS(0,0);
		System.out.println(ans);
	
	
	
	}//end of main

	private static void DFS(int cnt,int sum) {
		if(cnt>=N) { //날짜 넘으면 최대값 구하고 리턴
			ans = Math.max(ans, sum);
			return;
		}
		if(cnt+info[cnt][0]<=N) {
			DFS(cnt+info[cnt][0] , sum + info[cnt][1]);
		}else {
			DFS(cnt + info[cnt][0], sum);
		}
		
		DFS(cnt+1,sum);
		
	}
}
