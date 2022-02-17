import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_9663_NQueen_G5_이재순_4736ms {
	
	private static int N, ans;//체스판 한 변의 크기, 1 ≤ N < 15   /   정답
	private static int[] queens;//idx행에 놓인 퀸의 col을 저장하는 배열

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());//체스판 한 변의 크기, 1 ≤ N < 15
		queens = new int[N];//idx행에 놓인 퀸의 col을 저장하는 배열 선언
		ans = 0; // ans초기화
		bruteforce(0);//프로세스 진행
		System.out.println(ans);//출력
	}
	/**
	 * 이름만 완전탐색이고 사실 아님,  n-queen을 row~N-1행까지 진행하는 메소드
	 * @param row : 현재 퀸을 둘 행
	 */
	private static void bruteforce(int row) {
		if (row == N) {//0~N-1행까지 퀸을 모두 놓았으면 진행
			ans++;
			return;
		}//기저 조건
		
		for (int i = 0; i < N; i++) {
			queens[row] = i;//row행 i열에 퀸 저장
			boolean flag = true;//퀸을 i열에 둘수 있는지 판단하는 flag
			for (int j = 0; j < row; j++) {
				if (i==queens[j]||(row+i)==(j+queens[j])||(row-i)==(j-queens[j])) {//지금까지 둔 퀸들과 열, 대각선이 겹치면 진행
					flag = false;//퀸을 i열에 둘수 없음 저장
					break;
				}
			}
			//퀸을 i열에 둘수 있다면 다음 재귀 진행
			if (flag)	bruteforce(row+1);
		}
	}
}
