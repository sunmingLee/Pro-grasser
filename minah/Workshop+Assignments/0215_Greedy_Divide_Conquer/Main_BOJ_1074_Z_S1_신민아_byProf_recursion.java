import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 
public class Main_BOJ_1074_Z_S1_신민아_byProf_recursion {

	private static int r;
	private static int c;
	private static int answer = 0;
	private static int[] bin = {1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768}; // 범위가 한정되어 있으므로 사용할 2^n값 저장

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); // 1<=N<=15
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		go(N, 0, 0);
	}
	
	/** 사각형의 가로 세로 크기 = 2^N, 사각형의 시작 위치 sr, sc */
	private static void go(int n, int sr, int sc) {
		// 예상 가능한 부분의 재귀 호출 생략 : 사각 영역에 r,c 미포함 시 계산만 하고 넘기기
		
		if(r < sr || r >= sr + bin[n] || c < sc || c >= sc + bin[n]) { // 사각형의 영역 밖이면
			answer += bin[n] * bin[n];
			return;
		}
		
		if(n == 0) {
			if(sr == r && sc == c) {
				System.out.println(answer);
				System.exit(0);
			}
			answer++;
			return;
		}
		
		go(n-1, sr			, sc			); // 좌상
		go(n-1, sr			, sc + bin[n-1]); // 우상
		go(n-1, sr + bin[n-1], sc			); // 좌하
		go(n-1, sr + bin[n-1], sc + bin[n-1]); // 우하
	}
}
