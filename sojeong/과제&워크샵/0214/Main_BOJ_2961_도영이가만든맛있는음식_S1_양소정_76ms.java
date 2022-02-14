import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2961_도영이가만든맛있는음식_S1_양소정_76ms{
	private static boolean[] isSelected;
	private static int N;
	private static int[][] a; // 쓴맛 신맛 저장할 배열
	private static int ans;

	public static void main(String[] args) throws Exception {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringBuilder sb = new StringBuilder();
		 N = Integer.parseInt(br.readLine()); // 재료의 갯수  1 ≤ N ≤ 10
		 a = new int[N][2];
		
		 for (int i = 0; i < N; i++) {
			 StringTokenizer st = new StringTokenizer(br.readLine()," ");
				a[i][0] = Integer.parseInt(st.nextToken()); //쓴맛 저장
				a[i][1] = Integer.parseInt(st.nextToken()); //신맛 저장
		}
		ans =Integer.MAX_VALUE;
		isSelected = new boolean[N]; 
		Subset(0);
		System.out.println(ans);
		 
		 
	}

	private static void Subset(int cnt) {
		if(cnt == N) {
			int Asum = 1; //쓴맛 곱
			int Bsum = 0; //신맛 합
			int count =0;
			for (int i = 0; i < N; i++) {
				if(isSelected[i]) {
					Asum *= a[i][0];
					Bsum += a[i][1];
					count++;
				}
			}
			if(count == 0) return; //공집합 제외
			int total = Math.abs(Asum-Bsum);
			if(total<ans) {
				ans = total;
			}
			return;
		}
		
		isSelected[cnt] = true;
		Subset(cnt+1);
		isSelected[cnt] = false;
		Subset(cnt+1);
		
	}
}
