import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_3234_준환이의양팔저울_D4_신민아_1678ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int testCase = 1;testCase<=TC;testCase++) {
			int weightCount = Integer.parseInt(br.readLine());
			int[] weight = new int[weightCount];
			
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int i=0;i<weightCount;i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}
			
			sb.append("#").append(testCase).append(" ").append(getPermutations(0, weight, 0, 0, 0)).append("\n");
		}
		
		System.out.print(sb.toString());
	}
	
	private static int getPermutations(int count, int[] originalWeight, int flag, int leftSum, int rightSum) { // cnt : 순열에서 n번째 원소, 
		if(leftSum < rightSum) { // 오른쪽의 합이 크면 0을 리턴하고 바로 종료
			return 0;
		}
		
		if(count == originalWeight.length) { // 무사히 끝까지 왔을때 +1
			return 1;
		}
		
		int answer = 0;
		for(int i=0;i<originalWeight.length;i++) {
			// 기존 자리의 수들과 중복되는지 체크
			if((flag & 1<<i) != 0) continue; 
			
			// 다음 수 뽑으러 가기
			answer += getPermutations(count+1, originalWeight, flag | 1<<i, leftSum + originalWeight[i], rightSum) 
						+ getPermutations(count+1, originalWeight, flag | 1<<i, leftSum, rightSum + originalWeight[i]);
			
		}
		return answer;
	}
}
