import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_4012_요리사_이재순_146ms {
	static int[] food1, food2;
	private static int N;
	private static int[][] S;
	static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int testcase = 0; testcase < T; testcase++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st;
			S = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					if (i>j) {
						S[j][i] += Integer.parseInt(st.nextToken());
					}
					else S[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int n = N/2;
			food1 = new int[n];
			food2 = new int[n];
			food1[0] = 0;
			ans = Integer.MAX_VALUE;
			combination(1,n-1,0);
			sb.append("#").append(testcase+1).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}//end of main
	
	private static int calTotalS() {
		int food1S =0;
		int food2S =0;
		for (int i = 0; i < food1.length; i++) {
			for (int j = i; j < food1.length; j++) {
				food1S += S[food1[i]][food1[j]];
				food2S += S[food2[i]][food2[j]];
			}
		}
		return Math.abs(food1S-food2S);
	}
	
	private static void combination(int start, int n, int flag) {
	    if(n == 0) {
	    	int a=1;
	    	int b=0;
	    	for (int i = 1; i < N; i++) {
				if ((flag & 1<<i) != 0) {
					food1[a++]=i;
				}else {
					food2[b++]=i;
				}
			}
	    	ans = Math.min(calTotalS(), ans);
	        return;
	    }//기저조건

	    for(int i=start; i<N; i++) {
	        combination(i + 1, n - 1, flag | 1<<i); 
	    }
	}
}//end of class
