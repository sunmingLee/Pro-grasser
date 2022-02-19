package brute_force;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_9663_NQueen_G5_신민아 {
	static int n;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
	}
	
	private static void setQueen(int rowNo) { // rowNo : 퀸을 두어야 하는 현재 행!
		
		// 1열부터 n열까지 퀸을 놓는 시도(어차피 한 행에는 한개의 퀸만 둘 수 있으므로 2차원으로 탐색할 필요 없이 1차원으로 생각!)
		for(int i=1;i<=n;i++) {
			
		}
	}

}
