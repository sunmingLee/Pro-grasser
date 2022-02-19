import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 
public class Main_BOJ_1074_Z_S1_신민아_byProf_for {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); // 1<=N<=15
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int sr = 0;
		int sc = 0;
		int answer = 0;
		while(N > 0) {
			int size = 1 << (N-1); // 정사각형 한 변의 길이
			int area = size * size; // 정사각형 면적(내부 개수)
			
			if(r < sr + size && c < sr + size) { // 좌상
				
			} else if(r < sr + size && c >= sr + size) { // 우상
				answer += area;
				sc += size;
			} else if(r >= sr + size && c < sr + size) { // 좌하
				answer += area * 2;
				sr += size;
			} else { // 우하 조건 : r >= sr + size && c >= sr + size
				answer += area * 3;
				sr += size;
				sc += size;
			}
			N--;
		}
		
		System.out.print(answer);
	}
}
