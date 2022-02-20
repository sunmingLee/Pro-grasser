import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_4012_요리사_신민아_162ms {
	static int minDiff; // 차이의 최솟값
	static int size, food[][], team[]; // size : 재료의 개수, food : 시너지 정보 저장, team : 최초로 그룹에 속한 친구들(요리 1의 재료)
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int testCase=0;testCase<TC;testCase++) {
			minDiff = Integer.MAX_VALUE; // 최솟값 초기화
			
			size = Integer.parseInt(br.readLine());
			food = new int[size][size];
			team = new int[size/2];
			
			// 시너지 정보 입력 -> r,c가 같은 요소를 기준으로 미리 food[r][c]에 food[c][r]값을 더해둠
			for(int i=0;i<size;i++) {
				
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0;j<size;j++) {
					if(i > j) {
						food[j][i] += Integer.parseInt(st.nextToken());
					} else {
						food[i][j] = Integer.parseInt(st.nextToken());
					}
				}
			}
			
			getCombination(0, 0);
			sb.append("#").append(testCase + 1).append(" ").append(minDiff).append("\n");
		}
		
		System.out.print(sb.toString());
	}
	
	// 여기서 분명 겹치는 친구들을 줄일 수 있을 것 같은데 어떻게 해야할 지 ㅁ?ㄹ
	// n개 중 n/2개를 구하는 조합 메소드
	private static void getCombination(int count, int start) {
		if(count == size / 2) {
		
			// 요리 1에 속하지 않은 재료들 추출
			boolean[] isTeam = new boolean[size];
			for(int i=0;i<team.length;i++) {
				isTeam[team[i]] = true;
			}
			
			int[] newTeam = new int[size/2];
			for(int i=0, j=0;i<isTeam.length;i++) {
				if(!isTeam[i]) {
					newTeam[j++] = i;
				}
			}
			
			int team1Score = getCombiScore(team); // 1번째 요리의 시너지
			int team2Score = getCombiScore(newTeam); // 2번째 요리의 시너지
			minDiff = Math.min(minDiff, Math.abs(team1Score - team2Score));

			return;
		}
		
		// 요리 1에 들어갈 재료 조합
		for(int i=start;i<size;i++) {
			team[count] = i;
			getCombination(count+1, i+1);
		}
	}
	
	// n/2개(group1) 중에 2개 선택하여 시너지 합 만들기 by 반복문
	private static int getCombiScore(int[] team) {
		int result = 0;
		
		for(int i=0;i<team.length;i++) {
			for(int j=i+1;j<team.length;j++) {
				result += food[team[i]][team[j]];
			}
		}
		return result;
	}

}
