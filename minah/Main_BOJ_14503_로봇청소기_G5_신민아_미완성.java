package implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 문제 미완성 : 작동 조건에서 꼬임
public class Main_BOJ_14503_로봇청소기_G5_신민아_미완성 {
	static int cleanCount = 0;
	static int[][] room;
	
	// 후진 시에는 dr과 dc의 위치를 변경 후 -1 곱하기
	static int[] dr = {-1, 0, 1, 0}; // 왼쪽 탐색 시 row 좌표
	static int[] dc = {0, -1, 0, 1}; // 왼쪽 탐색 시 column 좌표
	static int[] changeDir = {3, 0, 1, 2}; // 왼쪽 회전 시 바뀌는 방향
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 방의 정보를 저장할 배열 initialization
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		room = new int[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];
		
		// 현재 청소기의 위치를 setting : r, c좌표 + 방향
		st = new StringTokenizer(br.readLine());
		
		int curR = Integer.parseInt(st.nextToken());
		int curC = Integer.parseInt(st.nextToken());
		int curDir = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<room.length;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<room[0].length;j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			clean(curR, curC); // 청소
			
			boolean isDirty = false;
			for(int delta=0;delta<4;delta++) {
				isDirty = isDirty || (room[curR + dr[delta]][curC + dc[delta]] == 0);
			}
			
			if(isDirty) {
				if(room[curR + dr[curDir]][curC + dc[curDir]] == 0) { // 왼쪽 탐색 시 청소를 할 수 있는 곳이라면
					curR = curR + dr[curDir]; // r,c 좌표를 해당하는 방향에 맞게 변경
					curC = curC + dc[curDir];
				}
				curDir = changeDir[curDir];
				continue;
			} else {
				if(room[curR - dc[curDir]][curC - dr[curDir]] == 1) {
					break;
				}
				curR = curR - dc[curDir];
				curC = curC - dr[curDir];
			}
			
			
			
//			boolean isFinished = isRoomCleaned(curR, curC, curDir);
//			
//			if(isFinished) {
//				break;
//			}
			
		}
		
		System.out.print(cleanCount);
		
	}
	
//	private static boolean isRoomCleaned(int r, int c, int dir) {
//		if(room[r + dr[dir]][c + dc[dir]] == 0) {
//			r = r + dr[dir];
//			c = c + dc[dir];
//			dir = changeDir[dir];
//			return false;
//		}
//		
//		return true;
//	}
	
	// 청소하는 함수
	private static void clean(int r, int c) {
		if(room[r][c] == 0) {
			room[r][c] = -1;
			cleanCount++;
		}
	}
}
