package brute_force;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_9663_NQueen_G5_신민아2 {
	static int n, answer;
	static int col[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		col = new int[n+1];
		
		setQueen(1);
		
		System.out.print(answer);
	}
	
	private static void setQueen(int rowNo) { // rowNo : 퀸을 두어야 하는 현재 행
		// 기본 파트 : 퀸을 모두 놓았을 때
		if(rowNo > n) {
			answer++;
			return;
		}
		
		// 1열부터 n열까지 퀸을 놓는 시도(어차피 한 행에는 한개의 퀸만 둘 수 있으므로 2차원으로 탐색할 필요 없이 1차원으로 생각!)
		for(int i=1;i<=n;i++) {
			col[rowNo] = i;
			if(isAvailable(rowNo)) { // 가능 하면 setQueen 실행
				setQueen(rowNo+1);
			}
		}
	}
	
	private static boolean isAvailable(int rowNo) { // rowNo : 놓아진 마지막 퀸
		for(int i=1;i<rowNo;i++) {
			if(col[rowNo] == col[i] // 같은 행 
					|| rowNo - i == Math.abs(col[rowNo]-col[i])) // 대각선
				return false;
		}
		
		return true;
	}

}
