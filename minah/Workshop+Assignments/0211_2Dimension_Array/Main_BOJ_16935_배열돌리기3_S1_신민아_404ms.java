import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_16935_배열돌리기3_S1_신민아_404ms {
	static int[][][] tempArray3D;
	static int[][] array, tempArray;
	static int sizeRow, sizeCol;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		sizeRow = Integer.parseInt(st.nextToken()); // row의 크기
		sizeCol = Integer.parseInt(st.nextToken()); // col의 크기
		int opCount = Integer.parseInt(st.nextToken()); // 연산 횟수
		
		array = new int[sizeRow][sizeCol]; // 원래 배열
		
		// 배열 초기화
		for(int i=0;i<sizeRow;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<sizeCol;j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		// 연산 정보 저장
//		String opStr = br.readLine();
//		String[] removableOp = {"1 1", "2 2", "3 3 3 3", "4 4 4 4", "5 5 5 5", "6 6 6 6"};
//		for(int i=0;i<removableOp.length;i++) {
//			opStr = opStr.replaceAll(removableOp[i], "");
//		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<opCount;i++) {
			doOperation(Integer.parseInt(st.nextToken()));
		}
		
		
		
		// 출력
		for(int i=0;i<sizeRow;i++) {
			for(int j=0;j<sizeCol;j++) {
				sb.append(array[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb.toString());
	}
	
	private static void doOperation(int operator) {
		switch(operator) {
			case 1: // 상하로 뒤집기
				for(int i=0;i<sizeRow/2;i++) {
					int[] temp = array[i];
					array[i] = array[sizeRow - i - 1];
					array[sizeRow - i - 1] = temp;
				}
				break;
				
			case 2: // 좌우로 뒤집기
				for(int i=0;i<sizeRow;i++) { 
					for(int j=0;j<sizeCol/2;j++)  {
						int temp = array[i][j];
						array[i][j] = array[i][sizeCol - j - 1];
						array[i][sizeCol - j - 1] = temp;
					}
				}
				break;
				
			// case 3,4는 코드를 통일 시킬 수 있을 것 같지만.. 수면 부족으로 이정도까지만..
			case 3: // 오른쪽으로 90도 회전
				tempArray = new int[sizeCol][sizeRow];
				for(int i=0;i<sizeRow;i++) {
					for(int j=0;j<sizeCol;j++) {
						tempArray[j][sizeRow - i - 1] = array[i][j];
					}
				}
				swapSizeAndArray(tempArray);
				break;
				
			case 4: // 왼쪽으로 90도 회전
				tempArray = new int[sizeCol][sizeRow];
				for(int i=0;i<sizeRow;i++) {
					for(int j=0;j<sizeCol;j++) {
						tempArray[sizeCol - j - 1][i] = array[i][j];
					}
				}
				swapSizeAndArray(tempArray);
				break;
				
			case 5: // 부분배열을 4개로 나누어서  반시계방향으로 회전	
				rotateByQuarter(new int[] {3, 0, 1, 2});
				break;
				
			case 6:
				rotateByQuarter(new int[] {1, 2, 3, 0});
				break;
				
		}
	}
	
	private static void swapSizeAndArray(int[][] tempArray) {
		array = tempArray;
		sizeRow = array.length;
		sizeCol = array[0].length;
	}
	
	private static void rotateByQuarter(int[] order) {
		makeTempArray3D();
		for(int r=0;r<sizeRow/2;r++) {
			for(int c=0;c<sizeCol/2;c++) {
				array[r][c] = tempArray3D[order[0]][r][c];
				array[r][sizeCol/2 + c] = tempArray3D[order[1]][r][c];
				array[sizeRow/2 + r][sizeCol/2 + c] = tempArray3D[order[2]][r][c];
				array[sizeRow/2 + r][c] = tempArray3D[order[3]][r][c];
			}
		}
	}
	
	private static void makeTempArray3D() { // 4분할로 쪼개는 메소드
		tempArray3D = new int[4][sizeRow/2][sizeCol/2];
		
		for(int r=0;r<sizeRow/2;r++) {
			for(int c=0;c<sizeCol/2;c++) {
				tempArray3D[0][r][c] = array[r][c];
				tempArray3D[1][r][c] = array[r][sizeCol/2 + c];
				tempArray3D[2][r][c] = array[sizeRow/2 + r][sizeCol/2 + c];
				tempArray3D[3][r][c] = array[sizeRow/2 + r][c];
			}
		}
	}
}
