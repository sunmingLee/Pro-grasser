import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
  독일 로또는 {1, 2, ..., 49}에서 수 6개를 고른다.
로또 번호를 선택하는데 사용되는 가장 유명한 전략은 49가지 수 중 k(k>6)개의 수를 골라 집합 S를 만든 다음 그 수만 가지고 번호를 선택하는 것이다.
예를 들어, k=8, S={1,2,3,5,8,13,21,34}인 경우 이 집합 S에서 수를 고를 수 있는 경우의 수는 총 28가지이다. ([1,2,3,5,8,13], [1,2,3,5,8,21], [1,2,3,5,8,34], [1,2,3,5,13,21], ..., [3,5,8,13,21,34])
집합 S와 k가 주어졌을 때, 수를 고르는 모든 방법을 구하는 프로그램을 작성하시오.
 *
 */

public class Main_BOj_6603_로또_S2_양소정_84ms {
	
	private static int[] S; 
	private static int K;  
	private static boolean[] check; 
	private static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		while(true) {
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken()); //받을 수 개수
			if(K==0) break; 	 // 0이면 tc 종료
			S = new int[K]; 		 //K개로 구성된 집합 
			check = new boolean[K];	 //방문체크
			
			//s집합에 원소 넣기
			for (int i = 0; i < K; i++) {
				S[i] =Integer.parseInt(st.nextToken());
				
			}
			
			DFS(0,0);
			sb.append("\n");
		}//end of tc
		System.out.println(sb);
	}//end of main
	
	

	private static void DFS(int cnt, int start) {
		
		if(cnt == 6) {  
			for (int i = 0 ; i< K; i++) {
				if(check[i])
				sb.append(S[i]).append(" ");
			}
			sb.append("\n");
			
		}
		
		for (int i = start; i < K; i++) {
			check[i] = true;
			DFS(cnt+1,i+1);
			check[i] = false;
		}	
	
	}
}//end of class
