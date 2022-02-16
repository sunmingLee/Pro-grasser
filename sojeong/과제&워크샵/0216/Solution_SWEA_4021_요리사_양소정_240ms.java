import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_4021_요리사_양소정_240ms {
	
	private static int N; //식재료수
	private static boolean[] visited;
	private static int[][] s; //시너지
	private static int ans;//최소

		public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st;
		    StringBuilder sb = new StringBuilder();
		    int T = Integer.parseInt(br.readLine());
		        
	        for(int tc=1;tc<=T;tc++) {
	        	N= Integer.parseInt(br.readLine());
	        	s = new int[N][N];
	        	
	        	for(int i=0;i<N;i++) {
	        		st = new StringTokenizer(br.readLine()," ");
	        		for(int j=0;j<N;j++) {
	        			s[i][j] = Integer.parseInt(st.nextToken());
	        		}
	        	visited = new boolean[N];
	            ans=Integer.MAX_VALUE;      
	            }
	        	
	            comb(0,0);
	            sb.append("#").append(tc).append(" ").append(ans).append("\n");
	        }
	        System.out.println(sb.toString());
		}//end of main
		    
	    public static void comb(int cnt, int start) {
	        if(cnt==N/2) {  //절반 고르면 
	            check();    //맛 차이 체크
	            return;
	        }
	        
	        for(int i=start; i<N;i++) {
	            visited[i] = true;
	            comb(cnt+1,i+1);
	            visited[i] = false;
	        }
	    }
		    
	    
	    public static void check() {
	        int A=0; //A음식 맛 
	        int B=0; //B음식 맛
	        int result=0; // 맛 차이
	        //visited배열에 true가 A음식 식재료
	        for(int i=0;i<N-1;i++) { //하나씩 뒤로 가면서 뒤에꺼랑 비교 마지막은 j가 있어야 되니까 그 전까지
	            for(int j=i+1;j<N;j++) { //비교되는 거 다음부터 비교
	                if(visited[i] && visited[j]) {
	                    A+=s[i][j]+s[j][i];
	                }
	                else if(!visited[i] && !visited[j]) {
	                    B+=s[i][j]+s[j][i];
	                }
	            }
	        }
	        result = Math.abs(A-B); 
	        ans = Math.min(result, ans); //맛차이 최소
	    }
}//end of class
