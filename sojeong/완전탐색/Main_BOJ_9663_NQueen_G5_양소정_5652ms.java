import java.util.Scanner;
//교수님코드
public class Main_BOJ_9663_NQueen_G5_양소정_5652ms{
	private static int[] col;
	private static int N;
	private static int ans;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		ans = 0;
		col = new int[N+1];
		setQueen(1);
		System.out.println(ans);
	}
	public static void setQueen(int rowNo) { //rowNo : 퀸을 두어야하는 현재 행
		
		if(!isAvailable(rowNo-1)) return; // 직전까지의 상황이 유망하지 않다면 리턴
		//기본파트 : 퀸을 모두 놓았다면
		if(rowNo>N) {
			ans ++;
			return;
		}
		
		//1열부터 - n열까지 퀀을 놓는 시도
		for (int i = 1; i <= N; i++) {
			col[rowNo] = i;
			setQueen(rowNo+1);
		}
	}
	
	public static boolean isAvailable(int rowNo) { //rowNo:놓아진 마지막 퀸
		for (int i = 1; i < rowNo; i++) {
			if(col[rowNo] == col[i] || rowNo-i ==Math.abs(col[rowNo]-col[i])) return false; //현재 열 기존퀸 열 번호 같으면 x 변호량 같으면 x 대각선
		}
		return true;
	}

}
