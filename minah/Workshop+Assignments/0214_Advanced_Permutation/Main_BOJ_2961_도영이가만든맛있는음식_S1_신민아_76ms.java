import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2961_도영이가만든맛있는음식_S1_신민아_76ms {
	static int ingredientCount;
	static int minDiff;
	static int[] sourValue, bitterValue;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		minDiff = Integer.MAX_VALUE;
		ingredientCount = Integer.parseInt(br.readLine());
		
		sourValue = new int[ingredientCount];
		bitterValue = new int[ingredientCount];
		
		StringTokenizer st;
		for(int i=0;i<ingredientCount;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			sourValue[i] = Integer.parseInt(st.nextToken());
			bitterValue[i] = Integer.parseInt(st.nextToken());
		}
		
		getAllSubsets(0, 0, 1, 0);
		
		System.out.print(minDiff);

	}
	
	// 부분집합 구할 시에도 파라미터로 넘기면 속도가 빠름!! -> memoization인가?
	private static void getAllSubsets(int count, int subsetCount, int sour, int bitter) {
		if(count == ingredientCount) {
			if(subsetCount > 0) {
				int diff = Math.abs(sour - bitter);
				if(minDiff > diff) {
					minDiff = diff;
				}
			}
			return;
		}
		
		getAllSubsets(count+1, subsetCount+1, sour*sourValue[count], bitter+bitterValue[count]); // n번째 원소를 사용할 때
		getAllSubsets(count+1, subsetCount, sour, bitter); // n번째 원소를 사용하지 않을 때
			
	}

}
