import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_6808_규영이와인영이의카드게임_D3_양소정_2733ms {
	private static int[] result;
	private static boolean[] check;
	private static int[] A;
	private static int[] B;
	private static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <=T; tc++) {
			A = new int[9]; //규영
			B = new int[9]; //인영
			boolean[] card = new boolean[19]; // 규영이가 낸 카드 true 인영 false
			//규영이 카드 true 저장
			StringTokenizer st =new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				A[i] = Integer.parseInt(st.nextToken());
				card[A[i]] = true;
			}
			//인영이 카드 9개 저장
			int idx = 0;
			for (int i = 1; i <= 18; i++) {
				if(!card[i]) {
					B[idx++] = i;
				}
			}
			result = new int[9];
			check = new boolean[9];
			count = 0; //규영이가 이긴 횟수
 			perm(0);
			
			sb.append("#").append(tc).append(" ").append(count).append(" ").append(362880 - count).append("\n");
																			//362880 은 9! 값
		} 
		System.out.print(sb);
		
	} //end of main

	private static void perm(int index) {
		if(index==9) {
			int AScore = 0; //규영이 점수
			int BScore = 0;//인영이 점수
			for (int i = 0; i < 9; i++) {
				if(A[i]>result[i]){
					AScore += A[i] + result[i];
				}else {
					BScore += A[i] + result[i];
				}			
			}
			//규영이 점수 크면 이긴횟수 ++
			if(AScore > BScore) count ++;
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if(!check[i]) {
				result[index] = B[i];  //이부분 약간 헷갈림
				check[i] = true;
				perm(index+1);
				check[i] = false;
				
			}
		}
	
	}
}//end of class
