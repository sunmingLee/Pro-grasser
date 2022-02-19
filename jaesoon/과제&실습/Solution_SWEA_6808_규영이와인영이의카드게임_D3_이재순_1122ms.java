import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * <pre>
 * 규영이와 인영이는 1에서 18까지의 수가 적힌 18장의 카드로 게임을 하고 있다.
한 번의 게임에 둘은 카드를 잘 섞어 9장씩 카드를 나눈다. 그리고 아홉 라운드에 걸쳐 게임을 진행한다.
한 라운드에는 한 장씩 카드를 낸 다음 두 사람이 낸 카드에 적힌 수를 비교해서 점수를 계산한다.
높은 수가 적힌 카드를 낸 사람은 두 카드에 적힌 수의 합만큼 점수를 얻고,
낮은 수가 적힌 카드를 낸 사람은 아무런 점수도 얻을 수 없다.
이렇게 아홉 라운드를 끝내고 총점을 따졌을 때, 총점이 더 높은 사람이 이 게임의 승자가 된다.
두 사람의 총점이 같으면 무승부이다.
이번 게임에 규영이가 받은 9장의 카드에 적힌 수가 주어진다.
규영이가 내는 카드의 순서를 고정하면, 인영이가 어떻게 카드를 내는지에 따른 9!가지 순서에 따라
규영이의 승패가 정해질 것이다.
이 때, 규영이가 이기는 경우와 지는 경우가 총 몇 가지 인지 구하는 프로그램을 작성하라.

[입력]
첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
각 테스트 케이스의 첫 번째 줄에는 아홉 개의 정수가 공백으로 구분되어 주어진다.
각 정수는 1이상 18이하이며, 같은 정수는 없다.
규영이는 정수가 주어지는 순서대로 카드를 낸다고 생각하면 된다.

[출력]
각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고 한 칸을 띄운 후,
인영이가 카드를 내는 9! 가지의 경우에 대해 규영이가 게임을 이기는 경우의 수와 게임을 지는 경우의 수를
공백 하나로 구분하여 출력한다.
 *</pre>
 */
public class Solution_SWEA_6808_규영이와인영이의카드게임_D3_이재순_1122ms {
	static int win;//이기는 경우의 수
	static int[] cards1, cards2; // 규영이의 카드, 인영이의 카드 배열
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine()); //테스트 케이스 입력
		for (int testcase = 0; testcase < T; testcase++) {//테스트 케이스 만큼 반복
			int[] cardsAll = new int[19];
			cards1 = new int[9];
			cards2 = new int[9];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				cards1[i]=Integer.parseInt(st.nextToken());
				cardsAll[cards1[i]] = 1;
			}
			
			if (cardsAll[17]+cardsAll[16]+cardsAll[15]+cardsAll[14]+cardsAll[18]==5) {//큰수 5개를 모두 가지고 있다면 전승
				sb.append("#").append(testcase+1).append(" ").append(362880).append(" ").append(0).append("\n");
				continue;
			}
			else if (cardsAll[17]+cardsAll[16]+cardsAll[15]+cardsAll[14]+cardsAll[18]==0) {//큰수 5개를 모두 가지지 못했다면 전패
				sb.append("#").append(testcase+1).append(" ").append(0).append(" ").append(362880).append("\n");
				continue;
			}
			
			int idx = 0;
			for (int i = 1; i < 19; i++) {
				if (cardsAll[i]==0) { //카드가 규영이에게 없으면 진행
					cards2[idx++]=i; //인영이 카드 입력
				}
			}
			
			win = 0; // 이기는 경우의 수 초기화
			permutation(0,0,0,0); //게임 진행
			
			//출력 형식에 맞추어 추가
			sb.append("#").append(testcase+1).append(" ").append(win).append(" ").append(362880-win).append("\n");
		}
		System.out.print(sb);//출력
	}//end of main
	/**
	 * 인영이의 카드로 순열을 만들어 이기는 경우의 수를 저장하는 메소드
	 */
	private static void permutation(int cnt, int plus, int minus, int flag) {
		if (plus>85||minus>85||cnt==9) {// 171/2점 이상이 되면 뒤의 경기와 상관없이 승리 또는 패배
			int matches=1; // 결정되는 경기 수
			for (int i = 9-cnt; i > 0; i--) { //(남은 경기수)!
				matches *=i;
			}
			if (plus>minus) win += matches; // 이길경우 결정된 경기수 win에 누적
			return;
		}//기저조건
		
		for (int i = 0; i < cards2.length; i++) {
			if ((flag & 1<<i) ==0) {//카드를 사용했는지 확인
				if (cards1[cnt]>cards2[i]) {//규영이가 이길경우 진행 (cards1 : 규영, cards2 : 인영)
					permutation(cnt+1,plus+cards1[cnt]+cards2[i],minus, flag|1<<i); //재귀 호출
				}
				else { //규영이가 진 경우
					permutation(cnt+1,plus, cards1[cnt]+cards2[i]+minus, flag|1<<i); //재귀 호출
				}
			}
		}//end of cards2.length
	}//end of permutaion
}//end of class
