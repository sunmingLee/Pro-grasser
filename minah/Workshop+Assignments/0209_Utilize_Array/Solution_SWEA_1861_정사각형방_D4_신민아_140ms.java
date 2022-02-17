import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1861_정사각형방_D4_신민아_140ms {
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); // 파라미터로 int형을 보내면 크기를 정할 수 있음
		int TC = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		int[] roomR;
		int[] roomC;
		for(int testCase=0;testCase < TC;testCase++) {
			int roomSize = Integer.parseInt(br.readLine()); // 방의 세로 or 가로 크기
			int roomArea = (int) Math.pow(roomSize, 2); // 방의 면적
			roomR = new int[roomArea+1]; // 각 방의 좌표 저장
			roomC = new int[roomArea+1];
			
			// 방의 좌표를 roomR, roomC라는 배열에 저장 : 방 번호에 맞게 각 좌표 저장
			for(int i=0;i<roomSize;i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0;j<roomSize;j++) {
					int roomNum = Integer.parseInt(st.nextToken());
					roomR[roomNum] = i;
					roomC[roomNum] = j;
				}
			}
			
			int maxMovableCount = 1; // curMoveCount 중 최댓값
			int minStartRoomNumber = 1; // maxMovableCount가 동일할 때 시작점 중 제일 빠른 방의 번호
			int curMoveCount = 1; // 현재 움직인 횟수
			boolean isMovable = false; // 현재 방에서 움직일 수 있는지 판단
			int curStartRoom = 1; // 시작하는 방
			
			// 1번방부터 n-1번방까지 순차 탐색
			for(int i=1;i<roomArea;i++) {
				
				// 4방 탐색 없이 좌표로 했다면 방의 좌표 차이의 절대값을 구해서 1이면 이동 가능!
				// 가지치기 아이디어! : maxCount가 i보다 크면 바로 빠져나와도 됨
				for(int delta=0;delta<4;delta++) { // 4방 탐색
					if((roomR[i+1] == roomR[i]+dr[delta]) && (roomC[i+1] == roomC[i]+dc[delta])) { // 4방 탐색 중 옮길 수 있는 방이 있다면
						if(!isMovable) { // 이전에 방을 옮길 수 없는 상태에서 진입 시
							curStartRoom = i; // 시작하는 방 초기화
							isMovable = true; // 옮겼다는 상태로 바꿈
						}
						curMoveCount++; // 움직인 방 ++
						break; // 4방 탐색 중 옮길 수 있는 방이 있다면 탈출
					}
					if(delta == 3) isMovable = false; // 마지막 델타까지 탐색했으나 방이 없다면 isMovable false처리
				}
				
				if(!isMovable || ((i == roomArea-1) && isMovable)) { // 옮길 수 있는 방이 더이상 없거나, 모든 방을 옮길 수 있는 상태에서 탐색 완료 시
					if(maxMovableCount < curMoveCount) { // 현재 방을 옮긴 값이 최대 방 이동 수보다 클 경우에만
						maxMovableCount = curMoveCount; // 최대로 방을 이동한 횟수를 바꿔줌
						minStartRoomNumber = curStartRoom; // max값이 변경되었으니 시작한 방의 정보도 바꿔줌
					}
					curMoveCount = 1; // 방 옮기는 횟수 초기화
				}
				
			}
			
			sb.append("#").append(testCase + 1).append(" ").append(minStartRoomNumber).append(" ").append(maxMovableCount).append("\n");
		}
		
		System.out.print(sb.toString());
	}

}
