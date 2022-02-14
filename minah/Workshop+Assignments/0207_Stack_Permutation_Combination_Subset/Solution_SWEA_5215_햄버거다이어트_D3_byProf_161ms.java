import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_5215_햄버거다이어트_D3_byProf_161ms {
	// Remind : 전역 변수에도 초기화는 한번씩 꼭 해주자
	// 알고리즘적으로 성능이 좋기 위해서는 1차원배열 2개를 사용하는 것이 더 좋긴함
	static int[] scores, calories;
	static int availIngredients, maxCal, bestScore;
	static boolean[] isSelected;
	
	/** i:단계, sumT:맛의 현재 단계까지의 합, sumK:칼로리의 현재 단계까지의 합
	 * 현재까지 계산한 결과를 매번 가지고 다니자!
	 */
	
	public static void dfs(int i, int sumT, int sumK) {
		if(i == availIngredients) {
			// 선택한 재료들의 맛의 총합, 칼로리의 총합을 구해서 칼로리 제한 범위 이내에서 최대 맛을 찾기
			if(sumK <= maxCal && bestScore < sumT)
				bestScore = sumT;
			
			return;
		}
		// 재귀 호출에 관한 가지치기!
		else if(sumK <= maxCal) {
			dfs(i+1, sumT+scores[i], sumK+calories[i]); // 선택함
			dfs(i+1, sumT, sumK); // 선택 안함
		}	
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 테스트케이스 입력 
		int testCase = Integer.parseInt(br.readLine());
		
		// 자주 쓰는 변수를 더 가까이 두면 시간 절약에 좋다
		StringBuilder sb = new StringBuilder();
		for(int TC=0;TC<testCase;TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			// bestScore 초기화, 재료 개수, 최대 칼로리 값 받기
			bestScore = 0;
			availIngredients = Integer.parseInt(st.nextToken());
			maxCal = Integer.parseInt(st.nextToken());
			
			// 각 데이터를 담는 배열 초기화
			scores = new int[availIngredients];
			calories = new int[availIngredients];
			isSelected = new boolean[availIngredients];
			
			for(int i=0;i<availIngredients;i++) {
				st = new StringTokenizer(br.readLine(), " ");
				scores[i] = Integer.parseInt(st.nextToken());
				calories[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0, 0, 0);
			sb.append("#").append(TC + 1).append(" ").append(bestScore).append("\n");
			
		}
		
		System.out.print(sb.toString());

	}
}
