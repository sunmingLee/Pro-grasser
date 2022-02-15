import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_5215_햄버거다이어트_D3_신민아_776ms {
	// Remind : 전역 변수에도 초기화는 한번씩 꼭 해주자
	// 알고리즘적으로 성능이 좋기 위해서는 1차원배열 2개를 사용하는 것이 더 좋긴함
	static int[] scores, calories;
	static int availIngredients, maxCal, bestScore;
	static boolean[] isSelected;

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
			
			getScores(0);
			sb.append("#").append(TC + 1).append(" ").append(bestScore).append("\n");
			
		}
		
		System.out.print(sb.toString());

	}
	
	// 부분집합을 통해 모든 햄버거 조합의 가격을 계산
	private static void getScores(int cnt) {
		if(cnt == availIngredients) {
			int score = 0;
			int cal = 0;
			for(int i=0;i<availIngredients;i++) {
				if(isSelected[i]) {
					score += scores[i];
					cal += calories[i];
				}
			}
			
			if((cal <= maxCal) && (bestScore < score)) {
				bestScore = score;
			}
			return;
		}
		
		isSelected[cnt] = true;
		getScores(cnt+1);
		
		isSelected[cnt] = false;
		getScores(cnt+1);
	}

}
