import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_6080_규영이와인영이의카드게임_D3_신민아_2571ms {
	static boolean[] isSelected;
	static int[] gyuyeong, inyeong, inyeongPermutation;
	static int win;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		int allCount = 1;
		
		for(int i=2;i<10;i++) { // 9! 전체 경우의 수
			allCount *= i;
		}
		
		StringTokenizer st;
		boolean cardSelected[];
		for(int testCase=0;testCase<TC;testCase++) {
			win = 0;
			st = new StringTokenizer(br.readLine(), " ");
			
			gyuyeong = new int[9]; // 규영이의 카드 덱 초기화
			inyeong = new int[9]; // 인영이의 카드 덱 초기화
			inyeongPermutation = new int[9]; // 인영이가 낼 수 있는 경우의 수
			isSelected = new boolean[9]; // 카드가 이미 선택되었는지 체크
			cardSelected = new boolean[19]; // 규영이가 가진 카드로부터 인영이의 덱을 알기 위한 배열
			
			for(int i=0;i<9;i++) { // 규영이의 카드 덱 넣기
				int tempCard = Integer.parseInt(st.nextToken());
				gyuyeong[i] = tempCard;
				cardSelected[tempCard] = true;
			}
			
			int cnt = 0;
			for(int i=1;i<19;i++) { // 인영이의 카드 덱 넣기
				if(!cardSelected[i]) {
					inyeong[cnt++] = i;
				}
			}
			
			getCardPermutation(0); // 모든 경우 완전탐색
			
			// 1~18까지 더했을 때 171이므로 비기는 경우는 없음
			sb.append("#").append(testCase+1).append(" ").append(win).append(" ").append(allCount-win).append("\n");
		}
		
		System.out.print(sb.toString());
	}
	
	private static void getCardPermutation(int cnt) { // 인영이가 낼 수 있는 카드 순서의 경우의 수
		if(cnt == 9) { // 9개를 다 냈으면
			int gyuScore = 0; // 규영이의 점수
			for(int i=0;i<9;i++) { // 규영이와 인영이의 카드를 차례로 비교
				if(gyuyeong[i] > inyeongPermutation[i]) { // 규영이가 인영이의 점수보다 높으면
					gyuScore += gyuyeong[i] + inyeongPermutation[i]; // 규영이의 점수에 둘다 더함
				}
			}
			if(gyuScore > 85) { // 규영이가 171의 절반인 85보다 점수가 높으면
				win++; // 이긴것
			}
			return; // 끝
		}
		
		for(int i=0;i<9;i++) {
			if(isSelected[i]) continue; // 이미 선택되었다면 넘기기
			
			inyeongPermutation[cnt] = inyeong[i]; // 인영이의 다음 선택은 인영이의 카드 덱에서부터 선택
			isSelected[i] = true; // 선택완료
			
			getCardPermutation(cnt+1); // 다음 선택 정하기 : 재귀
			isSelected[i] = false; // 선택 해제
		}
	}

}
