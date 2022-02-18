import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_SWEA_4012_요리사_이재순_211ms2 {
	static ArrayList<Integer> food1, food2;
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
			food1 = new ArrayList<Integer>(n);
			food1.add(0);
			ans = Integer.MAX_VALUE;
			combination(1,n-1,0,0);
			sb.append("#").append(testcase+1).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}//end of main
	
	private static int calS() {
		int foodsS =0;
		int size = food1.size()-1;
		for (int i = 0; i < food1.size(); i++) {
				foodsS += S[food1.get(i)][food1.get(size)];
		}
		return foodsS;
	}
	
	private static void combination(int start, int n, int flag, int food1S) {
	    if(n == 0) {
	    	food2 = new ArrayList<Integer>(n);
	    	int food2S=0;
	    	for (int i = 1; i < N; i++) {
				if ((flag & 1<<i) == 0) {
					food2.add(i);
				}
			}
	    	int size=food2.size();
	    	for (int i = 0; i < size; i++) {
				for (int j = i; j < size; j++) {
					food2S += S[food2.get(i)][food2.get(j)];
				}
			}
	    	ans = Math.min(Math.abs(food1S-food2S), ans);
	        return;
	    }//기저조건

	    for(int i=start; i<N; i++) {
	    	food1.add(i);
	        combination(i + 1, n - 1, flag | 1<<i, food1S+calS());
	        food1.remove(food1.size()-1);
	    }
	}
}//end of class
