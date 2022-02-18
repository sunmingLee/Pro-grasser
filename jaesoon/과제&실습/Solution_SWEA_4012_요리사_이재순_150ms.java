import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_4012_요리사_이재순_150ms {
	static int[] food1, food2;
	static int N;
	static int[][] S;
	static int ans;
	static int n;
	
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
			n = N/2;
			food1 = new int[n];
			food2 = new int[n];
			food1[0] = 0;
			ans = Integer.MAX_VALUE;
			combination(1,n-1,0,0);
			sb.append("#").append(testcase+1).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}//end of main
	
	private static int calFood2S() {
		int food2S =0;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				food2S += S[food2[i]][food2[j]];
			}
		}
		return food2S;
	}
	private static int calFood1S(int size) {
		int food1S =0;
		for (int i = 0; i < size; i++) {
			food1S += S[food1[i]][food1[size]];
		}
		return food1S;
	}
	
	private static void combination(int start, int n2, int flag, int food1S) {
	    if(n2 == 0) {
	    	int a=0;
	    	for (int i = 1; i < N; i++) {
				if ((flag & 1<<i) == 0) {
					food2[a++]=i;
				}
			}
	    	ans = Math.min(Math.abs(calFood2S()-food1S), ans);
	        return;
	    }//기저조건

	    for(int i=start; i<N; i++) {
	    	food1[n-n2] = i;
	        combination(i + 1, n2 - 1, flag | 1<<i, food1S+calFood1S(n-n2));
	    }
	}
}//end of class
