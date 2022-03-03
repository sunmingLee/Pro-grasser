package march;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
예시 입력 외에 추가 TC
6 5
1 6
2 4 5
2 1 2
2 2 3
2 3 4
2 5 6

 */
public class Main_BOJ_1043_거짓말_양소정_76ms{
	  static int N, M;
	    static boolean[] know;
	    static boolean[][] adj;

	    public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        N = Integer.parseInt(st.nextToken());
	        M = Integer.parseInt(st.nextToken());ㅁ
	        
	        st = new StringTokenizer(br.readLine());
	        know = new boolean[N + 1]; //진실을 아는 사람 체크
	        int len = Integer.parseInt(st.nextToken()); //진실을 아는 사람 수
	        for (int i = 0; i < len; i++)
	            know[Integer.parseInt(st.nextToken())] = true; 

	        int[][] party = new int[M][];
	        adj = new boolean[N + 1][N + 1]; //인접
	       

	        for (int i = 0; i < M; i++) {
	        	st = new StringTokenizer(br.readLine());
	            int input = Integer.parseInt(st.nextToken()); //파티에 참여한 사람 수
	            party[i] = new int[input];

	            party[i][0] = Integer.parseInt(st.nextToken());

	            for (int j = 1; j < input; j++) {
	                party[i][j] = Integer.parseInt(st.nextToken());
	                adj[party[i][j - 1]][party[i][j]] = adj[party[i][j]][party[i][j - 1]] = true; 
	            }
	        }

	        for (int i = 1; i <= N; i++)
	            if (know[i])  dfs(i);

	        int cnt = 0;
	        for (int i = 0; i < M; i++) { 		//DFS로 같은 파티에 참가한 사람들을 모두 진실을 알거나, 모르는 경우이기 때문에  1사람만 조사하면 됨
	            if (!know[party[i][0]])  cnt++;
	        }

	        System.out.println(cnt);


	    }

	    static void dfs(int n) {
	        for (int i = 1; i <= N; i++) {
	            if (adj[n][i] && !know[i]) {
	                know[i] = true;
	                dfs(i);
	            }
	        }
	    }
}

