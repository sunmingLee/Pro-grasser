import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_BOJ_1992_쿼드트리_S1_이재순_80ms {
	static int[][] map; //주어진 영상을 저장할 배열
	static StringBuilder sb = new StringBuilder(); // 출력을 위한 빌더
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());//배열의 크기(2의 제곱수), 1 ≤ N ≤ 64
		map = new int[N][N];//영상 배열 생성
		//영상 배열 초기화
		for (int i = 0; i < N; i++) {
			String line = br.readLine();//스트링으로 한줄 읽어 저장
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j)-'0';//char값이므로 int형으로 만들기위해 '0'빼주기
			}
		}
		divide(0, N, 0, N);//프로세스 진행
		System.out.println(sb);//정답 출력
	}
	
	/**
	 * 입력받은 범위의 배열이 모두 같은 수로 이루어져있는지 확인하고 그렇다면 그 수를 출력빌더에 추가하는 메소드
	 * @param rStart : 배열의 시작 row인덱스
	 * @param rEnd : 배열의 끝 row인덱스 + 1
	 * @param cStart : 배열의 시작 col인덱스
	 * @param cEnd : 배열의 끝 col인덱스 + 1
	 */
	private static void divide(int rStart, int rEnd, int cStart, int cEnd) {
		int size = (rEnd - rStart)/2; // 배열의 사이즈
		int rMid = rStart + size;//배열의 중간 row인덱스
		int cMid = cStart + size;//배열의 중간 col인덱스
		int temp = map[rStart][cStart];//배열의 첫 값
		for (int i = rStart; i < rEnd; i++) { // 배열 row탐색
			for (int j = cStart; j < cEnd; j++) {//배열 col탐색
				if (map[i][j]!=temp) {//배열의 첫 값과 다르다면 진행 
					sb.append("(");//출력 형식 저장
					divide(rStart, rMid, cStart, cMid);//왼쪽 위 배열 재귀
					divide(rStart, rMid, cMid, cEnd);//오른쪽 위 배열 재귀
					divide(rMid, rEnd, cStart, cMid);//왼쪽 아래 배열 재귀
					divide(rMid, rEnd, cMid, cEnd);//오른쪽 아래 배열 재귀
					sb.append(")");//출력 형식 저장
					return;
				}
			}
		}
		sb.append(temp);//배열이 모두 같은수로 이루어져있다면 출력형식에 저장
	}
}
