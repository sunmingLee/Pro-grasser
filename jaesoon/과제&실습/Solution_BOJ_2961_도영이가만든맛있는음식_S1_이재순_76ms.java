import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_BOJ_2961_도영이가만든맛있는음식_S1_이재순_76ms {
	static int N;
	static int[][] foods;
	static int ans=Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		foods = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			foods[i][0] = Integer.parseInt(st.nextToken());
			foods[i][1] = Integer.parseInt(st.nextToken());
		}
		powerset(0, 0);
		System.out.println(ans);
	}//end of main
	/**
	 * 멱집합을 만들며 신맛과 쓴맛의 차이의 최소값을 저장하는 메소드 
	 */
	private static void powerset(int cnt, int flag) {
		if (cnt==N) {
			int sour = 1;
			int bitter = 0;
			for (int i = 0; i < foods.length; i++) {
				if ((flag&1<<i)!=0) {
					sour *=foods[i][0];
					bitter +=foods[i][1];
				}
			}
			if (bitter != 0) {
				ans = Math.min(ans, Math.abs(bitter-sour));
			}
			return;
		}
		powerset(cnt+1, flag | 1 << cnt);
		powerset(cnt+1, flag);
	}
}//end of class
