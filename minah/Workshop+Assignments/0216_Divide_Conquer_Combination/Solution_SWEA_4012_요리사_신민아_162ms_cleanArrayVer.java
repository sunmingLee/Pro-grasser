import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_4012_요리사_신민아_162ms_cleanArrayVer {
	static int minDiff; // 최솟값 
	static int size, food[][], team[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int testCase=0;testCase<TC;testCase++) {
			minDiff = Integer.MAX_VALUE;
			
			size = Integer.parseInt(br.readLine());
			food = new int[size][size];
			team = new int[size/2];
			
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
	
	// 여기서 분명 1/2로 줄일 수 있을 것 같은데 어떻게 해야할 지 몰?루
	// n개 중 n/2개를 구하는 조합 메소드
	private static void getCombination(int count, int start) {
		if(count == size / 2) {
		
			// 조합에 뽑히지 않은 재료 추출
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
			
			int team1Score = getCombiScore(team);
			int team2Score = getCombiScore(newTeam);
			minDiff = Math.min(minDiff, Math.abs(team1Score - team2Score));

			return;
		}
		
		for(int i=start;i<size;i++) {
			team[count] = i;
			getCombination(count+1, i+1);
		}
	}
	
	// n/2개(group1) 중에 2개 선택하여 시너지 합 만ㄴ들기
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
