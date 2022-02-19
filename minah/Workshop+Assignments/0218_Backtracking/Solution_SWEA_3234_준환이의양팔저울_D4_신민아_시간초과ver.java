import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_3234_준환이의양팔저울_D4_신민아_시간초과ver {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int testCase = 1;testCase<=TC;testCase++) {
			int weightCount = Integer.parseInt(br.readLine());
			int[] weight = new int[weightCount];
			
			st = new StringTokenizer(br.readLine(), " ");
			
			int sum = 0;
			for(int i=0;i<weightCount;i++) {
				weight[i] = Integer.parseInt(st.nextToken());
				sum += weight[i];
			}
			
			sb.append("#").append(testCase).append(" ").append(getPermutations(0, weight, new int[weightCount], 0, sum)).append("\n");
		}
		
		System.out.print(sb.toString());
	}
	
	private static int getPermutations(int count, int[] originalWeight, int[] selectedOrder, int flag, int sum) { // cnt : 순열에서 n번째 원소, 
		if(count == originalWeight.length) {
			return getSubsetFromPermutation(selectedOrder, sum);
		}
		
		int answer = 0;
		for(int i=0;i<originalWeight.length;i++) {
			// 기존 자리의 수들과 중복되는지 체크
			if((flag & 1<<i) != 0) continue;
			
			selectedOrder[count] = originalWeight[i];
			
			// 다음 수 뽑으러 가기
			answer += getPermutations(count+1, originalWeight, selectedOrder, flag | 1<<i, sum);
		}
		return answer;
	}
	
	// 각 순열 별로 부분집합을 구하는 메소드
	private static int getSubsetFromPermutation(int[] selectedOrder, int sum) {
		int count = selectedOrder.length; // 원소의 수
		int answer = 0;
		
		for(int flag=1,caseCount=1<<count;flag<caseCount - 1;flag++) {
			int left = 0; // 왼쪽 요소의 합
			boolean able = true;
			
			// flag : 원소들의 선택상태의 비트열
			for(int i=0;i<count;i++) { // 각 비트열의 상태를 확인
				if((flag & 1<<i) != 0) { // 선택 되었다면
					left += selectedOrder[i]; // 왼쪽에 올림
				} else { // 선택되지 않으면
					left -= selectedOrder[i];
					if(left < 0) {
						able = false;
						break;
					}
				}	
			}
			
			if(able) answer++;
		}
		return answer + 1;
	}
	

}
