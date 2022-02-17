import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1210_Ladder1_D4_신민아_152ms {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		String[][] ladderMap = new String[100][100];
		
		for(int testCase=0;testCase<10;testCase++) {
			br.readLine(); // 테스트케이스가 10개 고정이므로 딱히 안써도 됨
			
			// 사다리 정보 초기화
			for(int i=0;i<100;i++) {
				ladderMap[i] = br.readLine().split(" ");
			}
			
			int curC = 0; // 도착점의 c좌표 -> 출발점이 되는 지점
			for(int i=0;i<100;i++) {
				if(Integer.parseInt(ladderMap[99][i]) == 2) {
					curC = i;
					break;
				}
			}
			
			int curR = 99; // 도착점의 r 좌표 -> 출발점
			int[] dr = {-1, 0, 0}; // 아래를 제외한 3방 탐색용 델타
			int[] dc = {0, 1, -1};
			int curDir = 0; // 0 : 위, 1 : 오른쪽 , 2 : 왼쪽 (현재 방향 저장 : 델타값 사용을 위한 변수)
			while(curR > 0) { // 시작지점 : curR, curC 도착점부터 출발
				switch(curDir) { // 방향에 따라서
					case 0:
						int dStart = 1; // 델타 탐색 시작하는 구간
						int dEnd = 3;  // 델타 탐색 끝나는 구간
						if(curC == 99) { // 현재 위치가 가장 오른쪽일 경우
							dStart = 2; // 우측은 탐색 못하니 델타 범위 제한
						} else if(curC == 0) { // 현재 위치가 가장 왼쪽일 경우
							dEnd = 2; // 좌측은 탐색 못하니 델타범위 제한
						}
						for(int i=dStart;i<dEnd;i++) { // 검색 가능한 델타로 좌표 값 검색
							if(Integer.parseInt(ladderMap[curR][curC + dc[i]]) == 1) { // 만약에 좌,우 방향 중 하나에 사다리를 이어탈 수 있다면
								curDir = i; // 방향 전환
								break;
							}
						}
						break;
					case 1: // 우측, 좌측인 경우 한 번만 검색하면 됨 : 북쪽으로 1이 있는지만 검색하면 완료
					case 2:
						if(Integer.parseInt(ladderMap[curR - 1][curC]) == 1) { // 위쪽으로 이동이 가능하다면
							curDir = 0; // 위쪽으로 방향 전환
						}
						break;
						
				}
				curR += dr[curDir]; // 방향에 따라 좌표 이동
				curC += dc[curDir]; // 방향에 따라 좌표 이동
			}
			sb.append("#").append(testCase + 1).append(" ").append(curC).append("\n");
		}
		
		System.out.print(sb.toString());

	}

}
