import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_SWEA_9229_한빈이와SpotMart_D3_신민아_162ms {
	static int maxWeight; // 최대로 들 수 있는 무게 저장 
	static List<Integer> snacks; // 과자들의 무게 데이터 저장
	static int bestScore; // 들 수 있는 가장 큰 무게 저장

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		
		// 테스트케이스 동안 반복
		for(int testCount=0;testCount<TC;testCount++) {
			sb.append("#").append(testCount+1).append(" "); // #n 출력
			st = new StringTokenizer(br.readLine()); // 다음 데이터 읽기(과자의 개수, 최대로 들 수 있는 무게)
			
			snacks = new ArrayList<Integer>(); // snack arraylist 초기화
			int snackCount = Integer.parseInt(st.nextToken()); // 전체 snack의 개수
			maxWeight = Integer.parseInt(st.nextToken()); // 최대로 들 수 있는 무게
			bestScore = -1; // bestScore의 기본 값 : -1(경우가 없는 경우를 default로 둠)
			
			st = new StringTokenizer(br.readLine()); // 과자들의 무게 데이터 가져옴
			for(int i=0;i<snackCount;i++) {
				int snackWeight = Integer.parseInt(st.nextToken());
				if(snackWeight < maxWeight)  // 가지치기를 위해 들 수 있는 무게보다 무거운 경우는 저장하지 않음
					snacks.add(snackWeight);
			}
			
			combSnack(0, 0, 0); // 2개씩 조합하여 bestScore을 저장하는 함수
			sb.append(bestScore).append("\n");
			
		}
		
		System.out.print(sb.toString());
	}
	
	private static void combSnack(int cnt, int start, int weight) {
		if(cnt == 2) {
			if(weight > maxWeight) return;
			
			bestScore = Math.max(bestScore, weight);
			return;
		}
		
		for(int i=start;i<snacks.size();i++) {
			combSnack(cnt+1, i+1, weight+snacks.get(i));
		}
	}

}
