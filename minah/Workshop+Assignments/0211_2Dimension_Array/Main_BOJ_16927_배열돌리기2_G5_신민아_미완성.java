import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_16927_배열돌리기2_G5_신민아_미완성 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int sizeRow = Integer.parseInt(st.nextToken()); // row의 크기
		int sizeCol = Integer.parseInt(st.nextToken()); // col의 크기
		int rotationCount = Integer.parseInt(st.nextToken()); // 회전 수
		int[][] rotateArea = new int[sizeRow][sizeCol]; // 원래 배열
		
		// 배열 초기화
		for(int i=0;i<sizeRow;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<sizeCol;j++) {
				rotateArea[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 위치에 따라 이동하는 방향 제시
		int[] dr = {0, 1, 0, -1};
		int[] dc = {1, 0, -1, 0};
		
		// 그룹 나누기 : 가장 작은 변 / 2
		int group = Math.min(sizeRow, sizeCol) / 2;
		
		// 회전 수만큼 반복
		for(int rotate=0;rotate<rotationCount;rotate++) {
			int rotateCor = rotationCount % (sizeRow * sizeCol);
			
			for(int g=0;g<group;g++) {
				int r = g; // 그룹 별 시작점 설정 : 0, 0부터 시작
				int c = g;
				
				int tempValue = rotateArea[r][c]; // 임시 저장
				
				int dir = 0; // 방향 설정
				while(dir < 4) { // dr, dc를 돌면서 이동
					int nextR = r + dr[dir];
					int nextC = c + dc[dir];
					
					if(nextR>=g && nextC>=g && nextR<sizeRow-g && nextC < sizeCol-g) { // 해당 범위에서 움직일 수 있다면
						rotateArea[r][c] = rotateArea[nextR][nextC]; // 움직임
						r = nextR; // 다음에 돌아갈 값 정함
						c = nextC;
					} else {
						dir++; // 다음 방향으로 탐색
					}
				}
				
				rotateArea[g+1][g] = tempValue; // 그룹 별 겹쳐서 사라지는 값 복원
				
			}
		}
		
		// 출력
		for(int i=0;i<sizeRow;i++) {
			for(int j=0;j<sizeCol;j++) {
				sb.append(rotateArea[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb.toString());
	}

}
