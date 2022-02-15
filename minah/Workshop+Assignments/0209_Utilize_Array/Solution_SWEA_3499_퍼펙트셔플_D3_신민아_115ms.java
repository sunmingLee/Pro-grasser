import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_SWEA_3499_퍼펙트셔플_D3_신민아_115ms {
	
	// idea : 모든 것을 저장 할 필요 없이 반만 저장하고 나머지 남은 token을 불러오는 형태도 좋음 --> ㅁㅔ모리 이득
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for(int testCase=0;testCase<TC;testCase++) {
			sb.append("#").append(testCase+1).append(" ");
			
			int cardCount = Integer.parseInt(br.readLine());
			String[] cards = br.readLine().split(" "); // 카드값을 저장하는 배열 생성
			
			int half = cardCount / 2; // 
			boolean isOddNum = cardCount % 2 != 0; // 카드의 개수가 홀수인지 짝수인지 판별
			int corrValue = isOddNum ? 1 : 0 ; // 홀수일 경우 다음에 섞일 카드의 인덱스 값이 바뀌므로 보정해주는 값 저장
			
			// 반만큼 돌리기
			for(int i=0;i<half;i++) {
				sb.append(cards[i]).append(" "); // 반토막을 나눠서 앞에있는 카드 그룹 중 차례대로 append
				sb.append(cards[i + half + corrValue]).append(" "); // 뒤의 카드 그룹 중 차례대로 append
			}
			
			if(isOddNum) { // 홀수일 경우 중간에 빼먹은 카드를 맨 뒤에 보낸다
				sb.append(cards[half]).append(" ");
			}
			
			sb.append("\n");
		}
		
		System.out.print(sb.toString());
	}

}
